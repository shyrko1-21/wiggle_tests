package com.stv.factory.factorypages;

import com.stv.framework.core.drivers.Driver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class MainFactoryPage extends FactoryPage {

    @FindBy(id = "accountLink")
    private WebElement accountLink;

    @FindBy(id = "Banner1")
    private WebElement shopNow;

    @FindBy(xpath = "//button[contains(text(),'Accept All Cookies')]")
    private WebElement trustButton;

    public boolean isAccountLinkDisplayed(){
        return accountLink.isDisplayed();
    }

    public void clickOnAccountLink(){
        accountLink.click();
    }

    public void clickOnTrustButton(){
        trustButton.click();
    }

    public void scrollDownToCategory() {
        ((JavascriptExecutor)Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", shopNow);
    }

    public void clickOnShopNowButton(){
        shopNow.click();
    }


}
