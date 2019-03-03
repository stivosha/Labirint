package com.mygdx.game.player;

public class Player {
    private String login;
    private String password;
    private String forFind;
    private int rating;

    public Player(){}

    public Player(String login, String password) {
        this.login = login;
        this.password = password;
        forFind = login + "@" + password;
    }

    public String getForFind() {
        return forFind;
    }
}
