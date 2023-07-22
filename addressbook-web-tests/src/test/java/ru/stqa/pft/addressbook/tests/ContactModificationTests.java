package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.List;

public class ContactModificationTests extends TestBase {

  @Test
  public void testContactModification() {
    app.getContactHelper().gotoHomePage();



    if (! app.getContactHelper().isThereContact()) {
      app.getContactHelper().createContact(new ContactData("Rom", "Lamz", "New-Studio",
              "Samara", "89277778781", "lamzinrn@gmail.com", "test"));
    };
    List<ContactData> before = app.getContactHelper().getContactList(); // v2
    // int before = app.getContactHelper().getContactCount();  // использовать после проверки предусловия // v1


    app.getContactHelper().selectContact(before.size() - 1); // выбор по индексу, к примеру последний элемент
    app.getContactHelper().initContactModification(before.size() - 1); // выбор по индексу, к примеру последний элемент именно edit
    app.getContactHelper().fillNewContactForm(new ContactData("Rom", "Lamz", "Modification-Studio", "Modification-city",
            "89277778781", "Modification@gmail.com", null), false);
    app.getContactHelper().submitContactModification();
    app.getContactHelper().gotoHomePage();

    List<ContactData> after = app.getContactHelper().getContactList(); // v2
   // int after = app.getContactHelper().getContactCount(); // v1
   // Assert.assertEquals(after, before); // v1
    Assert.assertEquals(after.size(), before.size()); // v2

  }
}
