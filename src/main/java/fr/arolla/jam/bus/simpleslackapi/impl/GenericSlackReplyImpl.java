package fr.arolla.jam.bus.simpleslackapi.impl;

import org.json.simple.JSONObject;

import fr.arolla.jam.bus.simpleslackapi.replies.GenericSlackReply;

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
