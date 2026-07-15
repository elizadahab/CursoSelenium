import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class TesteCadastro {
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
	public void deveRealizarCadastroComSucesso() {
		
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
	}

	@Test
	public void deveValidarNome() {
		driver.findElement(By.id("elementosForm:cadastrar")).click();
		Alert alert = driver.switchTo().alert();
		Assert.assertEquals("Nome eh obrigatorio", alert.getText());
	}

	@Test
	public void deveValidarSobrenome() {
		driver.findElement(By.id("elementosForm:nome")).sendKeys("Elizabeth");
		driver.findElement(By.id("elementosForm:cadastrar")).click();
		Alert alert = driver.switchTo().alert();
		Assert.assertEquals("Sobrenome eh obrigatorio", alert.getText());
	}

	@Test
	public void deveValidarSexo() {
		driver.findElement(By.id("elementosForm:nome")).sendKeys("Elizabeth");
		driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("Dahab");
		driver.findElement(By.id("elementosForm:cadastrar")).click();
		Alert alert = driver.switchTo().alert();
		Assert.assertEquals("Sexo eh obrigatorio", alert.getText());
	}

	@Test
	public void deveValidarQualSuaComidaFavorita() {
		driver.findElement(By.id("elementosForm:nome")).sendKeys("Elizabeth");
		driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("Dahab");
		driver.findElement(By.id("elementosForm:sexo:1")).click();
		driver.findElement(By.id("elementosForm:comidaFavorita:0")).click();
		driver.findElement(By.id("elementosForm:comidaFavorita:3")).click();
		driver.findElement(By.id("elementosForm:cadastrar")).click();
		Alert alert = driver.switchTo().alert();
		Assert.assertEquals("Tem certeza que voce eh vegetariano?", alert.getText());
	}

	@Test
	public void deveValidarPraticaEsporte() {
		driver.findElement(By.id("elementosForm:nome")).sendKeys("Elizabeth");
		driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("Dahab");
		driver.findElement(By.id("elementosForm:sexo:1")).click();
		driver.findElement(By.id("elementosForm:comidaFavorita:0")).click();
		Select combo = new Select(driver.findElement(By.id("elementosForm:esportes")));
		combo.selectByVisibleText("Corrida");
		combo.selectByVisibleText("O que eh esporte?");
		driver.findElement(By.id("elementosForm:cadastrar")).click();
		Alert alert = driver.switchTo().alert();
		Assert.assertEquals("Voce faz esporte ou nao?", alert.getText());
	}

}
