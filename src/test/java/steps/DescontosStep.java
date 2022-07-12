package steps;

import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import pages.HomePage;
import runner.RunCucumberTest;


public class DescontosStep extends RunCucumberTest {

    HomePage homePage = new HomePage(driver);
    @Dado("^que estou no site da qazando$")
    public void que_estou_no_site_da_qazando()  {
        homePage.acessarAplicacao();
    }

    @Quando("^eu preencho meu e-mail$")
    public void eu_preencho_meu_e_mail() throws InterruptedException {
        homePage.scrollDown();
        homePage.preencheEmail();
    }

    @Quando("^clico em ganhar cupom$")
    public void clico_em_ganhar_cupom() {
        homePage.clickGanharDesconto();
    }

    @Entao("^eu vejo o código de desconto$")
    public void eu_vejo_o_código_de_desconto()  {
        homePage.verificarCupomDesconto();

    }
}
