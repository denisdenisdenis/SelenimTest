import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class UsuariosSystemTest {
    private ChromeDriver driver;									//crio atributo ChromeDriver do tipo driver q vai ter sempre
	private UsuariosPage usuarios;									// crio atributo uauarios do tipo usuariosPage q vai ter sempre
	
	@Before
	public void incicioaliza(){
		System.setProperty("webdriver.chrome.driver","/Users/deniscarvalho/Documents/Desenv/chromedriver");
		this.driver = new ChromeDriver();							//instanciou um atribto nesse metodo 
	    //driver.get("http://localhost:8080/usuarios/new");			//informou url
		this.usuarios = new UsuariosPage(driver); 					//Instancio no atributo dessa classe um objeto de nome usuarios do tipo UsuariosPage.
	}
	
	
	@Test
    public void deveAdicionarUmUsuario() {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);								//Sem isso, da uma exception de elemento nao encontrado na pagina. 
        
		usuarios.visita();																				// Invocamos a URL da pagina atravez de um metodo q tem na classe dessa pagina.
		usuarios.novo().cadastra("Ronaldo Luiz de Albuquerque", "ronaldo2009@terra.com.br");			// com o atributo usuarios podemos invocar o metodo novo, q por sua vez devolve um obejto do tipo NovoUsuarioPage qe podemos invocar o metodo cadastra

        assertTrue(usuarios.existeNaListagem("Ronaldo Luiz de Albuquerque", "ronaldo2009@terra.com.br"));   

    }

	@After
	public void finaliza(){
		driver.close();
	}
}