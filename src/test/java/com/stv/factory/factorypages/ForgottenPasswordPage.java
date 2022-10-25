package com.stv.factory.factorypages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ForgottenPasswordPage extends FactoryPage {
    @FindBy(id = "recover-password")
    private WebElement recoverPasswordBlock;

    public boolean isForgottenPasswordPageDisplayed(){
        return recoverPasswordBlock.isDisplayed();
    }
}
