package fr.arolla.jam.bus.simpleslackapi;

import java.io.Serializable;
import java.util.Objects;

/**
 * Created by raphael on 21/01/2016.
 */
public class SlackID implements Serializable {
    private final String value;

    private SlackID(String id) {
        value = id;
    }

    public static SlackID from(String value) {
        return new SlackID(value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SlackID slackID = (SlackID) o;
        return Objects.equals(value, slackID.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    public String value() {
        return value;
    }

    public String toString() {
        return value();
    }
}
