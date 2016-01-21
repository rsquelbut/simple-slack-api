package fr.arolla.slack.simpleslackapi;

public interface SlackPersona {
    public enum SlackPresence {UNKNOWN, ACTIVE, AWAY, AUTO}

    SlackID getId();

    String getUserName();

    String getRealName();

    String getUserMail();

    boolean isDeleted();

    boolean isAdmin();

    boolean isOwner();

    boolean isPrimaryOwner();

    boolean isRestricted();

    boolean isUltraRestricted();

    boolean isBot();

    String getTimeZone();

    String getTimeZoneLabel();

    Integer getTimeZoneOffset();
}
