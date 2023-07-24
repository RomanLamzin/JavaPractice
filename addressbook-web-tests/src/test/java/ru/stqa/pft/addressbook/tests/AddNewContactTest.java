package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class AddNewContactTest extends TestBase {

  @Test(enabled = false)
  public void testAddNewContact() throws Exception {
    app.goTo().gotoHomePage();
    List<ContactData> before = app.contact().list(); // список эл до создания контакта // v2

    ContactData contact = new ContactData("Roman111", "Lamzin", "New-Studio",
            "Samara", "89277778781", "lamzinrn@gmail.com", "test");

    app.contact().create(contact);
    app.goTo().gotoHomePage();

    List<ContactData> after = app.contact().list(); // список эл после создания контакта // v2

    Assert.assertEquals(after.size(), before.size() + 1); // v2 -- сравниваем размер списка

    before.add(contact);

    Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);

  }


}
