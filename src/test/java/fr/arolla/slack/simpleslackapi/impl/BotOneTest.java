package fr.arolla.slack.simpleslackapi.impl;

import fr.arolla.slack.simpleslackapi.SlackChannel;
import fr.arolla.slack.simpleslackapi.SlackMessageHandle;
import fr.arolla.slack.simpleslackapi.SlackSession;
import fr.arolla.slack.simpleslackapi.replies.SlackMessageReply;
import org.junit.Ignore;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * Created by raphael on 21/01/2016.
 */
@Ignore
public class BotOneTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(BotOneTest.class);

    private static final String BOT1_TOKEN = "xoxb-19108991843-8XmlhYZSQxvOkbOUnmkkhFoi";

    @Test
    public void should_() throws IOException, InterruptedException {
        final SlackSession session = SlackSessionFactory.createWebSocketSlackSession(BOT1_TOKEN);

        session.addMessagePostedListener(
                (event, session1) -> {
                    LOGGER.warn("Detect a message");
                    //let's send a message
                    final SlackChannel generalChannel = session1.findChannelByName("general");

                    LOGGER.warn("Find channel : " + generalChannel);
                    final SlackMessageHandle<SlackMessageReply> handle = session1
                            .sendMessageOverWebSocket(
                                    generalChannel,
                                    event.getMessageContent(),
                                    null);
                    LOGGER.warn("Sent message : " + handle.getMessageId());
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    //2 secs later, let's update the message (I can only update my own messages)
                    final SlackMessageHandle<SlackMessageReply> updated = session1.updateMessage(handle.getReply().getTimestamp(), generalChannel,
                            event.getMessageContent() + " UPDATED");
                    LOGGER.warn("Updated message : " + updated.getMessageId());
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    //2 secs later, let's now delete the message (I can only delete my own messages)
                    final SlackMessageHandle<SlackMessageReply> deleted = session1.deleteMessage(handle.getReply().getTimestamp(), generalChannel);
                    LOGGER.warn("Deleted message : " + deleted.getMessageId());
                });
        session.connect();

        while (true) {
            Thread.sleep(1000);
        }


    }
}
