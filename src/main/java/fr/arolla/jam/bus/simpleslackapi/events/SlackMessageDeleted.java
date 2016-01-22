package fr.arolla.jam.bus.simpleslackapi.events;

import fr.arolla.jam.bus.simpleslackapi.SlackChannel;

public interface SlackMessageDeleted extends SlackMessageEvent {
    SlackChannel getChannel();

    String getMessageTimestamp();
}
