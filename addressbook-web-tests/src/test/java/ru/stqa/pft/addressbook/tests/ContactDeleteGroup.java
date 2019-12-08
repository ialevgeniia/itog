package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;


public class ContactDeleteGroup extends TestBase {


    @BeforeMethod
    public void ensurePreconditions() {
        if (app.db().groups().size() == 0){
            app.goTo().GroupPage();
            app.group().create(new GroupData().withName("name").withFooter("").withHeader(""));

        }
    }

    @Test
    public void  testContactAddGroup () {

        ContactData newcontact = new ContactData().withLastname("Prekrasnaia").withFirstnsme("Vasilisa").withMobile("77777").withEmail("").withEmail2("").withEmail3("").withHomePhone("").withworkPhone("").withAddress("");
        app.getContactHelper().createContact(newcontact);
        Contacts before = app.db().contacts();
        newcontact.withId(before.stream().mapToInt((g) -> (g).getId()).max().getAsInt());
        int idnew = newcontact.getId();
        GroupData group = app.db().groups().iterator().next();
        app.goTo().returnHomepage();
        app.getContactHelper().ContactToGroup(idnew, group.getId());



    }

}