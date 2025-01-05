package br.com.chronosacademy.pages;

import br.com.chronosacademy.core.Driver;
import br.com.chronosacademy.maps.LoginMap;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;


import static br.com.chronosacademy.core.Driver.getDriver;

public class LoginPage {

    LoginMap loginMap;

    public LoginPage() {
        loginMap = new LoginMap();
        PageFactory.initElements(Driver.getDriver(),loginMap);
    }

    public void clickBtnLogin(){
        Driver.visibilityOf(loginMap.btnLogin);
        loginMap.btnLogin.click();
    }

    public void clickBtnFechar(){
        loginMap.btnFechar.click();
    }

    public void clickDivFechaModal(){
        loginMap.divFechaModal.click();
    }

    public void setInpUserName(String username){
        if (username!= null) {
            loginMap.inpUserName.sendKeys(username);
        }
    }

    public void setInpPassword(String password){
        if (password != null) {
            loginMap.inpPassword.sendKeys(password);
        }
    }

    public void clickInpRemember(){
        loginMap.inpRemember.click();
    }

    public void clickLinkCreateAccount(){
        Actions actions= new Actions(getDriver());
        actions.moveToElement(loginMap.linkCreateAccount).perform();
        loginMap.linkCreateAccount.click();

    }

    public void clickBtnSignIn(){
        loginMap.btnSignIn.click();
    }

    public boolean isBtnSignIn(){
        return loginMap.btnSignIn.isEnabled();
    }

    public void visibilityOfBtnFechar(){
        Driver.visibilityOf(loginMap.btnFechar);
    }

    public void invisibilityOfBtnFechar(){
        Driver.invisibilityOf((loginMap.btnFechar));
    }

    public void aguardaLoader(){
        Driver.attributChange(loginMap.divLoader, "display", "none");
    }

    public void visibilityOfLinkCreateAccount() {
       Driver.visibilityOf(loginMap.linkCreateAccount);


//     WebDriver Driver;
//         Actions actions = new Actions(getDriver());
//     actions.moveToElement(loginMap.linkCreateAccount).perform();

    }
}

