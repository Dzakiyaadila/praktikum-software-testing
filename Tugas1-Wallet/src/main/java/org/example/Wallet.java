package org.example;

import java.util.ArrayList;
import java.util.List;

public class Wallet {

    private String owner;
    private List<String> card;
    private double cash;

    public Wallet(String owner, double cash) {
        this.owner = owner;
        this.cash = cash;
        this.card = new ArrayList<>();
    }

    public boolean deposit (double amount) {
        if (amount > 0 ) {
            cash += amount;
            return true;
        }
        return false;
    }
    public void addCard (String cards) {
        card.add(cards);
    }

    public boolean removeCard(int index) {
        if (index >= 0 && index < card.size()) {
            card.remove(index);
            return true;
        }
        return false;
    }

    public String getOwner() {
        return owner;
    }
    public void setOwner(String owner) {
        this.owner = owner;
    }
    public double getCash() {
        return cash;
    }
    public void setCash(double cash) {
        this.cash = cash;
    }
    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= cash) {
            cash -= amount;
            return true;
        }
        return false;
    }

    public List<String> getCard() {
        return card;
    }
}
