package fr.arolla.slack.simpleslackapi.impl;

import fr.arolla.slack.simpleslackapi.SlackPersona;
import fr.arolla.slack.simpleslackapi.events.SlackConnected;
import fr.arolla.slack.simpleslackapi.events.SlackEventType;

class SlackConnectedImpl implements SlackConnected {
    private SlackPersona slackConnectedPersona;

    SlackConnectedImpl(SlackPersona slackConnectedPersona) {
        this.slackConnectedPersona = slackConnectedPersona;
    }

    @Override
    public SlackPersona getConnectedPersona() {
        return slackConnectedPersona;
    }

    @Override
    public SlackEventType getEventType() {
        return SlackEventType.SLACK_CONNECTED;
    }
}
