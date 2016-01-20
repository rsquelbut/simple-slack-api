package fr.arolla.slack.simpleslackapi.impl;

import fr.arolla.slack.simpleslackapi.ChannelHistoryModule;
import fr.arolla.slack.simpleslackapi.SlackSession;

public class ChannelHistoryModuleFactory {

    public static ChannelHistoryModule createChannelHistoryModule(SlackSession session) {
        return new ChannelHistoryModuleImpl(session);
    }

    ;

}
