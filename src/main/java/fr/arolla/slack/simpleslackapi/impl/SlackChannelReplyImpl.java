package fr.arolla.slack.simpleslackapi.impl;

import fr.arolla.slack.simpleslackapi.SlackChannel;
import fr.arolla.slack.simpleslackapi.replies.SlackChannelReply;
import org.json.simple.JSONObject;

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
