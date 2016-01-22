package fr.arolla.jam.bus.simpleslackapi;

import java.util.List;

import org.threeten.bp.LocalDate;

import fr.arolla.jam.bus.simpleslackapi.events.SlackMessagePosted;

public interface ChannelHistoryModule {

    public List<SlackMessagePosted> fetchHistoryOfChannel(String channelName);

    public List<SlackMessagePosted> fetchHistoryOfChannel(String channelName, LocalDate day);

    public List<SlackMessagePosted> fetchHistoryOfChannel(String channelName, int numberOfMessages);

    public List<SlackMessagePosted> fetchHistoryOfChannel(String channelName, LocalDate day, int numberOfMessages);

    public List<SlackMessagePosted> fetchUpdatingHistoryOfChannel(String channelId);

    public List<SlackMessagePosted> fetchUpdatingHistoryOfChannel(String channelId, LocalDate day);

    public List<SlackMessagePosted> fetchUpdatingHistoryOfChannel(String channelId, int numberOfMessages);

    public List<SlackMessagePosted> fetchUpdatingHistoryOfChannel(String channelId, LocalDate day, int numberOfMessages);


}
