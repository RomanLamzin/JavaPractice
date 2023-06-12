package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.stqa.pft.addressbook.model.ContactData;

import static org.testng.Assert.assertTrue;

public class ContactHelper extends HelperBase {

  private boolean acceptNextAlert = true;

  public ContactHelper(WebDriver wd) {
    super(wd);
  }


  public void gotoHomePage() {
    click(By.linkText("home"));
  }

  public void submitFormContact() {
    click(By.xpath("//div[@id='content']/form/input[21]"));
  }

  public void fillNewContactForm(ContactData contactData) {
    type(By.name("firstname"), contactData.name());
    type(By.name("lastname"), contactData.lastname());
    type(By.name("company"), contactData.companyName());
    type(By.name("address"), contactData.cityContact());
    type(By.name("mobile"), contactData.mobile());
    type(By.name("email"), contactData.email());

  }

  public void openAddNewContactForm() {
    click(By.linkText("add new"));
  }

  public void confirmDeletionContact() {
    assertTrue(closeAlertAndGetItsText().matches("^Delete 1 addresses[\\s\\S]$"));
  }

  public void deleteSelectedContact() {
    click(By.xpath("//input[@value='Delete']"));
  }

  public void selectContact() {
    click(By.name("selected[]"));
  }

  public String closeAlertAndGetItsText() {
    try {
      Alert alert = wd.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }


}