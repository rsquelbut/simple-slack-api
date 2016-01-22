package fr.arolla.jam.bus.simpleslackapi.impl;

import fr.arolla.jam.bus.simpleslackapi.SlackChannel;
import fr.arolla.jam.bus.simpleslackapi.events.SlackGroupJoined;
import fr.arolla.jam.bus.simpleslackapi.events.SlackEventType;

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
