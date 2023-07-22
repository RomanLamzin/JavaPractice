package ru.stqa.pft.addressbook.model;

import java.util.Objects;

public final class ContactData {

  private final String id;
  private final String name;

  private final String lastname;
  private final String companyName;
  private final String cityContact;
  private final String mobile;
  private final String email;



  private final String Group;

  public String getId() {
    return id;
  }

  public ContactData( String name, String lastname, String companyName, String cityContact, String mobile, String email, String Group) {
    this.id = null;
    this.name = name;
    this.lastname = lastname;
    this.companyName = companyName;
    this.cityContact = cityContact;
    this.mobile = mobile;
    this.email = email;
    this.Group = Group;
  }


  public ContactData(String id, String name, String lastname, String companyName, String cityContact, String mobile, String email, String Group) {
    this.id = id;
    this.name = name;
    this.lastname = lastname;
    this.companyName = companyName;
    this.cityContact = cityContact;
    this.mobile = mobile;
    this.email = email;
    this.Group = Group;
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
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ContactData that = (ContactData) o;
    return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(lastname, that.lastname);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, lastname);
  }

  @Override
  public String toString() {
    return "ContactData{" +
            "id='" + id + '\'' +
            ", name='" + name + '\'' +
            ", lastname='" + lastname + '\'' +
            '}';
  }


}