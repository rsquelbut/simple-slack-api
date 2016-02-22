package fr.arolla.jam.client;

import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Created by raphael_squelbut on 22/02/16.
 */
class SlackBotBuilder {

	private Function<String, String> producer;
	private Predicate<String> acceptor;
	private String writingChannel;
	private String listeningChannel;
	private String token;

	public SlackBot build() {
		return new SlackBot() {
			@Override public boolean itIsNotForMe(final String message) {
				return !acceptor.test(message);
			}

			@Override public String getToken() {
				return token;
			}

			@Override public String readingChannel() {
				return listeningChannel;
			}

			@Override public String writingChannel() {
				return writingChannel;
			}

			@Override public String produceResponse(final String message) {
				return producer.apply(message);
			}
		};
	}

	public SlackBotBuilder transformWith(
			final Function<String, String> producer) {
		this.producer = producer;
		return this;
	}

	public SlackBotBuilder acceptAccordingTo(
			final Predicate<String> acceptor) {
		this.acceptor = acceptor;
		return this;
	}

	public SlackBotBuilder writeTo(final String channel) {
		this.writingChannel = channel;
		return this;
	}

	public SlackBotBuilder listenTo(final String channel) {
		this.listeningChannel = channel;
		return this;
	}

	public SlackBotBuilder withToken(final String token) {
		this.token = token;
		return this;
	}

}
