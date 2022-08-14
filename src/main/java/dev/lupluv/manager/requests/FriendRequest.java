package dev.lupluv.manager.requests;

import dev.lupluv.manager.Manager;

import java.sql.ResultSet;
import java.sql.SQLException;

public class FriendRequest {

    long id;
    RequestType type;
    long user1;
    long user2;
    String date;

    public FriendRequest() {
    }

    public FriendRequest(long user1, long user2) {
        this.user1 = user1;
        this.user2 = user2;
    }

    public FriendRequest(long id) {
        this.id = id;
    }

    public FriendRequest(long id, long user1, long user2, String date) {
        this.id = id;
        this.user1 = user1;
        this.user2 = user2;
        this.date = date;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUser1() {
        return user1;
    }

    public void setUser1(long user1) {
        this.user1 = user1;
    }

    public long getUser2() {
        return user2;
    }

    public void setUser2(long user2) {
        this.user2 = user2;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void loadByID() {
        if(Manager.getManager().getMySQL().isConnected()){
            try {
                ResultSet rs = Manager.getManager().getMySQL().getResult("SELECT * FROM social_requests WHERE ID = ?", String.valueOf(id));
                while (rs.next()) {
                    type = RequestType.valueOf(rs.getString("TYPE"));
                    user1 = rs.getLong("VAL1");
                    user2 = rs.getLong("VAL2");
                    date = rs.getString("DATE");
                }
            }catch (SQLException ex){
                ex.printStackTrace();
            }
        }
    }

    public void loadByUsers() {
        if(Manager.getManager().getMySQL().isConnected()){
            try {
                ResultSet rs = Manager.getManager().getMySQL().getResult("SELECT * FROM social_requests WHERE VAL1 = ? AND VAL2 = ?", String.valueOf(user1)
                        , String.valueOf(user2));
                while (rs.next()) {
                    id = rs.getLong("ID");
                    type = RequestType.valueOf(rs.getString("TYPE"));
                    date = rs.getString("DATE");
                }
            }catch (SQLException ex){
                ex.printStackTrace();
            }
        }
    }

    public boolean existsByID() {
        if(Manager.getManager().getMySQL().isConnected()){
            try {
                ResultSet rs = Manager.getManager().getMySQL().getResult("SELECT * FROM social_requests WHERE ID = ?", String.valueOf(id));
                while (rs.next()) {
                    return true;
                }
            }catch (SQLException ex){
                ex.printStackTrace();
            }
        }
        return false;
    }

    public boolean existsByUsers() {
        if(Manager.getManager().getMySQL().isConnected()){
            try {
                ResultSet rs = Manager.getManager().getMySQL().getResult("SELECT * FROM social_requests WHERE VAL1 = ? AND VAL2 = ?", String.valueOf(user1)
                        , String.valueOf(user2));
                while (rs.next()) {
                    return true;
                }
            }catch (SQLException ex){
                ex.printStackTrace();
            }
        }
        return false;
    }

}
