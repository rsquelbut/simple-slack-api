package fr.arolla.slack.simpleslackapi.events;

public interface SlackChannelRenamed extends SlackChannelEvent {
    String getNewName();
}
