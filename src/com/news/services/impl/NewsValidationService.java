package com.news.services.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.news.model.News;

public class NewsValidationService {
	private static final String CERTAIN_NEWS_ATTRIBUTE = "certainNews";
	private static final String COMMAND = "controller?command=";
	private static final String TITLE_WARNING_ATTRIBUTE = "titleWarning";
	private static final String TITLE_WARNING = "Title should contain from 10 to 500 characters.";
	private static final String BRIEF_WARNING_ATTRIBUTE = "briefWarning";
	private static final String BRIEF_WARNING = "Brief should contain from 10 to 3000 characters.";
	private static final String CONTENT_WARNING_ATTRIBUTE = "contentWarning";
	private static final String CONTENT_WARNING = "Content should contain at least 10 characters.";
	private String title;
	private String brief;
	private String content;
	
	public NewsValidationService() {
		
	}
	

	public boolean validate(HttpServletRequest req, HttpServletResponse resp, News news, String command) throws ServletException, IOException {
		this.title=news.getTitle();
		this.brief=news.getBrief();
		this.content=news.getContent();
		if (!titleValidation()) {
			req.setAttribute(CERTAIN_NEWS_ATTRIBUTE, news);
	    	req.setAttribute(TITLE_WARNING_ATTRIBUTE, TITLE_WARNING);
	    	req.getRequestDispatcher(COMMAND+command).forward(req, resp);
	    	return false;
		} else if (!briefValidation()) {
			req.setAttribute(CERTAIN_NEWS_ATTRIBUTE, news);
	    	req.setAttribute(BRIEF_WARNING_ATTRIBUTE, BRIEF_WARNING);
	    	req.getRequestDispatcher(COMMAND+command).forward(req, resp);
	    	return false;
		} else if (!contentValidation()) {
			req.setAttribute(CERTAIN_NEWS_ATTRIBUTE, news);
	    	req.setAttribute(CONTENT_WARNING_ATTRIBUTE, CONTENT_WARNING);
	    	req.getRequestDispatcher(COMMAND+command).forward(req, resp);
	    	return false;
		} else return true;
	}
	
	private boolean titleValidation() {
		if (this.title.length()<10 || this.title.length()>500) {
			return false;
		}
		return true;
	}
	private boolean briefValidation() {
		if (this.brief.length()<10 || this.brief.length()>3000) {
			return false;
		}
		return true;
	}
	private boolean contentValidation() {
		if (this.content.length()<10) {
			return false;
		}
		return true;
		
	}
	

}
