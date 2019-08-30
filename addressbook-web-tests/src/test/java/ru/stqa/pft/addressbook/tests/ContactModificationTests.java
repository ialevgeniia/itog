package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactModificationTests extends TestBase {

    @Test
    public void testContactModification()
    {
        app.getNavigationHelper().returnHomepage();
        if (!app.getContactHelper().isThereAContact()){
            app.getContactHelper().createContact (new ContactData("Seryi", "+7123443", "Volk", null));
            app.getContactHelper().returnToHomepage();
        }
        int before = app.getContactHelper().getContactCount();
        app.getContactHelper().editContact();
    app.getContactHelper().fillContactForm(new ContactData("Prekrasnaia", "+888888888", "Vasilisa", "vasilisa@google.com"));
    app.getContactHelper().updateContact();
    app.getContactHelper().returnToHomepage();
    int after = app.getContactHelper().getContactCount();
    Assert.assertEquals(after, before);
    }

}