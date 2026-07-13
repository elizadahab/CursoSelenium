import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TesteCadastro {

	@Test
	public void testeNome() {
		WebDriver driver = new FirefoxDriver();
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		driver.findElement(By.id("elementosForm:nome")).sendKeys("Elizabeth");
		Assert.assertEquals("Elizabeth", driver.findElement(By.id("elementosForm:nome")).getAttribute("value"));
		// driver.quit();
	}

	@Test
	public void testeSobrenome() {
		WebDriver driver = new FirefoxDriver();
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("Dahab");
		Assert.assertEquals("Dahab", driver.findElement(By.id("elementosForm:nome")).getAttribute("value"));
		// driver.quit();
	}

	@Test
	public void testSexo() {

		WebDriver driver = new FirefoxDriver();
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		driver.findElement(By.id("elementosForm:sexo:1")).click();
		Assert.assertTrue(driver.findElement(By.id("elementosForm:sexo:1")).isSelected());
		// driver.quit();
	}

	@Test
	public void testComidaFavorita() {

		WebDriver driver = new FirefoxDriver();
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		driver.findElement(By.id("elementosForm:comidaFavorita:2")).click();
		Assert.assertTrue(driver.findElement(By.id("elementosForm:comidaFavorita:2")).isSelected());
		//driver.quit();
	}
	
	@Test
	
}
