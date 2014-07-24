package cinema.db;

import java.sql.Connection;

public class AbstractRepository {
	
	private Connection connection;

	public AbstractRepository(Connection connection) {
		super();
		this.connection = connection;
	}

	protected Connection getConnection() {
		return connection;
	}
	
	

}
