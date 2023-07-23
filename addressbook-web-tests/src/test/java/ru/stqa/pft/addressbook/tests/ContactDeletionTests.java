package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.List;

public class ContactDeletionTests extends TestBase {


  @Test(enabled = false)
  public void testContactDelletion() throws Exception {

    app.getContactHelper().gotoHomePage();

    if (!app.getContactHelper().isThereContact()) {
      app.getContactHelper().createContact(new ContactData("Roman", "Lamzin", "New-Studio",
              "Samara", "89277778781", "lamzinrn@gmail.com", "test"));
    }
    ;
    List<ContactData> before = app.getContactHelper().getContactList(); // v2
    //   int before = app.getContactHelper().getContactCount(); // использовать после проверки предусловия // v1

    app.getContactHelper().selectContact(before.size() - 1); // выбор по индексу, к примеру последний элемент
    app.getContactHelper().deleteSelectedContact();
    app.getContactHelper().confirmDeletionContact();
    app.getContactHelper().gotoHomePage();

    List<ContactData> after = app.getContactHelper().getContactList(); // v2
    // int after = app.getContactHelper().getContactCount(); // v1
    // Assert.assertEquals(after, before - 1); // v1

    Assert.assertEquals(after.size(), before.size() - 1); // при работе со списками используем метод size // v2


    before.remove(before.size() - 1); // удаляем из списка один элемент

    Assert.assertEquals(before, after);


  }


}
