package fr.arolla.jam.bus.simpleslackapi.impl;

import fr.arolla.jam.bus.simpleslackapi.replies.ParsedSlackReply;

class SlackReplyImpl implements ParsedSlackReply {

    private boolean ok;

    SlackReplyImpl(boolean ok) {
        this.ok = ok;
    }

    @Override
    public boolean isOk() {
        return false;
    }
}
