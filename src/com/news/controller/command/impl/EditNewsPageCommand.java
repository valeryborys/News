package com.news.controller.command.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.news.controller.command.Command;
import com.news.model.News;
import com.news.services.NewsService;
import com.news.services.ServiceProvider;
import com.news.services.ServicesException;

public class EditNewsPageCommand implements Command {
	private static final String ID = "id";
	private static final String PAGE_URL = "/WEB-INF/jsp/editNews.jsp";
	private static final String CERTAIN_NEWS_ATTRIBUTE = "certainNews";

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int newsId = Integer.parseInt(req.getParameter(ID));
		ServiceProvider provider = ServiceProvider.getInstance();
		NewsService service = provider.getNewsService();
		News certainNews = null;
		if (req.getAttribute(CERTAIN_NEWS_ATTRIBUTE) != null) {
			req.getRequestDispatcher(PAGE_URL).forward(req, resp);
		} else {
			try {
				certainNews = service.find(newsId);
			} catch (ServicesException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			req.setAttribute(CERTAIN_NEWS_ATTRIBUTE, certainNews);
			req.getRequestDispatcher(PAGE_URL).forward(req, resp);
		}
	}
}
