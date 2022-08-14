package dev.lupluv.manager.social;

public class FriendShip {

    long id;
    long user1;
    long user2;
    boolean fav1;
    boolean fav2;
    String date;

    public FriendShip() {
    }

    public FriendShip(long id) {
        this.id = id;
    }

    public FriendShip(long user1, long user2) {
        this.user1 = user1;
        this.user2 = user2;
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

    public boolean isFav1() {
        return fav1;
    }

    public void setFav1(boolean fav1) {
        this.fav1 = fav1;
    }

    public boolean isFav2() {
        return fav2;
    }

    public void setFav2(boolean fav2) {
        this.fav2 = fav2;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
