package fr.arolla.jam.client;

import java.io.IOException;

import org.junit.Ignore;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.arolla.jam.client.addition.Addition;

/**
 * Created by raphael_squelbut on 22/01/16.
 */
@Ignore
public class BotAdditioner {
	private static final Logger LOGGER = LoggerFactory.getLogger(BotAdditioner.class);
	private static final String BOTONE_TOKEN = "xoxb-19108991843-8XmlhYZSQxvOkbOUnmkkhFoi";

	@Test
	public void should_create_BotAddition_which_compute_an_addition()
			throws IOException, InterruptedException {
		JamBot.create()
				.withToken(BOTONE_TOKEN)
				.listenTo("random")
				.acceptAccordingTo(Addition::accept)
				.transformWith(Addition::compute)
				.build()
				.start();
	}
}
