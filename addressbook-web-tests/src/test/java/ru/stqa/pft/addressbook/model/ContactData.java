package ru.stqa.pft.addressbook.model;

public class ContactData {
    private final String lastname;
    private final String mobile;
    private final String firstnsme;
    private final String email;

    public ContactData(String lastname, String mobile, String firstnsme, String email) {
        this.lastname = lastname;
        this.mobile = mobile;
        this.firstnsme = firstnsme;
        this.email = email;
    }

    public String getLastname() {
        return lastname;
    }

    public String getMobile() {
        return mobile;
    }

    public String getFirstnsme() {
        return firstnsme;
    }

    public String getEmail() {
        return email;
    }

}