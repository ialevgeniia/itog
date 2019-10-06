package ru.stqa.pft.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class ContactDeletionTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().returnHomepage();
        if (app.getContactHelper().all().size() == 0) {
            app.getContactHelper().createContact(new ContactData().withFirstnsme("Seryi").withLastname("Volk"));
            app.getContactHelper().returnToHomepage();
        }
    }

    @Test//(enabled=false)
    public void testContactDeletion(){
    app.goTo().returnHomepage();
        Contacts before = app.getContactHelper().all();
        ContactData deletedContact = before.iterator().next();
    app.getContactHelper().selectContactById(deletedContact.getId());
    app.getContactHelper().deleteSelectedContact();
    app.goTo().returnHomepage();
    Contacts after = app.getContactHelper().all();
    assertEquals(after.size(), before.size()-1);
        assertThat(after, equalTo(before.without(deletedContact)));
    }

}
