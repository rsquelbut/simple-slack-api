package fr.arolla.jam.bus.simpleslackapi.events;

import java.util.Map;

import org.json.simple.JSONObject;

import fr.arolla.jam.bus.simpleslackapi.SlackFile;
import fr.arolla.jam.bus.simpleslackapi.SlackPersona;
import fr.arolla.jam.bus.simpleslackapi.SlackChannel;

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
