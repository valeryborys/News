package com.news.db.connectionpool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import com.news.db.dao.impl.DaoException;

public class ConnectionPool {

	private static ConnectionPool instance;
	private static final String DB_URL = "db.url";
	private static final String DB_DRIVER_CLASS_NAME = "db.driverClassName";
	private static final String DB_LOGIN = "db.login";
	private static final String DB_PASSWORD = "db.password";
	private static final String DB_CONNECTIONS_QUANTITY = "db.connectionsQuantity";
	private static final String RESOURSES = "resources.db";
	private BlockingQueue<Connection> freeConnections;
	private BlockingQueue<Connection> givenConnections;

	private ConnectionPool() {

	}

	public static ConnectionPool getInstance() {
		if (instance == null) {
			synchronized (DB_CONNECTIONS_QUANTITY) {
				if (instance == null) {
					instance = new ConnectionPool();
					instance.init();
				}
			}
		}
		return instance;
	}

	public void init() {
		try {
			ResourceBundle bundle = ResourceBundle.getBundle(RESOURSES);
			String dbUrl = bundle.getString(DB_URL);
			String dbDriverClassName = bundle.getString(DB_DRIVER_CLASS_NAME);
			String dbLogin = bundle.getString(DB_LOGIN);
			String dbPassword = bundle.getString(DB_PASSWORD);
			int dbConnectionsQantity = Integer.parseInt(bundle.getString(DB_CONNECTIONS_QUANTITY));
			Class.forName(dbDriverClassName);
			freeConnections = new ArrayBlockingQueue<Connection>(dbConnectionsQantity);
			givenConnections = new ArrayBlockingQueue<Connection>(dbConnectionsQantity);
			for (int i = 0; i < dbConnectionsQantity; i++) {
				Connection connection = DriverManager.getConnection(dbUrl, dbLogin, dbPassword);
				freeConnections.put(connection);
			}
		} catch (SQLException | ClassNotFoundException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Connection takeConnection() {
		Connection connection = null;
		try {
			connection = freeConnections.take();
			givenConnections.put(connection);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;

	}

	public void returnConnection(Connection connection) throws DaoException {
		try {
			if (connection.isClosed() || connection == null) {
				throw new DaoException("connection is empty");
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			givenConnections.remove(connection);
			freeConnections.put(connection);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
