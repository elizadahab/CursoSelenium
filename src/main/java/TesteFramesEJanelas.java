import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class TesteFramesEJanelas {
private WebDriver driver;
	
	@Before
	public void inicializa() {
		driver = new FirefoxDriver();
		driver.manage().window().setSize(new Dimension(1200, 765));
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
	}
	
	@After
	public void finaliza() {
		driver.quit();
	}
	
	@Test
	public void deveInteragirComFames() {
		//o objetivo é pegar o botao Frame OK! e escrever ele no campo nome
		
		//como tem varios frames ao colocar o switchTo eu peço para ele focar no frame1 e clicar nele
		driver.switchTo().frame("frame1");
		driver.findElement(By.id("frameButton")).click();
		
		//aqui eu pego a mensagem(msg) do alerta
		Alert alert = driver.switchTo().alert();
		String msg = alert.getText();
		Assert.assertEquals("Frame OK!", msg);
		alert.accept();
		
		//eu troco o foco para a pagina principal (.defaultContent)
		driver.switchTo().defaultContent();
		//e escrevo neste campo a mensagem(msg) do alerta
		driver.findElement(By.id("elementosForm:nome")).sendKeys(msg);
	}
	
	@Test
	public void deveInteragirComJanelas() {
			
		driver.findElement(By.id("buttonPopUpEasy")).click();
		driver.switchTo().window("Popup");
		driver.findElement(By.tagName("textarea")).sendKeys("Deu certo?");
	}
	
	@Test
	public void deveInteragirComJanelasSemTitulo() {
		
		driver.findElement(By.id("buttonPopUpHard")).click();
		//estrutura generica de todas as janelas o windowhandle
		//aqui ele esta pedindo o windowhandle principal
		System.out.println(driver.getWindowHandle());
		//no segundo ele pega todas as pops q tem na pagina, os numero é a identificacao de cada uma
		System.out.println(driver.getWindowHandles());
		//aqui eu pego o segundo pop por seu id que é o que eu quero e foco nele 
		driver.switchTo().window((String)driver.getWindowHandles().toArray()[1]);
		driver.findElement(By.tagName("textarea")).sendKeys("Deus certo?");
		
		//aqui volta pra principal
		driver.switchTo().window((String)driver.getWindowHandles().toArray()[0]);
		driver.findElement(By.tagName("textarea")).sendKeys("E agora?");	
	}
	
}


