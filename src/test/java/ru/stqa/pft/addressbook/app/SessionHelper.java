package ru.stqa.pft.addressbook.app;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SessionHelper extends BaseHelper{
    public SessionHelper(WebDriver wd) {
        super(wd);
    }
    public void login(String user, String password) {
        wd.get("http://localhost/addressbook/");
        click(By.name("user"));
        wd.findElement(By.name("user")).sendKeys(user);
        click(By.name("pass"));
        wd.findElement(By.name("pass")).sendKeys(password);
        click(By.cssSelector("input[type=\"submit\"]"));
    }
}
