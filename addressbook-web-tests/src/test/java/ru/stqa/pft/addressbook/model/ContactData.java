package ru.stqa.pft.addressbook.model;

public class ContactData {
    private final String firstName;
    private final String lastName;
    private final String address;
    private final String phoneNumber;
    private final String email;
    private String group;
    //private final String id;

    public ContactData( String firstName, String lastName, String address, String phoneNumber,

                        String email, String group) {
       // this.id=id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.group = group;
    }


    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
    public String getEmail() {
        return email;
    }

    public String getGroup() {
        return group;
    }



    /*public String getId() {
        return id;
    } */

}
