package com.stv.factory.factorypages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BasketPopupPage extends FactoryPage {
    @FindBy(className = "bem-add-to-basket-popup-header")
    private WebElement basketPopupHeader;

    @FindBy(id = "view-basket")
    private WebElement viewFullBasketLink;

    @FindBy(xpath = "(//p[@class='bem-add-to-basket-popup-detail bem-add-to-basket-popup-detail--qty'])[1]")
    private WebElement qtyBlock;

    public boolean isBasketPopupPageDisplayed() {
        return basketPopupHeader.isDisplayed();
    }

    public void clickOnViewFullBasketLink() {
        viewFullBasketLink.click();
    }

    public int getQuantity() {
        String qtyTextBlock = qtyBlock.getText();
        String qtyText = qtyTextBlock.substring(qtyTextBlock.indexOf(" ") + 1);
        return Integer.parseInt(qtyText);
    }
}
