package org.example;

public class NotificationService {
    // Mengirim notifikasi ke user
    public void sendNotification(String username, String title) {
        // kirim email/push notification ke username
        System.out.println("Notifikasi terkirim ke " + username
                + ": buku '" + title + "' berhasil diproses.");
    }
}