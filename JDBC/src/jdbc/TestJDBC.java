package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestJDBC {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Connection c = null;
		Statement s = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/how2java?characterEncoding=UTF-8","root","admin");
			s = c.createStatement();
			String sql = "select * from hero";
			ResultSet rs = s.executeQuery(sql);
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString(2);
				float hp = rs.getFloat("hp");
				int damage = rs.getInt(4);
				System.out.printf("%d\t%s\t%f\t%d%n", id, name, hp, damage);
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(s!=null)
				try {
					s.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			if (c!=null)
				try {
					c.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
	}

}
