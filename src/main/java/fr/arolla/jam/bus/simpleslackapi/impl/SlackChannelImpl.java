package fr.arolla.jam.bus.simpleslackapi.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import fr.arolla.jam.bus.simpleslackapi.SlackUser;
import fr.arolla.jam.bus.simpleslackapi.SlackChannel;
import fr.arolla.jam.bus.simpleslackapi.SlackID;

class SlackChannelImpl implements SlackChannel {
    private final boolean direct;
    private SlackID id;
    private String name;
    private Set<SlackUser> members = new HashSet<>();
    private String topic;
    private String purpose;

    SlackChannelImpl(SlackID id, String name, String topic, String purpose, boolean direct) {
        this.id = id;
        this.name = name;
        this.topic = topic;
        this.purpose = purpose;
        this.direct = direct;
    }

    void addUser(SlackUser user) {
        members.add(user);
    }

    void removeUser(SlackUser user) {
        members.remove(user);
    }

    @Override
    public SlackID getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Collection<SlackUser> getMembers() {
        return new ArrayList<>(members);
    }

    @Override
    public String getTopic() {
        return topic;
    }

    @Override
    public String toString() {
        return "SlackChannelImpl{" +
                "topic='" + topic + '\'' +
                ", purpose='" + purpose + '\'' +
                ", id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public String getPurpose() {
        return purpose;
    }

    @Override
    public boolean isDirect() {
        return direct;
    }
}
