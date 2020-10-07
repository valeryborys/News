package com.news.services.impl;

import java.util.List;

import com.news.db.dao.DaoProvider;
import com.news.db.dao.NewsDAO;
import com.news.db.dao.impl.DaoException;
import com.news.model.News;
import com.news.services.NewsService;
import com.news.services.ServicesException;

public class NewsServiceImpl implements NewsService {

	@Override
	public void save(News news) throws ServicesException {
		try {
			DaoProvider provider = DaoProvider.getInstance();
			NewsDAO<News> newsDao = provider.getNewsDao();
			newsDao.save(news);
		} catch (DaoException e) {
			throw new ServicesException("Save in DB service exception", e);
		}

	}

	@Override
	public News find(int id) throws ServicesException {
		try {
			DaoProvider provider = DaoProvider.getInstance();
			NewsDAO<News> newsDao = provider.getNewsDao();
			return newsDao.find(id);
		} catch (DaoException e) {
			throw new ServicesException("Find in DB service exception", e);
		}
	}

	@Override
	public void delete(int id) throws ServicesException {
		try {
			DaoProvider provider = DaoProvider.getInstance();
			NewsDAO<News> newsDao = provider.getNewsDao();
			newsDao.delete(id);
		} catch (DaoException e) {
			throw new ServicesException("Delete from DB service exception", e);
		}
	}

	@Override
	public void update(News news) throws ServicesException {
		try {
			DaoProvider provider = DaoProvider.getInstance();
			NewsDAO<News> newsDao = provider.getNewsDao();
			newsDao.update(news);
		} catch (DaoException e) {
			throw new ServicesException("Update in DB service exception", e);
		}
	}

	@Override
	public List<News> findAll() throws ServicesException {
		try {
			DaoProvider provider = DaoProvider.getInstance();
			NewsDAO<News> newsDao = provider.getNewsDao();
			return newsDao.findAll();
		} catch (DaoException e) {
			throw new ServicesException("Find all in DB service exception", e);
		}
	}
	@Override
	public void delete(int[] checkbox) throws ServicesException {
		try {
			DaoProvider provider = DaoProvider.getInstance();
			NewsDAO<News> newsDao = provider.getNewsDao();
			newsDao.delete(checkbox);
		} catch (DaoException e) {
			throw new ServicesException("Delete from DB service exception", e);
		}
	}

}
