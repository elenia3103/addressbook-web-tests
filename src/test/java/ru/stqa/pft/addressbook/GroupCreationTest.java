package ru.stqa.pft.addressbook;


import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;


public class GroupCreationTest {
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
    public void testGroupCreation() throws Exception {
        initGroupCreation();
        fillGroupForm(new GroupData("test1", "testov1", "address1","mobile1","email1"));
        submitGroupCreation();
        goToHomePage();
    }

    private void submitGroupCreation() {
        wd.findElement(By.xpath("//input[21]")).click();
    }
    private void goToHomePage() {
        wd.findElement(By.linkText("home page")).click();
    }

    private void fillGroupForm(GroupData groupData) {
        wd.findElement(By.name("firstname")).click();
        wd.findElement(By.name("firstname")).sendKeys(groupData.getFirstname());
        wd.findElement(By.name("lastname")).click();
        wd.findElement(By.name("lastname")).sendKeys(groupData.getLastname());
        wd.findElement(By.name("address")).click();
        wd.findElement(By.name("address")).sendKeys(groupData.getAddress());
        wd.findElement(By.name("email")).click();
        wd.findElement(By.name("email")).sendKeys(groupData.getEmail());
        wd.findElement(By.name("mobile")).click();
        wd.findElement(By.name("mobile")).sendKeys(groupData.getMobile());
    }

    private void initGroupCreation() {
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
