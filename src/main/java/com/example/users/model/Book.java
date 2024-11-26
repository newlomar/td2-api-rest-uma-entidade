package com.example.users.model;

public class Book {
    private int id;
    private String name;
    private String release_date;

    public Book(int id, String name, String release_date) {
        this.id = id;
        this.name = name;
        this.release_date = release_date;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;

    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;

    }
}