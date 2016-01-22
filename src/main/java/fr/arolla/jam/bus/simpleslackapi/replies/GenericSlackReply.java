package fr.arolla.jam.bus.simpleslackapi.replies;

import org.json.simple.JSONObject;

public interface GenericSlackReply extends SlackReply {
    public JSONObject getPlainAnswer();
}
