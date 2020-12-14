package com.academy.news.service.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.academy.news.db.dao.impl.SqlNewsDaoImpl;
import com.academy.news.model.News;

public class NewsValidationService {
	private static final String CERTAIN_NEWS_ATTRIBUTE = "certainNews";
	private static final String COMMAND = "controller?command=";
	private static final String TITLE_WARNING_ATTRIBUTE = "titleWarning";
	private static final String BRIEF_WARNING_ATTRIBUTE = "briefWarning";
	private static final String CONTENT_WARNING_ATTRIBUTE = "contentWarning";
	private static final int MIN_LENGTH = 10;
	private static final int MAX_TITLE_LENGTH= 500;
	private static final int MAX_BRIEF_LENGTH = 3000;
	private static final int WARNING = 10;
	private static final Logger logger = LogManager.getLogger(NewsValidationService.class);

	public NewsValidationService() {

	}

	public boolean validate(HttpServletRequest req, HttpServletResponse resp, News news, String command)
			throws ServletException, IOException {
		if (!titleValidation(news.getTitle())) {
			req.setAttribute(CERTAIN_NEWS_ATTRIBUTE, news);
			req.setAttribute(TITLE_WARNING_ATTRIBUTE, WARNING);
			req.getRequestDispatcher(COMMAND + command).forward(req, resp);
			logger.info("The News did not pass validation");
			return false;
		} else if (!briefValidation(news.getBrief())) {
			req.setAttribute(CERTAIN_NEWS_ATTRIBUTE, news);
			req.setAttribute(BRIEF_WARNING_ATTRIBUTE, WARNING);
			req.getRequestDispatcher(COMMAND + command).forward(req, resp);
			logger.info("The News did not pass validation");
			return false;
		} else if (!contentValidation(news.getContent())) {
			req.setAttribute(CERTAIN_NEWS_ATTRIBUTE, news);
			req.setAttribute(CONTENT_WARNING_ATTRIBUTE, WARNING);
			req.getRequestDispatcher(COMMAND + command).forward(req, resp);
			logger.info("The News did not pass validation");
			return false;
		} else
			return true;
	}

	private boolean titleValidation(String title) {
		if (title.length() < MIN_LENGTH || title.length() > MAX_TITLE_LENGTH) {
			return false;
		}
		return true;
	}

	private boolean briefValidation(String brief) {
		if (brief.length() < MIN_LENGTH || brief.length() > MAX_BRIEF_LENGTH) {
			return false;
		}
		return true;
	}

	private boolean contentValidation(String content) {
		if (content.length() < MIN_LENGTH) {
			return false;
		}
		return true;

	}

}
