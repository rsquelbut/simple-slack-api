package fr.arolla.jam.bus.simpleslackapi.replies;

import fr.arolla.jam.bus.simpleslackapi.SlackChannel;

public interface SlackChannelReply extends SlackReply {
    SlackChannel getSlackChannel();
}
