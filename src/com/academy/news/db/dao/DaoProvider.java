package com.academy.news.db.dao;

import com.academy.news.db.dao.impl.SqlNewsDaoImpl;
import com.academy.news.model.News;

public class DaoProvider {
	private static final DaoProvider instance = new DaoProvider();

	private final NewsDAO<News> newsDao = new SqlNewsDaoImpl();

	private DaoProvider() {
	}

	public NewsDAO<News> getNewsDao() {
		return newsDao;
	}

	public static DaoProvider getInstance() {
		return instance;
	}

}
