package fr.arolla.jam.bus.simpleslackapi.impl;

import fr.arolla.jam.bus.simpleslackapi.replies.SlackReply;
import fr.arolla.jam.bus.simpleslackapi.replies.SlackUserPresenceReply;

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
