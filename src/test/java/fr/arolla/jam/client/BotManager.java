package fr.arolla.jam.client;


import fr.arolla.jam.bus.simpleslackapi.SlackChannel;
import fr.arolla.jam.bus.simpleslackapi.SlackSession;
import fr.arolla.jam.bus.simpleslackapi.events.SlackMessagePosted;
import fr.arolla.jam.bus.simpleslackapi.impl.SlackSessionFactory;
import fr.arolla.jam.bus.simpleslackapi.listeners.SlackMessagePostedListener;
import fr.arolla.jam.client.addition.Addition;
import org.junit.Ignore;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * Created by raphael_squelbut on 22/01/16.
 */
@Ignore
public class BotManager {
	private static final Logger LOGGER = LoggerFactory.getLogger(BotOneTest.class);
	private static final String BOTMANAGER_TOKEN = "xoxb-19249860497-Pw2hdd7nPfkPTlRCaVrlqlW3";

	@Test
	public void should_() throws IOException, InterruptedException {
		final SlackSession session = SlackSessionFactory.createWebSocketSlackSession(BOTMANAGER_TOKEN);

		session.addMessagePostedListener(createMessagePostedListener());
		session.connect();
		session.joinChannel("random");
		while (true) {
			Thread.sleep(1000);
		}
	}

	private SlackMessagePostedListener createMessagePostedListener() {
		return (event, session) -> {
			if (shouldIForgetIt(event, session)) { return; }

			Addition addition = Addition.parse(event.getMessageContent());

			//let's send a message
			final SlackChannel responseChannel = event.getChannel();
			session.sendMessage( //
					responseChannel, //
					addition.result(), //
					null);
		};
	}

	public boolean shouldIForgetIt(final SlackMessagePosted event, final SlackSession session) {
		boolean itSMeWhoSendMessage = itSMeWhoSentMessage(event, session);
		boolean itSAnAddition = itSAnAddition(event);
		final boolean shouldIForgetIt = itSMeWhoSendMessage || !itSAnAddition;
		LOGGER.debug("shouldIForgetIt : " + shouldIForgetIt);
		return shouldIForgetIt;
	}

	private boolean itSAnAddition(final SlackMessagePosted event) {
		final String message = event.getMessageContent();
		final boolean itsAnAddition = Addition.accept(message);
		LOGGER.debug(message + " is an addition : " + itsAnAddition);
		return itsAnAddition;
	}

	public boolean itSMeWhoSentMessage(final SlackMessagePosted event, final SlackSession session) {
		return event.getSender().getId().equals(session.sessionPersona().getId());
	}
}
