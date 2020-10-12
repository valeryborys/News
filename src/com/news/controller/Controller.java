package com.news.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.news.controller.command.Command;
import com.news.controller.command.CommandProvider;

public class Controller extends HttpServlet {
	private final CommandProvider provider = new CommandProvider();
	private static final long serialVersionUID = 1L;
	private static final String COMMAND = "command";

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String commandName = req.getParameter(COMMAND);
		Command command = provider.getCommand(commandName);
		command.execute(req, resp);
	
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req,resp);
	}
	
	

}
