package com.news.controller.command;

import java.util.HashMap;
import java.util.Map;

import com.news.controller.command.impl.AddNewsCommand;
import com.news.controller.command.impl.AddNewsPageCommand;
import com.news.controller.command.impl.DeleteChosenNewsCommand;
import com.news.controller.command.impl.DeleteNewsCommand;
import com.news.controller.command.impl.EditNewsCommand;
import com.news.controller.command.impl.EditNewsPageCommand;
import com.news.controller.command.impl.LocaleChangeCommand;
import com.news.controller.command.impl.MainPageCommand;
import com.news.controller.command.impl.ShowCertainNewsCommand;


public class CommandProvider {
	private Map<String, Command> commands = new HashMap<>();
	
	public CommandProvider() {
		commands.put("main", new MainPageCommand());
		commands.put("show", new ShowCertainNewsCommand());
		commands.put("delete", new DeleteNewsCommand());
		commands.put("addPage", new AddNewsPageCommand());
		commands.put("addNews", new AddNewsCommand());
		commands.put("editPage", new EditNewsPageCommand());
		commands.put("edit", new EditNewsCommand());
		commands.put("deleteChosen", new DeleteChosenNewsCommand());
		commands.put("localeChange", new LocaleChangeCommand());
	}
	
	public Command getCommand(String commandName) {
		return commands.get(commandName);
	}
}
