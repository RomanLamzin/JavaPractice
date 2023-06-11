package ru.stqa.pft.addressbook;

import org.testng.annotations.Test;

public class ContactDeletionTests extends TestBase {


  @Test
  public void testContactDelletion() throws Exception {

    gotoHomePage();
    selectContact();
    deleteSelectedContact();
    confirmDeletion();
    gotoHomePage();
    logOut();
  }


}
