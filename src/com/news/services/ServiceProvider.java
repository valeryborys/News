package com.news.services;

import com.news.services.impl.NewsServiceImpl;

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
