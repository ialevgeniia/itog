package ru.stqa.pft.addressbook.tests;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class ContactCreationTest extends TestBase {

  @DataProvider
  public Iterator<Object[]> validGroups() throws IOException {
    BufferedReader reader = new BufferedReader(new FileReader(new File("src\\test\\resources\\contacts.json")));
    String json ="";
    String line = reader.readLine();
    while (line !=null){
      json += line;
      line = reader.readLine();
    }
    Gson gson = new Gson ();
    List<ContactData> groups = gson.fromJson(json, new TypeToken<List<ContactData>>(){}.getType());
    return groups.stream().map((g) -> new Object[] {g}).collect(Collectors.toList()).iterator();
  }

  @Test (dataProvider = "validGroups")
  public void testContactCreation(ContactData contact) throws Exception {
    Contacts before = app.db().contacts();
    app.goTo().returnHomepage();
    app.getContactHelper().createContact(contact);
    Contacts after = app.db().contacts();
    assertEquals(after.size(), before.size()+1);
    assertThat(after, equalTo(before.withAdded(contact.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));
  }
}

