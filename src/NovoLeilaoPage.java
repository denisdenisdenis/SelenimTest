import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class NovoLeilaoPage {

    private WebDriver driver;

    public NovoLeilaoPage(WebDriver driver) {
        this.driver = driver;
    }

    public void preenche(String nome, double valor, String usuario, boolean usado) {

        WebElement txtNome = driver.findElement(By.name("leilao.nome"));
        WebElement txtValor = driver.findElement(By.name("leilao.valorInicial"));

        txtNome.sendKeys(nome);
        txtValor.sendKeys(String.valueOf(valor));

        WebElement combo = driver.findElement(By.name("leilao.usuario.id"));				//gravo na variavel combo o elemento da pagina q eh um combo
        Select cbUsuario = new Select(combo);												// crio uma variavel cbUsuario do tipo select  q consege ler os valores do combo
        cbUsuario.selectByVisibleText(usuario);												// essa variavel consegue usar um metodo q acha os elementos do combo baseado no paramentro usuario

        if(usado) {																			// se a variavel tiver sido passada no metodo como parametro execta as linhas abaixo
            WebElement ckUsado = driver.findElement(By.name("leilao.usado"));				// 
            ckUsado.click();
        }

        txtNome.submit();
    }

}