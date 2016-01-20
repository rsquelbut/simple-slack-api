package fr.arolla.slack.simpleslackapi.replies;

import fr.arolla.slack.simpleslackapi.SlackChannel;

public interface SlackChannelReply extends SlackReply {
    SlackChannel getSlackChannel();
}
