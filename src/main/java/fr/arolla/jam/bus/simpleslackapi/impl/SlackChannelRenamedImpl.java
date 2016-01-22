package fr.arolla.jam.bus.simpleslackapi.impl;

import fr.arolla.jam.bus.simpleslackapi.events.SlackChannelRenamed;
import fr.arolla.jam.bus.simpleslackapi.SlackChannel;
import fr.arolla.jam.bus.simpleslackapi.events.SlackEventType;

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
