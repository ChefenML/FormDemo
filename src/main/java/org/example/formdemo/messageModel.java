package org.example.formdemo;

public class messageModel {
    private String name;
    private String message;
    private boolean privpub;

    public messageModel() {
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

    public boolean isPrivpub() {
        return this.privpub;
    }

    public void setPrivpub(boolean privpub) {
        this.privpub = privpub;
    }
}
