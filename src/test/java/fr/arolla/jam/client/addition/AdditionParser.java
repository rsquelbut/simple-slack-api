package fr.arolla.jam.client.addition;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.arolla.jam.client.BotOneTest;

/**
 * Created by raphael_squelbut on 22/01/16.
 */
public class AdditionParser {
	private static final Logger LOGGER = LoggerFactory.getLogger(AdditionParser.class);
	private static final Pattern ADDITION_PATTERN = Pattern.compile("ADD +([A-Z_]+) +([0-9]+) +([0-9]+)");

	public boolean accept(String input) {
		return input != null && ADDITION_PATTERN.matcher(input).matches();
	}

	public Addition build(String input) {
		final Matcher matcher = ADDITION_PATTERN.matcher(input);
		final Addition.Builder additionBuilder = Addition.newAddition();
		if (matcher.find()) {
			additionBuilder.variable(matcher.group(1));
			additionBuilder.a(Integer.valueOf(matcher.group(2)));
			additionBuilder.b(Integer.valueOf(matcher.group(3)));
		}
		final Addition addition = additionBuilder.build();
		return addition;
	}
}
