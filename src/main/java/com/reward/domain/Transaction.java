package com.reward.domain;

import java.time.LocalDateTime;

public class Transaction {

    private String id;
    private int amount;
    private LocalDateTime transactionDate;
    private String customerId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public LocalDateTime getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(LocalDateTime transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public Transaction withId(String valueId) {
        this.setId(valueId);
        return this;
    }

    public Transaction withCustomerId(String valueCustomerId) {
        this.setCustomerId(valueCustomerId);
        return this;
    }

    public Transaction withAmount(int valueAmount) {
        this.setAmount(valueAmount);
        return this;
    }

    public Transaction withTransactionDate(LocalDateTime valueTransactionDate) {
        this.setTransactionDate(valueTransactionDate);
        return this;
    }

}
