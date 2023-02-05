package passwords;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class ForgotPasswordTests extends BaseTests {

    @Test
    public void testForgotPassword(){
        var forgotPasswordPage = homePage.clickForgotPassword();
        var emailSentPage = forgotPasswordPage.retrievePassword("tau@example.com");
        assertTrue(emailSentPage.getMessage().contains("Your e-mail's been sent"),"Message is incorrect");
    }
}
