package fr.arolla.slack.simpleslackapi.impl;

import fr.arolla.slack.simpleslackapi.replies.ParsedSlackReply;

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
