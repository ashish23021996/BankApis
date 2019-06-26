package apis.bank.indian;

import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbcp2.BasicDataSource;

public class BranchesDao {
	private BasicDataSource connectionPool;

	public BranchesDao() {
		super();

		connectionPool = DatabaseConnection.getDataSource();

	}

	public List<Branches> getAllBranches(String bank_name, String city_name) {

		List<Branches> branchList = new ArrayList<Branches>();

		Statement stmt = null;
		try {
			Connection c = connectionPool.getConnection();
			System.out.println("Opened database successfully");

			stmt = c.createStatement();
			System.out.println("select * from branches where city = '" + city_name
					+ "' and bank_id = (select id from banks where name ='" + bank_name + "' ); ");
			ResultSet rs = stmt.executeQuery("select * from branches where city = '" + city_name
					+ "' and bank_id = (select id from banks where name ='" + bank_name + "' ) ;");
			while (rs.next()) {

				String ifsc = rs.getString("ifsc");
				int id = rs.getInt("bank_id");
				String branch = rs.getString("branch");
				String address = rs.getString("address");
				String city = rs.getString("city");
				String district = rs.getString("district");
				String state = rs.getString("state");
				Branches branches = new Branches(ifsc, id, branch, address, city, district, state);

				branchList.add(branches);

			}
			rs.close();
			stmt.close();

		} catch (Exception e) {

			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		System.out.println("Operation done successfully");

		return branchList;
	}

	public List<Branches> getAllBranches(String bank_name, String city_name, String limit) {

		List<Branches> branchList = new ArrayList<Branches>();

		Statement stmt = null;
		try {
			Connection c = connectionPool.getConnection();
			System.out.println("The Connection Object is of Class: " + c.getClass());
			System.out.println("Opened database successfully");

			stmt = c.createStatement();
			System.out.println("select * from branches where city = '" + city_name
					+ "' and bank_id = (select id from banks where name ='" + URLEncoder.encode(bank_name, "UTF-8")
					+ "' ) " + limit + ";");
			ResultSet rs = stmt.executeQuery("select * from branches where city = '" + city_name
					+ "' and bank_id = (select id from banks where name ='" + bank_name + "' ) " + limit + ";");
			while (rs.next()) {

				String ifsc = rs.getString("ifsc");
				int id = rs.getInt("bank_id");
				String branch = rs.getString("branch");
				String address = rs.getString("address");
				String city = rs.getString("city");
				String district = rs.getString("district");
				String state = rs.getString("state");
				Branches branches = new Branches(ifsc, id, branch, address, city, district, state);

				branchList.add(branches);

			}
			rs.close();
			stmt.close();
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		System.out.println("Operation done successfully");

		return branchList;
	}

	public List<Branches> getAllBranches(String bank_name, String city_name, String limit, String offset) {
		// TODO Auto-generated method stub

		List<Branches> branchList = new ArrayList<Branches>();

		Statement stmt = null;
		try {
			Connection c = connectionPool.getConnection();
			System.out.println("The Connection Object is of Class: " + c.getClass());
			System.out.println("Opened database successfully");

			stmt = c.createStatement();
			System.out.println("select * from branches where city = '" + city_name
					+ "' and bank_id = (select id from banks where name ='" + bank_name + "' ) " + limit + " " + offset
					+ ";");
			ResultSet rs = stmt.executeQuery("select * from branches where city = '" + city_name
					+ "' and bank_id = (select id from banks where name ='" + bank_name + "' ) " + limit + " " + offset
					+ ";");
			while (rs.next()) {

				String ifsc = rs.getString("ifsc");
				int id = rs.getInt("bank_id");
				String branch = rs.getString("branch");
				String address = rs.getString("address");
				String city = rs.getString("city");
				String district = rs.getString("district");
				String state = rs.getString("state");
				Branches branches = new Branches(ifsc, id, branch, address, city, district, state);

				branchList.add(branches);

			}
			rs.close();
			stmt.close();
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		System.out.println("Operation done successfully");

		return branchList;

	}

}
