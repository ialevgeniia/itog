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

public class ContactModificationTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().returnHomepage();
        if (app.getContactHelper().all().size() == 0) {
            app.getContactHelper().createContact(new ContactData().withFirstnsme("Seryi").withLastname("Volk"));
            app.getContactHelper().returnToHomepage();
        }
    }

     @Test//(enabled=false)
     public void testContactModification () {
            Contacts before = app.getContactHelper().all();
            ContactData modifiedContact = before.iterator().next();
            ContactData contact = new ContactData()
                    .withId(modifiedContact.getId()).withLastname("Volk").withFirstnsme("Seriy").withMobile("2222").withEmail("volk@google.com");
          app.getContactHelper().editContact(contact.getId());
            app.getContactHelper().fillContactForm(contact);
            app.getContactHelper().updateContact();
            app.getContactHelper().returnToHomepage();
            Contacts after = app.getContactHelper().all();
            assertEquals(after.size(), before.size());
         assertThat(after, equalTo(before.without(modifiedContact).withAdded(contact)));

        }

    }