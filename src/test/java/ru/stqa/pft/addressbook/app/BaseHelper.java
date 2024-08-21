package ru.stqa.pft.addressbook.app;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.Browser;
import ru.stqa.pft.addressbook.model.GroupData;

public class BaseHelper {
    protected WebDriver wd;
    public BaseHelper(WebDriver wd) {
        this.wd=wd;
    }
    protected void click(By locator) {
        wd.findElement(locator).click();
    }
    public boolean isAlertPresent() {
        try {
            wd.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }
}

