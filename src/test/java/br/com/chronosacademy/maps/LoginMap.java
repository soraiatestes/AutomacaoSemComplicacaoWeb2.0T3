package br.com.chronosacademy.maps;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginMap {
    @FindBy(css = "#menuUser")
    public WebElement btnLogin;

    @FindBy(css = ".closeBtn")
    public WebElement btnFechar;

    @FindBy(css = ".PopUp")
    public WebElement divFechaModal;

    @FindBy(css = "*[name='username']")
    public WebElement inpUserName;

    @FindBy(css = "*[name=password]")
    public WebElement inpPassword;

    @FindBy(css = "#sign_in_btn")
    public WebElement btnSignIn;

    @FindBy(css = "*[name = remember_me ]")
    public WebElement inpRemember;

//  @FindBy(linkText = "CREATE NEW ACCOUNT")
//  @FindBy(css = ".create-new-account")
    @FindBy(css = ".create-new-account")
    public WebElement linkCreateAccount;

    @FindBy(css = ".loader")
    public WebElement divLoader;

    @FindBy(css = ".containMiniTitle")
    public WebElement textLogado;

    @FindBy(xpath = "//label[contains(text(), 'Incorrect')]")
    public WebElement textErroLogin;

}
