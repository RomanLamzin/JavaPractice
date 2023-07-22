package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.List;

public class AddNewContactTest extends TestBase {

  @Test
  public void testAddNewContact() throws Exception {
    app.getNavigationHelper().gotoHomePage();
    List<ContactData> before = app.getContactHelper().getContactList(); // список эл до создания контакта // v2
    //int before = app.getContactHelper().getContactCount(); // v1

    app.getContactHelper().createContact(new ContactData("Roman", "Lamzin", "New-Studio",
            "Samara", "89277778781", "lamzinrn@gmail.com", "test"));

    app.getNavigationHelper().gotoHomePage();

    List<ContactData> after = app.getContactHelper().getContactList(); // список эл после создания контакта // v2
    //int after = app.getContactHelper().getContactCount(); // v1
    // Assert.assertEquals(after, before + 1); // v1
    Assert.assertEquals(after.size(), before.size() + 1); // v2 -- сравниваем размер списка


  }


}
