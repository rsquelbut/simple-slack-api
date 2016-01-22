package fr.arolla.jam.bus.simpleslackapi.impl;

import fr.arolla.jam.bus.simpleslackapi.SlackUser;
import fr.arolla.jam.bus.simpleslackapi.SlackID;

class SlackUserImpl extends SlackPersonaImpl implements SlackUser {
    //private static final Logger LOGGER   = LoggerFactory.getLogger(SlackUserImpl.class);

    @Override
    public String toString() {
        return "SlackUserImpl{" + "id='" + id + '\'' + ", userName='" + userName + '\'' + ", realName='" + realName + '\'' + ", userMail='" + userMail + '\'' + ", isDeleted=" + deleted + '\'' + ", isAdmin=" + admin + '\'' + ", isOwner="
                + owner + '\'' + ", isPrimaryOwner=" + primaryOwner + '\'' + ", isRestricted=" + restricted + '\'' + ", isUltraRestricted=" + ultraRestricted + ", timeZone=" + timeZone + ", timeZoneLabel=" + timeZoneLabel + ", timeZoneOffset="
                + timeZoneOffset + "}";
    }

    SlackUserImpl(SlackID id, String userName, String realName, String userMail, boolean deleted, boolean admin, boolean owner, boolean primaryOwner, boolean restricted, boolean ultraRestricted, boolean bot, String timeZone,
                  String timeZoneLabel, Integer timeZoneOffset) {
        super(id, userName, realName, userMail, deleted, admin, owner, primaryOwner, restricted, ultraRestricted, bot, timeZone, timeZoneLabel, timeZoneOffset);
    }
}
