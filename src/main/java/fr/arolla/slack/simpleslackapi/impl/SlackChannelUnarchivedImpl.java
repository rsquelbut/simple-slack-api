package fr.arolla.slack.simpleslackapi.impl;

import fr.arolla.slack.simpleslackapi.SlackChannel;
import fr.arolla.slack.simpleslackapi.SlackUser;
import fr.arolla.slack.simpleslackapi.events.SlackChannelUnarchived;
import fr.arolla.slack.simpleslackapi.events.SlackEventType;

class SlackChannelUnarchivedImpl implements SlackChannelUnarchived {
    private SlackChannel slackChannel;
    private SlackUser slackuser;

    SlackChannelUnarchivedImpl(SlackChannel slackChannel, SlackUser slackuser) {
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
        return SlackEventType.SLACK_CHANNEL_UNARCHIVED;
    }

}
