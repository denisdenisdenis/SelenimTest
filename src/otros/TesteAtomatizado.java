package otros;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TesteAtomatizado {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver","/Users/deniscarvalho/Documents/Desenv/chromedriver");
		WebDriver driver = new ChromeDriver();

		//WebDriver driver = new FirefoxDriver();
		
		driver.get("http://www.google.com.br/");
		WebElement campoDeTexto = driver.findElement(By.name("q"));
		campoDeTexto.sendKeys("Denis");
		campoDeTexto.submit();
	}
}
