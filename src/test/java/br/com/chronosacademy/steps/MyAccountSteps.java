package br.com.chronosacademy.steps;

import br.com.chronosacademy.core.Driver;
import br.com.chronosacademy.pages.MyAccountPage;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import org.junit.Assert;

import java.io.IOException;

public class MyAccountSteps {
    MyAccountPage myAccountPage;

    @Dado("que esteja na pagina myAccount")
    public void queEstejaNaPaginaMyAccount() throws IOException {
        myAccountPage = new MyAccountPage();
        myAccountPage.clickLinkUser();
        myAccountPage.clickLinkMyAccount();
        Driver.printScreen("pagina myaccount");
    }
    @Quando("for efetuado a acao do clique em delete e em yes")
    public void forEfetuadoAAcaoDoCliqueEmDeleteEEmYes() throws IOException {
        myAccountPage.clickBtnDelete();
        myAccountPage.clickBtnYes();
        Driver.printScreen("clique no botão delete e em yes");
    }
    @Entao("o usuario deve ser deletado")
    public void oUsuarioDeveSerDeletado() {
        Assert.assertEquals("Account deleted successfully", myAccountPage.getTextDelete());
    }
}
