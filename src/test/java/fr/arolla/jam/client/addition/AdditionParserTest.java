package fr.arolla.jam.client.addition;

import static org.junit.Assert.*;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by raphael_squelbut on 22/01/16.
 */
public class AdditionParserTest {
	private AdditionParser sut;

	@Before
	public void init() {
		sut = new AdditionParser();
	}

	@Test
	public void should_accept_correct_format() {
		// GIVEN
		String input = "ADD  VAR 32 65";
		// WHEN
		final boolean actual = sut.accept(input);

		// THEN
		Assertions.assertThat(actual).isTrue();
	}

	@Test
	public void should_not_accept_when_no_start_with_ADD() {
		// GIVEN
		String input = "AD  VAR 32 65";
		// WHEN
		final boolean actual = sut.accept(input);

		// THEN
		Assertions.assertThat(actual).isFalse();
	}

	@Test
	public void should_build_an_addition() {
		// GIVEN
		final Addition expected = Addition.newAddition().variable("VAR").a(32).b(11).build();

		// WHEN
		final Addition actual = sut.build("ADD VAR 32 11");
		// THEN
		Assertions.assertThat(actual).isEqualTo(expected);
	}
}