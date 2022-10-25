package com.stv.factory.factorypages;

import com.stv.framework.core.drivers.Driver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductsPage extends FactoryPage{
    @FindBy(className = "blogGuideAreaPage")
    private WebElement productsPageBanner;

    @FindBy(xpath = "//div[@data-position='1']")
    private WebElement item;

    public boolean isProductsPageDisplayed(){
        return productsPageBanner.isDisplayed();
    }

    public void scrollDownToItem() {
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", item);
    }

    public void clickOnItem() {
        item.click();
    }
}
