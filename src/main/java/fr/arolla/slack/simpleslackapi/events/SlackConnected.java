package fr.arolla.slack.simpleslackapi.events;

import fr.arolla.slack.simpleslackapi.SlackPersona;

public interface SlackConnected extends SlackEvent {
    SlackPersona getConnectedPersona();
}
