package fr.arolla.jam.bus.simpleslackapi.impl;

import fr.arolla.jam.bus.simpleslackapi.SlackSession;
import fr.arolla.jam.bus.simpleslackapi.ChannelHistoryModule;

public class ChannelHistoryModuleFactory {

    public static ChannelHistoryModule createChannelHistoryModule(SlackSession session) {
        return new ChannelHistoryModuleImpl(session);
    }

    ;

}
