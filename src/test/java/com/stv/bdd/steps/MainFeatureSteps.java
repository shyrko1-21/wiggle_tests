package com.stv.bdd.steps;

import com.stv.factory.factorypages.*;
import com.stv.factory.factorytests.BasicFactoryTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class MainFeatureSteps extends BasicFactoryTest {
    private int qtyFromBasketPopupPage;
    private MainFactoryPage mainFactoryPage = new MainFactoryPage();
    private LoginPage loginPage = new LoginPage();
    private ProductsPage productsPage = new ProductsPage();
    private ItemPage itemPage = new ItemPage();
    private BasketPopupPage basketPopupPage = new BasketPopupPage();
    private BasketPage basketPage = new BasketPage();
    private ForgottenPasswordPage forgottenPasswordPage = new ForgottenPasswordPage();

    @Given("Main page is opened")
    public void mainPageOpened() throws Exception {
        setUp();
        mainFactoryPage.clickOnTrustButton();
        boolean actualResult = mainFactoryPage.isAccountLinkDisplayed();
        Assert.assertTrue(actualResult, "Account link isn't visible");
    }

    @When("A user scrolls down to a category")
    public void scrollDownToCategory() {
        mainFactoryPage.scrollDownToCategory();
    }

    @And("Clicks on the Shop now button")
    public void clickOnShopNowButton() {
        mainFactoryPage.clickOnShopNowButton();
    }

    @Then("Products page is opened")
    public void productsPageOpened() {
        boolean actualResult = productsPage.isProductsPageDisplayed();
        Assert.assertTrue(actualResult);
    }

    @When("A user scrolls down to an item")
    public void scrollDownToItem() {
        productsPage.scrollDownToItem();
    }

    @And("Clicks on a item")
    public void clickOnItem() {
        productsPage.clickOnItem();
    }

    @Then("Item page is opened")
    public void ItemPageOpened() {
        Assert.assertTrue(itemPage.isItemPageDisplayed());
    }

    @When("A user selects a size")
    public void selectSize() {
        itemPage.selectSize();
    }

    @And("Clicks on Add to basket button")
    public void clickOnAddToBasketButton() {
        itemPage.clickOnAddToBasketButton();
    }

    @Then("Basket pop-up page appears")
    public void basketPopupPageOpened() {
        qtyFromBasketPopupPage = basketPopupPage.getQuantity();
        Assert.assertTrue(basketPopupPage.isBasketPopupPageDisplayed());
    }

    @When("A user clicks on View full basket link")
    public void clickOnViewFullBasketLink() {
        basketPopupPage.clickOnViewFullBasketLink();
    }

    @Then("Basket page is opened")
    public void basketPageOpened() {
        Assert.assertTrue(basketPage.isBasketPageDisplayed());
    }

    @And("Quantity is not changed")
    public void quantityNotChanged() {
        Assert.assertEquals(basketPage.getQuantity(), qtyFromBasketPopupPage);
    }

    @When("A user clicks on the Continue to checkout button")
    public void clickOnContinueToCheckoutButton() {
        basketPage.clickOnContinueToCheckoutButton();
    }

    @Then("Login page is opened")
    public void loginPageOpened() {
        Assert.assertTrue(loginPage.isLoginContainerDisplayed(), "Login page isn't loaded properly");
    }

    @When("A user clicks on the Forgotten password button")
    public void clickOnForgottenPasswordLink() {
        loginPage.clickOnForgottenPasswordLink();
    }

    @Then("Forgotten password page is opened")
    public void forgottenPasswordPageOpened() {
        Assert.assertTrue(forgottenPasswordPage.isForgottenPasswordPageDisplayed());
    }
}
