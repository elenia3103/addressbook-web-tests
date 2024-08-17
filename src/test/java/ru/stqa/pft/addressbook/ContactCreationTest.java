package ru.stqa.pft.addressbook;


import org.testng.annotations.Test;


public class ContactCreationTest extends TestBase{

    @Test
    public void testContactCreation() throws Exception {
        initContactCreation();
        fillContactForm(new ContactData("test1", "testov1", "address1","mobile1","email1"));
        submitContactCreation();
        goToHomePage();
    }

}
