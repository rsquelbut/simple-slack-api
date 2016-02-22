package com.ullink.slack.simpleslackapi.impl;

import org.json.simple.JSONObject;

import com.ullink.slack.simpleslackapi.replies.SlackChannelReply;
import com.ullink.slack.simpleslackapi.SlackChannel;

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