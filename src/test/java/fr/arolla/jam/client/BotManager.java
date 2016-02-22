package fr.arolla.jam.client;

import java.io.IOException;

import fr.arolla.jam.client.ullink.JamBot;
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
	private static final String BOTMANAGER_TOKEN = "xoxb-19249860497-Pw2hdd7nPfkPTlRCaVrlqlW3";

	@Test public void should_create_BotAddition_which_compute_an_addition()
			throws IOException, InterruptedException {
		JamBot.create()
				.withToken(BOTMANAGER_TOKEN)
				.acceptAccordingTo(s -> !s.isEmpty())
				.transformWith(s -> "moi je manage : " + s)
				.build()
				.start();
	}
}
