//Essa classe se trata da pagina UsuariosPage e seus metodos tem haver com as acoes e possibilidades de envolvimento com esta pagina




import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

class UsuariosPage {

    private WebDriver driver;
    public UsuariosPage(WebDriver driver) {							//Construtor eh o Metodo com o nome da classe q exige receber um objeto
        this.driver = driver;										//recebemos o objeto driver do tipo webdriver e atribuimos o valor dele no atributo desta classe
    }

    public void visita() {
        driver.get("localhost:8080/usuarios");
    }

    public NovoUsuarioPage novo() {										//Esse metodo se trata de clicar em m link da pagina usuariosPage.
        // clica no link de novo usuario								//Pela razao do link abrir uma nova pagina, e cada pagina tem sua propria classe, devemos retornar invocando esta classe
        driver.findElement(By.linkText("Novo Usuário")).click();		//devido a classe de NovosarioPage ter um construtor q recebe driver, passamos o nosso driver.
        return new NovoUsuarioPage(driver);
    }

    public boolean existeNaListagem(String nome, String email) {
        // verifica se ambos existem na listagem
        return driver.getPageSource().contains(nome) && 
                driver.getPageSource().contains(email);
    }

}