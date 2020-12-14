package com.academy.news.db.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.academy.news.db.connectionpool.ConnectionPool;
import com.academy.news.db.dao.NewsDAO;
import com.academy.news.model.News;

public class SqlNewsDaoImpl implements NewsDAO<News> {
	private ConnectionPool pool = ConnectionPool.getInstance();
	private static final String SQL_SAVE_NEWS_TO_DB = "INSERT INTO news.news (title, date, brief, content) VALUES (?, ?, ?, ?)";
	private static final String SQL_FIND_ALL_NEWS = "SELECT * FROM news ORDER BY id DESC";
	private static final String SQL_FIND_BY_ID = "SELECT * FROM news WHERE id = ?;";
	private static final String SQL_DELETE_BY_ID = "DELETE FROM news WHERE id = ?;";
	private static final String SQL_UPDATE_NEWS = "UPDATE news SET title = ?, brief = ?, content = ? WHERE id = ?;";
	private static final Logger logger = LogManager.getLogger(SqlNewsDaoImpl.class);

	@Override
	public void save(News news) throws DaoException {
		String title = news.getTitle();
		String brief = news.getBrief();
		Timestamp date = new Timestamp(System.currentTimeMillis());
		String content = news.getContent();
		Connection connection = pool.takeConnection();
		PreparedStatement statement =null;
		try {
			statement = connection.prepareStatement(SQL_SAVE_NEWS_TO_DB);
			statement.setString(1, title);
			statement.setTimestamp(2, date);
			statement.setString(3, brief);
			statement.setNString(4, content);
			statement.execute();
		} catch (SQLException e) {
			throw new DaoException("Save to DB Exception", e);
		} finally {
			try {
				if (statement != null) {
					statement.close();
				}
				if (connection != null) {
					pool.returnConnection(connection);
				}
			} catch (DaoException | SQLException e) {
			logger.error("Connection returning exception after saving News to the DB");
			}
		}

	}

	@Override
	public List<News> findAll() throws DaoException {
		List<News> list = new ArrayList<>();
		Connection connection = pool.takeConnection();
		Statement statement =null;
		try {
			statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(SQL_FIND_ALL_NEWS);
			while (resultSet.next()) {
				News news = new News(resultSet.getInt(1), resultSet.getString(2), resultSet.getTimestamp(3),
				resultSet.getString(4), resultSet.getString(5));
				list.add(news);
			}
		} catch (SQLException e) {
			throw new DaoException("Find all in DB Exception", e);
		} finally {
			try {
				if (statement != null) {
					statement.close();
				}
				if (connection != null) {
					pool.returnConnection(connection);
				}
			} catch (DaoException | SQLException e) {
				logger.error("Connection returning exception after News finding");
			}
		}
		return list;
	}

	@Override
	public void update(News news) throws DaoException {
		Connection connection = pool.takeConnection();
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(SQL_UPDATE_NEWS);
			statement.setString(1, news.getTitle());
			statement.setString(2, news.getBrief());
			statement.setString(3, news.getContent());
			statement.setInt(4, news.getId());
			statement.execute();
		} catch (SQLException e) {
			throw new DaoException("Update in DB Exception", e);
		} finally {
			try {
				if (statement != null) {
					statement.close();
				}
				if (connection != null) {
					pool.returnConnection(connection);
				}
			} catch (DaoException | SQLException e) {
				logger.error("Connection returning exception after News updating");
			}
		}

	}

	@Override
	public News find(int id) throws DaoException {
		Connection connection = pool.takeConnection();
		News news = new News();
		PreparedStatement statement =null;
		try {
			statement = connection.prepareStatement(SQL_FIND_BY_ID);
			statement.setInt(1, id);
			ResultSet result = statement.executeQuery();
			if (result.next()) {
				news.setId(result.getInt(1));
				news.setTitle(result.getString(2));
				news.setDatetime(result.getTimestamp(3));
				news.setBrief(result.getString(4));
				news.setContent(result.getString(5));
			}
		} catch (SQLException e) {
			throw new DaoException("Find in DB Exception", e);
		} finally {
			try {
				if (statement != null) {
					statement.close();
				}
				if (connection != null) {
					pool.returnConnection(connection);
				}
			} catch (DaoException | SQLException e) {
				logger.error("Connection returning exception after News finding");
			}
		}
		return news;
	}

	@Override
	public void delete(int id) throws DaoException {
		Connection connection = pool.takeConnection();
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(SQL_DELETE_BY_ID);
			statement.setInt(1, id);
			statement.execute();
		} catch (SQLException e) {
			throw new DaoException("Delete form DB Exception", e);
		} finally {
			try {
				if (statement != null) {
					statement.close();
				}
				if (connection != null) {
					pool.returnConnection(connection);
				}
			} catch (DaoException | SQLException e) {
				logger.error("Connection returning exception after News deleting");
			}
		}

	}

	@Override
	public void delete(int[] checkbox) throws DaoException {
		Connection connection = pool.takeConnection();
		PreparedStatement statement = null;
		try {
		for(int id: checkbox) {
			statement = connection.prepareStatement(SQL_DELETE_BY_ID);
			statement.setInt(1, id);
			statement.execute();
		}
		}catch (SQLException e) {
			throw new DaoException("Delete form DB Exception", e);
		} finally {
			try {
				if (statement != null) {
					statement.close();
				}
				if (connection != null) {
					pool.returnConnection(connection);
				}
			} catch (DaoException | SQLException e) {
				logger.error("Connection returning exception after News deleting");
			}
		}
		
	}
	
	

}
