package fr.arolla.jam.client.operation.addition;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by raphael_squelbut on 22/01/16.
 */
class AdditionParser {
	private static final Logger LOGGER = LoggerFactory.getLogger(AdditionParser.class);
	private static final Pattern ADDITION_PATTERN = Pattern.compile("ADD +([A-Z_]+) +([0-9]+) +([0-9]+)");

	public boolean accept(String input) {
		return input != null && ADDITION_PATTERN.matcher(input).matches();
	}

	public Addition build(String input) {
		final Matcher matcher = ADDITION_PATTERN.matcher(input);
		final Addition.Builder additionBuilder = Addition.newAddition();
		if (matcher.find()) {
			additionBuilder.willAdd(matcher.group(2))
					.to(matcher.group(3))
					.in(matcher.group(1));
		}
		final Addition addition = additionBuilder.build();
		return addition;
	}
}
