package org.example;

/**
 * Buat kelas pengujian pada kelas student dan course (sistem elok)
 * dengan mengimplementasikan lifecycle
 * 1. Pada kelas Uji buatlah method:
 * • InitClass berisi pembuatan object course dan array/list of students
 * • cleanClass berisi hapus course
 * • initMethod berisi pembuatan objek student dan menambahkan ke list of student
 * • Test method 1 untuk test student enrol, verifikasi jumlah student
 * • Test method 2 untuk test student unenroll, verifikasi jumlah student
 * • Perhatikan hasilnya
 * 2. Tambahkan
 * • clean method untuk menghapus jumlah student
 * • Perhatikan hasilnya
 *
 */

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello and welcome!");

        for (int i = 1; i <= 5; i++) {
            //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
            // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
            System.out.println("i = " + i);
        }
    }
}