package fr.arolla.jam.bus.simpleslackapi.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import fr.arolla.jam.bus.simpleslackapi.SlackPersona;
import fr.arolla.jam.bus.simpleslackapi.SlackUser;
import fr.arolla.jam.bus.simpleslackapi.listeners.ReactionAddedListener;
import fr.arolla.jam.bus.simpleslackapi.SlackAttachment;
import fr.arolla.jam.bus.simpleslackapi.SlackChannel;
import fr.arolla.jam.bus.simpleslackapi.SlackID;
import fr.arolla.jam.bus.simpleslackapi.SlackMessageHandle;
import fr.arolla.jam.bus.simpleslackapi.SlackSession;
import fr.arolla.jam.bus.simpleslackapi.SlackTeam;
import fr.arolla.jam.bus.simpleslackapi.listeners.ReactionRemovedListener;
import fr.arolla.jam.bus.simpleslackapi.listeners.SlackChannelArchivedListener;
import fr.arolla.jam.bus.simpleslackapi.listeners.SlackChannelCreatedListener;
import fr.arolla.jam.bus.simpleslackapi.listeners.SlackChannelDeletedListener;
import fr.arolla.jam.bus.simpleslackapi.listeners.SlackChannelRenamedListener;
import fr.arolla.jam.bus.simpleslackapi.listeners.SlackChannelUnarchivedListener;
import fr.arolla.jam.bus.simpleslackapi.listeners.SlackConnectedListener;
import fr.arolla.jam.bus.simpleslackapi.listeners.SlackGroupJoinedListener;
import fr.arolla.jam.bus.simpleslackapi.listeners.SlackMessageDeletedListener;
import fr.arolla.jam.bus.simpleslackapi.listeners.SlackMessagePostedListener;
import fr.arolla.jam.bus.simpleslackapi.listeners.SlackMessageUpdatedListener;
import fr.arolla.jam.bus.simpleslackapi.replies.SlackMessageReply;

abstract class AbstractSlackSessionImpl implements SlackSession {
	static final SlackChatConfiguration DEFAULT_CONFIGURATION = SlackChatConfiguration.getConfiguration().asUser();
	static final boolean DEFAULT_UNFURL = true;
	protected Map<String, SlackChannel> channels = new HashMap<>();
	protected Map<String, SlackUser> users = new HashMap<>();
	protected SlackPersona sessionPersona;
	protected SlackTeam team;
	protected List<SlackChannelArchivedListener> channelArchiveListener = new ArrayList<>();
	protected List<SlackChannelCreatedListener> channelCreateListener = new ArrayList<>();
	protected List<SlackChannelDeletedListener> channelDeleteListener = new ArrayList<>();
	protected List<SlackChannelRenamedListener> channelRenamedListener = new ArrayList<SlackChannelRenamedListener>();
	protected List<SlackChannelUnarchivedListener> channelUnarchiveListener = new ArrayList<SlackChannelUnarchivedListener>();
	protected List<SlackGroupJoinedListener> groupJoinedListener = new ArrayList<SlackGroupJoinedListener>();
	protected List<SlackMessageDeletedListener> messageDeletedListener = new ArrayList<SlackMessageDeletedListener>();
	protected List<SlackMessagePostedListener> messagePostedListener = new ArrayList<SlackMessagePostedListener>();
	protected List<SlackMessageUpdatedListener> messageUpdatedListener = new ArrayList<SlackMessageUpdatedListener>();
	protected List<SlackConnectedListener> slackConnectedListener = new ArrayList<SlackConnectedListener>();
	protected List<SlackConnectedListener> slackConnectedLinster = new ArrayList<>();
	protected List<ReactionAddedListener> reactionAddedListener = new ArrayList<>();
	protected List<ReactionRemovedListener> reactionRemovedListener = new ArrayList<>();

	@Override
	public Collection<SlackChannel> getChannels() {
		return new ArrayList<>(channels.values());
	}

	@Override
	public Collection<SlackUser> getUsers() {
		return new ArrayList<>(users.values());
	}

	@Override
	public SlackChannel findChannelByName(String channelName) {
		for (SlackChannel channel : channels.values()) {
			if (channelName.equals(channel.getName())) {
				return channel;
			}
		}
		return null;
	}

	@Override
	public SlackChannel findChannelById(String channelId) {
		SlackChannel toReturn = channels.get(channelId);
		if (toReturn == null) {
			// direct channel case
			if (channelId != null && channelId.startsWith("D")) {
				toReturn = new SlackChannelImpl(SlackID.from(channelId), "", "", "", true);
			}
		}
		return toReturn;
	}

	@Override
	public SlackUser findUserById(String userId) {
		return users.get(userId);
	}

	@Override
	public SlackUser findUserByUserName(String userName) {
		for (SlackUser user : users.values()) {
			if (userName.equals(user.getUserName())) {
				return user;
			}
		}
		return null;
	}

	@Override
	public SlackUser findUserByEmail(String userMail) {
		for (SlackUser user : users.values()) {
			if (userMail.equals(user.getUserMail())) {
				return user;
			}
		}
		return null;
	}

	@Override
	public SlackPersona sessionPersona() {
		return sessionPersona;
	}

	@Override
	public SlackMessageHandle<SlackMessageReply> sendMessage(SlackChannel channel, String message, SlackAttachment attachment) {
		return sendMessage(channel, message, attachment, DEFAULT_CONFIGURATION);
	}

	@Override
	public SlackMessageHandle<SlackMessageReply> sendMessage(SlackChannel channel, String message) {
		return sendMessage(channel, message, DEFAULT_UNFURL);
	}

	@Override
	public SlackMessageHandle<SlackMessageReply> sendMessage(SlackChannel channel, String message, boolean unfurl) {
		return sendMessage(channel, message, null, DEFAULT_CONFIGURATION, unfurl);
	}

	@Override
	public SlackMessageHandle<SlackMessageReply> sendMessage(SlackChannel channel, String message, SlackAttachment attachment,
			boolean unfurl) {
		return sendMessage(channel, message, attachment, DEFAULT_CONFIGURATION, unfurl);
	}

	@Override
	public SlackMessageHandle<SlackMessageReply> sendMessage(SlackChannel channel, String message, SlackAttachment attachment,
			SlackChatConfiguration chatConfiguration) {
		return sendMessage(channel, message, attachment, chatConfiguration, DEFAULT_UNFURL);
	}

	@Override
	public void addchannelArchivedListener(SlackChannelArchivedListener listener) {
		channelArchiveListener.add(listener);
	}

	@Override
	public void removeChannelArchivedListener(SlackChannelArchivedListener listener) {
		channelArchiveListener.remove(listener);
	}

	@Override
	public void addchannelCreatedListener(SlackChannelCreatedListener listener) {
		channelCreateListener.add(listener);
	}

	@Override
	public void removeChannelCreatedListener(SlackChannelCreatedListener listener) {
		channelCreateListener.remove(listener);
	}

	@Override
	public void addchannelDeletedListener(SlackChannelDeletedListener listener) {
		channelDeleteListener.add(listener);
	}

	@Override
	public void removeChannelDeletedListener(SlackChannelDeletedListener listener) {
		channelDeleteListener.remove(listener);
	}

	@Override
	public void addChannelRenamedListener(SlackChannelRenamedListener listener) {
		channelRenamedListener.add(listener);
	}

	@Override
	public void removeChannelRenamedListener(SlackChannelRenamedListener listener) {
		channelRenamedListener.remove(listener);
	}

	@Override
	public void addChannelUnarchivedListener(SlackChannelUnarchivedListener listener) {
		channelUnarchiveListener.add(listener);
	}

	@Override
	public void removeChannelUnarchivedListener(SlackChannelUnarchivedListener listener) {
		channelUnarchiveListener.remove(listener);
	}

	@Override
	public void addMessageDeletedListener(SlackMessageDeletedListener listener) {
		messageDeletedListener.add(listener);
	}

	@Override
	public void removeMessageDeletedListener(SlackMessageDeletedListener listener) {
		messageDeletedListener.remove(listener);
	}

	@Override
	public void addMessagePostedListener(SlackMessagePostedListener listener) {
		messagePostedListener.add(listener);
	}

	@Override
	public void removeMessagePostedListener(SlackMessagePostedListener listener) {
		messagePostedListener.remove(listener);
	}

	@Override
	public void addMessageUpdatedListener(SlackMessageUpdatedListener listener) {
		messageUpdatedListener.add(listener);
	}

	@Override
	public void removeMessageUpdatedListener(SlackMessageUpdatedListener listener) {
		messageUpdatedListener.remove(listener);
	}

	@Override
	public void addGroupJoinedListener(SlackGroupJoinedListener listener) {
		groupJoinedListener.add(listener);
	}

	@Override
	public void removeGroupJoinedListener(SlackGroupJoinedListener listener) {
		groupJoinedListener.remove(listener);
	}

	@Override
	public void addSlackConnectedListener(SlackConnectedListener listener) {
		slackConnectedListener.add(listener);
	}

	@Override
	public void removeSlackConnectedListener(SlackConnectedListener listener) {
		slackConnectedListener.remove(listener);
	}

	@Override
	public void addReactionAddedListener(ReactionAddedListener listener) {
		reactionAddedListener.add(listener);
	}

	@Override
	public void removeReactionAddedListener(ReactionAddedListener listener) {
		reactionAddedListener.remove(listener);
	}

	@Override
	public void addReactionRemovedListener(ReactionRemovedListener listener) {
		reactionRemovedListener.add(listener);
	}

	@Override
	public void removeReactionRemovedListener(ReactionRemovedListener listener) {
		reactionRemovedListener.remove(listener);
	}
}

