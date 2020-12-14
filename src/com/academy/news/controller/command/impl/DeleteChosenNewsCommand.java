package com.academy.news.controller.command.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.academy.news.controller.command.Command;
import com.academy.news.service.NewsService;
import com.academy.news.service.ServiceProvider;
import com.academy.news.service.ServicesException;

public class DeleteChosenNewsCommand implements Command {
	private static final String PAGE_URL = "controller?command=main";
	private static final String PARAVETER_VALUES = "deleteCheckbox";
	private static final Logger logger = LogManager.getLogger(DeleteChosenNewsCommand.class);

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String[] checkboxString = req.getParameterValues(PARAVETER_VALUES);
		int[] checkbox = new int[checkboxString.length];
		for (int i = 0; i < checkboxString.length; i++) {
			checkbox[i] = Integer.parseInt(checkboxString[i]);
		}
		ServiceProvider provider = ServiceProvider.getInstance();
		NewsService service = provider.getNewsService();
		try {
			service.delete(checkbox);
			logger.info("The chosen News was succesfully deleted");
		} catch (ServicesException e) {
			logger.error("Service Exception while deleting News from the DB");
		}
		resp.sendRedirect(PAGE_URL);

	}

}
