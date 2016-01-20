package fr.arolla.slack.simpleslackapi.impl;

import fr.arolla.slack.simpleslackapi.SlackChannel;
import fr.arolla.slack.simpleslackapi.events.SlackChannelRenamed;
import fr.arolla.slack.simpleslackapi.events.SlackEventType;

class SlackChannelRenamedImpl implements SlackChannelRenamed {
    private SlackChannel slackChannel;
    private String newName;

    SlackChannelRenamedImpl(SlackChannel slackChannel, String newName) {
        this.slackChannel = slackChannel;
        this.newName = newName;
    }

    @Override
    public SlackChannel getSlackChannel() {
        return slackChannel;
    }

    @Override
    public String getNewName() {
        return newName;
    }

    @Override
    public SlackEventType getEventType() {
        return SlackEventType.SLACK_CHANNEL_RENAMED;
    }

}
