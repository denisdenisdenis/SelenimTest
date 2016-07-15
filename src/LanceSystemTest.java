import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LanceSystemTest {

    private WebDriver driver;
    private LeiloesPage leiloes;

    @Before
    public void inicializa() {
		System.setProperty("webdriver.chrome.driver","/Users/deniscarvalho/Documents/Desenv/chromedriver");
		this.driver = new ChromeDriver();	

        driver.get("http://localhost:8080/apenas-teste/limpa"); 								//URL programada para limpar o banco e comecar os teste do zero

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); //nem falo nada
        
        UsuariosPage usuarios = new UsuariosPage(driver);										//para lances necessario ter usuarios
        usuarios.visita();
        usuarios.novo().cadastra("Paulo Henrique", "paulo@henrique.com");
        usuarios.novo().cadastra("José Alberto", "jose@alberto.com");

        leiloes = new LeiloesPage(driver);														// para lances necessario ter leiloes
        leiloes.visita();
        leiloes.novo().preenche("Geladeira", 100, "Paulo Henrique", false);
    }

    @Test
    public void deveFazerUmLance() {

        DetalhesDoLeilaoPage lances = leiloes.detalhes(1);

        lances.lance("José Alberto", 150);

        assertTrue(lances.existeLance("José Alberto", 150));
    }

}