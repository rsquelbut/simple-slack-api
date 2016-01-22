package fr.arolla.jam.bus.simpleslackapi.events;

import fr.arolla.jam.bus.simpleslackapi.SlackUser;

public interface SlackChannelCreated extends SlackChannelEvent {
    SlackUser getCreator();
}
