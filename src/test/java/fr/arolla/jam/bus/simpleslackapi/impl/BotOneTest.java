package fr.arolla.jam.bus.simpleslackapi.impl;

import fr.arolla.jam.bus.simpleslackapi.replies.SlackMessageReply;
import fr.arolla.jam.bus.simpleslackapi.SlackChannel;
import fr.arolla.jam.bus.simpleslackapi.SlackMessageHandle;
import fr.arolla.jam.bus.simpleslackapi.SlackSession;
import fr.arolla.jam.bus.simpleslackapi.listeners.SlackMessagePostedListener;
import fr.arolla.jam.bus.simpleslackapi.replies.GenericSlackReply;

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

			LOGGER.warn("Detect a message : \"" + event.getMessageContent() + "\" from " + event.getSender().getUserName());
			//let's send a message
			final SlackChannel generalChannel = session1.findChannelByName("general");
			session1.joinChannel(generalChannel.getName());
			LOGGER.warn("Found channel : " + generalChannel);
//			session1.leaveChannel(generalChannel);
			final SlackMessageHandle handle = session1.sendMessage( //
					generalChannel, //
					event.getMessageContent(), //
					null);
			LOGGER.warn("Sent message : " + handle.getReply());
			 GenericSlackReply reply = (GenericSlackReply) handle.getReply();
			LOGGER.warn("Reply : "+reply.getPlainAnswer().toJSONString());
			String ts = (String)reply.getPlainAnswer().get("ts");
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				LOGGER.error("error when sleeping", e);
			}

			//2 secs later, let's update the message (I can only update my own messages)
			final SlackMessageHandle updated = session1.updateMessage( //
					ts, //
					generalChannel, //
					event.getMessageContent() + " UPDATED" //
			);

			LOGGER.warn("Updated message : " + updated.getReply());

			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				LOGGER.error("error when sleeping", e);
			}
			 reply = (GenericSlackReply) handle.getReply();
			ts = (String)reply.getPlainAnswer().get("ts");
			//2 secs later, let's now delete the message (I can only delete my own messages)
			final SlackMessageHandle<SlackMessageReply> deleted = session1.deleteMessage( //
					ts, //
					generalChannel);

			LOGGER.warn("Deleted message : " + deleted.getReply());
		};
	}
}
