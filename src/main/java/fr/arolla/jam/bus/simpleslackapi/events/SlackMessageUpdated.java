package fr.arolla.jam.bus.simpleslackapi.events;

import fr.arolla.jam.bus.simpleslackapi.SlackChannel;

public interface SlackMessageUpdated extends SlackMessageEvent {
    SlackChannel getChannel();

    String getMessageTimestamp();

    String getNewMessage();
}
