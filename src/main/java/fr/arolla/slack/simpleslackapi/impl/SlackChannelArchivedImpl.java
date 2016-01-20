package fr.arolla.slack.simpleslackapi.impl;

import fr.arolla.slack.simpleslackapi.SlackChannel;
import fr.arolla.slack.simpleslackapi.SlackUser;
import fr.arolla.slack.simpleslackapi.events.SlackChannelArchived;
import fr.arolla.slack.simpleslackapi.events.SlackEventType;

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
