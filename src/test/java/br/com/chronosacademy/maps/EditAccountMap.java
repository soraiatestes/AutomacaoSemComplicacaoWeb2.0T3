package br.com.chronosacademy.maps;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditAccountMap {

    @FindBy(name="first_nameAccountDetails")
    public WebElement inpFirstName;

    @FindBy(name="last_nameAccountDetails")
    public WebElement inpLastName;

    @FindBy(css = "#save_btn")
    public WebElement btnSave;

    @FindBy(name="countryListboxAccountDetails")
    public WebElement slcCountry;
}
