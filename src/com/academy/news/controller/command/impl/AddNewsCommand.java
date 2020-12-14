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

public class AddNewsCommand implements Command {
	private static final String CERTAIN_NEWS_ATTRIBUTE = "certainNews";
	private static final String TITLE_WARNING_ATTRIBUTE = "titleWarning";
	private static final String BRIEF_WARNING_ATTRIBUTE = "briefWarning";
	private static final String CONTENT_WARNING_ATTRIBUTE = "contentWarning";
	private static final int WARNING = 10;
	private static final String PAGE_URL = "controller?command=main";
	private static final String NEWS_TITLE = "title";
	private static final String NEWS_BRIEF = "brief";
	private static final String NEWS_CONTENT = "content";
	private static final String COMMAND_ADD_PAGE = "controller?command=addPage";
	private static final Logger logger = LogManager.getLogger(AddNewsCommand.class);

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String title = req.getParameter(NEWS_TITLE);
		String brief = req.getParameter(NEWS_BRIEF);
		String content = req.getParameter(NEWS_CONTENT);
		News news = new News(title, brief, content);
		ServiceProvider provider = ServiceProvider.getInstance();
		NewsService service = provider.getNewsService();
		if (!NewsValidationService.titleValidation(title)) {
			req.setAttribute(CERTAIN_NEWS_ATTRIBUTE, news);
			req.setAttribute(TITLE_WARNING_ATTRIBUTE, WARNING);
			req.getRequestDispatcher(COMMAND_ADD_PAGE).forward(req, resp);
			logger.info("The News did not pass validation");
		} else if (!NewsValidationService.briefValidation(brief)) {
			req.setAttribute(CERTAIN_NEWS_ATTRIBUTE, news);
			req.setAttribute(BRIEF_WARNING_ATTRIBUTE, WARNING);
			req.getRequestDispatcher(COMMAND_ADD_PAGE).forward(req, resp);
			logger.info("The News did not pass validation");
		} else if (!NewsValidationService.contentValidation(content)) {
			req.setAttribute(CERTAIN_NEWS_ATTRIBUTE, news);
			req.setAttribute(CONTENT_WARNING_ATTRIBUTE, WARNING);
			req.getRequestDispatcher(COMMAND_ADD_PAGE).forward(req, resp);
			logger.info("The News did not pass validation");
		} else {
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
