package fr.arolla.slack.simpleslackapi.events;

import fr.arolla.slack.simpleslackapi.SlackUser;

public interface SlackChannelUnarchived extends SlackChannelEvent {
    SlackUser getUser();
}
