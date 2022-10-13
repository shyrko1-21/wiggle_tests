package com.stv.factory.factorypages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends FactoryPage {
    @FindBy(className = "bem-checkout__login-container")
    private WebElement loginContainer;

    @FindBy(id = "LogOnModel_UserName-error")
    private WebElement emailValidationMessage;

    @FindBy(id="LogOnModel_UserName")
    private WebElement emailAddress;

    @FindBy(id="LogOnModel_Password")
    private WebElement password;

    @FindBy(id="passwordToggle")
    private WebElement passwordCheckBox;

    @FindBy(id="forgotten-password")
    private WebElement forgottenPasswordLink;


    public boolean isLoginContainerDisplayed(){
        return loginContainer.isDisplayed();
    }

    public boolean isEmailFormDisplayed(){
        return emailAddress.isDisplayed();
    }

    public void enterEmail(String email) {
        emailAddress.clear();
        emailAddress.sendKeys(email);
        emailAddress.sendKeys(Keys.RETURN);
    }

    public String getEmailValidationMessage() {
        try {
            return emailValidationMessage.getText();
        } catch (Exception e) {
            return "";
        }
    }

    public boolean isPasswordFormDisplayed() {
        return password.isDisplayed();
    }

    public boolean isPasswordCheckBoxDisplayed() {
        return passwordCheckBox.isDisplayed();
    }

    public boolean isPasswordDisplayed() {
        return password.getAttribute("type").equals("text");
    }

    public void clickOnPasswordCheckbox() {
        if (passwordCheckBox.isSelected()) {
            passwordCheckBox.click();
        }
        passwordCheckBox.click();
    }

    public void enterPassword(String ps) {
        password.clear();
        password.sendKeys(ps);
    }

    public boolean isForgottenPasswordLinkDisplayed() {
        return forgottenPasswordLink.isDisplayed();
    }

    public void clickOnForgottenPasswordLink() {
        forgottenPasswordLink.click();
    }
}
