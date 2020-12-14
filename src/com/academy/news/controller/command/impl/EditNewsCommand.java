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
import com.academy.news.service.impl.NewsValidationService;

public class EditNewsCommand implements Command {
	private static final String PAGE_URL = "controller?command=show&id=";
	private static final String NEWS_ID = "id";
	private static final String NEWS_TITLE = "title";
	private static final String NEWS_BRIEF = "brief";
	private static final String NEWS_CONTENT = "content";
	private static final String COMMAND_EDIT_PAGE = "editPage";
	private static final Logger logger = LogManager.getLogger(EditNewsCommand.class);

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int newsId = Integer.parseInt(req.getParameter(NEWS_ID));
		String title = new String(req.getParameter(NEWS_TITLE).getBytes("ISO-8859-1"), "UTF-8");
		String brief = new String(req.getParameter(NEWS_BRIEF).getBytes("ISO-8859-1"), "UTF-8");
		String content = new String(req.getParameter(NEWS_CONTENT).getBytes("ISO-8859-1"), "UTF-8");
		News news = new News(newsId, title, brief, content);
		ServiceProvider provider = ServiceProvider.getInstance();
		NewsService service = provider.getNewsService();
		NewsValidationService validator = new NewsValidationService();
		if (validator.validate(req, resp, news, COMMAND_EDIT_PAGE)) {
			try {
				service.update(news);
				logger.info("The News with id=" + newsId + " was succesfully updated");
			} catch (ServicesException e) {
				logger.error("Service Exception while updating News");
			}
			resp.sendRedirect(PAGE_URL + newsId);
		}
	}
}
