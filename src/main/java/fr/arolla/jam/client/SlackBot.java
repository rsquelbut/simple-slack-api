package fr.arolla.jam.client;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.arolla.jam.bus.simpleslackapi.SlackChannel;
import fr.arolla.jam.bus.simpleslackapi.SlackSession;
import fr.arolla.jam.bus.simpleslackapi.events.SlackMessagePosted;
import fr.arolla.jam.bus.simpleslackapi.impl.SlackSessionFactory;
import fr.arolla.jam.bus.simpleslackapi.listeners.SlackMessagePostedListener;

/**
 * Created by raphael_squelbut on 22/02/16.
 */
public abstract class SlackBot {
	private static final Logger LOGGER = LoggerFactory.getLogger(
			SlackBot.class);

	public abstract boolean itIsNotForMe(final String message);

	public abstract String getToken();

	public abstract String readingChannel();

	public abstract String writingChannel();

	public abstract String produceResponse(String message);

	public void start() throws IOException, InterruptedException {
		final SlackSession session = SlackSessionFactory
				.createWebSocketSlackSession(getToken());

		session.addMessagePostedListener(createMessagePostedListener());
		session.connect();
		final String channelToJoin =
				readingChannel() != null ? readingChannel() : "random";
		session.joinChannel(channelToJoin);
		while (true) {
			Thread.sleep(1000);
		}
	}

	protected SlackMessagePostedListener createMessagePostedListener() {
		return (event, session) -> {
			if (shouldIForgetIt(event, session)) {
				return;
			}

			String response = produceResponse(event.getMessageContent());

			//let's send a message
			final SlackChannel responseChannel = findResponseChannel(event,
					session);
			session.sendMessage( //
					responseChannel, //
					response, //
					null);
		};
	}

	protected SlackChannel findResponseChannel(final SlackMessagePosted event,
			final SlackSession session) {
		return writingChannel() != null ?
				session.findChannelByName(readingChannel()) :
				event.getChannel();
	}

	protected boolean shouldIForgetIt(final SlackMessagePosted event,
			final SlackSession session) {
		boolean itSMeWhoSendMessage = itSMeWhoSentMessage(event, session);
		final boolean shouldIForgetIt =
				itSMeWhoSendMessage || itIsNotForMe(event.getMessageContent());
		LOGGER.debug("shouldIForgetIt : " + shouldIForgetIt);
		return shouldIForgetIt;
	}

	protected boolean itSMeWhoSentMessage(final SlackMessagePosted event,
			final SlackSession session) {
		return event.getSender()
				.getId()
				.equals(session.sessionPersona().getId());
	}

	public static SlackBotBuilder create() {
		return new SlackBotBuilder();
	}
}
