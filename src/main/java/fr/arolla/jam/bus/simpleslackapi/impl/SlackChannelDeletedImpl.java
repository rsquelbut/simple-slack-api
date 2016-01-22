package fr.arolla.jam.bus.simpleslackapi.impl;

import fr.arolla.jam.bus.simpleslackapi.SlackChannel;
import fr.arolla.jam.bus.simpleslackapi.events.SlackChannelDeleted;
import fr.arolla.jam.bus.simpleslackapi.events.SlackEventType;

class SlackChannelDeletedImpl implements SlackChannelDeleted {
    private SlackChannel slackChannel;

    SlackChannelDeletedImpl(SlackChannel slackChannel) {
        this.slackChannel = slackChannel;
    }

    @Override
    public SlackChannel getSlackChannel() {
        return slackChannel;
    }

    @Override
    public SlackEventType getEventType() {
        return SlackEventType.SLACK_CHANNEL_DELETED;
    }
}
