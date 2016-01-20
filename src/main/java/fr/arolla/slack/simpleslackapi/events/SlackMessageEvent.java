package fr.arolla.slack.simpleslackapi.events;

public interface SlackMessageEvent extends SlackEvent {
    String getTimeStamp();
}
