package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class AddNewContactTest extends TestBase {

  @Test
  public void testAddNewContact() throws Exception {
    app.getNavigationHelper().gotoHomePage();
    List<ContactData> before = app.getContactHelper().getContactList(); // список эл до создания контакта // v2

    ContactData contact = new ContactData("Roman111", "Lamzin", "New-Studio",
            "Samara", "89277778781", "lamzinrn@gmail.com", "test");

    app.getContactHelper().createContact(contact);
    app.getNavigationHelper().gotoHomePage();

    List<ContactData> after = app.getContactHelper().getContactList(); // список эл после создания контакта // v2

    Assert.assertEquals(after.size(), before.size() + 1); // v2 -- сравниваем размер списка

    before.add(contact);

    Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);

  }


}
