package org.example.formdemo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

//@Entity
public class MessageModel {
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id1;

    @NotBlank
    @Size(min=3,max=20)
    private String name;

    @NotBlank
    @Size(min=3,max=200)
    private String message;
    private String privpub;
    private LocalDate date;
    private int likes;
    private int id;

    public MessageModel() {
        this.date = LocalDate.now();
        this.likes = 0;
    }

    public MessageModel(String name, String message, String privpub, LocalDate date){
        this.name = name;
        this.message = message;
        this.privpub = privpub;
        this.date = date;
        this.likes = 0;
    }

    public Long getId1() {
        return id1;
    }

    public void setId1(Long id1) {
        this.id1 = id1;
    }

    public String getName() {
        return this.name;
    }

    public void setName( String name) {
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

}
