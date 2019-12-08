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

        ContactData newcontact = new ContactData().withLastname("Carevna").withFirstnsme("Liagushka").withMobile("").withEmail("").withEmail2("").withEmail3("").withHomePhone("").withworkPhone("").withAddress("");
        app.getContactHelper().createContact(newcontact);
        Contacts before = app.db().contacts();
        newcontact.withId(before.stream().mapToInt((g) -> (g).getId()).max().getAsInt());
        int idnew = newcontact.getId();
        Groups groupsbefore = newcontact.getGroups();
        GroupData group = app.db().groups().iterator().next();
        app.goTo().returnHomepage();
        app.getContactHelper().ContactToGroup(idnew, group.getId());
        app.goTo().returnHomepage();
        app.getContactHelper().ContactFromGroup(idnew, group);

        Contacts after = app.db().contacts();
        ContactData contactafter = null;

        for(ContactData i : after){
            if (i.getId() == idnew){
                contactafter = i;
                break;
            }
        }
        assert (groupsbefore.equals(contactafter.getGroups()));

    }

}