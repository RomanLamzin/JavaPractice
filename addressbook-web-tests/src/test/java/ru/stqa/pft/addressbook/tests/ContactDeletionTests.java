package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.List;

public class ContactDeletionTests extends TestBase {
  @BeforeMethod
  public void ensurePreconditions() {
    app.contact().homePage();
    if (app.contact().list().size() == 0) {
      app.contact().create(new ContactData("Rom", null, null,
              null, null, null, null));
    }
  }

  @Test
  public void testContactDelletion() throws Exception {


    List<ContactData> before = app.contact().list(); // v2

    int index = before.size() - 1;
    app.contact().delete(index);

    List<ContactData> after = app.contact().list(); // v2


    Assert.assertEquals(after.size(), before.size() - 1); // при работе со списками используем метод size // v2


    before.remove(index); // удаляем из списка один элемент

    Assert.assertEquals(before, after);


  }


}
