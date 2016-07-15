import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LeilaoSystemTest {

    private WebDriver driver;
    private LeiloesPage leiloes;

    @Before
    public void inicializa() {
		System.setProperty("webdriver.chrome.driver","/Users/deniscarvalho/Documents/Desenv/chromedriver");
		this.driver = new ChromeDriver();	
		
        leiloes = new LeiloesPage(driver);
        
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); //nem falo nada
        
        UsuariosPage usuarios = new UsuariosPage(driver);
        usuarios.visita();
        usuarios.novo().cadastra("Paulo Henrique", "paulo@henrique.com");
    }

    @Test
    public void deveCadastrarUmLeilao() {

        leiloes.visita();
        NovoLeilaoPage novoLeilao = leiloes.novo();
        novoLeilao.preenche("Geladeira", 123, "Paulo Henrique", true);

        //leiloes.novo().preenche("Geladeira", 123, "Paulo Henrique", true);  					// entender a diferenca dessa linha pras duas linhas de cima. da no mesmo.
        
        
        assertTrue(leiloes.existe("Geladeira", 123, "Paulo Henrique", true));

    }
    @After
    public void encerra(){
    	driver.close();
    }
}