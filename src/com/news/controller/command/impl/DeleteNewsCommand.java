package com.news.controller.command.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.news.controller.command.Command;
import com.news.services.NewsService;
import com.news.services.ServiceProvider;
import com.news.services.ServicesException;

public class DeleteNewsCommand implements Command {
	private static final String ID = "id";
	private static final String PAGE_URL = "controller?command=main";

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ServiceProvider provider = ServiceProvider.getInstance();
		NewsService service = provider.getNewsService();
		int newsId = Integer.parseInt(req.getParameter(ID));
		try {
			service.delete(newsId);
		} catch (ServicesException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		resp.sendRedirect(PAGE_URL);

	}

}
