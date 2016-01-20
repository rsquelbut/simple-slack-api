package fr.arolla.slack.simpleslackapi.replies;

public interface SlackMessageReply extends SlackReply {
    long getReplyTo();

    String getTimestamp();

}
