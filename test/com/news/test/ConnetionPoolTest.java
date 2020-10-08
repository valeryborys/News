package com.news.test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.sql.Connection;

import org.junit.Test;

import com.news.db.connectionpool.ConnectionPool;
import com.news.db.dao.impl.DaoException;

public class ConnetionPoolTest {
	
	@Test
	public void getConnectionTest() {
		ConnectionPool pool = null;
		Connection connection = null;
		try {
		pool = ConnectionPool.getInstance();
		connection = pool.takeConnection();
		assertNotNull(connection);
		}finally {
			if (connection != null) {
			try {
				pool.returnConnection(connection);
			} catch (DaoException e) {
				e.printStackTrace();
			}
			}
		}
		
		
	}

}
