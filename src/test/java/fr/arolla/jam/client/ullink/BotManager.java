package fr.arolla.jam.client.ullink;

import java.io.IOException;

import fr.arolla.jam.client.Token;
import org.junit.Ignore;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by raphael_squelbut on 22/01/16.
 */
@Ignore
public class BotManager {
	private static final Logger LOGGER = LoggerFactory.getLogger(BotManager.class);

	@Test public void should_create_BotAddition_which_compute_an_addition()
			throws IOException, InterruptedException {
		JamBot.create()
				.withToken(Token.BOT2.get())
				.acceptAccordingTo(s -> !s.isEmpty())
				.transformWith(s -> "moi je manage : " + s)
				.build()
				.start();
	}
}
