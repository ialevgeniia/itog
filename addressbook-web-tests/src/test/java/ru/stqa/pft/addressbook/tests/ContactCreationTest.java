package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

public class ContactCreationTest extends TestBase {


  @Test
  public void testContactCreation() throws Exception {
    app.getNavigationHelper().returnHomepage();
    app.getContactHelper().createContact(new ContactData("Bessmertniy", "+8828282", "Kashei", "kashei@google.com"));
    app.getContactHelper().returnToHomepage();
  }
}