package fr.arolla.jam.client;

import fr.arolla.jam.bus.simpleslackapi.SlackSession;
import fr.arolla.jam.bus.simpleslackapi.events.SlackMessagePosted;
import fr.arolla.jam.bus.simpleslackapi.replies.GenericSlackReply;
import fr.arolla.jam.bus.simpleslackapi.replies.SlackReply;

/**
 * Created by raphael_squelbut on 22/01/16.
 */
public class SlackReplyHelper {

	public static SlackReplyHelper slackReplyHelper() {
		return new SlackReplyHelper();
	}

	public String message(final SlackReply reply) {
		if (reply instanceof GenericSlackReply) {
			return message((GenericSlackReply) reply);
		}
		throw new IllegalArgumentException(reply + " is not a " + GenericSlackReply.class);
	}

	public String timestamp(final SlackReply reply) {
		if (reply instanceof GenericSlackReply) {
			return timestamp((GenericSlackReply) reply);
		}
		throw new IllegalArgumentException(reply + " is not a " + GenericSlackReply.class);
	}

	private String timestamp(final GenericSlackReply reply) {
		return field(reply, "ts");
	}

	private String message(final GenericSlackReply reply) {
		return field(reply, "message");
	}

	private String field(final GenericSlackReply reply, final String field) {
		return (String) reply.getPlainAnswer().get(field);
	}
}
