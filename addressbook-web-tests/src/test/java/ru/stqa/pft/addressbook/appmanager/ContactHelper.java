package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.stqa.pft.addressbook.model.ContactData;

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
        wd.findElements(By.name("selected[]")).get(index).click();
    }


    public void deleteSelectedContact() {
        click(By.xpath("//input[@value='Delete']"));
    }

    public void agreeDeleteContact() {
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

   public List<ContactData> getContactList() {
       List<ContactData> contacts = new ArrayList<ContactData>();
       List<WebElement> elements = wd.findElements(By.xpath("//tr[@name='entry']"));
       for (WebElement element: elements){
           List<WebElement> row = element.findElements(By.cssSelector("td"));
           String firstnsme = row.get(2).getText();
           String lastname = row.get(1).getText();
           int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            ContactData contact = new ContactData(id, lastname, null, firstnsme, null);
            contacts.add(contact);
          }
         return contacts;
    }
}
