package fr.arolla.slack.simpleslackapi.events;

import fr.arolla.slack.simpleslackapi.SlackChannel;

public interface SlackMessageUpdated extends SlackMessageEvent {
    SlackChannel getChannel();

    String getMessageTimestamp();

    String getNewMessage();
}
