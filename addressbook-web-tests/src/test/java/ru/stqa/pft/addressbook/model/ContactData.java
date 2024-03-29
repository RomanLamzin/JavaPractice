package ru.stqa.pft.addressbook.model;

import java.util.Objects;

public final class ContactData {
  private int id = Integer.MAX_VALUE;


  private String name;
  private String lastname;
  private String companyName;
  private String cityContact;
  private String homeAddress;
  private String mobile;
  private String homePhone;
  private String workPhone;
  private String allPhones;
  private String allEmails;
  private String email;
  private String email2;
  private String email3;
  private String Group;

  public String getHomeAddress() {
    return homeAddress;
  }

  public ContactData withHomeAddress(String homeAddress) {
    this.homeAddress = homeAddress;
    return this;
  }

  public String getAllPhones() {
    return allPhones;
  }

  public ContactData withAllPhones(String allPhones) {
    this.allPhones = allPhones;
    return this;
  }


  public String getAllEmails() {
    return allEmails;
  }

  public ContactData withAllEmails(String allEmails) {
    this.allEmails = allEmails;
    return this;
  }


  public ContactData withId(int id) {
    this.id = id;
    return this;
  }

  public ContactData withName(String name) {
    this.name = name;
    return this;
  }

  public ContactData withLastname(String lastname) {
    this.lastname = lastname;
    return this;
  }

  public ContactData withCompanyName(String companyName) {
    this.companyName = companyName;
    return this;
  }

  public ContactData withCityContact(String cityContact) {
    this.cityContact = cityContact;
    return this;
  }

  public ContactData withMobile(String mobile) {
    this.mobile = mobile;
    return this;
  }

  public ContactData withWorkPhone(String workPhone) {
    this.workPhone = workPhone;
    return this;
  }


  public ContactData withHomePhone(String homePhone) {
    this.homePhone = homePhone;
    return this;
  }


  public ContactData withEmail(String email) {
    this.email = email;
    return this;
  }

  public ContactData withEmail2(String email2) {
    this.email2 = email2;
    return this;
  }


  public ContactData withEmail3(String email3) {
    this.email3 = email3;
    return this;
  }


  public ContactData withGroup(String group) {
    Group = group;
    return this;
  }

  public int getId() {
    return id;
  }

  public String name() {
    return name;
  }

  public String lastname() {
    return lastname;
  }

  public String companyName() {
    return companyName;
  }

  public String cityContact() {
    return cityContact;
  }

  public String mobile() {
    return mobile;
  }

  public String homePhone() {
    return homePhone;
  }

  public String workPhone() {
    return workPhone;
  }

  public String email() {
    return email;
  }

  public String email2() {
    return email2;
  }


  public String email3() {
    return email3;
  }


  public String Group() {
    return Group;
  }

  @Override
  public String toString() {
    return "ContactData{" +
            "id='" + id + '\'' +
            ", name='" + name + '\'' +
            ", lastname='" + lastname + '\'' +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ContactData that = (ContactData) o;
    return id == that.id && Objects.equals(name, that.name) && Objects.equals(lastname, that.lastname);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, lastname);
  }


}