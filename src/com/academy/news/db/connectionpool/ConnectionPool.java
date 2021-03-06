package com.academy.news.db.connectionpool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.academy.news.db.dao.impl.DaoException;

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
	private static final Logger logger = LogManager.getLogger(ConnectionPool.class);

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
			logger.error("Connection Pool intialization exception");
		}
	}

	public Connection takeConnection() {
		Connection connection = null;
		try {
			connection = freeConnections.take();
			givenConnections.put(connection);
		} catch (InterruptedException e) {
			logger.error("Connection Pool take connection exception");
		}
		return connection;
	}

	public void returnConnection(Connection connection) throws DaoException {
		try {
			if (connection.isClosed() || connection == null) {
				throw new DaoException("connection is empty");
			}
		} catch (SQLException e1) {
			logger.error("Connection Pool connection returning exception. Connection is empty");
		}
		try {
			givenConnections.remove(connection);
			freeConnections.put(connection);
		} catch (InterruptedException e) {
			logger.error("Connection Pool connection returning exception.");
		}
	}

}
