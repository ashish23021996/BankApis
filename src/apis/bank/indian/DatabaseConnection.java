package apis.bank.indian;

import org.apache.commons.dbcp2.BasicDataSource;

public class DatabaseConnection {

	private static BasicDataSource connectionPool;

	public static BasicDataSource getDataSource() {
		if (connectionPool == null) {
			System.out.println("going to open a neew connection111");
			String dbUrl = "jdbc:postgresql://ec2-176-34-183-20.eu-west-1.compute.amazonaws.com:5432/d1pq68u3kuvpep?sslmode=require";
			connectionPool = new BasicDataSource();
			connectionPool.setUsername("mahxsmfwyxwjbk");
			connectionPool.setPassword("128e48320cebbdb5f31d48e711a000036d482772fa712db425528279975f51db");
			connectionPool.setDriverClassName("org.postgresql.Driver");
			connectionPool.setUrl(dbUrl);
			connectionPool.setMinIdle(2);
			connectionPool.setMaxIdle(5);
			connectionPool.setMaxOpenPreparedStatements(20);
		}

		return connectionPool;
	}

}
