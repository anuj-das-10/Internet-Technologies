package database_connectivity;

import java.sql.*;
import java.util.Scanner;

class JavaDataBaseConnectivity {
	
	public static void displayTables(String _DATABASE, Statement st) throws SQLException {
		String userData = "";
		System.out.println("\nTable/s available in \"" + _DATABASE + "\" :: ");
		ResultSet rs = st.executeQuery("SHOW TABLES");
        while(rs.next()) {
            userData = rs.getString(1);
            System.out.println(userData);
        }
		
	}
	
	public static void main(String[] args) throws Exception {
		
		Scanner input = new Scanner(System.in);
		
		String _DATABASE = "gcsc_database";
		String _URL = "jdbc:mysql://localhost:3306/" + _DATABASE;
		String _USERNAME = "root";
		String _PASSWORD = "matrixADX@123";
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(_URL, _USERNAME, _PASSWORD);
		Statement st = con.createStatement();

		
		 	int key;
		 	System.out.println("DATABASE Selected:  " + _DATABASE);
		 	
	        do {
	        	System.out.println("\nDATABASE OPERATIONS:");
		        System.out.println("1. View Records of a Table");
		        System.out.println("2. Insert Data into Table");
		        System.out.println("3. Exit");
		        
		        System.out.print("Enter your choice:  ");
	            key = input.nextInt();
	            
	            switch (key) {
	                
	            	case 1: String _QUERY = "";
	                		String userData = "";
	                		
	                		displayTables(_DATABASE, st);   
	                		
	                        System.out.print("\nEnter the name of the Table:  ");
	                        String _TABLE = input.next();      						// selected_members or gcsc_core_coordinators
	                        
	                        
	                        if(_TABLE.equalsIgnoreCase("selected_members")) {
	                        	
	                        	userData = "";
	                        	_QUERY = "select * from "+_TABLE;
	                        	
	                        	ResultSet rs = st.executeQuery(_QUERY);
	                        	System.out.println("\nGCSC_ID" + " | " + "MOBILE_NUMBER" + " | " + "SEMESTER" + " | " + "SEX" + " | " + " NAMES\n");
	                        	
	                        	while(rs.next()) {
	                        		userData = rs.getInt(1) +" ------ "+ rs.getLong(2) +" ------ "+ rs.getString(3) + " ------ " + rs.getString(4)+ " --- "+ rs.getString(5);
	                        		System.out.println(userData);
	                        	}	                        	
	                        } 
	                        
	                        else if(_TABLE.equalsIgnoreCase("gcsc_core_coordinators")) {
	                        	
	                        	userData = "";
	                        	_QUERY = "select * from " + _TABLE;
	                        	
	                        	ResultSet rs = st.executeQuery(_QUERY);
	                        	System.out.println("\nCORE_ID" + " | " + "MOBILE_NUMBER" + " | " + "SEX" + " | " + "NAMES  & ROLES\n");
	                        	
	                        	while(rs.next()) {
	                        		userData = rs.getInt(1) +" ----- "+ rs.getLong(2) +" ---- "+ rs.getString(3) + " --- " + rs.getString(4) + " ("+ rs.getString(5) + ")";
	                        		System.out.println(userData);
	                        	} 
	                        } 
	                        
	                        else {
	                        	System.out.println("Enter the Table Name Correctly!!");
	                        }
	                        
	                        break;
	                
	                
	                
	                
	                case 2: userData = "";
                    		                    		
                    		displayTables(_DATABASE, st);
                    		
	                        System.out.print("\nEnter the name of the Table:  ");
	                        String _TABLE_NAME = input.next();      				// selected_members or gcsc_core_coordinators
	                                            		
	                   
                    		if(_TABLE_NAME.equalsIgnoreCase("selected_members")) {
                    			
                    			int id = 0;
                    			
                    			ResultSet rs = st.executeQuery("SELECT gcsc_ID from " + _TABLE_NAME);
    	                        while(rs.next()) {
                        		id = rs.getInt(1);
    	                        }

    	                        id += 1;
                        		System.out.println("\nYour Auto-Generated GCSC_ID:  " + id);
                        		

                        		System.out.print("Enter your MOBILE NUMBER:  ");
                        		long mobile_no = input.nextLong();
                        		
                        		System.out.print("Enter your Semester Number (1 - 6):  ");
                        		int semester = input.nextInt();
                        		
                        		System.out.print("Enter your SEX (M / F):  ");
                        		String sex = input.next().toUpperCase();
                        		
                        		System.out.print("Enter your NAME:  ");
                        		String names = input.nextLine();
                        		names = input.nextLine();

                        		System.out.println("\nDETAILS!\n-----------------------------------");
                        		System.out.println("GCSC_ID: " + id + "\n" +"MOBILE_NUMBER: " + mobile_no + "\n" + "SEMESTER: " + semester+ "\n" + "SEX: " + sex+ "\n"+ "NAME: " + names);
                        		System.out.println("-----------------------------------");
                        		
                        		
                        		String DML_QUERY = "INSERT INTO " + _TABLE_NAME + " VALUES ( ? , ? , ? , ? , ? )";
                        		PreparedStatement ps = con.prepareStatement(DML_QUERY);
                        		
                        		ps.setInt(1, id);
                        		ps.setLong(2, mobile_no);
                        		ps.setLong(3, semester);
                        		ps.setString(4, sex);
                        		ps.setString(5,names);
                        		
                        		int status = ps.executeUpdate();
                        		System.out.println("\n"+status + " row/s effected!");
                        		
                        		if(status > 0) {
                        			System.out.println("Record Inserted Successfully!\n");
                        		} else {
                        			System.out.println("Insertion of Record did not Completed Successfully!\n");
                        		}
                    		
                    		} 
                    		
                    		else if(_TABLE_NAME.equalsIgnoreCase("gcsc_core_coordinators")) {
                    			
                    			int id = 0;
                    			
                    			ResultSet rs = st.executeQuery("SELECT ID_ from " + _TABLE_NAME);
    	                        while(rs.next()) {
                        		id = rs.getInt(1);
    	                        }
    	                        
    	                        id += 1;
    	                        System.out.println("\nYour Auto-Generated CORE_ID:  " + id);
                        		
                        		System.out.print("Enter your MOBILE NUMBER:  ");
                        		long mobile_no = input.nextLong();
    	                        
                        		System.out.print("Enter your SEX (M / F):  ");
                        		String sex = input.next().toUpperCase();
                       		
                        		System.out.print("Enter your FULL NAME:  ");
                        		String names = input.nextLine();
                        		names = input.nextLine();
                        		
                        		System.out.print("Enter your ROLE:  ");
                        		String roles = input.nextLine();
                        		
                        		System.out.println("\nDETAILS!\n-----------------------------------");
                        		System.out.println("CORE_ID: " + id + "\n" +"MOBILE_NUMBER: " + mobile_no + "\n" + "SEX: " + sex+ "\n" + "NAME: " + names+ "\n"+ "ROLE: " + roles);
                        		System.out.println("-----------------------------------");
                        		
    	                        String DML_QUERY = "INSERT INTO " + _TABLE_NAME + " VALUES ( ? , ? , ? , ? , ? )";
                        		PreparedStatement ps = con.prepareStatement(DML_QUERY);
                        		
                        		ps.setInt(1, id);
                        		ps.setLong(2, mobile_no);
                        		ps.setString(3, sex);
                        		ps.setString(4, names);
                        		ps.setString(5, roles);
                        		
                        		int status = ps.executeUpdate();
                        		System.out.println("\n"+status + " row/s effected!");
                        		
                        		if(status > 0) {
                        			System.out.println("Record Inserted Successfully!\n");
                        		} else {
                        			System.out.println("Insertion of Record did not Completed Successfully!\n");
                        		}
                    			
                    		} 
                    		
                    		else {
                    			System.out.println("Enter the Table Name Correctly!!");
                    		}
	         
                    		break;
                   
                    		
                    		
	                case 3: System.out.println("Exiting DB Operations Menu. . . . .");
	                		break;
	               
	                
	                
	                default: System.out.println("Invalid Choice!!");
	                    	 break;
	            }

	        } while( key != 3 );
		
		st.close();
		con.close();
		input.close();
	}
}
