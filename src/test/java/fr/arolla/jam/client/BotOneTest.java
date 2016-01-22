package fr.arolla.jam.client;

import fr.arolla.jam.bus.simpleslackapi.impl.SlackSessionFactory;
import fr.arolla.jam.bus.simpleslackapi.replies.SlackMessageReply;
import fr.arolla.jam.bus.simpleslackapi.SlackChannel;
import fr.arolla.jam.bus.simpleslackapi.SlackMessageHandle;
import fr.arolla.jam.bus.simpleslackapi.SlackSession;
import fr.arolla.jam.bus.simpleslackapi.listeners.SlackMessagePostedListener;
import fr.arolla.jam.bus.simpleslackapi.replies.GenericSlackReply;
import fr.arolla.jam.bus.simpleslackapi.replies.SlackReply;

import org.junit.Ignore;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

@Ignore
public class BotOneTest {
	private static final Logger LOGGER = LoggerFactory.getLogger(BotOneTest.class);
	private static final String BOTONE_TOKEN = "xoxb-19108991843-8XmlhYZSQxvOkbOUnmkkhFoi";

	@Test
	public void should_() throws IOException, InterruptedException {
		final SlackSession session = SlackSessionFactory.createWebSocketSlackSession(BOTONE_TOKEN);

		session.addMessagePostedListener(createMessagePostedListener());
		session.connect();

		while (true) {
			Thread.sleep(1000);
		}
	}

	private SlackMessagePostedListener createMessagePostedListener() {
		return (event, session1) -> {
			if (event.getSender().getId().equals(session1.sessionPersona().getId())) { return; }

			//let's send a message
			final SlackChannel responseChannel = event.getChannel();
			session1.joinChannel(responseChannel.getName());
			final SlackMessageHandle response = session1.sendMessage( //
					responseChannel, //
					event.getMessageContent(), //
					null);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				LOGGER.error("error when sleeping", e);
			}

			//2 secs later, let's update the message (I can only update my own messages)
			final SlackMessageHandle updated = session1.updateMessage( //
					timestamp(response.getReply()), //
					responseChannel, //
					event.getMessageContent() + " UPDATED" //
			);

			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				LOGGER.error("error when sleeping", e);
			}
			//2 secs later, let's now delete the message (I can only delete my own messages)
			session1.deleteMessage( //
					timestamp(response.getReply()), //
					responseChannel);

		};
	}

	private String timestamp(final SlackReply reply) {
		if (reply instanceof GenericSlackReply) {
			return timestamp((GenericSlackReply) reply);
		}
		throw new IllegalArgumentException(reply + " is not a " + GenericSlackReply.class);
	}

	private String timestamp(final GenericSlackReply reply) {
		return (String) reply.getPlainAnswer().get("ts");
	}
}
