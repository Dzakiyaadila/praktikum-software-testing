package org.example;

public class Book {
    private int id;
    private String title;
    private String author;
    private boolean isBorrowed;   // field baru

    public Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isBorrowed = false;  // default: belum dipinjam
    }

    public int getId() {
        return id;
    }      
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public boolean isBorrowed() {
        return isBorrowed;
    }
    public void setBorrowed(boolean borrowed) {
        isBorrowed = borrowed;
    }
}