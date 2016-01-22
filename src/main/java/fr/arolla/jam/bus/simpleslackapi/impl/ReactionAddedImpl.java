package fr.arolla.jam.bus.simpleslackapi.impl;

import fr.arolla.jam.bus.simpleslackapi.SlackChannel;
import fr.arolla.jam.bus.simpleslackapi.events.ReactionAdded;
import fr.arolla.jam.bus.simpleslackapi.events.SlackEventType;

public class ReactionAddedImpl implements ReactionAdded {

    private final String emojiName;
    private final String messageID;
    private final SlackChannel channel;

    public ReactionAddedImpl(String emojiName, String messageID, SlackChannel channel) {
        this.emojiName = emojiName;
        this.messageID = messageID;
        this.channel = channel;
    }

    @Override
    public String getEmojiName() {
        return emojiName;
    }

    @Override
    public SlackChannel getChannel() {
        return channel;
    }

    @Override
    public String getMessageID() {
        return messageID;
    }

    @Override
    public SlackEventType getEventType() {
        return SlackEventType.REACTION_ADDED;
    }

}
