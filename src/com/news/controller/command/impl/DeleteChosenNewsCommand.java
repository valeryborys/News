package com.news.controller.command.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.news.controller.command.Command;
import com.news.services.NewsService;
import com.news.services.ServiceProvider;
import com.news.services.ServicesException;

public class DeleteChosenNewsCommand implements Command {
	private static final String PAGE_URL = "controller?command=main";

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String[] checkboxString = req.getParameterValues("deleteCheckbox");
		int[] checkbox = new int[checkboxString.length];
		for (int i = 0; i < checkboxString.length; i++) {
			checkbox[i] = Integer.parseInt(checkboxString[i]);
		}
		ServiceProvider provider = ServiceProvider.getInstance();
		NewsService service = provider.getNewsService();
		try {
			service.delete(checkbox);
		} catch (ServicesException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		resp.sendRedirect(PAGE_URL);

	}

}
