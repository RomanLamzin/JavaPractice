package ru.stqa.pft.addressbook;

import org.testng.annotations.Test;

public class AddNewContactTest extends TestBase{

  @Test
  public void testAddNewContact() throws Exception {
    openAddNewContactForm();
    fillNewContactForm(new ContactData("Roman", "Lamzin", "New-Studio", "Samara", "89277778781", "lamzinrn@gmail.com"));
    submitForm();
    gotoHomePage();
    logOut();
  }


}
