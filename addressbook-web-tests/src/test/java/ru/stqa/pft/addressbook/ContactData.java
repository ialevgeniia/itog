package ru.stqa.pft.addressbook;

public class ContactData {
    private final String lastname;
    private final String mobile;
    private final String firstnsme;
    private final String email;

    public ContactData(String lastname, String mobile, String firstname, String email) {
        this.lastname = lastname;
        this.mobile = mobile;
        this.firstnsme = firstname;
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
