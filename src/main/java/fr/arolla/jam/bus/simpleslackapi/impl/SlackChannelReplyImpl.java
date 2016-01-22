package fr.arolla.jam.bus.simpleslackapi.impl;

import org.json.simple.JSONObject;

import fr.arolla.jam.bus.simpleslackapi.replies.SlackChannelReply;
import fr.arolla.jam.bus.simpleslackapi.SlackChannel;

public class SlackChannelReplyImpl extends SlackReplyImpl implements SlackChannelReply {
    private SlackChannel slackChannel;

    SlackChannelReplyImpl(boolean ok, JSONObject plain, SlackChannel slackChannel) {
        super(ok);
        this.slackChannel = slackChannel;
    }

    @Override
    public SlackChannel getSlackChannel() {
        return slackChannel;
    }
}
