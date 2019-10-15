package com.example.myquran.modal;

public class ModalServer {

    private String id;
    private String name;
    private String Server;
    private String rewaya;

    public ModalServer(String id, String name, String server, String rewaya) {
        this.id = id;
        this.name = name;
        Server = server;
        this.rewaya = rewaya;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getServer() {
        return Server;
    }

    public void setServer(String server) {
        Server = server;
    }

    public String getRewaya() {
        return rewaya;
    }

    public void setRewaya(String rewaya) {
        this.rewaya = rewaya;
    }
}
