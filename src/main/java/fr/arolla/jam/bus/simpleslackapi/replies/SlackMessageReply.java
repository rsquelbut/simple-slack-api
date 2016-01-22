package fr.arolla.jam.bus.simpleslackapi.replies;

public interface SlackMessageReply extends SlackReply {
    long getReplyTo();

    String getTimestamp();

}
