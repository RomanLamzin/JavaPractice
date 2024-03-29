package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertTrue;


public class ContactHelper extends HelperBase {
  GroupHelper groupHelper = new GroupHelper(wd);

  private boolean acceptNextAlert = true;

  public ContactHelper(WebDriver wd) {
    super(wd);
  }


  public void homePage() {
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

  public void selectContact(int index) {
    wd.findElements(By.name("selected[]")).get(index).click();
  }

  public void selectContactById(int id) {
    wd.findElement(By.cssSelector("input[value='" + id + "']")).click();
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

  public void initContactModification(int index) {
    wd.findElements(By.xpath("//img[@alt='Edit']")).get(index).click();
//    click(By.xpath("//img[@alt='Edit']"));
  }

  public void submitContactModification() {
    click(By.name("update"));
  }


  public void create(ContactData group) {
    openAddNewContactForm();
    if (!isElementPresent(By.xpath("//*[@id='content']/form/select[5]/option[2]"))) {
      System.out.println(" No group in that place");
      click(By.linkText("groups"));
      groupHelper.create(new GroupData().withName("test"));
    }
    ;
    openAddNewContactForm();
    fillNewContactForm(group, true);
    submitFormContact();
    contactCache = null;
    homePage();
  }

////////////////

  private void editContactById(ContactData contactData) {
    click(By.xpath("//table[@id='maintable']/tbody/tr/td/a[@href='edit.php?id=" + contactData.getId() + "']"));

  }


  public void modify(ContactData contactData) {
    editContactById(contactData);//передается номер строки, которую редактируем
    fillNewContactForm(contactData, false);
    submitContactModification();
    contactCache = null;
    homePage();
  }


  public void delete(ContactData contact) {
    selectContactById(contact.getId()); // выбор по индексу, к примеру последний элемент
    deleteSelectedContact();
    confirmDeletionContact();
    contactCache = null;
    homePage();
  }


  public boolean isThereContact() {
    return isElementPresent(By.name("selected[]"));
  }

  public int count() {

    return wd.findElements(By.xpath("//tr[contains(@name, 'entry')]")).size(); // метод wb который возввращает список у которого получаем размер  //tr[contains(@name, 'entry')]
  }

  public List<ContactData> list() {

    List<ContactData> contacts = new ArrayList<ContactData>();          // создаём список который будем заполнять(новый). Указываем конкретный класс который реализует ArrayList
    List<WebElement> elements = wd.findElements(By.xpath("//table[@id='maintable']/tbody/tr[@name='entry']"));

    for (WebElement element : elements) {
      String name = element.findElement(By.xpath(".//td[3]")).getText(); // получаем текст при переборе  name
      String lastname = element.findElement(By.xpath(".//td[2]")).getText(); // получаем текст при переборе lastname
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value")); // достаём значение id и преобразовываем строку в число
      contacts.add(new ContactData().withId(id).withName(name).withLastname(lastname));// добавляем созданный объект в список, т.е. добавляем новое значение в массив contacts
    }

    return contacts; // возвращаем новый список (массив) который создан в начале тела данного  метода
  }


  private Contacts contactCache = null;

  public Contacts all() {

    if (contactCache != null) {
      return new Contacts(contactCache);
    }

    contactCache = new Contacts();          // создаём список который будем заполнять(новый). Указываем конкретный класс который реализует ArrayList
    List<WebElement> elements = wd.findElements(By.xpath("//table[@id='maintable']/tbody/tr[@name='entry']"));

    for (WebElement element : elements) {
      String name = element.findElement(By.xpath(".//td[3]")).getText(); // получаем текст при переборе  name
      String lastname = element.findElement(By.xpath(".//td[2]")).getText(); // получаем текст при переборе lastname
      String homeAddress = element.findElement(By.xpath(".//td[4]")).getText();
      String allEmails = element.findElement(By.xpath(".//td[5]")).getText();
      String allPhones = element.findElement(By.xpath(".//td[6]")).getText(); // все записи телефонов
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value")); // достаём значение id и преобразовываем строку в число

      contactCache.add(new ContactData().withId(id).withName(name).withLastname(lastname)
              .withHomeAddress(homeAddress)
              .withAllEmails(allEmails) // берем все Emails
              .withAllPhones(allPhones)); // берем все телефоны
    }

    return new Contacts(contactCache); // возвращаем новый список (массив) который создан в начале тела данного  метода
  }


  public ContactData infoFromEditForm(ContactData contact) { // забираем данные со страницы редактирования контакта

    initContactModificationById(contact.getId());
    String firstname = wd.findElement(By.name("firstname")).getAttribute("value");
    String lastname = wd.findElement(By.name("lastname")).getAttribute("value");
    String home = wd.findElement(By.name("home")).getAttribute("value");
    String mobile = wd.findElement(By.name("mobile")).getAttribute("value");
    String work = wd.findElement(By.name("work")).getAttribute("value");
    String address = wd.findElement(By.name("address")).getAttribute("value");
    String email = wd.findElement(By.name("email")).getAttribute("value");
    String email2 = wd.findElement(By.name("email2")).getAttribute("value");
    String email3 = wd.findElement(By.name("email3")).getAttribute("value");

    wd.navigate().back();
    return new ContactData().withId(contact.getId()).withName(firstname)
            .withLastname(lastname).withMobile(mobile).withHomePhone(home).withWorkPhone(work)
            .withHomeAddress(address)
            .withEmail(email)
            .withEmail2(email2)
            .withEmail3(email3)
            ;

  }

  private void initContactModificationById(int id) {
    wd.findElement(By.xpath(String.format("//input[@value='%s']/../../td[8]/a", id))).click(); // клик по edit на главной
  }
}
