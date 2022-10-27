package com.stv.factory.factorypages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RecoverPasswordPage extends FactoryPage{
    @FindBy(id = "recover-password")
    private WebElement recoverPasswordContainer;

    public boolean isRecoverPasswordContainerDisplayed() {
        return recoverPasswordContainer.isDisplayed();
    }
}
