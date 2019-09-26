package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactModificationTests extends TestBase {

    @Test
    public void testContactModification()
    {
        app.getNavigationHelper().returnHomepage();
        if (!app.getContactHelper().isThereAContact()){
            app.getContactHelper().createContact (new ContactData("Seryi", "+7123443", "Volk", null));
            app.getContactHelper().returnToHomepage();
        }
    List<ContactData> before = app.getContactHelper().getContactList();
    app.getContactHelper().editContact(before.get(before.size()-2).getId());
    ContactData contact = new ContactData(before.get(before.size()-2).getId(), "Seryi", "+71234", "Volk", "volk@google.com");
    app.getContactHelper().fillContactForm(contact);
    app.getContactHelper().updateContact();
    app.getContactHelper().returnToHomepage();
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size());
    before.remove(before.size()-2);
    before.add(contact);
    Comparator<? super ContactData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
    }

}