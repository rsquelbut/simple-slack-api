package fr.arolla.jam.bus.simpleslackapi.events;

public interface SlackChannelRenamed extends SlackChannelEvent {
    String getNewName();
}
