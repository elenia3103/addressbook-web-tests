package ru.stqa.pft.addressbook;


import org.testng.annotations.Test;


public class GroupCreationTest extends TestBase {

    @Test
    public void testGroupCreation() throws Exception {
        goToGroupPage();
        initGroupCreation();
        fillGroupForm(new GroupData("group1", "header1", "footer1"));
        submitGroupCreation();
        returnToGroupPage();

    }

}
