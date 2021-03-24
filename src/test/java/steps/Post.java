package steps;

import cucumber.api.PendingException;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Post extends Base{
    private Base base;

    public Post(Base base) {
        this.base = base;
    }


    @Dado("^quando acesso a Wikipedia em Portugues$")
    public void quandoAcessoAWikipediaEmPortugues() {
        base.driver.get (base.url); // abre o navegador no site alvo ( extendendo da base)
        System.out.println("Passo 1 - Acessou a página");

    }

    @Quando("^pesquiso por \"([^\"]*)\"$")
    public void pesquisoPor(String pascoa)  {
        base.driver.findElement(By.id("searchInput")).sendKeys(pascoa + Keys.ENTER);
        System.out.println("Passo 2 - Pesquisou por " + pascoa );
    }

    @Entao("^Exibe a expressao \"([^\"]*)\" no titulo da guia$")
    public void exibeAExpressaoNoTituloDaGuia(String pascoa)  {
        //assertEquals("Ovo de Páscoa – Wikipédia, a enciclopédia livre",base.driver.getTitle());
        assertTrue(base.driver.getTitle().contains(pascoa));
        System.out.println("Passo 3 - Verificou na aba do título o nome por " + pascoa);

    }
}
