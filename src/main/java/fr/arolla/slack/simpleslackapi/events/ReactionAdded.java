package fr.arolla.slack.simpleslackapi.events;

import fr.arolla.slack.simpleslackapi.SlackChannel;


public interface ReactionAdded extends SlackEvent {

    public String getEmojiName();

    public SlackChannel getChannel();

    public String getMessageID();

}
