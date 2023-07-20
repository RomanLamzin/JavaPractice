package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

import static org.testng.Assert.assertTrue;


public class ContactHelper extends HelperBase {
  GroupHelper groupHelper = new GroupHelper(wd);

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

  public void fillNewContactForm(ContactData contactData, boolean creation) {
    type(By.name("firstname"), contactData.name());
    type(By.name("lastname"), contactData.lastname());
    type(By.name("company"), contactData.companyName());
    type(By.name("address"), contactData.cityContact());
    type(By.name("mobile"), contactData.mobile());
    type(By.name("email"), contactData.email());

    if (creation) {
      try {
        new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.Group());
        System.out.println("We  use  Group with name ---- " + contactData.Group());
      } catch (Exception e) {
        wd.findElement(By.xpath("//*[@id='content']/form/select[5]/option[2]")).click();
        System.out.println("There is no Group with name ---- " + contactData.Group() + ", we selected first in list");
      }

    } else {
      Assert.assertFalse(isElementPresent((By.name("new_group"))));
    }
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

  public void initContactModification() {
    click(By.xpath("//img[@alt='Edit']"));
  }

  public void submitContactModification() {
    click(By.name("update"));
  }


  public void createContact(ContactData group) {
    openAddNewContactForm();
    if (!isElementPresent(By.xpath("//*[@id='content']/form/select[5]/option[2]"))) {
      System.out.println(" No group in that place");
      click(By.linkText("groups"));
      groupHelper.createGroup(new GroupData("test", null, null));
    }
    ;
    openAddNewContactForm();
    fillNewContactForm(group, true);
    submitFormContact();
    gotoHomePage();
  }

  public boolean isThereContact() {
    return isElementPresent(By.name("selected[]"));
  }

  public int getContactCount() {

    return wd.findElements(By.xpath("//tr[contains(@name, 'entry')]")).size(); // метод wb который возввращает список у которого получаем размер  //tr[contains(@name, 'entry')]
  }
}
