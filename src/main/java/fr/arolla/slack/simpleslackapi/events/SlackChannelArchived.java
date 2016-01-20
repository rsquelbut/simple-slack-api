package fr.arolla.slack.simpleslackapi.events;

import fr.arolla.slack.simpleslackapi.SlackUser;

public interface SlackChannelArchived extends SlackChannelEvent {
    SlackUser getUser();
}
