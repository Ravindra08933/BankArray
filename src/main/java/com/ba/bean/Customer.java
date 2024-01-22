package com.ba.bean;
public class Customer {
    private String name;
    private Integer id;
    private Account account;
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Account getAccount() {
        return account;
    }
    public void setAccount(Account account) {
        this.account = account;
    }
    public Customer(String name, Integer id, Account account) {
        this.name = name;
        this.id = id;
        this.account = account;
    }
    public Customer() {
    }
}

