package in.Delete;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class DeleteDemo {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter User ID To Delete Your Details : ");
		String uid = sc.nextLine();
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/smartprogrammingpractice", "root","rashmi");
		PreparedStatement ps = con.prepareStatement("delete from players  where UID=?");
		ps.setString(1, uid);
		

		int count = ps.executeUpdate();

		if (count > 0) {
			System.out.println("Your Details Deleted Successfully");
		} else {
			System.out.println("User Id Not Found ------> Deletion Failed");
		}
		con.close();

	}

}
