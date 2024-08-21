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
        type(contactData.getFirstname(), By.name("firstname"));
        type(contactData.getLastname(), By.name("lastname"));
        type(contactData.getAddress(), By.name("address"));
        type(contactData.getEmail(), By.name("email"));
        type(contactData.getMobile(), By.name("mobile"));
    }

    public void initContactCreation() {
        click(By.linkText("add new"));
    }
    public void deleteSelectedContact() {
        click(By.xpath("//input[@value='Delete']"));
        wd.switchTo().alert().accept();
    }
    public void selectContact(){
        click(By.id("6"));
    }
    public void editSelectedContact(){
        click(By.cssSelector("a[href='edit.php?id=6']"));
    }

    public void updateContact() {
        click(By.name("update"));
    }
}
