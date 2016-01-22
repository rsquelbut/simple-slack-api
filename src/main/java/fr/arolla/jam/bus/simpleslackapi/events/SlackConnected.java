package fr.arolla.jam.bus.simpleslackapi.events;

import fr.arolla.jam.bus.simpleslackapi.SlackPersona;

public interface SlackConnected extends SlackEvent {
    SlackPersona getConnectedPersona();
}
