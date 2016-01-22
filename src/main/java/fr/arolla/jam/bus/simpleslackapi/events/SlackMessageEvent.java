package fr.arolla.jam.bus.simpleslackapi.events;

public interface SlackMessageEvent extends SlackEvent {
    String getTimeStamp();
}
