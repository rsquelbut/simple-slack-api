package fr.arolla.slack.simpleslackapi.impl;

import fr.arolla.slack.simpleslackapi.replies.GenericSlackReply;
import org.json.simple.JSONObject;

class GenericSlackReplyImpl implements GenericSlackReply {
    private JSONObject obj;

    public GenericSlackReplyImpl(JSONObject obj) {
        this.obj = obj;
    }

    @Override
    public JSONObject getPlainAnswer() {
        return obj;
    }

    public String toString() {
		return this.getClass().getSimpleName()+":"+obj.toJSONString();
	}

}
