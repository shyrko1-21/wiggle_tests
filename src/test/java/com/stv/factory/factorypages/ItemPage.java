package com.stv.factory.factorypages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ItemPage extends FactoryPage{
    @FindBy(id = "productTitle")
    private WebElement productTitle;

    @FindBy(xpath = "(//a[@class='bem-sku-selector__option-prompt'])[2]")
    private WebElement selectSizeList;

    @FindBy(xpath = "//li[@title='UK10']")
    private WebElement selectSize;

    @FindBy(id = "quickBuyButton")
    private WebElement addToBasketButton;

    public boolean isItemPageDisplayed(){
        return productTitle.isDisplayed();
    }

    public void selectSize() {
        selectSizeList.click();
        selectSize.click();
    }

    public void clickOnAddToBasketButton() {
        addToBasketButton.click();
    }
}
