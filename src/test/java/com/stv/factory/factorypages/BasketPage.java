package com.stv.factory.factorypages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BasketPage extends FactoryPage {
    @FindBy(className = "product-list")
    private WebElement basketProducts;

    @FindBy(className = "txt-qty")
    private WebElement qtyBlock;

    @FindBy(id = "continue-checkout")
    private WebElement continueToCheckoutButton;

    public boolean isBasketPageDisplayed() {
        return basketProducts.isDisplayed();
    }

    public int getQuantity() {
        String qtyText = qtyBlock.getAttribute("value");
        return Integer.parseInt(qtyText);
    }

    public void clickOnContinueToCheckoutButton() {
        continueToCheckoutButton.click();
    }
}
