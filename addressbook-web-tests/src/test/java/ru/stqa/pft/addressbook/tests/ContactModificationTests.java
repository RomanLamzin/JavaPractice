package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

public class ContactModificationTests extends TestBase {

  @Test
  public void testContactModification() {
    app.getContactHelper().gotoHomePage();

//    if (! app.getGroupHelper().isThereGroup()) {
//      app.getGroupHelper().createGroup(new GroupData("test", null, null));
//    };

    if (! app.getContactHelper().isThereContact()) {
      app.getContactHelper().createContact(new ContactData("Roman", "Lamzin", "New-Studio",
              "Samara", "89277778781", "lamzinrn@gmail.com", "test"), true);
    };


    app.getContactHelper().selectContact();
    app.getContactHelper().initContactModification();
    app.getContactHelper().fillNewContactForm(new ContactData("Roman", "Lamzin", "Modification-Studio", "Modification-city",
            "89277778781", "Modification@gmail.com", null), false);
    app.getContactHelper().submitContactModification();
    app.getContactHelper().gotoHomePage();

  }
}
