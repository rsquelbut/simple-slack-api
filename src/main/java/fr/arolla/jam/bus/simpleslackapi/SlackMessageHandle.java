package fr.arolla.jam.bus.simpleslackapi;

import java.util.concurrent.TimeUnit;

import fr.arolla.jam.bus.simpleslackapi.replies.SlackReply;

public interface SlackMessageHandle<T extends SlackReply> {
    // the id given to the message sent
    long getMessageId();

    // server response
    T getReply();

    boolean isAcked();

    void waitForReply(long timeout, TimeUnit unit);
}
