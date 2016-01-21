package fr.arolla.slack.simpleslackapi.impl;

import java.io.IOException;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.arolla.slack.simpleslackapi.SlackChannel;
import fr.arolla.slack.simpleslackapi.SlackMessageHandle;
import fr.arolla.slack.simpleslackapi.SlackSession;
import fr.arolla.slack.simpleslackapi.SlackUser;
import fr.arolla.slack.simpleslackapi.replies.SlackChannelReply;
import fr.arolla.slack.simpleslackapi.replies.SlackMessageReply;

/**
 * Created by raphael_squelbut on 21/01/16.
 */
public class JamVsctTest {
	private static final Logger LOGGER = LoggerFactory.getLogger(JamVsctTest.class);

	@Test
	public void should_connect_and_send_a_message() throws IOException, InterruptedException {
		// GIVEN
		// create a session
		final String authToken = "xoxb-19075704544-lzGtSaPXy1GRi4H5xzT0ry1F";
		final SlackSession session = SlackSessionFactory.createWebSocketSlackSession(authToken);

		//		 listening messages
		configureSession(session, "test");

		session.connect();

		final SlackUser botdecalcul = session.findUserByUserName("botdecalcul");
		System.out.println(botdecalcul);
		final SlackMessageHandle<SlackChannelReply> joinTest = session.joinChannel("test");
//		System.out.println("joinTest : " + joinTest.getReply().getSlackChannel());
		session.getUsers().stream() //
				.map(persona -> persona.getUserName() + "->" + persona.getId()) //
				.forEach(System.out::println);

		final SlackMessageHandle<SlackMessageReply> messageHandle = session.sendMessageOverWebSocket( //
				session.findChannelByName("test"), //
				"Paye ton addition", //
				null);
		System.out.println("message id : " + messageHandle.getMessageId());
		System.out.println(session.findChannelByName("test"));
		// THEN
		while (1 == 1) {
		}
	}

	private void configureSession(final SlackSession session, final String channelToPostEvents) {
		session.addMessagePostedListener(//
				(event, sess) -> session.sendMessageOverWebSocket(sess.findChannelByName("test"),//
						"Message sent : " + event.getMessageContent(), //
						null));

		session.addMessageUpdatedListener((event, sess) -> session
				.sendMessageOverWebSocket(sess.findChannelByName("test"), "New Message is : " + event.getNewMessage(), null));

		session.addSlackConnectedListener((event, sess) -> session.sendMessageOverWebSocket(sess.findChannelByName("test"),
				"New persona is : " + session.findUserById(event.getConnectedPersona().getId()), null));
	}
}
