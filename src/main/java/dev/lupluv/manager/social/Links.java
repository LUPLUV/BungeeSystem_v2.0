package dev.lupluv.manager.social;

public class Links {

    long userID;
    String youtubeName;
    String youtubeLink;
    String twitchName;
    String twitchLink;
    String discordName;
    String discordTag;
    String email;

    public Links() {
    }

    public Links(long userID) {
        this.userID = userID;
    }

    public long getUserID() {
        return userID;
    }

    public void setUserID(long userID) {
        this.userID = userID;
    }

    public String getYoutubeName() {
        return youtubeName;
    }

    public void setYoutubeName(String youtubeName) {
        this.youtubeName = youtubeName;
    }

    public String getYoutubeLink() {
        return youtubeLink;
    }

    public void setYoutubeLink(String youtubeLink) {
        this.youtubeLink = youtubeLink;
    }

    public String getTwitchName() {
        return twitchName;
    }

    public void setTwitchName(String twitchName) {
        this.twitchName = twitchName;
    }

    public String getTwitchLink() {
        return twitchLink;
    }

    public void setTwitchLink(String twitchLink) {
        this.twitchLink = twitchLink;
    }

    public String getDiscordName() {
        return discordName;
    }

    public void setDiscordName(String discordName) {
        this.discordName = discordName;
    }

    public String getDiscordTag() {
        return discordTag;
    }

    public void setDiscordTag(String discordTag) {
        this.discordTag = discordTag;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
