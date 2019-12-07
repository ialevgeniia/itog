package ru.stqa.pft.addressbook.tests;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

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

public class ContactAddGroup extends TestBase {


    private ContactData contactToAdd;

       @BeforeMethod
    public void ensurePreconditions() {
           if (app.db().contacts().size() == 0) {
            app.getContactHelper().createContact(new ContactData().withLastname("Ivan").withFirstnsme("Carevich").withMobile("77782").withEmail("car@car.car").withEmail2("").withEmail3("").withHomePhone("").withworkPhone("").withAddress(""));
        }
       if (app.db().groups().size() == 0){
                app.goTo().GroupPage();
                app.group().create(new GroupData().withName("name").withFooter("").withHeader(""));

        }
    }

    @Test
    public void  testContactAddGroup () {
      Contacts contactsbefore = app.db().contacts();
      Groups groupsbefore = app.db().groups();
      ContactData contact = app.db().contacts().iterator().next();
      GroupData group = app.db().groups().iterator().next();
      app.goTo().returnHomepage();
      app.getContactHelper().ContactToGroup(contact.getId(), group.getId());

    }
}