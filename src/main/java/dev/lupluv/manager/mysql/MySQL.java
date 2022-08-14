package dev.lupluv.manager.mysql;

import dev.lupluv.manager.Manager;

import java.sql.*;

public class MySQL {

    public static final String mysqlPrefix = "§6§l[BungeeSystem - MySQL] §7";

    public MySQL(String host, String port, String database, String username, String password) {
        this.host = host;
        this.port = port;
        this.database = database;
        this.username = username;
        this.password = password;
    }

    String host;
    String port;
    String database;
    String username;
    String password;
    Connection con;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getDatabase() {
        return database;
    }

    public void setDatabase(String database) {
        this.database = database;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }

    public void connect() {
        if(!isConnected()){
            Manager.sendColoredConsoleMessage(mysqlPrefix + "Connecting to the Database.");
            Manager.sendColoredConsoleMessage(mysqlPrefix + "Host: '" + host + "'");
            Manager.sendColoredConsoleMessage(mysqlPrefix + "Port: '" + port + "'");
            Manager.sendColoredConsoleMessage(mysqlPrefix + "Database: '" + database + "'");
            Manager.sendColoredConsoleMessage(mysqlPrefix + "Username: '" + username + "'");
            Manager.sendColoredConsoleMessage(mysqlPrefix + "Password: '********'");
            try {
                con = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + database + "?autoReconnect=true&characterEncoding=utf8&useUnicode=true", username, password);
                Manager.sendColoredConsoleMessage(mysqlPrefix + "Successfully connected to the Database. §4❤");
            } catch (SQLException e) {
                Manager.sendColoredConsoleMessage(mysqlPrefix + "An error occurred while closing the Database Connection.");
                e.printStackTrace();
            }
        }
    }

    public void disconnect() {
        if(isConnected()){
            Manager.sendColoredConsoleMessage(mysqlPrefix + "Closing the Database Connection.");
            try {
                con.close();
                Manager.sendColoredConsoleMessage(mysqlPrefix + "Successfully closed Database Connection. §4✘");
            } catch (SQLException e) {
                Manager.sendColoredConsoleMessage(mysqlPrefix + "An error occurred while closing the Database Connection.");
                e.printStackTrace();
            }

        }
    }

    public boolean isConnected(){
        return (con == null ? false : true);
    }

    public void update(String qry){
        try {
            PreparedStatement ps = con.prepareStatement(qry);
            ps.executeUpdate();
        } catch (SQLException e) {
            Manager.sendColoredConsoleMessage(mysqlPrefix + "An error occurred while updating MySQL table.");
            e.printStackTrace();
        }
    }

    public void update(String qry, String... args){
        try {
            PreparedStatement ps = con.prepareStatement(qry);
            for (int i = 1; i <= args.length; i++) {
                ps.setString(i, args[i-1]);
            }
            ps.executeUpdate();
        } catch (SQLException e) {
            Manager.sendColoredConsoleMessage(mysqlPrefix + "An error occurred while updating MySQL table.");
            e.printStackTrace();
        }
    }

    public ResultSet getResult(String qry) {
        try {
            PreparedStatement ps = con.prepareStatement(qry);
            return ps.executeQuery();
        } catch (SQLException e) {
            Manager.sendColoredConsoleMessage(mysqlPrefix + "An error occurred while reading MySQL table.");
            e.printStackTrace();
        }
        return null;
    }

    public ResultSet getResult(String qry, String... args) {
        try {
            PreparedStatement ps = con.prepareStatement(qry);
            for (int i = 1; i <= args.length; i++) {
                ps.setString(i, args[i-1]);
            }
            return ps.executeQuery();
        } catch (SQLException e) {
            Manager.sendColoredConsoleMessage(mysqlPrefix + "An error occurred while reading MySQL table.");
            e.printStackTrace();
        }
        return null;
    }

}
