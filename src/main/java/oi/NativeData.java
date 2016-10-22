package oi;

import java.sql.*;

public class NativeData {

	public NativeData() {
		try {

			Class.forName("org.hsqldb.jdbcDriver");
			Connection con = DriverManager
					.getConnection("jdbc:hsqldb:hsql://localhost/;shutdown=true", "sa", "");

			Statement stmt = con.createStatement();
			String update = "insert into CUSTOMER values('pitt','erick')";
			String getData = "select * FROM CUSTOMER";
			String delete = "DELETE FROM CUSTOMER WHERE FIRSTNAME='pitt'";
			
//			stmt.executeUpdate(update);
//			stmt.executeUpdate(delete);
			
			ResultSet rs = stmt.executeQuery(getData);
			
			while (rs.next()) {
				System.out.println(rs.getString(1));
				System.out.println(rs.getString(2));

			}
			
			rs.close();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
