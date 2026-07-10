import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Dimension;
//import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TesteGoogle {

	@Test
	public void teste() {
		WebDriver driver = new FirefoxDriver();
		//WebDriver driver = new ChromeDriver();

		driver.get("http://www.google.com");

		//Tamanho do browser - nao funciona no firefox:
		//driver.manage().window().setPosition(new Point(100,100)); 
		
		//Posicao do browser:
		driver.manage().window().setSize(new Dimension(1200, 765));
		
		//Para o browser aparecer maximizado:	    
		//driver.manage().window().maximize();

		Assert.assertEquals("Google", driver.getTitle());

		// Teste de Falha
		// Assert.assertEquals("Yahoo", driver.getTitle());

		// Fecha apenas uma aba do browser;
		//driver.close();

		// Fechando o browser e mata a instancia do driver
		driver.quit();

	}
}
