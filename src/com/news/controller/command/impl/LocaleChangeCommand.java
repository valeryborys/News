package com.news.controller.command.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.news.controller.command.Command;

public class LocaleChangeCommand implements Command {
	private static final Logger logger = LogManager.getLogger(LocaleChangeCommand.class);

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getSession(true).setAttribute("locale", req.getParameter("locale"));
		logger.info("Locale changed to "+ req.getParameter("locale"));
		resp.sendRedirect(req.getHeader("Referer"));

	}

}
