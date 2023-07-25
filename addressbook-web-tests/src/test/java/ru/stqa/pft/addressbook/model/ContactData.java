package ru.stqa.pft.addressbook.model;

import java.util.Objects;

public final class ContactData {
  private int id = Integer.MAX_VALUE;
  private String name;
  private String lastname;
  private String companyName;
  private String cityContact;
  private String mobile;
  private String email;
  private String Group;


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

  public ContactData withEmail(String email) {
    this.email = email;
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

  public String email() {
    return email;
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
    return Objects.equals(name, that.name) && Objects.equals(lastname, that.lastname);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, lastname);
  }


}