package fr.arolla.jam.bus.simpleslackapi;

import java.util.Collection;

public interface SlackChannel {
    SlackID getId();

    String getName();

    Collection<SlackUser> getMembers();

    String getTopic();

    String getPurpose();

    boolean isDirect();

}
