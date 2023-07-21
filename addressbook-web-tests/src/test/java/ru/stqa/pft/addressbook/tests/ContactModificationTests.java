package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactModificationTests extends TestBase {

  @Test
  public void testContactModification() {
    app.getContactHelper().gotoHomePage();

    int before = app.getContactHelper().getContactCount();

    if (! app.getContactHelper().isThereContact()) {
      app.getContactHelper().createContact(new ContactData("Rom", "Lamz", "New-Studio",
              "Samara", "89277778781", "lamzinrn@gmail.com", "test"));
    };

    app.getContactHelper().selectContact(before - 1); // выбор по индексу, к примеру последний элемент
    app.getContactHelper().initContactModification(before - 1); // выбор по индексу, к примеру последний элемент edit
    app.getContactHelper().fillNewContactForm(new ContactData("Rom", "Lamz", "Modification-Studio", "Modification-city",
            "89277778781", "Modification@gmail.com", null), false);
    app.getContactHelper().submitContactModification();
    app.getContactHelper().gotoHomePage();

    int after = app.getContactHelper().getContactCount();
    Assert.assertEquals(after, before);

  }
}
