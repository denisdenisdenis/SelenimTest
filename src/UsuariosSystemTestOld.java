import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class UsuariosSystemTestOld {
    private ChromeDriver driver;									//crio atributo ChromeDriver do tipo driver
	
	
	@Before
	public void incicioaliza(){
		System.setProperty("webdriver.chrome.driver","/Users/deniscarvalho/Documents/Desenv/chromedriver");
		this.driver = new ChromeDriver();							//instanciou um atribto nesse metodo 
	    driver.get("http://localhost:8080/usuarios/new");				//informou url
	}
	
	
	
	@Test
    public void deveAdicionarUmUsuario() {								// para usar o @test do junit o metodo nao pode ser main
 

        WebElement nome = driver.findElement(By.name("usuario.nome"));	//achou elemento usuario e jogou na variavel nome
        WebElement email = driver.findElement(By.name("usuario.email"));//achou elemento email e jogou na variavel email

        nome.sendKeys("Ronaldo Luiz de Albuquerque");					//mandou escrever a string na variavel nome
        email.sendKeys("ronaldo2009@terra.com.br");						//mandou escrever a string na variavel email	
        //nome.submit();												//opcional... tipo um enter
        WebElement botaoSalvar = driver.findElement(By.id("btnSalvar"));// salva na variavel botaosalvar o objeto da tela do id btnSalvar tranformando ele no tipo webElement
        botaoSalvar.click();											// tipo webElement eh possivel chamar o metodo clicar. entao clica no botao

        boolean achouNome = driver.getPageSource()						//tento achar a string no codigo fonte e gardar a resposta na variavel achonome
            .contains("Ronaldo Luiz de Albuquerque");					//tento achar a string no codigo fonte e gardar a resposta na variavel achoemail
        boolean achouEmail = driver.getPageSource()
            .contains("ronaldo2009@terra.com.br");

        assertTrue(achouNome);											//usou os asserts nas variaveis booleanas para validar o teste no junit
        assertTrue(achouEmail);

    }

	@After
	public void finaliza(){
		driver.close();
	}
}