package ru.stqa.pft.addressbook;

public class GroupData {
    private final String firstname;
    private final String lastname;
    private String address;
    private String email;
    private String mobile;

    public GroupData(String firstname, String lastname, String address, String mobile, String email) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.address = address;
        this.mobile = mobile;
        this.email = email;
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
