package com.academy.news.controller.command.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.academy.news.controller.command.Command;
import com.academy.news.model.News;
import com.academy.news.service.NewsService;
import com.academy.news.service.ServiceProvider;
import com.academy.news.service.ServicesException;

public class ShowCertainNewsCommand implements Command {
	private static final String CERTAIN_NEWS_ATTRIBUTE = "certainNews";
	private static final String ID = "id";
	private static final String PAGE_URL = "/WEB-INF/jsp/certainNews.jsp";
	private static final Logger logger = LogManager.getLogger(ShowCertainNewsCommand.class);

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ServiceProvider provider = ServiceProvider.getInstance();
		NewsService service = provider.getNewsService();
		int newsId = Integer.parseInt(req.getParameter(ID));
		News certainNews = null;
		try {
			certainNews = service.find(newsId);

		} catch (ServicesException e) {
			logger.error("Service Exception while finding News in the DB");
		}
		req.setAttribute(CERTAIN_NEWS_ATTRIBUTE, certainNews);
		req.getRequestDispatcher(PAGE_URL).forward(req, resp);

	}

}
