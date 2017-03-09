/**
 * 
 */
package fr.neio.mosaic.main;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.util.concurrent.FutureCallback;

import de.btobastian.javacord.DiscordAPI;
import de.btobastian.javacord.Javacord;
import de.btobastian.sdcf4j.CommandHandler;
import de.btobastian.sdcf4j.handler.JavacordHandler;
import fr.neio.mosaic.command.EchoCommand;
import fr.neio.mosaic.command.HelloCommand;
import fr.neio.mosaic.command.WebcamCommand;

/**
 * @author Wolf
 *
 */
public class App {

	static Logger logger = LoggerFactory.getLogger(App.class);

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		DiscordAPI api = Javacord.getApi("Mjg5NDU3NTE0NTYxNjY3MDcy.C6Mp4w.YXsmBiCuBgAsSsc6m6Nt7I4kpKQ", true);
		logger.info("Registering Commands");
		CommandHandler cmdHandler = new JavacordHandler(api);
		cmdHandler.registerCommand(new EchoCommand());
		cmdHandler.registerCommand(new HelloCommand());
		cmdHandler.registerCommand(new WebcamCommand());
		logger.info("Commands successfully registered");
		api.connect(new FutureCallback<DiscordAPI>() {
			@Override
			public void onSuccess(final DiscordAPI api) {
				logger.info("Successfully launched!");
			}

			@Override
			public void onFailure(Throwable t) {
				logger.info("Connection failed");
				logger.error(t.getMessage());
			}
		});
		Runtime.getRuntime().addShutdownHook(new Thread() {
			@Override
			public void run() {
				System.out.println("Shutdown hook ran!");
				api.disconnect();
			}
		});

		// Javacord
	}

}
