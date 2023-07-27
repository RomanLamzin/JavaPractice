package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Set;

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

    Set<ContactData> before = app.contact().all(); // v2
    ContactData deletedContact = before.iterator().next();

    app.contact().delete(deletedContact);

    Set<ContactData> after = app.contact().all(); // v2

    Assert.assertEquals(after.size(), before.size() - 1); // при работе со списками используем метод size // v2


    before.remove(deletedContact); // удаляем из списка один элемент

    Assert.assertEquals(before, after);


  }


}
