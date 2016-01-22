package fr.arolla.jam.bus.simpleslackapi.replies;

public interface SlackUserPresenceReply extends ParsedSlackReply {
    boolean isActive();
}
