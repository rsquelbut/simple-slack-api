package fr.arolla.jam.bus.simpleslackapi;

import java.io.IOException;
import java.util.Collection;
import java.util.Map;

import fr.arolla.jam.bus.simpleslackapi.listeners.ReactionAddedListener;
import fr.arolla.jam.bus.simpleslackapi.listeners.SlackChannelUnarchivedListener;
import fr.arolla.jam.bus.simpleslackapi.listeners.SlackConnectedListener;
import fr.arolla.jam.bus.simpleslackapi.listeners.SlackGroupJoinedListener;
import fr.arolla.jam.bus.simpleslackapi.replies.SlackChannelReply;
import fr.arolla.jam.bus.simpleslackapi.replies.SlackMessageReply;
import fr.arolla.jam.bus.simpleslackapi.impl.SlackChatConfiguration;
import fr.arolla.jam.bus.simpleslackapi.listeners.ReactionRemovedListener;
import fr.arolla.jam.bus.simpleslackapi.listeners.SlackChannelArchivedListener;
import fr.arolla.jam.bus.simpleslackapi.listeners.SlackChannelCreatedListener;
import fr.arolla.jam.bus.simpleslackapi.listeners.SlackChannelDeletedListener;
import fr.arolla.jam.bus.simpleslackapi.listeners.SlackChannelRenamedListener;
import fr.arolla.jam.bus.simpleslackapi.listeners.SlackMessageDeletedListener;
import fr.arolla.jam.bus.simpleslackapi.listeners.SlackMessagePostedListener;
import fr.arolla.jam.bus.simpleslackapi.listeners.SlackMessageUpdatedListener;
import fr.arolla.jam.bus.simpleslackapi.replies.GenericSlackReply;
import fr.arolla.jam.bus.simpleslackapi.replies.SlackReply;

public interface SlackSession {

    Collection<SlackChannel> getChannels();

    Collection<SlackUser> getUsers();

    SlackChannel findChannelByName(String channelName);

    SlackChannel findChannelById(String channelId);

    SlackUser findUserById(String userId);

    SlackUser findUserByUserName(String userName);

    SlackUser findUserByEmail(String userMail);

    SlackPersona sessionPersona();

    SlackMessageHandle<GenericSlackReply> inviteUser(String email, String firstName, boolean setActive);

    void connect() throws IOException;

    void disconnect() throws IOException;

    SlackMessageHandle<SlackMessageReply> deleteMessage(String timeStamp, SlackChannel channel);

    SlackMessageHandle<SlackMessageReply> sendMessage(SlackChannel channel, String message, SlackAttachment attachment, SlackChatConfiguration chatConfiguration, boolean unfurl);

    SlackMessageHandle<SlackMessageReply> sendMessage(SlackChannel channel, String message, SlackAttachment attachment, SlackChatConfiguration chatConfiguration);

    SlackMessageHandle<SlackMessageReply> sendMessage(SlackChannel channel, String message, SlackAttachment attachment, boolean unfurl);

    SlackMessageHandle<SlackMessageReply> sendMessage(SlackChannel channel, String message, SlackAttachment attachment);

    SlackMessageHandle<SlackMessageReply> sendMessage(SlackChannel channel, String message, boolean unfurl);

    SlackMessageHandle<SlackMessageReply> sendMessage(SlackChannel channel, String message);

    SlackMessageHandle<SlackMessageReply> sendMessageToUser(SlackUser user, String message, SlackAttachment attachment);

    SlackMessageHandle<SlackMessageReply> sendMessageToUser(String userName, String message, SlackAttachment attachment);

    SlackMessageHandle<SlackMessageReply> updateMessage(String timeStamp, SlackChannel channel, String message);

    SlackMessageHandle<SlackMessageReply> sendMessageOverWebSocket(SlackChannel channel, String message, SlackAttachment attachment);

    SlackMessageHandle<SlackMessageReply> addReactionToMessage(SlackChannel channel, String messageTimeStamp, String emojiCode);

    SlackMessageHandle<SlackChannelReply> joinChannel(String channelName);

    SlackMessageHandle<SlackChannelReply> leaveChannel(SlackChannel channel);

    SlackMessageHandle<SlackChannelReply> inviteToChannel(SlackChannel channel, SlackUser user);

    SlackMessageHandle<SlackReply> archiveChannel(SlackChannel channel);

    SlackMessageHandle<SlackChannelReply> openDirectMessageChannel(SlackUser user);

    SlackMessageHandle<SlackChannelReply> openMultipartyDirectMessageChannel(SlackUser... users);

    SlackPersona.SlackPresence getPresence(SlackPersona persona);

    SlackMessageHandle<GenericSlackReply> postGenericSlackCommand(Map<String, String> params, String command);

    void addchannelArchivedListener(SlackChannelArchivedListener listener);

    void removeChannelArchivedListener(SlackChannelArchivedListener listener);

    void addchannelCreatedListener(SlackChannelCreatedListener listener);

    void removeChannelCreatedListener(SlackChannelCreatedListener listener);

    void addchannelDeletedListener(SlackChannelDeletedListener listener);

    void removeChannelDeletedListener(SlackChannelDeletedListener listener);

    void addChannelRenamedListener(SlackChannelRenamedListener listener);

    void removeChannelRenamedListener(SlackChannelRenamedListener listener);

    void addChannelUnarchivedListener(SlackChannelUnarchivedListener listener);

    void removeChannelUnarchivedListener(SlackChannelUnarchivedListener listener);

    void addMessageDeletedListener(SlackMessageDeletedListener listener);

    void removeMessageDeletedListener(SlackMessageDeletedListener listener);

    void addMessagePostedListener(SlackMessagePostedListener listener);

    void removeMessagePostedListener(SlackMessagePostedListener listener);

    void addMessageUpdatedListener(SlackMessageUpdatedListener listener);

    void removeMessageUpdatedListener(SlackMessageUpdatedListener listener);

    void addGroupJoinedListener(SlackGroupJoinedListener listener);

    void removeGroupJoinedListener(SlackGroupJoinedListener listener);


    /*
     * Subscribe to events related to the connection to the slack
     * server. At this time a set of status information is exchanged that
     * is useful to implementing bots.
     * 
     * For example, the current user that is connecting.
     * knowing your own user id will help you stop answering your own
     * questions.
     */
    void addSlackConnectedListener(SlackConnectedListener listner);

    void removeSlackConnectedListener(SlackConnectedListener listener);

    /**
     * @return true if connection is open
     */
    boolean isConnected();

    void addReactionAddedListener(ReactionAddedListener listener);

    void removeReactionAddedListener(ReactionAddedListener listener);

    void addReactionRemovedListener(ReactionRemovedListener listener);

    void removeReactionRemovedListener(ReactionRemovedListener listener);

}
