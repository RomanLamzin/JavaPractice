package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

public class AddNewContactTest extends TestBase {

  @Test
  public void testAddNewContact() throws Exception {
    app.goTo().gotoHomePage();
    Set<ContactData> before = app.contact().all(); // список эл до создания контакта // v2

    ContactData contact = new ContactData().withName("Roman111").withLastname("Lamzin").withCompanyName("New-Studio")
            .withCityContact("Samara").withMobile("89277778781").withEmail("lamzinrn@gmail.com").withGroup("test");

    app.contact().create(contact);
    app.goTo().gotoHomePage();

    Set<ContactData> after = app.contact().all(); // список эл после создания контакта // v2

    Assert.assertEquals(after.size(), before.size() + 1); // v2 -- сравниваем размер списка

    contact.withId(after.stream().mapToInt((g)->g.getId()).max().getAsInt());
    before.add(contact);


    Assert.assertEquals(before, after);

  }


}
