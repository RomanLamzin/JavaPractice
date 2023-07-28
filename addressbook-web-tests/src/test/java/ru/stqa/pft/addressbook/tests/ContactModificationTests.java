package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactModificationTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.contact().homePage();
    if (app.contact().list().size() == 0) {
      app.contact().create(new ContactData().withName("Rom"));
    }
  }


  @Test
  public void testContactModification() {

    Contacts before = app.contact().all(); // v2
    ContactData modifiedContact = before.iterator().next();

    ContactData contact = new ContactData().withId(modifiedContact.getId()).withName("Roman111").withLastname("Lamzin").withCompanyName("New-Studio")
            .withCityContact("Samara").withMobile("89277778781").withEmail("lamzinrn@gmail.com").withGroup("test");

    app.contact().modify(contact);

    Contacts after = app.contact().all(); // v2
    assertThat(after.size(), equalTo(before.size())); // v2
    assertThat(after, equalTo(before.without(modifiedContact).withAdded(contact)));

  }
}
