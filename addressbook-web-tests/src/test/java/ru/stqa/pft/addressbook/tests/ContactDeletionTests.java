package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.List;

public class ContactDeletionTests extends TestBase {

    @Test
    public void testContactDeletion(){
    app.getNavigationHelper().returnHomepage();
    if (!app.getContactHelper().isThereAContact()){
         app.getContactHelper().createContact (new ContactData("Seryi", "+7123443", "Volk", null));
            app.getContactHelper().returnToHomepage();
        }
   List<ContactData> before = app.getContactHelper().getContactList();
    app.getContactHelper().selectContact(before.size()-2);
    app.getContactHelper().deleteSelectedContact();
    app.getContactHelper().agreeDeleteContact();
    app.getNavigationHelper().returnHomepage();
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size()-1);
    before.remove(before.size()-2);
    Assert.assertEquals(before, after);
    }

}
