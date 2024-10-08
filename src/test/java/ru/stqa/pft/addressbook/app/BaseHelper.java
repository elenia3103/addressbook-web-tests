package ru.stqa.pft.addressbook.app;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
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
    protected void type(String text, By locator) {
        click(locator);
        if (text!=null){
            String existingText = wd.findElement(locator).getAttribute("value");
            if (!text.equals(existingText)){
                wd.findElement(locator).clear();
                wd.findElement(locator).sendKeys(text);
            }

        }
    }
    public boolean isAlertPresent() {
        try {
            wd.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }


    protected boolean isElementPresent(By locator) {
        try {
            wd.findElement(locator);
            return true;
        } catch(NoSuchElementException exception){
            return false;
        }
    }
}

