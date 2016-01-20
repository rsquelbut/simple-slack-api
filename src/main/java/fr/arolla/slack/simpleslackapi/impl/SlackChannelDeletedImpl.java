package fr.arolla.slack.simpleslackapi.impl;

import fr.arolla.slack.simpleslackapi.SlackChannel;
import fr.arolla.slack.simpleslackapi.events.SlackChannelDeleted;
import fr.arolla.slack.simpleslackapi.events.SlackEventType;

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
