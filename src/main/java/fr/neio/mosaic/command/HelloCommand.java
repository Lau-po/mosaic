package fr.neio.mosaic.command;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.btobastian.javacord.entities.message.Message;
import de.btobastian.sdcf4j.Command;
import de.btobastian.sdcf4j.CommandExecutor;

public class HelloCommand implements CommandExecutor{

	Logger logger = LoggerFactory.getLogger(HelloCommand.class);
	
	@Command(aliases = {"!hello"}, description = "Say hello!")
	    public void onHello(Message message) {
    	logger.info(message.getAuthor().getName() + " has launched the hello command");
	    	message.reply("Hello " + message.getAuthor().getName());
	    }
}
