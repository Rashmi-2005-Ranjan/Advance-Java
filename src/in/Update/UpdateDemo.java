package in.Update;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.*;

public class UpdateDemo {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter User ID : ");
		String uid = sc.nextLine();
		System.out.println("Enter The State Name You Want To Update : ");
		String state = sc.nextLine();
		System.out.println("Enter The Class You Want To Update : ");
		String Cllass = sc.nextLine();
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/smartprogrammingpractice", "root","rashmi");

//		System.out.println("Connection EstaBlished With Database");

		PreparedStatement ps = con.prepareStatement("update players set State=?,Class=? where UID=?");
		ps.setString(1, state);
		ps.setString(2, Cllass);
		ps.setString(3, uid);

		int count = ps.executeUpdate();

		if (count > 0) {
			System.out.println("Updated Successfully");
		} else {
			System.out.println("User Id Not Found ------> Updation Failed");
		}
		con.close();
	}

}
