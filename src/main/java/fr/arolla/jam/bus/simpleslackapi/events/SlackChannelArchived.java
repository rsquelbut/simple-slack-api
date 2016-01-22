package fr.arolla.jam.bus.simpleslackapi.events;

import fr.arolla.jam.bus.simpleslackapi.SlackUser;

public interface SlackChannelArchived extends SlackChannelEvent {
    SlackUser getUser();
}
