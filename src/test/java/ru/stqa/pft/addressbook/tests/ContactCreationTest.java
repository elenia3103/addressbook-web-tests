package ru.stqa.pft.addressbook.tests;


import org.openqa.selenium.By;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;


public class ContactCreationTest extends TestBase{

    @Test
    public void testContactCreation() throws Exception {
        app.getContactHelper().initContactCreation();
        app.getContactHelper().fillContactForm(new ContactData("test1", "testov1", "address1", "mobile1", "email1","name3"),true);
        app.getContactHelper().submitContactCreation();
        app.getNavigationHelper().goToHomePage();
    }

}
