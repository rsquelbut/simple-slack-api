package fr.arolla.slack.simpleslackapi.impl;

import fr.arolla.slack.simpleslackapi.SlackID;
import fr.arolla.slack.simpleslackapi.SlackPersona;

class SlackPersonaImpl implements SlackPersona {
    final SlackID id;
    final String userName;
    final String realName;
    final String userMail;
    final boolean deleted;
    final boolean admin;
    final boolean owner;
    final boolean primaryOwner;
    final boolean restricted;
    final boolean ultraRestricted;
    final boolean bot;
    final String timeZone;
    final String timeZoneLabel;
    final Integer timeZoneOffset;

    SlackPersonaImpl(SlackID id, String userName, String realName, String userMail, boolean deleted, boolean admin, boolean owner, boolean primaryOwner, boolean restricted, boolean ultraRestricted, boolean bot, String timeZone, String timeZoneLabel, Integer timeZoneOffset) {
        this.id = id;
        this.userName = userName;
        this.realName = realName;
        this.userMail = userMail;
        this.deleted = deleted;
        this.admin = admin;
        this.owner = owner;
        this.primaryOwner = primaryOwner;
        this.restricted = restricted;
        this.ultraRestricted = ultraRestricted;
        this.bot = bot;
        this.timeZone = timeZone;
        this.timeZoneLabel = timeZoneLabel;
        this.timeZoneOffset = timeZoneOffset;
    }

    @Override
    public SlackID getId() {
        return id;
    }

    @Override
    public String getUserName() {
        return userName;
    }

    @Override
    public boolean isDeleted() {
        return deleted;
    }

    @Override
    public boolean isAdmin() {
        return admin;
    }

    @Override
    public boolean isOwner() {
        return owner;
    }

    @Override
    public boolean isPrimaryOwner() {
        return primaryOwner;
    }

    @Override
    public boolean isRestricted() {
        return restricted;
    }

    @Override
    public boolean isUltraRestricted() {
        return ultraRestricted;
    }

    @Override
    public boolean isBot() {
        return bot;
    }

    @Override
    public String getUserMail() {
        return userMail;
    }

    @Override
    public String getRealName() {
        return realName;
    }

    @Override
    public String getTimeZone() {
        return timeZone;
    }

    @Override
    public String getTimeZoneLabel() {
        return timeZoneLabel;
    }

    @Override
    public Integer getTimeZoneOffset() {
        return timeZoneOffset;
    }

}
