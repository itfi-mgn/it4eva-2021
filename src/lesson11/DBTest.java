package lesson11;

import java.sql.*;

public class DBTest {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		try(final Connection	conn = DriverManager.getConnection(
								"jdbc:postgresql://localhost/postgres", 
								"abcde",
								"")) {
			conn.setAutoCommit(false);
			System.err.println("COnnect!!!!!");
		
			try(final Statement	stmt = conn.createStatement()) {
				System.err.println("Stmt!!!!!");
				
				try(final ResultSet	rs = stmt.executeQuery("select x,y from t")){
					final ResultSetMetaData	rsmd = rs.getMetaData();
					
					for (int index = 1; index <= rsmd.getColumnCount(); index++) {
						System.err.println("Column "+index+":");
						System.err.println("-name:"+rsmd.getColumnName(index));
						System.err.println("-type:"+rsmd.getColumnTypeName(index));
					}
					
					while (rs.next()) {
						System.err.println("Item1="+rs.getString("x")+
											",item2="+rs.getString(2));
					}
				}
				
				stmt.executeUpdate("insert into t (x,y) values (23456,'assa')");
				conn.commit();
			}
			
			try(final PreparedStatement pstmt = conn.prepareStatement(
					"select * from t where x = ?")) {
				pstmt.setInt(1, 100);
				
				try(final ResultSet rs = pstmt.executeQuery()) {
					while (rs.next()) {
						System.err.println("X::; Item1="+rs.getString("x")+
											",item2="+rs.getString(2));
					}
					
				}
				
				pstmt.setInt(1, 101);
				
				try(final ResultSet rs = pstmt.executeQuery()) {
					while (rs.next()) {
						System.err.println("X::-----; Item1="+rs.getString("x")+
											",item2="+rs.getString(2));
					}
					
				}

			}
			
			
//			DatabaseMetaData	dbmd = conn.getMetaData();
//			try(final ResultSet rs = dbmd.getTables(null, null, "%", null)) {
//				int count = 0;
//				while (rs.next()) {
//					System.err.println("Table="+rs.getString("TABLE_NAME"));
//					count++;
//				}
//				System.err.println("Total: "+count);
//			}
			//conn.close();
		} // finally {conn.close();}
		
	}

}
