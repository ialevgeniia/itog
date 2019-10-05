package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactCreationTest extends TestBase {


  @Test//(enabled=false)
  public void testContactCreation() throws Exception {
    app.goTo().returnHomepage();
    List<ContactData> before = app.getContactHelper().getContactList();
    ContactData contact = new ContactData("Premudraia", "+8828282", "Vasilisa", "vasilisa@google.com");
    app.getContactHelper().createContact(contact);
    app.getContactHelper().returnToHomepage();
    List<ContactData> after = app.getContactHelper().getContactList();
    before.add(contact);
    Assert.assertEquals(after.size(), before.size());
    Comparator<? super ContactData> byId = (g1,g2) -> Integer.compare(g1.getId(), g2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
  }
}