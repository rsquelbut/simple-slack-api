package fr.arolla.slack.simpleslackapi.impl;

import fr.arolla.slack.simpleslackapi.replies.SlackReply;
import fr.arolla.slack.simpleslackapi.replies.SlackUserPresenceReply;

public class SlackUserPresenceReplyImpl extends SlackReplyImpl implements SlackUserPresenceReply, SlackReply {
    private boolean active;

    SlackUserPresenceReplyImpl(boolean ok, boolean active) {
        super(ok);
        this.active = active;
    }

    @Override
    public boolean isActive() {
        return active;
    }
}
