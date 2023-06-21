package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class AddNewContactTest extends TestBase {

  @Test
  public void testAddNewContact() throws Exception {
    app.getContactHelper().createContact(new ContactData("Roman", "Lamzin", "New-Studio",
            "Samara", "89277778781", "lamzinrn@gmail.com", "test"), true);


  }


}
