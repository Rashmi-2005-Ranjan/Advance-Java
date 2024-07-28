package in.Fetch;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class FetchDemo {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter User ID To Show Your Details : ");
		String uid = sc.nextLine();
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/smartprogrammingpractice", "root",
				"rashmi");
		PreparedStatement ps = con.prepareStatement("select * from players  where UID=?");
		ps.setString(1, uid);

		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			String NAME = rs.getString("Players Name");
			String USER_ID = rs.getString("UID");
			String STATE = rs.getString("State");
			String CLASS = rs.getString("Class");
			String SPORT_NAME = rs.getString("Type Of Sport");
			int JERCY_NO = rs.getInt("Jersy No");
			long PHONE_NO = rs.getLong("Phone Number");
			String GENDER = rs.getString("Gender");
			int AGE = rs.getInt("AGE");
			
			
			
			System.out.println("YOUR NAME : " + NAME);
			System.out.println("-----------------------------------------");
			System.out.println("YOUR USER ID : " + USER_ID);
			System.out.println("-----------------------------------------");

			System.out.println("YOUR STATE : " + STATE);
			System.out.println("-----------------------------------------");

			System.out.println("YOUR CLASS : " + CLASS);
			System.out.println("-----------------------------------------");

			System.out.println("YOUR EXPERTISE : " + SPORT_NAME);
			System.out.println("-----------------------------------------");

			System.out.println("YOUR JERCY NUMBER : " + JERCY_NO);
			System.out.println("-----------------------------------------");

			System.out.println("YOUR PHONE NUMBER : " + PHONE_NO);
			System.out.println("-----------------------------------------");

			System.out.println("YOUR GENDER : " + GENDER);
			System.out.println("-----------------------------------------");

			System.out.println("YOUR AGE : " + AGE);
			System.out.println("-----------------------------------------");

		}
		con.close();

	}

}
