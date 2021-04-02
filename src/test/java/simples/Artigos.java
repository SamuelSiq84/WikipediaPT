package simples;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Artigos {
    String url;
    WebDriver driver;

    @Before
    public void iniciar(){
        url = "https://pt.wikipedia.org/";
        System.setProperty("webdriver.chrome.driver","drivers/chrome/88/chromedriver.exe");
        //aonde está o driver do chrome
        driver = new ChromeDriver();
        //instanciar o selenium como chrome driver

        driver.manage().window().maximize(); // maximizar a janela do navegador

        driver.manage().timeouts().implicitlyWait(60000, TimeUnit.MILLISECONDS);
        // define uma espera implicita com 1 minuto, verificando o carregamento a cada milissegundos


    }
    @Test    // durante o teste
    public void consultarArtigo(){

        // abrir o site
        driver.get(url);


        //pesquisar por "Ovo de Páscoa"
        driver.findElement(By.id("searchInput")).sendKeys("Ovo de Páscoa");
        driver.findElement(By.xpath("//*[@id='searchform']/button")).click();
        //driver.findElement(By.id("searchButton")).click(); // clica na lupa

        //validar o título da página

        assertEquals("Ovo de Páscoa – Wikipédia, a enciclopédia livre", driver.getTitle());
        //assertTrue(driver.getTitle().contains("Wikipédia, a enciclopédia livre"));
    }
    @After   // depois do teste
    public void finalizar(){
        driver.quit();

    }
}
