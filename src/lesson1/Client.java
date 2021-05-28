package lesson1;

import java.awt.AWTException;
import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.TrayIcon;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.StringReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;
import java.util.Properties;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Client {
	private static final int		POLLING_DELAY_MS = 60000;
	private static final File		configFile = new File(".conf");

	public static void main(final String[] args) {
		if (args.length == 0) {
			System.err.println("Use:");
			System.exit(128);
		}
		else if (!SystemTray.isSupported()) {
			System.err.println("System tray is not supported");
			System.exit(128);
        }		
		else {
			final int		colonIndex = args[0].lastIndexOf(':');
			final String	host = colonIndex >= 0 ? args[0].substring(0,colonIndex) : args[0]; 
			final int 		port = Integer.valueOf(colonIndex >= 0 ? args[0].substring(colonIndex+1) : "8080");
			
	        try{
	        	UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
	        } catch (UnsupportedLookAndFeelException | IllegalAccessException | InstantiationException | ClassNotFoundException ex) {
				System.err.println("LAF is not supported");
				System.exit(128);
	        }
			
			try{if (args.length > 1 && "-s".equals(args[1])) {
					final Timer		t = new Timer(true);
					
					try(final ServerSocket		sock = new ServerSocket(port);
						final DeviceConnector	dc = new DeviceConnector(configFile);
						final TrayConnector		tc = new TrayConnector(sock,dc)) {
						final TimerTask		tt = new TimerTask() {
												@Override
												public void run() {
													tc.processState(getState(dc));
												}
											};
						
						dc.connect();
						t.schedule(tt, POLLING_DELAY_MS, POLLING_DELAY_MS);
						
						for (;;) {
							asServer(sock.accept(),tc,dc);
						}
					} catch (IOException e) {
					} finally {
						t.purge();
					}
				}
				else {
					try(final Socket		sock = new Socket(host,port);
						final TrayConnector	tc = new TrayConnector(sock)) {
						
						asClient(sock,tc);
					}
					
				}
			} catch (Exception e) {
				e.printStackTrace();
				System.exit(128);
			}
		}
	}
	
	private static void manage(final DeviceConnector dc) {
		
	}

	private static String getState(final DeviceConnector dc) {
		return dc.getState();
	}
	
	private static void processRequests(final Socket sock, final TrayConnector tc, final DeviceConnector dc) throws IOException {
		try(final InputStream		is = sock.getInputStream();
			final Reader			rdr = new InputStreamReader(is);
			final BufferedReader	brdr = new BufferedReader(rdr);
			final OutputStream		os = sock.getOutputStream();
			final PrintWriter		pw = new PrintWriter(os)) {

			String	request;
			
			while ((request = brdr.readLine()) != null) {
				switch (request) {
					case "state" :
						pw.println(getState(dc));
						break;
					default :
						pw.println("Unknown request");
						break;
				}
			}
		}
	}

	private static void asServer(final Socket sock, final TrayConnector tc, final DeviceConnector dc) {
		final Thread	t = new Thread(()->{
							try {
								processRequests(sock,tc,dc);
							} catch (IOException e) {
								e.printStackTrace();
							} finally {
								try{
									sock.close();
								} catch (IOException e) {
									e.printStackTrace();
								}
							}
						});
		t.setDaemon(true);
		t.start();
	}

	private static void asClient(final Socket sock, final TrayConnector tc) {
		try(final InputStream		is = sock.getInputStream();
			final Reader			rdr = new InputStreamReader(is);
			final BufferedReader	brdr = new BufferedReader(rdr);
			final OutputStream		os = sock.getOutputStream();
			final PrintWriter		pw = new PrintWriter(os)) {

			for (;;) {
				pw.write("state\n");
				tc.processState(brdr.readLine());
				Thread.sleep(POLLING_DELAY_MS);
			}
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	private static Image createImage(final String path, final String description) throws Exception {
        final URL imageURL = Client.class.getResource(path);
         
        if (imageURL == null) {
        	throw new Exception("Resource not found: " + path);
        }
        else {
            return new ImageIcon(imageURL, description).getImage();
        }
    }
	
	private static class TrayConnector implements AutoCloseable   {
        final TrayIcon 		trayIcon = new TrayIcon(createImage("icon.png", "tray icon"));
        
		public TrayConnector(final Socket sock) throws Exception {
	        final SystemTray 	tray = SystemTray.getSystemTray();
	        final PopupMenu 	popup = new PopupMenu();
	        
	        final MenuItem 		exitItem = new MenuItem("Exit");
	        
	        exitItem.addActionListener((e)->{
				try{sock.close();
				} catch (IOException e1) {
				}
			});
	        
	        popup.add(exitItem);
            trayIcon.setImageAutoSize(true);
	        trayIcon.setPopupMenu(popup);
	         
	        try {
	            tray.add(trayIcon);
	        } catch (AWTException e) {
	        	throw new Exception(e.getLocalizedMessage(),e);
	        }
		}
		
		public TrayConnector(final ServerSocket sock, final DeviceConnector dc) throws Exception {
	        final SystemTray 	tray = SystemTray.getSystemTray();
	        final PopupMenu 	popup = new PopupMenu();
	        final MenuItem 		refreshItem = new MenuItem("Refresh");
	        final MenuItem 		exitItem = new MenuItem("Exit");
	        
	        refreshItem.addActionListener((e)->{
	        	dc.refresh();
			});
	        exitItem.addActionListener((e)->{
				try{sock.close();
				} catch (IOException exc) {
				}
			});
	        
	        popup.add(refreshItem);
	        popup.add(exitItem);
            trayIcon.setImageAutoSize(true);
	        trayIcon.setPopupMenu(popup);
	         
	        try {
	            tray.add(trayIcon);
	        } catch (AWTException e) {
	        	throw new Exception(e.getLocalizedMessage(),e);
	        }
	        trayIcon.addActionListener((e)->manage(dc));
		}

		// t1=zzz,t2=zzz,t3=zzz,t4=zzz,amount=zzz,l={on|off|spy}
		public void processState(final String state) {
			try{final Properties	props = new Properties();
			
				props.load(new StringReader(state));
				trayIcon.setToolTip(String.format("",props.getProperty("t1"),props.getProperty("t2"),props.getProperty("t3"),props.getProperty("t4"),props.getProperty("amount"),props.getProperty("l")));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		@Override
		public void close() throws RuntimeException {
	        final SystemTray 	tray = SystemTray.getSystemTray();
	        
	        tray.remove(trayIcon);
		}
	}

	private static class DeviceConnector implements AutoCloseable   {
		private static final String	PORT_ADDR ="portAddr";
		private static final String	DEFAULT_PORT_ADDR = "???";
		
		private final File			configFile;
		private final Properties	props = new Properties();
		
		public DeviceConnector(final File configFile) {
			this.configFile = configFile;
			if (configFile.exists()) {
				try(final InputStream	is = new FileInputStream(configFile)) {
					props.load(is);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		public boolean isAvailable(final String port) {
			return true;
		}
		
		public void connect() throws IOException {
			final String	port = getProps().getProperty(PORT_ADDR,DEFAULT_PORT_ADDR); 
			
			if (isAvailable(port)) {
				connect(port);
				refresh();
			}
			else {
				throw new IOException("Device port ["+getProps().getProperty(PORT_ADDR,DEFAULT_PORT_ADDR)+"] is missing or unavailable");
			}
		}

		public void disconnect() {
			disconnect(getProps().getProperty(PORT_ADDR,DEFAULT_PORT_ADDR));
		}
		
		public void refresh() {
			final String	port = getProps().getProperty(PORT_ADDR,DEFAULT_PORT_ADDR);
			
			select(port,0);
		}
		
		public String getState() {
			final StringBuilder	sb = new StringBuilder();
			final String		port = getProps().getProperty(PORT_ADDR,DEFAULT_PORT_ADDR);
			
			select(port,0);
			write(port,"::state\n");
			return null;
		}

		public Properties getProps() {
			return props;
		}
		
		public void save() throws IOException {
			try(final OutputStream	os = new FileOutputStream(configFile)) {
				props.store(os,"");
			}
		}
		
		@Override
		public void close() throws RuntimeException {
			disconnect();
		}

		private void connect(final String port) {
			// TODO Auto-generated method stub
		}

		private void write(final String port, final String request) {
			// TODO Auto-generated method stub
		}

		private String read(final String port) {
			// TODO Auto-generated method stub
			return null;
		}
		
		private void disconnect(final String port) {
			// TODO Auto-generated method stub
		}
		
		private void select(final String port, final int channel) {
			write(port,"::ver\n");
			if ("SS".equals(read(port))) {
				write(port,"::sel 0\n");
			}
		}
	}
}
