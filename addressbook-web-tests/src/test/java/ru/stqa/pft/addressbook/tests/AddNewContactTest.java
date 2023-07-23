package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.HashSet;
import java.util.List;

public class AddNewContactTest extends TestBase {

  @Test
  public void testAddNewContact() throws Exception {
    app.getNavigationHelper().gotoHomePage();
    List<ContactData> before = app.getContactHelper().getContactList(); // список эл до создания контакта // v2

    ContactData contact = new ContactData("Roman", "Lamzin", "New-Studio",
            "Samara", "89277778781", "lamzinrn@gmail.com", "test");

    app.getContactHelper().createContact(contact);
    app.getNavigationHelper().gotoHomePage();

    List<ContactData> after = app.getContactHelper().getContactList(); // список эл после создания контакта // v2

    Assert.assertEquals(after.size(), before.size() + 1); // v2 -- сравниваем размер списка



    // find max id bellow
    int max =0;
    for (ContactData c : after){
      if (c.getId() > max) {
        max = c.getId();
      };
    };

    // set to new contact maxId bellow
    contact.setId(max);
    before.add(contact);
    Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));

  }


}
