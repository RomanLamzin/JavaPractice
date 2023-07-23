package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class ContactModificationTests extends TestBase {

  @Test
  public void testContactModification() {
    app.getContactHelper().gotoHomePage();


    if (!app.getContactHelper().isThereContact()) {
      app.getContactHelper().createContact(new ContactData("Rom", null, null,
              null, null, null, null));
    }
    ;
    List<ContactData> before = app.getContactHelper().getContactList(); // v2

    app.getContactHelper().selectContact(before.size() - 1); // выбор по индексу, к примеру последний элемент
    app.getContactHelper().initContactModification(before.size() - 1); // выбор по индексу, к примеру последний элемент именно edit


    ContactData contact = new ContactData(before.get(before.size() - 1).getId(), "Rom", "ZZZZZZZ", null,
            null, null, null, null);

    app.getContactHelper().fillNewContactForm(contact, false);
    app.getContactHelper().submitContactModification();
    app.getContactHelper().gotoHomePage();

    List<ContactData> after = app.getContactHelper().getContactList(); // v2

    Assert.assertEquals(after.size(), before.size()); // v2

    before.remove(before.size() - 1);

    before.add(contact);
    Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);


  }
}
