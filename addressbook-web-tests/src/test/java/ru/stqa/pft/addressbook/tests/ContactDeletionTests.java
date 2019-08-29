package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

public class ContactDeletionTests extends TestBase {

    @Test
    public void testContactDeletion(){
        if (!app.getContactHelper().isThereAContact()){
            app.getContactHelper().createContact (new ContactData("Seryi", "+7123443", "Volk", null));
            app.getNavigationHelper().returnToHomepage();
        }
    app.getContactHelper().selectContact();
    app.getContactHelper().deleteSelectedContact();
    app.getContactHelper().agreeDeleteContact();
    }

}
