package com.news.controller.command.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.news.controller.command.Command;
import com.news.services.NewsService;
import com.news.services.ServiceProvider;
import com.news.services.ServicesException;

public class DeleteNewsCommand implements Command {
	private static final String ID = "id";
	private static final String PAGE_URL = "controller?command=main";
	private static final Logger logger = LogManager.getLogger(DeleteNewsCommand.class);

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ServiceProvider provider = ServiceProvider.getInstance();
		NewsService service = provider.getNewsService();
		int newsId = Integer.parseInt(req.getParameter(ID));
		try {
			service.delete(newsId);
			logger.info("The News with id=" + newsId + " was succesfully deleted");
		} catch (ServicesException e) {
			logger.error("Service Exception while deleting News from the DB");
		}
		resp.sendRedirect(PAGE_URL);

	}

}
