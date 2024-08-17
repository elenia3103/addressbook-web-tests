package ru.stqa.pft.addressbook;


import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;


public class ContactCreationTest {
    private WebDriver wd;

    @BeforeMethod(alwaysRun = true)
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "C:\\Windows\\System32\\chromedriver.exe");
        wd = new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        login("admin", "secret");

    }

    private void login(String user, String password) {
        wd.get("http://localhost/addressbook/");
        wd.findElement(By.name("user")).click();
        wd.findElement(By.name("user")).sendKeys(user);
        wd.findElement(By.name("pass")).click();
        wd.findElement(By.name("pass")).sendKeys(password);
        wd.findElement(By.cssSelector("input[type=\"submit\"]")).click();
    }

    @Test
    public void testContactCreation() throws Exception {
        initContactCreation();
        fillContactForm(new ContactData("test1", "testov1", "address1","mobile1","email1"));
        submitContactCreation();
        goToHomePage();
    }

    private void submitContactCreation() {
        wd.findElement(By.xpath("//input[21]")).click();
    }
    private void goToHomePage() {
        wd.findElement(By.linkText("home page")).click();
    }

    private void fillContactForm(ContactData contactData) {
        wd.findElement(By.name("firstname")).click();
        wd.findElement(By.name("firstname")).sendKeys(contactData.getFirstname());
        wd.findElement(By.name("lastname")).click();
        wd.findElement(By.name("lastname")).sendKeys(contactData.getLastname());
        wd.findElement(By.name("address")).click();
        wd.findElement(By.name("address")).sendKeys(contactData.getAddress());
        wd.findElement(By.name("email")).click();
        wd.findElement(By.name("email")).sendKeys(contactData.getEmail());
        wd.findElement(By.name("mobile")).click();
        wd.findElement(By.name("mobile")).sendKeys(contactData.getMobile());
    }

    private void initContactCreation() {
        wd.findElement(By.linkText("add new")).click();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() throws Exception {
        wd.quit();
    }

    private boolean isElementPresent(By by) {
        try {
            wd.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private boolean isAlertPresent() {
        try {
            wd.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }
}
