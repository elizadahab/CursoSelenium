import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class TesteCadastro {

	@Test
	public void testeCadastrar() {
		WebDriver driver = new FirefoxDriver();
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		
		driver.findElement(By.id("elementosForm:nome")).sendKeys("Elizabeth");
		driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("Dahab");
		driver.findElement(By.id("elementosForm:sexo:1")).click();
		driver.findElement(By.id("elementosForm:comidaFavorita:2")).click();
		new Select(driver.findElement(By.id("elementosForm:escolaridade"))).selectByVisibleText("Mestrado");
		new Select(driver.findElement(By.id("elementosForm:esportes"))).selectByVisibleText("Corrida");
		driver.findElement(By.id("elementosForm:sugestoes")).sendKeys("Eu faço crossfit!");
		driver.findElement(By.id("elementosForm:cadastrar")).click();
		
		// confirma que os elementos foram cadastrados
		Assert.assertTrue(driver.findElement(By.id("resultado")).getText().startsWith("Cadastrado!"));
		Assert.assertTrue(driver.findElement(By.id("descNome")).getText().endsWith("Elizabeth"));
		Assert.assertTrue(driver.findElement(By.id("descSobrenome")).getText().endsWith("Dahab"));
		Assert.assertTrue(driver.findElement(By.id("descSexo")).getText().endsWith("Feminino"));
		Assert.assertTrue(driver.findElement(By.id("descComida")).getText().endsWith("Pizza"));
		Assert.assertEquals("Escolaridade: mestrado", driver.findElement(By.id("descEscolaridade")).getText());
		Assert.assertEquals("Esportes: Corrida", driver.findElement(By.id("descEsportes")).getText());
		Assert.assertEquals("Sugestoes: Eu faço crossfit!", driver.findElement(By.id("descSugestoes")).getText());
		
		driver.quit();
	}
}