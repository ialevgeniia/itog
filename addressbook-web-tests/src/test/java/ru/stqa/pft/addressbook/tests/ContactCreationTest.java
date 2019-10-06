package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class ContactCreationTest extends TestBase {


  @Test(enabled=false)
  public void testContactCreation() throws Exception {
    app.goTo().returnHomepage();
    Contacts before = app.getContactHelper().all();
    ContactData contact = new ContactData().withLastname("Last").withEmail("mail").withFirstnsme("first").withMobile("2222");
    app.getContactHelper().createContact(contact);
    app.getContactHelper().returnToHomepage();
    Contacts after = app.getContactHelper().all();
    assertEquals(after.size(), before.size()+1);
    assertThat(after, equalTo(before.withAdded(contact.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));
  }
}