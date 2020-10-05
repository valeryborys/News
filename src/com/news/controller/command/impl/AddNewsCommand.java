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

public class AddNewsCommand implements Command{
	private static final String PAGE_URL = "controller?command=main";
	private static final String NEWS_TITLE = "title";
	private static final String NEWS_BRIEF = "brief";
	private static final String NEWS_CONTENT = "content";

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    String title = new String(req.getParameter(NEWS_TITLE).getBytes("ISO-8859-1"), "UTF-8");
	    String brief = new String(req.getParameter(NEWS_BRIEF).getBytes("ISO-8859-1"), "UTF-8");
	    String content = new String(req.getParameter(NEWS_CONTENT).getBytes("ISO-8859-1"), "UTF-8");
	    News news = new News(title, brief, content);
	    ServiceProvider provider = ServiceProvider.getInstance();
	    NewsService service = provider.getNewsService();
	    try {
			service.save(news);
		} catch (ServicesException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    resp.sendRedirect(PAGE_URL);
	    
		
	}

}