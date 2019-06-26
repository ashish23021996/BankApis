package apis.bank.indian;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbcp2.BasicDataSource;

public class BanksDao {
	private BasicDataSource connectionPool;

	public BanksDao() {
		super();

		connectionPool = DatabaseConnection.getDataSource();

	}

	public List<Bank> getAllBanks(String ifsc) {
		List<Bank> bankList = new ArrayList<Bank>();

		Statement stmt = null;
		try {
			Connection c = connectionPool.getConnection();

			stmt = c.createStatement();
			System.out.println("The Connection Object is of Class: " + c.getClass());
			System.out.println(
					"select *  from banks where id = (select bank_id from branches where ifsc = '" + ifsc + "');");
			ResultSet rs = stmt.executeQuery(
					"select *  from banks where id = (select bank_id from branches where ifsc = '" + ifsc + "');");
			while (rs.next()) {

				String name = rs.getString("name");
				int id = rs.getInt("id");
				Bank bank = new Bank(name, id);

				bankList.add(bank);

			}
			rs.close();
			stmt.close();
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		System.out.println("Operation done successfully");

		return bankList;
	}

	public List<Bank> getAllBanks(String ifsc, String limit) {

		List<Bank> bankList = new ArrayList<Bank>();

		Statement stmt = null;
		try {
			Connection c = connectionPool.getConnection();
			System.out.println("The Connection Object is of Class: " + c.getClass());
			System.out.println("Opened database successfully");

			stmt = c.createStatement();
			System.out.println("select *  from banks where id = (select bank_id from branches where ifsc = '" + ifsc
					+ "') " + limit + ";");
			ResultSet rs = stmt
					.executeQuery("select *  from banks where id = (select bank_id from branches where ifsc = '" + ifsc
							+ "')  " + limit + ";");
			while (rs.next()) {

				String name = rs.getString("name");
				int id = rs.getInt("id");
				Bank bank = new Bank(name, id);

				bankList.add(bank);

			}
			rs.close();
			stmt.close();
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		System.out.println("Operation done successfully");

		return bankList;

	}

	public List<Bank> getAllBanks(String ifsc, String limit, String offset) {

		List<Bank> bankList = new ArrayList<Bank>();

		Statement stmt = null;
		try {
			Connection c = connectionPool.getConnection();
			System.out.println("The Connection Object is of Class: " + c.getClass());
			System.out.println("Opened database successfully");

			stmt = c.createStatement();
			System.out.println("select *  from banks where id = (select bank_id from branches where ifsc = '" + ifsc
					+ "' ) " + limit + " " + offset + ";");
			ResultSet rs = stmt
					.executeQuery("select *  from banks where id = (select bank_id from branches where ifsc = '" + ifsc
							+ "' )  " + limit + " " + offset + ";");
			while (rs.next()) {

				String name = rs.getString("name");
				int id = rs.getInt("id");
				Bank bank = new Bank(name, id);

				bankList.add(bank);

			}
			rs.close();
			stmt.close();
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		System.out.println("Operation done successfully");

		return bankList;

	}
}
