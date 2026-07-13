import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TesteFrames {
	
	@Test
	public void deveInteragirComFames() {
		WebDriver driver = new FirefoxDriver();

		// Posicao do browser:
		driver.manage().window().setSize(new Dimension(1200, 765));

		// Propriedade que vai me retornar o local exato onde o java esta rodando
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
	}

}


