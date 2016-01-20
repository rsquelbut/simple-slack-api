package fr.arolla.slack.simpleslackapi.impl;

import fr.arolla.slack.simpleslackapi.SlackChannel;
import fr.arolla.slack.simpleslackapi.SlackUser;
import fr.arolla.slack.simpleslackapi.events.SlackChannelCreated;
import fr.arolla.slack.simpleslackapi.events.SlackEventType;

class SlackChannelCreatedImpl implements SlackChannelCreated {
    private SlackChannel slackChannel;
    private SlackUser slackuser;

    SlackChannelCreatedImpl(SlackChannel slackChannel, SlackUser slackuser) {
        this.slackChannel = slackChannel;
        this.slackuser = slackuser;
    }

    @Override
    public SlackChannel getSlackChannel() {
        return slackChannel;
    }

    @Override
    public SlackUser getCreator() {
        return slackuser;
    }

    @Override
    public SlackEventType getEventType() {
        return SlackEventType.SLACK_CHANNEL_CREATED;
    }

}
