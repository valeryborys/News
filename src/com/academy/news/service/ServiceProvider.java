package com.academy.news.service;

import com.academy.news.service.impl.NewsServiceImpl;

public class ServiceProvider {
	private static final ServiceProvider instance = new ServiceProvider();
	
	private ServiceProvider() {}
	
	private NewsService newsService = new NewsServiceImpl();

	
	
	public NewsService getNewsService() {
		return newsService;
		
	}
	
	
	public static ServiceProvider getInstance() {
		return instance;
		
	}
}
