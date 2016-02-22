package fr.arolla.jam.client.flowctrl;

import flowctrl.integration.slack.SlackClientFactory;
import flowctrl.integration.slack.bot.SlackbotClient;
import fr.arolla.jam.client.Token;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

/**
 * Created by raphael on 22/02/2016.
 */
@Ignore
public class FlowctrlTester {
    private String slackbotUrl = "https://{team}.slack.com/services/hooks/slackbot?token={token}";
    private SlackbotClient client;

    @Before
    public void init() {
        String url = slackbotUrl.replace("{team}", "jamrolla")
                .replace("{token}", Token.BOT1.get());
        client = SlackClientFactory.createSlackbotClient(url);
    }

    @After
    public void close() {
        client.shutdown();
    }

    @Test
    public void should_() {
        // GIVEN

        client.post("general", "toto va a la plage");
        // WHEN

        // THEN

    }
}
