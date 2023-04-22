package com.bridgelabz;

import java.sql.*;

public class AddressBook {
	public static void main(String[] args) {
		String DB_URL = "jdbc:mysql://localhost:3306/AddressBook";
		String USER = "root";
		String PASS = "anjali";
		Connection con;
		try {
			System.out.println("Connecting to database: "+DB_URL);
			try {
				con = DriverManager.getConnection(DB_URL,USER,PASS);
				PreparedStatement stmt = con.prepareStatement("select * from AddressBook where city =?");
				stmt.setString(1,"Nanded");
				int count = stmt.executeUpdate();
//               ResultSet rs = stmt.executeQuery();
				Statement stmt2 = con.createStatement();
				ResultSet rs = stmt2.executeQuery("select * from AddressBook");
				System.out.println(count);
				while (rs.next()) {
					System.out.print(" first_name: " + rs.getString("first_name"));
					System.out.print(", last_name: " + rs.getString("last_name"));
					System.out.print(", address_book_name: " + rs.getString("address_book_name"));
					System.out.print(", type: " + rs.getString("type"));
					System.out.print(", address: " + rs.getString("address"));
					System.out.print(", city: " + rs.   getString("city"));
					System.out.print(", state: " + rs.getString("state"));
					System.out.print(", zip: " + rs.getInt("zip"));
					System.out.print(", phone_number: " + rs.getString("phone_number"));
					System.out.print(", email: " + rs.getString("email"));
					System.out.println();
				}
			} catch (SQLException ex) {
				throw new RuntimeException(ex);
			}
			System.out.println("Connection is successful!!!! "+con);
		} catch (Exception e){
			e.printStackTrace();
		}
	}
}