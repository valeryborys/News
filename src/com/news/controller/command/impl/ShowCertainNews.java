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

public class ShowCertainNews implements Command {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ServiceProvider provider = ServiceProvider.getInstance();
		NewsService service = provider.getNewsService();
		int newsId = Integer.parseInt(req.getParameter("id"));
		News certainNews = null;
		try {
			certainNews = service.find(newsId);
			
		} catch (ServicesException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		req.setAttribute("certainNews", certainNews);
		req.getServletContext().getRequestDispatcher("/WEB-INF/jsp/certainNews.jsp").forward(req, resp);
		
		
	}

}
