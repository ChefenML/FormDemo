package org.example.formdemo;

import java.time.LocalDate;

public class MessageModel {
    private String name;
    private String message;
    private String privpub;
    private LocalDate date;

    public MessageModel() {
    }

    public MessageModel(String name, String message, String privpub, LocalDate date){
        this.name = name;
        this.message = message;
        this.privpub = privpub;
        this.date = date;
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

    public String isPrivpub() {
        return this.privpub;
    }

    public void setPrivpub(String privpub) {
        this.privpub = privpub;
    }
}
