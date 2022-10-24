package com.stv.factory.factorytests;

import com.stv.factory.factorypages.LoginPage;
import com.stv.factory.factorypages.MainFactoryPage;
import com.stv.factory.factorypages.RecoverPasswordPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class MainFactoryTest extends BasicFactoryTest {

    MainFactoryPage mainFactoryPage = new MainFactoryPage();
    LoginPage loginPage = new LoginPage();
    RecoverPasswordPage recoverPasswordPage = new RecoverPasswordPage();

    @DataProvider
    public Object[][] testDataEmailValidation() {
        return new Object[][]{
                new Object[]{"333", "Please ensure you have entered the correct email address"},
                new Object[]{"123@mail.ru", ""}
        };
    }

    @DataProvider
    public Object[][] testDataIsPasswordReadable() {
        return new Object[][]{
                new Object[]{"333"},
                new Object[]{"asdzxc"}
                };
        }

    @Test (description = "Assert the main page is loaded and account icon is visible")
    public void assertAccountIconIsDisplayed() {
        boolean actualResult = mainFactoryPage.isAccountLinkDisplayed();
        Assert.assertEquals(actualResult, true, "Account link isn't visible");
    }

    @Test (description = "Assert the login page is loaded", dependsOnMethods = "assertAccountIconIsDisplayed")
    public void assertLoginPageOpened() throws Exception {
        mainFactoryPage.clickOnTrustButton();
        mainFactoryPage.clickOnAccountLink();
        Assert.assertEquals(new LoginPage().isLoginContainerDisplayed(), true, "Login page isn't loaded properly");
    }

    @Test (description = "Assert that email form is displayed", dependsOnMethods = "assertLoginPageOpened")
    public void assertEmailFormIsDispayed() {
        boolean actualResult = loginPage.isEmailFormDisplayed();
        Assert.assertTrue(actualResult, "Email form isn't visible");
    }

    @Test(description = "Assert email validation", dependsOnMethods = "assertEmailFormIsDispayed", dataProvider = "testDataEmailValidation")
    public void assertEmailValidation(String email, String result) {
        loginPage.enterEmail(email);
        String actualResult = loginPage.getEmailValidationMessage();
        Assert.assertEquals(actualResult, result);
    }

    @Test(description = "Assert that password form is displayed", dependsOnMethods = "assertLoginPageOpened")
    public void assertPasswordFormIsDispayed() {
        boolean actualResult = loginPage.isPasswordFormDisplayed();
        Assert.assertTrue(actualResult, "Password form isn't visible");
    }

    @Test(description = "Assert that password checkbox is displayed", dependsOnMethods = "assertLoginPageOpened")
    public void assertPasswordCheckboxIsDispayed() {
        boolean actualResult = loginPage.isPasswordCheckBoxDisplayed();
        Assert.assertTrue(actualResult, "Password checkbox isn't visible");
    }

    @Test (description = "Assert password is readable",
            dependsOnMethods = {"assertPasswordFormIsDispayed", "assertPasswordCheckboxIsDispayed"},
            dataProvider = "testDataIsPasswordReadable")
    public void assertIsPasswordReadable(String ps) {
        loginPage.enterPassword(ps);
        loginPage.clickOnPasswordCheckbox();
        boolean actualResult = loginPage.isPasswordDisplayed();
        Assert.assertTrue(actualResult);
    }

    @Test(description = "Assert that forgotten password link is displayed", dependsOnMethods = "assertLoginPageOpened")
    public void assertForgottenPasswordLinkIsDispayed() {
        boolean actualResult = loginPage.isForgottenPasswordLinkDisplayed();
        Assert.assertTrue(actualResult, "Forgotten password link isn't visible");
    }

    @Test(description = "Assert that forgotten password page is displayed", dependsOnMethods = {"assertForgottenPasswordLinkIsDispayed", "assertIsPasswordReadable"})
    public void assertForgottenPasswordPageIsDispayed() {
        loginPage.clickOnForgottenPasswordLink();
        boolean actualResult = recoverPasswordPage.isRecoverPasswordContainerDisplayed();
        Assert.assertTrue(actualResult, "Forgotten password page isn't displayed");
    }


}
