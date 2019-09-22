package ru.stqa.pft.addressbook.model;

public class ContactData {
    private int id;
    private String lastname;
    private String mobile;
    private String firstnsme;
    private String email;



    public ContactData(String lastname, String mobile, String firstnsme, String email) {
        this.id = Integer.MAX_VALUE;
        this.lastname = lastname;
        this.mobile = mobile;
        this.firstnsme = firstnsme;
        this.email = email;
    }

    public ContactData(int id, String lastname, String mobile, String firstnsme, String email) {
        this.id = id;
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


    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "ContactData{" +
                "lastname='" + lastname + '\'' +
                ", firstnsme='" + firstnsme + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContactData that = (ContactData) o;

        if (lastname != null ? !lastname.equals(that.lastname) : that.lastname != null) return false;
        return firstnsme != null ? firstnsme.equals(that.firstnsme) : that.firstnsme == null;
    }

    @Override
    public int hashCode() {
        int result = lastname != null ? lastname.hashCode() : 0;
        result = 31 * result + (firstnsme != null ? firstnsme.hashCode() : 0);
        return result;
    }
}