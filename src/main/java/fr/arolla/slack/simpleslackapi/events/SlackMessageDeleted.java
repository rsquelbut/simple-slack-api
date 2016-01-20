package fr.arolla.slack.simpleslackapi.events;

import fr.arolla.slack.simpleslackapi.SlackChannel;

public interface SlackMessageDeleted extends SlackMessageEvent {
    SlackChannel getChannel();

    String getMessageTimestamp();
}
