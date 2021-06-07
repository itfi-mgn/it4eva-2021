package lesson11;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;

public class FileTest {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
//		FileInputStream s = new FileInputStream("abcde");
		File	f = new File("c:/temp");
FileInputStream		s = new FileInputStream(f);
		
		System.err.println("EXists ? "+f.exists());
		System.err.println("Is directory ? "+f.isDirectory());
		System.err.println("Is file ? "+f.isFile());
	
		System.err.println("COntent: "+Arrays.toString(f.list()));
		for (String item : f.list()) {
			File	ff = new File(f,item);
			
			System.err.println("-- is file? "+ff.getName()+" : "+ff.isFile());
			System.err.println("-- size? "+ff.length());
			System.err.println("-- can read? "+ff.canRead());
			System.err.println("-- can write? "+ff.canWrite());
			System.err.println("-- can execute? "+ff.canExecute());
			System.err.println("-- modified? "+new Date(ff.lastModified()));
			final Date d = new Date(0);
			
			System.err.println("Date: "+d);
			System.err.println("-- Path? "+ff.getCanonicalPath());
			System.err.println("-- Parent? "+ff.getParentFile());
			
			System.err.println("Roots: "+Arrays.toString(ff.listRoots()));
		}
		
		File	fileOld = new File("c:/temp/store.bin");
		File	fileNew = new File("c:/temp/storeZZZ.bin");
		
		System.err.println("--- before ---");
		System.err.println("Old: "+fileOld.exists()+" and "+fileOld.isFile());
		System.err.println("New: "+fileNew.exists()+" and "+fileNew.isFile());
		
		fileOld.renameTo(fileNew);
		
		System.err.println("--- after ---");
		System.err.println("Old: "+fileOld.exists()+" and "+fileOld.isFile());
		System.err.println("New: "+fileNew.exists()+" and "+fileNew.isFile());
	}
}
