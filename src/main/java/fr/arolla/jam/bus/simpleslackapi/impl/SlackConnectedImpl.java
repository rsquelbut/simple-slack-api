package fr.arolla.jam.bus.simpleslackapi.impl;

import fr.arolla.jam.bus.simpleslackapi.SlackPersona;
import fr.arolla.jam.bus.simpleslackapi.events.SlackConnected;
import fr.arolla.jam.bus.simpleslackapi.events.SlackEventType;

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
