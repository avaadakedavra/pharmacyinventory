package Login_Sys;

import java.sql.*;

import javax.swing.JOptionPane;

public class DBConnect {
		
		private Connection con;
		public Statement st;
		private ResultSet rs;
		String tabname;
		public DBConnect() {
			
			try {
				Class.forName("com.mysql.jdbc.Driver");
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacy","root","jbrag42669" );
				st = con.createStatement();	
				
			}catch(Exception ex) {
				System.out.println("Error:"+ex);
			}
			
		}
		
		public ResultSet getData(String tabname) {
			
			
			
			try {
				
				String query = "select * from "+tabname;
				
				rs = st.executeQuery(query);
				
				

				/*
				System.out.println("Records from database");
				while(rs.next()) {
					
					String name = rs.getString("customername");	
					String id = rs.getString("customer_id");
					System.out.println("Name: "+name+"   "+"ID: "+id);
					//JOptionPane.showMessageDialog(null, name);
					
				}*/				
				
			}catch(Exception ex) {
				System.out.println("Error:"+ex);
			}
			

			return rs;
		}
		
		public ResultSet insertData(String sql) {
			
		}
		
		public ResultSet updateData(String sql) {
			
		}
		
		public ResultSet deleteData(String sql) {
			
		}
}
