package ru.stqa.pft.addressbook.tests;


import org.testng.annotations.Test;


public class GroupDeletionTest extends TestBase{

    @Test
    public void testGroupDeletion() throws Exception {
        app.getNavigationHelper().goToGroupPage();
        app.getGroupHelper().selectGroup();
        app.getGroupHelper().deleteGroup();
        app.getNavigationHelper().returnToGroupPage();
    }

}
