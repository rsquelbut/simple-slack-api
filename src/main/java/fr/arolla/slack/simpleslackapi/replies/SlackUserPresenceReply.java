package fr.arolla.slack.simpleslackapi.replies;

public interface SlackUserPresenceReply extends ParsedSlackReply {
    boolean isActive();
}
