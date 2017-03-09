package fr.neio.mosaic.command;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.btobastian.javacord.entities.message.Message;
import de.btobastian.sdcf4j.Command;
import de.btobastian.sdcf4j.CommandExecutor;

public class EchoCommand implements CommandExecutor{

		Logger logger = LoggerFactory.getLogger(EchoCommand.class);
	
	    @Command(aliases = {"!echo"}, description = "Send Gif!")
	    public void onEcho(Message message) {
	    	logger.info(message.getAuthor().getName() + " has launched the gif command");
	    	message.getAuthor().sendMessage("Tu m'as dis \"" +message.getContent() + "\"");
//	    	message.reply("You are in channel #" + channel.getName() + " sending arg1 " + args[0]);
	    }
}
