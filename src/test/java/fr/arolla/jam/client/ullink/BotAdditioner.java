package fr.arolla.jam.client.ullink;

import java.io.IOException;

import fr.arolla.jam.client.Token;
import org.junit.Ignore;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.arolla.jam.client.operation.addition.Addition;

/**
 * Created by raphael_squelbut on 22/01/16.
 */
@Ignore
public class BotAdditioner {
	private static final Logger LOGGER = LoggerFactory.getLogger(BotAdditioner.class);

	@Test
	public void should_create_BotAddition_which_compute_an_addition()
			throws IOException, InterruptedException {
		JamBot.create()
				.withToken(Token.BOT1)
				.listenTo("random")
				.acceptAccordingTo(Addition::accept)
				.transformWith(Addition::compute)
				.build()
				.start();
	}
}
