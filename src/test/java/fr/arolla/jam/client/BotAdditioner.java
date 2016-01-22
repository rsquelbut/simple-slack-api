package fr.arolla.jam.client;

import static fr.arolla.jam.client.SlackReplyHelper.slackReplyHelper;

import java.io.IOException;
import java.util.Optional;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.arolla.jam.bus.simpleslackapi.SlackChannel;
import fr.arolla.jam.bus.simpleslackapi.SlackMessageHandle;
import fr.arolla.jam.bus.simpleslackapi.SlackSession;
import fr.arolla.jam.bus.simpleslackapi.events.SlackMessagePosted;
import fr.arolla.jam.bus.simpleslackapi.impl.SlackSessionFactory;
import fr.arolla.jam.bus.simpleslackapi.listeners.SlackMessagePostedListener;
import fr.arolla.jam.client.addition.Addition;
import fr.arolla.jam.client.addition.AdditionParser;

/**
 * Created by raphael_squelbut on 22/01/16.
 */
public class BotAdditioner {
	private static final Logger LOGGER = LoggerFactory.getLogger(BotOneTest.class);
	private static final String BOTONE_TOKEN = "xoxb-19108991843-8XmlhYZSQxvOkbOUnmkkhFoi";
	private final AdditionParser parser = new AdditionParser();

	@Test
	public void should_() throws IOException, InterruptedException {
		final SlackSession session = SlackSessionFactory.createWebSocketSlackSession(BOTONE_TOKEN);

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

			Addition addition = parser.build(event.getMessageContent());

			//let's send a message
			final SlackChannel responseChannel = event.getChannel();
			final SlackMessageHandle response = session.sendMessage( //
					responseChannel, //
					addition.result(), //
					null);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				LOGGER.error("error when sleeping", e);
			}
//
//			//2 secs later, let's update the message (I can only update my own messages)
//			final SlackMessageHandle updated = session.updateMessage( //
//					slackReplyHelper().timestamp(response.getReply()), //
//					responseChannel, //
//					event.getMessageContent() + " UPDATED" //
//			);
//
//			try {
//				Thread.sleep(2000);
//			} catch (InterruptedException e) {
//				LOGGER.error("error when sleeping", e);
//			}
//			//2 secs later, let's now delete the message (I can only delete my own messages)
//			session.deleteMessage( //
//					slackReplyHelper().timestamp(response.getReply()), //
//					responseChannel);
//			session.getPresence(session.sessionPersona());
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
		final boolean itsAnAddition = Optional.of(message).filter(parser::accept).isPresent();
		LOGGER.debug(message + " is an addition : " + itsAnAddition);
		return itsAnAddition;
	}

	public boolean itSMeWhoSentMessage(final SlackMessagePosted event, final SlackSession session) {
		return event.getSender().getId().equals(session.sessionPersona().getId());
	}
}
