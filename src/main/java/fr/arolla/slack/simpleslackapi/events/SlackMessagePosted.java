package fr.arolla.slack.simpleslackapi.events;

import fr.arolla.slack.simpleslackapi.SlackChannel;
import fr.arolla.slack.simpleslackapi.SlackFile;
import fr.arolla.slack.simpleslackapi.SlackPersona;

import org.json.simple.JSONObject;

import java.util.Map;

public interface SlackMessagePosted extends SlackMessageEvent {
    String getMessageContent();

    SlackPersona getSender();

    SlackChannel getChannel();

    SlackFile getSlackFile();

    JSONObject getJsonSource();

    String getTimestamp();

    Map<String, Integer> getReactions();

    int getTotalCountOfReactions();

}
