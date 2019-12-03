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
        if (app.db().contacts().size() == 0) {
            app.getContactHelper().createContact(new ContactData().withFirstnsme("Seryi").withLastname("Volk"));
            app.getContactHelper().returnToHomepage();
        }
    }

     @Test
     public void testContactModification () {
            Contacts before = app.db().contacts();
            ContactData modifiedContact = before.iterator().next();
            ContactData contact = new ContactData()
                    .withId(modifiedContact.getId()).withLastname("Car").withFirstnsme("Carevich").withMobile("77782").withEmail("car@car.car");
          app.getContactHelper().editContact(contact.getId());
            app.getContactHelper().fillContactForm(contact);
            app.getContactHelper().updateContact();
            app.getContactHelper().returnToHomepage();
            Contacts after = app.db().contacts();
            assertEquals(after.size(), before.size());
         assertThat(after, equalTo(before.without(modifiedContact).withAdded(contact)));

        }

    }