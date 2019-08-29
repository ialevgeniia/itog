package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactModificationTests extends TestBase {

    @Test
    public void testContactModification()
    {
        if (!app.getContactHelper().isThereAContact()){
            app.getContactHelper().createContact (new ContactData("Seryi", "+7123443", "Volk", null));
            app.getNavigationHelper().returnToHomepage();
        }
    app.getContactHelper().editContact();
    app.getContactHelper().fillContactForm(new ContactData("Bessmertniy", "", "Kashei", "bessmertniy@google.com"));
    app.getContactHelper().updateContact();
    app.getNavigationHelper().returnToHomepage();

    }

}