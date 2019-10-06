package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.util.ArrayList;
import java.util.List;

public class ContactHelper extends HelperBase {

    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    public void submitContactCreation() {
        click(By.name("submit"));
    }

    public void fillContactForm(ContactData contactData) {
        type(By.name("firstname"), contactData.getFirstnsme());
        type(By.name("lastname"), contactData.getLastname());
        type(By.name("mobile"), contactData.getMobile());
        type(By.name("email"), contactData.getEmail());
    }

    public void initContactCreation() {
        click(By.linkText("add new"));
    }


    public void selectContact(int index) {
        wd.findElements(By.cssSelector("selected[]")).get(index).click();
    }

    public void selectContactById(int id) {
        //wd.findElements(By.cssSelector("input[value='" + id +"']")).click();
        click(By.cssSelector("input[value='" + id +"']"));
    }


    public void deleteSelectedContact() {
        click(By.xpath("//input[@value='Delete']"));
        wd.switchTo().alert().accept();
    }


    public void editContact(int id) {
        click(By.xpath("//a[@href='edit.php?id=" + id + "']"));
    }

    public void updateContact() {
        click(By.xpath("//input[22]"));
    }

    public void createContact(ContactData contact) {
        initContactCreation();
        fillContactForm(contact);
        submitContactCreation();
    }

    public boolean isThereAContact() {
        return isElementPresent(By.name("selected[]"));
    }

    public int getContactCount() {
        return wd.findElements(By.name("selected[]")).size();
    }

    public void returnToHomepage() {
        click(By.linkText("home page"));
    }

   public Contacts all() {
       Contacts contacts = new Contacts();
       List<WebElement> elements = wd.findElements(By.xpath("//tr[@name='entry']"));
       for (WebElement element: elements){
           List<WebElement> row = element.findElements(By.cssSelector("td"));
           String firstnsme = row.get(2).getText();
           String lastname = row.get(1).getText();
           String allPhones = row.get(5).getText();
           int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            contacts.add(new ContactData().withId(id).withLastname(lastname).withFirstnsme(firstnsme)
                    .withAllPhones(allPhones));
          }
         return contacts;
    }

    public ContactData infoFromEditForm (ContactData contact){
        editContact (contact.getId());
        String firstnsme = wd.findElement(By.name("firstname")).getAttribute("value");
        String lastname = wd.findElement(By.name("lastname")).getAttribute("value");
        String home = wd.findElement(By.name("home")).getAttribute("value");
        String mobile = wd.findElement(By.name("mobile")).getAttribute("value");
        String work = wd.findElement(By.name("work")).getAttribute("value");
        wd.navigate().back();
        return new ContactData().withId(contact.getId()).withFirstnsme(firstnsme).withLastname(lastname)
                .withHomePhone(home).withmobilePhone(mobile).withworkPhone(work);


    }
}