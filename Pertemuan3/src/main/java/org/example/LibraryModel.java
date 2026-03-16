package org.example;

import java.util.ArrayList;
import java.util.List;

public class LibraryModel {

    public List<Book> getAllBooks() {
        List<Book> allBooks = new ArrayList<>();
        // fetch from database
        return allBooks;
    }

    public void saveSearchKeyword(String keyword) {
        // save to db
    }

    public boolean cekKetersediaan(int id) {
        return false;
    }

    // pinjam buku based on id
    public void borrowBook(int id) {
        // update status di database
    }

    // kembalikan buku based on id
    public void returnBook(int id) {
        // update status di database
    }
}