package ru.stqa.pft.addressbook.tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactModificationTest extends TestBase{
    @Test
    public void testContactModification(){
        app.getContactHelper().editSelectedContact();
        app.getContactHelper().fillContactForm(new ContactData("modify", null, "addr", null, "qqq@main.fo"));
        app.getContactHelper().updateContact();
        app.getNavigationHelper().goToHomePage();
    }
}
