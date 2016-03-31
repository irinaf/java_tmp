package ru.stqa.pft.addressbook.model;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.File;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.stream.Collectors;

@Entity
@Table(name="addressbook")
public class ContactData {

    @Id
    @Column(name="id")
    private int id;

    @Column(name="firstname")
    private  String firstName;

    @Column(name="lastname")
    private  String lastName;

    @Column(name="middlename")
    private  String middleName;

    @Override
    public String toString() {
        return "ContactData{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    @Column(name="address")
    @Type(type="text")
    private  String address;

    @Column(name="home")
    @Type(type="text")
    private  String homePhone;

    @Column(name="mobile")
    @Type(type="text")
    private  String mobilePhone;

    @Column(name="work")
    @Type(type="text")
    private  String workPhone;

    @Transient
    private String phoneNumber;
    @Transient
    private String group;
    @Transient
    private String allPhones;
    @Transient
    private String allEmails;
    @Transient
    private  String email1;
    @Transient
    private  String email2;
    @Transient
    private  String email3;
    @Transient
    private String allDetails;

    @Column(name="photo")
    @Type(type="text")
    private String photo;

      public File getPhoto() {
        return new File(photo);
    }

    public ContactData withPhoto(File photo) {
       this.photo = photo.getPath();
        return this;
    }

   // private File photo;




    public String getAllPhones() {
        return allPhones;
    }
    public String getAllEmails() {
        return allEmails;
    }

    public ContactData withAllPhones(String allPhones) {
        this.allPhones = allPhones;
        return this;
    }

    public ContactData withId(int id) {
        this.id=id;
        return this;
    }

    public ContactData withAllEmails(String allEmails) {
        this.allEmails=allEmails;
        return this;
    }

    public ContactData withEmail1(String email1) {
        this.email1=email1;
        return this;
    }
    public ContactData withEmail2(String email2) {
        this.email2=email2;
        return this;
    }

    public ContactData withEmail3(String email3) {
        this.email3=email3;
        return this;
    }

    public ContactData withAddress(String address) {
        this.address=address;
        return this;
    }

    public ContactData withHomePhone(String homePhone){

        this.homePhone=homePhone;
        return this;
    }


    public ContactData withMobilePhone(String mobilePhone){

        this.mobilePhone=mobilePhone;
        return this;
    }

    public ContactData withFirstname(String firstName){

        this.firstName=firstName;
        return this;
    }

    public ContactData withMiddlename(String middleName){

        this.middleName=middleName;
        return this;
    }


    public ContactData withLastname(String lastName){

        this.lastName=lastName;
        return this;
    }

    public ContactData withAllDetails(String allDetails) {
        this.allDetails=allDetails;
        return this;
    }


    public String getMobilePhone() {
        return mobilePhone;
    }

    public String getHomePhone() {
        return homePhone;
    }
    public String getWorkPhone() {
        return workPhone;
    }

    public String getEmail1() {
        return email1;
    }
    public String getEmail2() {
        return email2;
    }
    public String getEmail3() {
        return email3;
    }

    public String getFio() {

       return Arrays.asList(getFirstName(),getMiddleName(),getLastName()).stream().filter((s) ->! s.equals("")).collect(Collectors.joining(" "));

    }

    public ContactData withWorkPhone(String workPhone){

        this.workPhone=workPhone;
        return this;
    }




  /*  public ContactData(int id, String firstName, String lastName, String address, String phoneNumber,

                       String email, String group) {
        this.id=id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.group = group;
    }


    public ContactData( String firstName, String lastName, String address, String phoneNumber,
                        String email, String group) {
        this.id=Integer.MAX_VALUE; // this.id=0; может быть любое значение
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.group = group;
    }   */


    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getMiddleName() {
        return middleName;
    }
    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }


    public String getGroup() {
        return group;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContactData that = (ContactData) o;

        if (id != that.id) return false;
        if (firstName != null ? !firstName.equals(that.firstName) : that.firstName != null) return false;
        return lastName != null ? lastName.equals(that.lastName) : that.lastName == null;

    }

    @Override
    public int hashCode() {
        int result = firstName != null ? firstName.hashCode() : 0;
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + id;
        return result;
    }

    public int    getId() {
        return id;
    }

    public void setId(int id) {
          this.id = id;
    }


}
