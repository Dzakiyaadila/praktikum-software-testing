package org.example;

import java.util.ArrayList;
import java.util.List;

public class Wallet {

    private String owner;
    private List<String> cards;
    private double cash;

    public Wallet(String owner, double cash) {
        this.owner = owner;
        this.cash = cash;
        this.cards = new ArrayList<>();
    }

    public String getOwner() {
        return owner;
    }
    public double getCash() {
        return cash;
    }
    public List<String> getCards() {
        return cards;
    }
    public void setOwner(String owner) {
        this.owner = owner;
    }
    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Saldo harus positipph");
        } cash += amount;
    }
    public void withdraw(double amount) {
        if (amount > cash) {
            throw new IllegalArgumentException("Saldo ga cukupp");
        } cash -= amount;
    }
    public void addCard(String card) {
        cards.add(card);
    }
    public void removeCard(String card) {
        cards.remove(card);
    }
}

//package org.example;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class Wallet {
//    private Owner owner; // Level up: dari String ke Object
//    private List<String> cards;
//    private double cash;
//
//    public Wallet(Owner owner, double cash) {
//        this.owner = owner;
//        this.cash = cash;
//        this.cards = new ArrayList<>();
//    }
//
//    public Owner getOwner() { return owner; }
//    public double getCash() { return cash; }
//
//    public void deposit(double amount) {
//        if (amount <= 0) {
//            throw new IllegalArgumentException("Saldo harus positif");
//        }
//        cash += amount;
//    }
//
//    public void withdraw(double amount) {
//        if (amount < 0) {
//            throw new IllegalArgumentException("Jumlah withdraw tidak boleh negatif");
//        }
//        if (amount > cash) {
//            // Sesuai modul: melempar exception jika saldo kurang
//            throw new RuntimeException("Insufficient Funds Exception");
//        }
//        cash -= amount;
//    }
//
//    public void addCard(String card) { cards.add(card); }
//}