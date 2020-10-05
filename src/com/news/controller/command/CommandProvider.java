package com.news.controller.command;

import java.util.HashMap;
import java.util.Map;

import com.news.controller.command.impl.MainPageCommand;
import com.news.controller.command.impl.ShowCertainNews;


public class CommandProvider {
	private Map<String, Command> commands = new HashMap<>();
	
	public CommandProvider() {
		commands.put("main", new MainPageCommand());
		commands.put("show", new ShowCertainNews());
	}
	
	public Command getCommand(String commandName) {
		return commands.get(commandName);
	}
}
