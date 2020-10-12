package com.news.controller.command.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.news.controller.Controller;
import com.news.controller.command.Command;
import com.news.model.News;
import com.news.services.NewsService;
import com.news.services.ServiceProvider;
import com.news.services.ServicesException;
import com.news.services.impl.NewsValidationService;

public class AddNewsCommand implements Command {
	private static final String PAGE_URL = "controller?command=main";
	private static final String NEWS_TITLE = "title";
	private static final String NEWS_BRIEF = "brief";
	private static final String NEWS_CONTENT = "content";
	private static final String COMMAND_ADD_PAGE = "addPage";
	private static final Logger logger = LogManager.getLogger(AddNewsCommand.class);

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String title = new String(req.getParameter(NEWS_TITLE).getBytes("ISO-8859-1"), "UTF-8");
		String brief = new String(req.getParameter(NEWS_BRIEF).getBytes("ISO-8859-1"), "UTF-8");
		String content = new String(req.getParameter(NEWS_CONTENT).getBytes("ISO-8859-1"), "UTF-8");
		News news = new News(title, brief, content);
		ServiceProvider provider = ServiceProvider.getInstance();
		NewsService service = provider.getNewsService();
		NewsValidationService validator = new NewsValidationService();
		if (validator.validate(req, resp, news, COMMAND_ADD_PAGE)) {
			try {
				service.save(news);
				logger.info("The News was succesfully saved");
			} catch (ServicesException e) {
			logger.error("Service Exception while saving new News to the DB");
			}
			resp.sendRedirect(PAGE_URL);
		}

	}

}
