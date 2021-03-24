package steps;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class Hooks extends Base{
    private Base base;

    public Hooks (Base base){
        this.base = base;
    }
    @Before
    public void setup(){ // iniciar
        System.setProperty("webdriver.chrome.driver","drivers/chrome/88/chromedriver.exe");
        base.driver = new ChromeDriver(); // Instanciando o Selenium como Chrome
        base.driver.manage().window().maximize(); // maximizar a janela do navegador
        base.driver.manage().timeouts().implicitlyWait(60000, TimeUnit.MILLISECONDS);
        System.out.println("Passo 0 - Instanciou o Selenium");
    }
    @After
    public void tearDown(){ //finalizar
        base.driver.quit();
        System.out.println("Passo 4 - Finalizou o Selenium");
    }


}
