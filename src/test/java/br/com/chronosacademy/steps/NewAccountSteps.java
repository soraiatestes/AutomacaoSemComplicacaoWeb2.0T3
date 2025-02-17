package br.com.chronosacademy.steps;

import br.com.chronosacademy.core.Driver;
import br.com.chronosacademy.pages.LoginPage;
import br.com.chronosacademy.pages.NewAccountPage;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import org.junit.Assert;

import java.io.IOException;
import java.util.Map;

public class NewAccountSteps {
    NewAccountPage newAccountPage;
    String username;

    @Dado("que a pagina new account esteja sendo exibida")
    public void queAPaginaNewAccountEstejaSendoExibida() throws IOException {
        newAccountPage = new NewAccountPage();
        Driver.getDriver().get("https://advantageonlineshopping.com/");
        Driver.getDriver().get("https://advantageonlineshopping.com/#/register");
        Assert.assertEquals("CREATE ACCOUNT", newAccountPage.getTextNewAccount());
        Driver.printScreen("pagina new account");
       }

    @Quando("os campos de cadastros estiverem preenchidos com")
    public void osCamposDeCadastrosEstiveremPreenchidosCom(Map<String, String>map) throws IOException {
        username = map.get("username");
        newAccountPage.setInpUserName(map.get("username"));
        newAccountPage.setInpEmail(map.get("email"));
        newAccountPage.setInpPassword(map.get("password"));
        newAccountPage.setInpConfirmPassword(map.get("password"));
        newAccountPage.selectCountry(map.get("country"));
        newAccountPage.clickInpIagree();
        newAccountPage.clickBtnRegister();
        Driver.printScreen("campos de cadastros preenchidos");
    }
    @Entao("deve ser possivel logar no sistema apos o cadastro")
    public void deveSerPossivelLogarNoSistemaAposOCadastro() {
        LoginPage loginPage = new LoginPage();
        Assert.assertEquals(username, loginPage.getUsuarioLogado());
    }
}
