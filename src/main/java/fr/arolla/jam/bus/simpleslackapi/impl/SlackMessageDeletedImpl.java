package fr.arolla.jam.bus.simpleslackapi.impl;

import fr.arolla.jam.bus.simpleslackapi.SlackChannel;
import fr.arolla.jam.bus.simpleslackapi.events.SlackEventType;
import fr.arolla.jam.bus.simpleslackapi.events.SlackMessageDeleted;

class SlackMessageDeletedImpl implements SlackMessageDeleted {
    private final SlackChannel channel;
    private final String messageTimestamp;
    private final String deleteTimestamp;

    SlackMessageDeletedImpl(SlackChannel channel, String messageTimestamp, String deleteTimestamp) {
        this.channel = channel;
        this.messageTimestamp = messageTimestamp;
        this.deleteTimestamp = deleteTimestamp;
    }

    @Override
    public SlackChannel getChannel() {
        return channel;
    }

    @Override
    public String getMessageTimestamp() {
        return messageTimestamp;
    }

    @Override
    public String getTimeStamp() {
        return deleteTimestamp;
    }

    @Override
    public SlackEventType getEventType() {
        return SlackEventType.SLACK_MESSAGE_DELETED;
    }

}
