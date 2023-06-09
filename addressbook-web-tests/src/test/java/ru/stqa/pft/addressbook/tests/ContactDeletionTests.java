package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactDeletionTests extends TestBase {


  @Test
  public void testContactDelletion() throws Exception {

    app.getContactHelper().gotoHomePage();

    if (!app.getContactHelper().isThereContact()) {
      app.getContactHelper().createContact(new ContactData("Roman", "Lamzin", "New-Studio",
              "Samara", "89277778781", "lamzinrn@gmail.com", "test"));
    };

    app.getContactHelper().selectContact();
    app.getContactHelper().deleteSelectedContact();
    app.getContactHelper().confirmDeletionContact();
    app.getContactHelper().gotoHomePage();

  }


}
