package com.news.controller.command.impl;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.news.controller.command.Command;
import com.news.model.News;
import com.news.services.NewsService;
import com.news.services.ServiceProvider;
import com.news.services.ServicesException;

public class MainPageCommand implements Command{
	private static final String ALL_NEWS_ATTRIBUTE = "allNews";
	private static final String PAGE_URL = "/WEB-INF/jsp/news.jsp";

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ServiceProvider provider = ServiceProvider.getInstance();
		NewsService newsService = provider.getNewsService();
		List<News> allNews = null;
		try {
			 allNews = newsService.findAll();
			
		} catch (ServicesException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 req.setAttribute(ALL_NEWS_ATTRIBUTE, allNews);
		 req.getServletContext().getRequestDispatcher(PAGE_URL).forward(req, resp);
	}

}
