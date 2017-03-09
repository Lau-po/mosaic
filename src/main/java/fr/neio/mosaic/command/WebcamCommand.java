package fr.neio.mosaic.command;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.sarxos.webcam.Webcam;

import de.btobastian.javacord.entities.Channel;
import de.btobastian.javacord.entities.message.Message;
import de.btobastian.sdcf4j.Command;
import de.btobastian.sdcf4j.CommandExecutor;
import fr.neio.mosaic.utils.Constants;

public class WebcamCommand implements CommandExecutor {

	Logger logger = LoggerFactory.getLogger(WebcamCommand.class);

	@Command(aliases = { "!pic" }, description = "Get a Picture!")
	public void onHello(Message message, Channel channel) {
		logger.info(message.getAuthor().getName() + " has launched the pic command");
		if (message.isPrivateMessage() && userIsAutorized(message.getAuthor().getId())) {
			message.reply("Voici l'image " + message.getAuthor().getName());
			File f = new File(System.currentTimeMillis()+".png");
			Webcam webcam = Webcam.getDefault();
			webcam.open();
			try {
				ImageIO.write(webcam.getImage(), "PNG", f);
				message.getAuthor().sendFile(f);
			} catch (IOException e) {
				logger.error(e.getMessage());
//				e.printStackTrace();
				message.reply("Oh désolé, un disfonctionnement à eu lieu :/");
			}
			webcam.close();
		}else{
			logger.info(message.getAuthor().getName() + " wasn't allowed to access it ("+message.getAuthor().getId()+")");
		}
	}

	private boolean userIsAutorized(String id) {
		if (id != null) {
			for (int i = 0; i < Constants.USERS_AUTHORIZED.length; i++) {
				if (id.equals(Constants.USERS_AUTHORIZED[i])) {
					return true;
				}
			}
		}
		return false;
	}
}
