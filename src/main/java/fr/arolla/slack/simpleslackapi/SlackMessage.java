package fr.arolla.slack.simpleslackapi;

import fr.arolla.slack.simpleslackapi.events.SlackMessageEvent;
import fr.arolla.slack.simpleslackapi.events.SlackMessagePosted;

/**
 * @deprecated use {@link SlackMessagePosted}
 */
@Deprecated
public interface SlackMessage extends SlackMessageEvent {

    String getMessageContent();

    SlackUser getSender();

    SlackBot getBot();

    SlackChannel getChannel();

}
