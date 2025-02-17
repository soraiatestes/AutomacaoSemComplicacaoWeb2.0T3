package br.com.chronosacademy.steps;

import br.com.chronosacademy.core.Driver;
import br.com.chronosacademy.enums.Browser;
import br.com.chronosacademy.pages.LoginPage;
import br.com.chronosacademy.pages.NewAccountPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import org.junit.Assert;

import java.io.IOException;
import java.util.Map;

public class LoginSteps {
    LoginPage loginPage;
    String username;
    @Before
    public void iniciaNavegador(Scenario cenario){
        new Driver(Browser.CHROME);
        Driver.setNomeCenario(cenario.getName());
        Driver.criaDiretorio();
    }

    @After
    public void fechaNavegador(Scenario cenario) throws IOException {
//        Driver.getDriver().quit();
//        System.out.println(Driver.getNomeCenario() + "-" +cenario.getStatus());
//        System.out.println(cenario.isFailed());

        if (cenario.isFailed()){
            Driver.printScreen("erro no cenario");
        }
        Driver.getDriver().quit();
    }

    @Dado("que a modal esteja sendo exibida")
    public void queAModalEstejaSendoExibida() throws IOException {
        Driver.getDriver().get("https://advantageonlineshopping.com/");
        loginPage = new LoginPage();
        loginPage.clickBtnLogin();
        loginPage.visibilityOfBtnFechar();
        loginPage.aguardaLoader();
        Driver.printScreen("modal esteja sendo exibida");
    }
//  @Quando("for realizado um clique fora da modal")
//  public void forRealizadoUmCliqueForaDaModal() {
//      loginPage.clickDivFechaModal();
//  }
    @Então("a janela modal deve ser fechada")
    public void aJanelaModalDeveSerFechada() throws Exception {
        try{
            loginPage.invisibilityOfBtnFechar();
        }catch (Exception e){
            throw new Exception("A janela modal não foi fechada");
        }

    }

    @Quando("for realizado em clique no icone de fechar a modal")
    public void forRealizadoEmCliqueNoIconeDeFecharAModal() {
        loginPage.clickBtnFechar();
    }

    @Quando("for realizado um clique no link create new account")
    public void forRealizadoUmCliqueNoLinkCreateNewAccount() {
        loginPage.visibilityOfLinkCreateAccount();
        loginPage.clickLinkCreateAccount();

    }

    @Então("a pagina create new account deve ser exibida")
    public void aPaginaCreateNewAccountDeveSerExibida() throws IOException {
        NewAccountPage newAccountPage = new NewAccountPage();
        Assert.assertEquals("CREATE ACCOUNT", newAccountPage.getTextNewAccount());
        Driver.printScreen("pagina create new accountexibida");
    }

    @Quando("os campos de login sejam preenchidos da seguinte forma")
    public void osCamposDeLoginSejamPreenchidosDaSeguinteForma(Map<String, String> map) throws IOException {
        username = map.get("login");
        String password = map.get("password");
        boolean remember = Boolean.parseBoolean(map.get("remember"));

        loginPage.setInpUserName(username);
        loginPage.setInpPassword(password);
        if (remember) loginPage.clickInpRemember();
        Driver.printScreen("preenchimento dos campos de login");
    }

    @Quando("for realizado o clique no botao sign in")
    public void forRealizadoOCliqueNoBotaoSignIn() {
        loginPage.clickBtnSignIn();
    }

    @Então("deve ser possivel logar no sistema")
    public void deveSerPossivelLogarNoSistema() throws IOException {
        Assert.assertEquals(username,loginPage.getUsuarioLogado());
        Driver.printScreen("logado no sistema");
        
    }

    @Então("o sistema devera exibir uma mensagem de erro")
    public void oSistemaDeveraExibirUmaMensagemDeErro() throws IOException {
        Assert.assertEquals("Incorrect user name or password.", loginPage.getErroLogin());
        Driver.printScreen("mensagem de erro");
    }

    @Então("o botao sign in deve permanecer desabilitado")
    public void oBotaoSignInDevePermanecerDesabilitado() throws IOException {
        boolean enabled = loginPage.isBtnSignIn();
        Assert.assertFalse(enabled);
        Driver.printScreen("botão signIn desabilitado");
    }

    @Dado("que esteja logado no sisttema com")
    public void queEstejaLogadoNoSisttemaCom(Map<String, String>map) throws IOException {
        queAModalEstejaSendoExibida();
        osCamposDeLoginSejamPreenchidosDaSeguinteForma(map);
        forRealizadoOCliqueNoBotaoSignIn();
        deveSerPossivelLogarNoSistema();
        Driver.printScreen("logado no sistema");
    }
}
