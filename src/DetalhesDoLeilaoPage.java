import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DetalhesDoLeilaoPage {

    private WebDriver driver;

    public DetalhesDoLeilaoPage(WebDriver driver) {
        this.driver = driver;
    }

    public void lance(String usuario, double valor) {
        WebElement txtValor = driver.findElement(By.name("lance.valor"));					//Acha
        WebElement combo = driver.findElement(By.name("lance.usuario.id"));
        Select cbUsuario = new Select(combo);

        cbUsuario.selectByVisibleText(usuario);												//Preenche
        txtValor.sendKeys(String.valueOf(valor));
        
        driver.findElement(By.id("btnDarLance")).click();									//Finaliza clicando

    }
    public boolean existeLance(String usuario, double valor) {								
    	Boolean temUsuario =																// variavel temUsuario espera retorno de true o false se vai existir um id em ate 10 segndos
                new WebDriverWait(driver, 10)
                    .until(ExpectedConditions
                    .textToBePresentInElement(By.id("lancesDados"), usuario));

        if(temUsuario) return driver.getPageSource().contains(String.valueOf(valor));		//se existe, faz a validacao e retorna true, se nao false
        return false;
    }

}