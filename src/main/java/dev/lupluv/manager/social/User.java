package dev.lupluv.manager.social;

import dev.lupluv.manager.Manager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class User {

    long id;
    UUID uuid;
    String name;
    String status;
    long lastOnline;
    String currentServer;
    boolean jumping;
    boolean requests;
    boolean messages;
    boolean onlineNotify;

    public User() {
    }

    public User(long id) {
        this.id = id;
    }

    public User(UUID uuid) {
        this.uuid = uuid;
    }

    public User(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public long getLastOnline() {
        return lastOnline;
    }

    public void setLastOnline(long lastOnline) {
        this.lastOnline = lastOnline;
    }

    public String getCurrentServer() {
        return currentServer;
    }

    public void setCurrentServer(String currentServer) {
        this.currentServer = currentServer;
    }

    public boolean isJumping() {
        return jumping;
    }

    public void setJumping(boolean jumping) {
        this.jumping = jumping;
    }

    public boolean isRequests() {
        return requests;
    }

    public void setRequests(boolean requests) {
        this.requests = requests;
    }

    public boolean isMessages() {
        return messages;
    }

    public void setMessages(boolean messages) {
        this.messages = messages;
    }

    public boolean isOnlineNotify() {
        return onlineNotify;
    }

    public void setOnlineNotify(boolean onlineNotify) {
        this.onlineNotify = onlineNotify;
    }

    public boolean existsByID(){
        if(Manager.getManager().getMySQL().isConnected()){
            try{
                PreparedStatement ps = Manager.getManager().getMySQL().getCon().prepareStatement("SELECT * FROM psys_Punishments WHERE ID = ?");
                ps.setString(1, String.valueOf(id));
                ResultSet rs = ps.executeQuery();
                while (rs.next()){
                    return true;
                }
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        return false;
    }

    public boolean existsByUUID(){
        if(Manager.getManager().getMySQL().isConnected()){
            try{
                PreparedStatement ps = Manager.getManager().getMySQL().getCon().prepareStatement("SELECT * FROM psys_Punishments WHERE UUID = ?");
                ps.setString(1, uuid.toString());
                ResultSet rs = ps.executeQuery();
                while (rs.next()){
                    return true;
                }
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        return false;
    }

}
