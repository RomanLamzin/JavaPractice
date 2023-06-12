package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

public class ContactDeletionTests extends TestBase {


  @Test
  public void testContactDelletion() throws Exception {

    app.gotoHomePage();
    app.selectContact();
    app.deleteSelectedContact();
    app.confirmDeletion();
    app.gotoHomePage();
    app.logOut();
  }


}
