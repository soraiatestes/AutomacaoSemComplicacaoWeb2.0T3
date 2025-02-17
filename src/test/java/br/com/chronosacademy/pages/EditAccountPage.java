package br.com.chronosacademy.pages;

import br.com.chronosacademy.core.Driver;
import br.com.chronosacademy.maps.EditAccountMap;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class EditAccountPage {
    EditAccountMap editAccountMap;

    public EditAccountPage(){
        editAccountMap = new EditAccountMap();
        PageFactory.initElements(Driver.getDriver(), editAccountMap);
    }

    public void setFirstName(String firstName){
        Driver.visibilityOf(editAccountMap.inpFirstName);
        editAccountMap.inpFirstName.clear();
        editAccountMap.inpFirstName.sendKeys(firstName);
    }

    public void setLastName(String lastName) {
        editAccountMap.inpLastName.clear();
        editAccountMap.inpLastName.sendKeys(lastName);
    }

    public void clickBtnSSave(){
        Driver.aguardaOptions(new Select(editAccountMap.slcCountry));
        editAccountMap.btnSave.click();
    }
}
