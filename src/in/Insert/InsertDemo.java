package in.Insert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.*;

public class InsertDemo {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try {

			// ----Load and register Driver Class----------//
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver Class Loaded Successfully");
			// ----Load and register Driver Class----------//

			// ----Establishing Connection With Database By Providing All The Details Like
			// Database name,User Name,Password----//
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/SmartProgrammingPractice", "root","rashmi");
			System.out.println("Database SmartProgrammingPractice Connected SuccessFully");
			// ----Establishing Connection With Database By Providing All The Details Like
			// Database name,User Name,Password----//

			// -----Taking Input From Client------//
			System.out.println("Enter Players Name");
			String name = sc.nextLine();
			System.out.println("Enter Players userid");
			String uid = sc.nextLine();
			System.out.println("Enter Players State");
			String state = sc.nextLine();
			System.out.println("Enter Players Class");
			String Class = sc.nextLine();
			System.out.println("Enter The Type Of Game players Playing");
			String Type = sc.nextLine();
			System.out.println("Enter Player's Jersey Number");
			int jerseyNo = sc.nextInt();
			System.out.println("Enter Players Mobile Number");
			long mobile = sc.nextLong();
			System.out.println("Enter Players Gender");
			String gender = sc.next();
			System.out.println("Enter Players Age");
			int age = sc.nextInt();
			// -----Taking Input From Client------//

			// ------Different Types Of Method To Insert Value into Database------//

			// Inserting Value Directly
//	        PreparedStatement ps=	con.prepareStatement("insert into players values ('Rohit Sharma','rhit@123','Maharastra','A','Cricket','45','6244378345','Male') ");

			// Inserting Value Via typeCasting
//			PreparedStatement ps = con.prepareStatement("INSERT INTO players VALUES ('" + name + "', '" + uid + "', '" + state + "', '" + Class + "', '" + Type + "', " + jerseyNo + ", " + mobile + ", '" + gender + "', " + age + ")");

			// Inserting Value Via Positional Parameter
			PreparedStatement ps = con.prepareStatement("INSERT INTO players VALUES (?,?,?,?,?,?,?,?,?)");
			ps.setString(1, name);
			ps.setString(2, uid);
			ps.setString(3, state);
			ps.setString(4, Class);
			ps.setString(5, Type);
			ps.setInt(6, jerseyNo);
			ps.setLong(7, mobile);
			ps.setString(8, gender);
			ps.setInt(9, age);
			// Inserting Value Via Positional Parameter
			// ------Different Types Of Method To Insert Value into Database------//

			int i = ps.executeUpdate();
			if (i > 0) {
				System.out.println("Hello User 🙌🙌🙌🙌 Your Registration Done Successfully");
			} else {
				System.out.println("Hello User 🤦‍♂️🤦‍♂️🤦‍♂️🤦‍♂️ You Provide Wrong Value");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
