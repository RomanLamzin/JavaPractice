package ru.stqa.pft.sandbox;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CheckFirefox {




   public void mainsTo() {

      System.setProperty("webdriver.gecko.driver", "libs/geckodriver.exe");

      WebDriver wd ;
      wd = new FirefoxDriver();

      wd.get("http://localhost/addressbook/group.php");

   }
}
