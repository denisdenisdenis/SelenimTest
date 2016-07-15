import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

class NovoUsuarioPage {

    private WebDriver driver;
    												//para usarmos o driver da classe Systemtest, precisamos passalo pra ca.
    public NovoUsuarioPage(WebDriver driver) {		// criamos um construtor q exige receber um objeto driver do tipo webdriver de qem invocalo
        this.driver = driver;						// e fazemos nossa classe ter um atribto driver do tipo webdriver qe atribuimos o valor do objeto recebido pelo contrutor. 
    }

    public void cadastra(String nome, String email) {								//metodo recebe dois parametros
        
    	WebElement txtNome = driver.findElement(By.name("usuario.nome"));			//procuramos um elemento na tela e gravamos em uma variavel
        WebElement txtEmail = driver.findElement(By.name("usuario.email"));

        txtNome.sendKeys(nome);														//no objeto dessa variavel mandamos escrever o valor q recebemos como parametro no metodo
        txtEmail.sendKeys(email);

        txtNome.submit();

    }

}