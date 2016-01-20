package fr.arolla.slack.simpleslackapi.events;

import fr.arolla.slack.simpleslackapi.SlackUser;

public interface SlackChannelCreated extends SlackChannelEvent {
    SlackUser getCreator();
}
