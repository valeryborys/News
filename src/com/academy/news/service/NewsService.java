package com.academy.news.service;

import java.util.List;

import com.academy.news.model.News;

public interface NewsService {

	void save(News news) throws ServicesException;
	News find(int id) throws ServicesException;
	void delete(int id) throws ServicesException;
	void update(News news) throws ServicesException;
	List<News> findAll() throws ServicesException;
	void delete(int[] checkbox) throws ServicesException;
	
}
