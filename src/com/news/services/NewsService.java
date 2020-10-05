package com.news.services;

import java.util.List;

import com.news.model.News;

public interface NewsService {

	void save(News news) throws ServicesException;
	News find(int id) throws ServicesException;
	void delete(int id) throws ServicesException;
	void update(News news) throws ServicesException;
	List<News> findAll() throws ServicesException;
	
}