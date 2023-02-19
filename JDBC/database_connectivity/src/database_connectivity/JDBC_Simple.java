package database_connectivity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


class JDBC_Simple {
	
	public static void main(String[] args) throws Exception{		
		String _DATABASE = "gcsc_database";
		String _URL = "jdbc:mysql://localhost:3306/" + _DATABASE;
		String _USERNAME = "root";
		String _PASSWORD = "matrixADX@123";
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(_URL, _USERNAME, _PASSWORD);
		Statement st = con.createStatement();
		
		String userData = "";
    	String _QUERY = "select * from gcsc_core_coordinators";
    	
    	ResultSet rs = st.executeQuery(_QUERY);
    	System.out.println("\nCORE_ID" + " | " + "MOBILE_NUMBER" + " | " + "SEX" + " | " + "NAMES  & ROLES\n");
    	
    	while(rs.next()) {
    		userData = rs.getInt(1) +" ----- "+ rs.getLong(2) +" ---- "+ rs.getString(3) + " --- " + rs.getString(4) + " ("+ rs.getString(5) + ")";
    		System.out.println(userData);
    	} 
    	st.close();
		con.close();
	}
}
