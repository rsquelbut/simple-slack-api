package fr.arolla.jam.bus.simpleslackapi.listeners;

import fr.arolla.jam.bus.simpleslackapi.SlackSession;
import fr.arolla.jam.bus.simpleslackapi.events.SlackEvent;

public interface SlackEventListener<T extends SlackEvent> {
    void onEvent(T event, SlackSession session);
}
