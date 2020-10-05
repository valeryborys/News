package com.news.db.dao;

import java.util.List;

import com.news.db.dao.impl.DaoException;

public interface NewsDAO<News> {
	void delete(int id) throws DaoException;
	void save(News news) throws DaoException;
	News find(int id) throws DaoException;
	void update(News news) throws DaoException;
	List<News> findAll() throws DaoException;
}
