package org.example;

import java.util.List;

public class LibraryControl {
    private final LibraryModel model;
    private final NotificationService notificationService; // dependency baru

    public LibraryControl(LibraryModel model, NotificationService notificationService) {
        this.model = model;
        this.notificationService = notificationService;
    }

    public String searchBookAuthor(String title) {
        List<Book> books = model.getAllBooks();
        String result = "";
        for (Book book : books) {
            if (book.getTitle().equals(title)) {
                model.saveSearchKeyword(title);
                result = book.getAuthor();
            }
        }
        return result;
    }

    public boolean checkAvailability(int id) {
        return model.cekKetersediaan(id);
    }

    // logic buat minjem buku
    // panggil username untuk notif
    public void borrowBook(int id, String username) {
        // - ambil semua buku untuk cari title
        List<Book> books = model.getAllBooks();

        // - cari buku based on id
        String title = "";
        for (Book book : books) {
            if (book.getId() == id) {
                title = book.getTitle();
                break;
            }
        }

        // cek avail buku
        boolean available = model.cekKetersediaan(id);

        if (available) {
            //kalo ada dipinjam dan kirim notif
            model.borrowBook(id);
            notificationService.sendNotification(username, title);
        }
        // kalau tidak tersedia, tidak ada yang dipanggil
    }
}