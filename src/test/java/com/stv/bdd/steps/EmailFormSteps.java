package com.stv.bdd.steps;

import com.stv.factory.factorypages.LoginPage;
import com.stv.factory.factorypages.MainFactoryPage;
import com.stv.factory.factorytests.BasicFactoryTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class EmailFormSteps extends BasicFactoryTest {
    private MainFactoryPage mainFactoryPage = new MainFactoryPage();
    private LoginPage loginPage = new LoginPage();

    @Given("Main page is opened")
    public void mainPageOpened() throws Exception{
        setUp();
        mainFactoryPage.clickOnTrustButton();
        boolean actualResult = mainFactoryPage.isAccountLinkDisplayed();
        Assert.assertTrue(actualResult, "Account link isn't visible");
    }

    @When("A user clicks on Your account button")
    public void clickOnYourAccountButton() {
        mainFactoryPage.clickOnAccountLink();
    }

    @Then("Account page is opened")
    public void accountPageOpened() throws Exception {
        boolean actualResult = loginPage.isLoginContainerDisplayed();
        Assert.assertTrue(actualResult, "Login page isn't loaded properly");
        afterClass();
    }

    @Given("Login page is opened")
    public void loginPageOpened() {
        setUp();
        try {
            mainFactoryPage.clickOnTrustButton();
        } catch (Exception e) {

        } finally {
            mainFactoryPage.clickOnAccountLink();
            boolean actualResult = loginPage.isLoginContainerDisplayed();
            Assert.assertTrue(actualResult, "Login page isn't loaded properly");
        }
    }

    @When("A user enters {string}")
    public void enterNonValidEmail(String email) {
        loginPage.enterEmail(email);
    }

    @Then("{string} appears")
    public void errorValidationMessageAppears(String errorValidationMessage) {
        String actualResult = loginPage.getEmailValidationMessage();
        Assert.assertEquals(actualResult, errorValidationMessage);
    }
}
