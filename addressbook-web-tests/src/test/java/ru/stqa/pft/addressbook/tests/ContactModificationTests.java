package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactModificationTests extends TestBase {

  @Test
  public void testContactModification() {
    app.getContactHelper().gotoHomePage();
    app.getContactHelper().selectContact();
    app.getContactHelper().initContactModification();
    app.getContactHelper().fillNewContactForm(new ContactData("Roman", "Lamzin", "Modification-Studio", "Modification-city",
            "89277778781", "Modification@gmail.com", null), false);
    app.getContactHelper().submitContactModification();
    app.getContactHelper().gotoHomePage();

  }
}
