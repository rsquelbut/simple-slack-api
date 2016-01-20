package fr.arolla.slack.simpleslackapi.impl;

import fr.arolla.slack.simpleslackapi.SlackChannel;
import fr.arolla.slack.simpleslackapi.events.SlackEventType;
import fr.arolla.slack.simpleslackapi.events.SlackGroupJoined;

class SlackGroupJoinedImpl implements SlackGroupJoined {
    private SlackChannel slackChannel;

    SlackGroupJoinedImpl(SlackChannel slackChannel) {
        this.slackChannel = slackChannel;
    }

    @Override
    public SlackChannel getSlackChannel() {
        return slackChannel;
    }

    void setSlackChannel(SlackChannel slackChannel) {
        this.slackChannel = slackChannel;
    }

    @Override
    public SlackEventType getEventType() {
        return SlackEventType.SLACK_GROUP_JOINED;
    }

}
