package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.Browser;

import java.time.Duration;

public class ApplicationManager {

  private final Browser browser;
  public WebDriver wd;
  private ContactHelper contactHelper;
  private SessionHelper sessionHelper;
  private NavigationHelper navigationHelper;
  private GroupHelper groupHelper;
  private JavascriptExecutor js;

  public ApplicationManager(Browser browser) {

    this.browser = browser;
  }

  public void init() {

    //String browser = String.valueOf(Browser.FIREFOX);

    if (browser.equals(Browser.CHROME)) {
      System.setProperty("webdriver.chrome.driver", "libs/chromedriver.exe");
      wd = new ChromeDriver();

    } else if (browser.equals(Browser.FIREFOX)){
      System.out.println("FIREFOX FIREFOX FIREFOX FIREFOX FIREFOX FIREFOX");
      System.setProperty("webdriver.gecko.driver", "libs/geckodriver.exe");
      wd = new FirefoxDriver();
    }

    //System.setProperty("webdriver.chrome.driver", "libs/chromedriver.exe");

    // wd = new ChromeDriver();

    wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    js = (JavascriptExecutor) wd;
    wd.get("http://localhost/addressbook/group.php");
    groupHelper = new GroupHelper(wd);
    navigationHelper = new NavigationHelper(wd);
    sessionHelper = new SessionHelper(wd);
    contactHelper = new ContactHelper(wd);

    sessionHelper.login("admin", "secret");
  }


  public void stop() {
    wd.quit();
  }

  public boolean isElementPresent(By by) {
    try {
      wd.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }


  public GroupHelper getGroupHelper() {
    return groupHelper;
  }

  public NavigationHelper getNavigationHelper() {
    return navigationHelper;
  }

  public ContactHelper getContactHelper() {
    return contactHelper;
  }
}
