package fr.arolla.slack.simpleslackapi.listeners;

import fr.arolla.slack.simpleslackapi.SlackSession;
import fr.arolla.slack.simpleslackapi.events.SlackEvent;

public interface SlackEventListener<T extends SlackEvent> {
    void onEvent(T event, SlackSession session);
}
