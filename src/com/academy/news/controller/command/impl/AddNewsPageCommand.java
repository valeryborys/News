package com.academy.news.controller.command.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.academy.news.controller.command.Command;

public class AddNewsPageCommand implements Command {
	private static final String PAGE_URL = "/WEB-INF/jsp/addNews.jsp";

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher(PAGE_URL).forward(req, resp);
		;

	}

}
