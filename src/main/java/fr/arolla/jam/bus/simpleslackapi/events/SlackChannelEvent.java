package fr.arolla.jam.bus.simpleslackapi.events;

import fr.arolla.jam.bus.simpleslackapi.SlackChannel;

public interface SlackChannelEvent extends SlackEvent {
    SlackChannel getSlackChannel();
}
