package ru.stqa.pft.addressbook.model;

import ru.stqa.pft.addressbook.tests.TestBase;

public class ContactData extends TestBase {
    private String firstname;
    private String lastname;
    private String address;
    private String email;

    private String group;
    private String mobile;


    public ContactData(String firstname, String lastname, String address, String mobile, String email, String group) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.address = address;
        this.mobile = mobile;
        this.email = email;
        this.group = group;
    }
    public String getGroup() {
        return group;
    }
    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getAddress() { return address;
    }

    public String getEmail() { return email;
    }

    public String getMobile() { return mobile;
    }
}
