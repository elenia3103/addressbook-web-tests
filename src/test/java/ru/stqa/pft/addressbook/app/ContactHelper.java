package ru.stqa.pft.addressbook.app;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactHelper extends BaseHelper{
    public ContactHelper (WebDriver wd){
        super(wd);
    }
    public void submitContactCreation() {
        wd.findElement(By.xpath("//input[21]")).click();
    }

    public void fillContactForm(ContactData contactData) {
        click(By.name("firstname"));
        wd.findElement(By.name("firstname")).sendKeys(contactData.getFirstname());
        click(By.name("lastname"));
        wd.findElement(By.name("lastname")).sendKeys(contactData.getLastname());
        click(By.name("address"));
        wd.findElement(By.name("address")).sendKeys(contactData.getAddress());
        click(By.name("email"));
        wd.findElement(By.name("email")).sendKeys(contactData.getEmail());
        click(By.name("mobile"));
        wd.findElement(By.name("mobile")).sendKeys(contactData.getMobile());
    }

    public void initContactCreation() {
        click(By.linkText("add new"));
    }
    public void deleteSelectedContact() {
        click(By.xpath("//input[@value='Delete']"));
        wd.switchTo().alert().accept();
    }
    public void selectContact(){
        click(By.id("7"));
    }
    public void editSelectedContact(){
        click(By.cssSelector("a[href='edit.php?id=7']"));
    }

    public void updateContact() {
        click(By.name("update"));
    }
}
