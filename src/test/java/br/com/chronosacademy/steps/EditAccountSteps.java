package br.com.chronosacademy.steps;

import br.com.chronosacademy.pages.EditAccountPage;
import br.com.chronosacademy.pages.MyAccountPage;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import org.junit.Assert;

import java.util.Map;

public class EditAccountSteps {
    MyAccountPage myAccountPage;
    EditAccountPage editAccountPage;
    Map<String, String> mapsDados;

    @Dado("que esteja na pagina de alteracao de conta")
    public void queEstejaNaPaginaDeAlteracaoDeConta() {
        myAccountPage = new MyAccountPage();
        myAccountPage.clickLinkUser();
        myAccountPage.clickLinkMyAccount();
        myAccountPage.clickLinkEdit();
    }
    @Quando("altero os valores dos seguintes campos")
    public void alteroOsValoresDosSeguintesCampos(Map<String, String>map) {
        mapsDados = map;
        editAccountPage = new EditAccountPage();
        editAccountPage.setFirstName(map.get("firstName"));
        editAccountPage.setLastName(map.get("lastName"));
    }
    @Quando("for realizado o clique am salvar")
    public void forRealizadoOCliqueAmSalvar() {
        editAccountPage.clickBtnSSave();
    }
    @Entao("a alteeracao foi exibida na pagina myAccount")
    public void aAlteeracaoFoiExibidaNaPaginaMyAccount() {
        String nome = mapsDados.get("firstName")+" "+mapsDados.get("lastName");
        Assert.assertEquals(nome, myAccountPage.getTextUsuario());
    }

}
