package fr.arolla.jam.bus.simpleslackapi.events;

import fr.arolla.jam.bus.simpleslackapi.SlackUser;

public interface SlackChannelUnarchived extends SlackChannelEvent {
    SlackUser getUser();
}
