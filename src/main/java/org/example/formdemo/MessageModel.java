package org.example.formdemo;

import java.time.LocalDate;

public class MessageModel {
    private String name;
    private String message;
    private String privpub;
    private LocalDate date;
    private int likes;
    private static int nextId = 1;
    private int id,id2;

    public MessageModel() {
        this.date = LocalDate.now();
        this.likes = 0;
        this.id2 = nextId++;
    }

    public MessageModel(String name, String message, String privpub, LocalDate date){
        this.name = name;
        this.message = message;
        this.privpub = privpub;
        this.date = date;
        this.likes = 0;
        this.id2 = nextId++;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPrivpub() {
        return privpub;
    }

    public void setPrivpub(String privpub) {
        this.privpub = privpub;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public void likePost(){
        likes++;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId2() {
        return id2;
    }

    public void setId2(int id2) {
        this.id2 = id2;
    }
}
