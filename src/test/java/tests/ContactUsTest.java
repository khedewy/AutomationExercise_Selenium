package tests;

import data.ContactUData;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ContactUsPage;
import pages.HomePage;

import java.io.IOException;

public class ContactUsTest extends TestBase{
    HomePage home;
    ContactUsPage contact;
    @Test
    public void NavigateToContactUs(){
        home = new HomePage(driver);
        home.navigateToContactUsPage();
        contact = new ContactUsPage(driver);
        Assert.assertEquals(contact.assertThatUserIContactUsPage(),"GET IN TOUCH");
    }

    @Test(priority = 1)
    public void EnterContactUsData() throws IOException, ParseException {
        ContactUData data = new ContactUData(driver);
        data.ContactUsData();
        contact = new ContactUsPage(driver);
        contact.ContactUs(data.name, data.email, data.subject, data.message, data.path);
        Assert.assertEquals(contact.getContactAssertionMessage(),"Success! Your details have been submitted successfully.");
    }
}
