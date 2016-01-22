package fr.arolla.jam.bus.simpleslackapi.events;

import fr.arolla.jam.bus.simpleslackapi.SlackChannel;


public interface ReactionAdded extends SlackEvent {

    public String getEmojiName();

    public SlackChannel getChannel();

    public String getMessageID();

}
