package fr.arolla.slack.simpleslackapi.impl;

import fr.arolla.slack.simpleslackapi.SlackMessageHandle;
import fr.arolla.slack.simpleslackapi.replies.SlackReply;

import java.util.concurrent.TimeUnit;

class SlackMessageHandleImpl<T extends SlackReply> implements SlackMessageHandle<T> {

    private long messageId;
    private volatile T slackReply;

    public SlackMessageHandleImpl(long messageId) {
        this.messageId = messageId;
    }

    @Override
    public long getMessageId() {
        return messageId;
    }

    @Override
    public T getReply() {
        return slackReply;
    }

    void setReply(T slackReply) {
        this.slackReply = slackReply;
    }

    @Override
    public boolean isAcked() {
        return false;
    }

    @Override
    public void waitForReply(long timeout, TimeUnit unit) {
        long nanoStart = System.nanoTime();
        while ((System.nanoTime() - nanoStart) < unit.toNanos(timeout) && slackReply == null) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                return;
            }
        }
    }
}
