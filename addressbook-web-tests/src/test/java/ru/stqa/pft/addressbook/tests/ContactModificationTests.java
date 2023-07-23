package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

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

    System.out.println("this is before   " + before);
    app.getContactHelper().selectContact(before.size() - 1); // выбор по индексу, к примеру последний элемент
    app.getContactHelper().initContactModification(before.size() - 1); // выбор по индексу, к примеру последний элемент именно edit


    ContactData contact = new ContactData(before.get(before.size() - 1).getId(),"Rom", "ZZZZZZZ", null,
            null, null, null, null);

    app.getContactHelper().fillNewContactForm(contact,false);
    app.getContactHelper().submitContactModification();
    app.getContactHelper().gotoHomePage();

    List<ContactData> after = app.getContactHelper().getContactList(); // v2

    Assert.assertEquals(after.size(), before.size()); // v2

    before.remove(before.size() - 1);

    before.add(contact);

    Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));


  }
}
