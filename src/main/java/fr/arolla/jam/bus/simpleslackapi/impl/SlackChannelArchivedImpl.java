package fr.arolla.jam.bus.simpleslackapi.impl;

import fr.arolla.jam.bus.simpleslackapi.SlackUser;
import fr.arolla.jam.bus.simpleslackapi.events.SlackChannelArchived;
import fr.arolla.jam.bus.simpleslackapi.SlackChannel;
import fr.arolla.jam.bus.simpleslackapi.events.SlackEventType;

class SlackChannelArchivedImpl implements SlackChannelArchived {
    private SlackChannel slackChannel;
    private SlackUser slackuser;

    SlackChannelArchivedImpl(SlackChannel slackChannel, SlackUser slackuser) {
        this.slackChannel = slackChannel;
        this.slackuser = slackuser;
    }

    @Override
    public SlackChannel getSlackChannel() {
        return slackChannel;
    }

    @Override
    public SlackUser getUser() {
        return slackuser;
    }

    @Override
    public SlackEventType getEventType() {
        return SlackEventType.SLACK_CHANNEL_ARCHIVED;
    }

}
