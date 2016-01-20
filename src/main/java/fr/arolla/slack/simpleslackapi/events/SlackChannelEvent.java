package fr.arolla.slack.simpleslackapi.events;

import fr.arolla.slack.simpleslackapi.SlackChannel;

public interface SlackChannelEvent extends SlackEvent {
    SlackChannel getSlackChannel();
}
