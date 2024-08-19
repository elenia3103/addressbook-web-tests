package ru.stqa.pft.addressbook.app;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.stqa.pft.addressbook.model.GroupData;

public class BaseHelper {
    WebDriver wd;

    public BaseHelper(WebDriver wd) {
        this.wd=wd;
    }

    protected void type(GroupData groupData, By locator) {
        click(locator);
        wd.findElement(locator).clear();
        wd.findElement(locator).sendKeys(groupData.getName());
    }

    protected void click(By locator) {
        wd.findElement(locator).click();
    }
}
