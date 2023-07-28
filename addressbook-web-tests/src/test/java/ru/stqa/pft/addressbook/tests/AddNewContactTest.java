package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class AddNewContactTest extends TestBase {

  @Test
  public void testAddNewContact() throws Exception {
    app.goTo().gotoHomePage();
    Contacts before = app.contact().all(); // список эл до создания контакта // v2

    ContactData contact = new ContactData().withName("Roman111").withLastname("Lamzin").withCompanyName("New-Studio")
            .withCityContact("Samara").withMobile("89277778781").withEmail("lamzinrn@gmail.com").withGroup("test");

    app.contact().create(contact);
    app.goTo().gotoHomePage();

    Contacts after = app.contact().all(); // список эл после создания контакта // v2

    assertThat(after.size(), equalTo(before.size() + 1)); // v2 -- сравниваем размер списка

//    contact.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt());


    assertThat(after, equalTo(
            before.withAdded(contact.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));

  }


}
