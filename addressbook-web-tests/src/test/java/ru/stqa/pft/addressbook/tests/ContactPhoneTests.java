package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactPhoneTests extends TestBase {

  @Test
  public void testContactPhones() {
    app.goTo().gotoHomePage();
    ContactData contact = app.contact().all().iterator().next();
    ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);

    assertThat(contact.getAllPhones(), equalTo(mergePhones(contactInfoFromEditForm))); // сравнение AllPhones
    assertThat(contact.getHomeAddress(), equalTo(contactInfoFromEditForm.getHomeAddress().trim())); // сравнение адресов
    assertThat(contact.getAllEmails(), equalTo(mergeAllEmails(contactInfoFromEditForm))); // сравнение AllEmails

  }

  private String mergePhones(ContactData contact) {

    return Arrays.asList(contact.homePhone(), contact.mobile(), contact.workPhone())
            .stream().filter((s)-> !s.equals(""))
            .map(ContactPhoneTests::cleaned)
            .collect(Collectors.joining("\n"));
  }


  private String mergeAllEmails(ContactData contact) {

    return Arrays.asList(contact.email(), contact.email2(), contact.email3())
            .stream().filter((s)-> !s.equals(""))
            .map(ContactPhoneTests::cleaned)
            .collect(Collectors.joining("\n"));
  }

  public static String cleaned(String phone) {
    return phone.replaceAll("\\s", "").replaceAll("[-()]", "");
  }
}
