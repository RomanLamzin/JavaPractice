package ru.stqa.pft.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class ContactDeletionTests extends TestBase {
  @BeforeMethod
  public void ensurePreconditions() {
    app.contact().homePage();
    if (app.contact().list().size() == 0) {
      app.contact().create(new ContactData().withName("Rom"));
    }
  }

  @Test
  public void testContactDelletion() throws Exception {

    Contacts before = app.contact().all(); // v2
    ContactData deletedContact = before.iterator().next();
    app.contact().delete(deletedContact);
    Contacts after = app.contact().all(); // v2
    assertThat(after.size(), equalTo(before.size() - 1)); // при работе со списками используем метод size // v2
    assertThat(after, equalTo(before.without(deletedContact)));

  }


}
