package fr.arolla.jam.client.addition;

import java.util.Objects;
import java.util.Optional;

/**
 * Created by raphael_squelbut on 22/01/16.
 */
public class Addition {
    private static AdditionParser parser = new AdditionParser();

    private final String variable;
    private final Integer a;
    private final Integer b;

    public static Addition parse(String input) {
        return Optional.of(input)
                .filter(parser::accept)
                .map(parser::build)
                .orElseThrow(IllegalArgumentException::new);
    }

    public static String compute(String input) {
        return parse(input).result();
    }

    public static boolean accept(String input) {
        return parser.accept(input);
    }

    public Addition(final String variable, final Integer a, final Integer b) {
        this.variable = variable;
        this.a = a;
        this.b = b;
    }

    private Addition(Builder builder) {
        this.variable = builder.variable;
        this.a = builder.a;
        this.b = builder.b;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Addition)) {
            return false;
        }
        final Addition addition = (Addition) o;
        return Objects.equals(variable, addition.variable) &&
                Objects.equals(a, addition.a) &&
                Objects.equals(b, addition.b);
    }

    @Override
    public int hashCode() {
        return Objects.hash(variable, a, b);
    }

    public static Builder newAddition() {
        return new Builder();
    }

    public String result() {
        return variable + "=" + (a + b);
    }

    public static final class Builder {
        private String variable;
        private Integer a;
        private Integer b;

        private Builder() {
        }

        public Addition build() {
            return new Addition(this);
        }

        public Builder in(String variable) {
            this.variable = variable;
            return this;
        }

        public Builder willAdd(Integer a) {
            this.a = a;
            return this;
        }
        public Builder willAdd(String a) {
            this.a = Integer.valueOf(a);
            return this;
        }

        public Builder to(Integer b) {
            this.b = b;
            return this;
        }
        public Builder to(String b) {
            this.b = Integer.valueOf(b);
            return this;
        }
    }
}
