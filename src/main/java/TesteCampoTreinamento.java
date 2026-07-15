import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class TesteCampoTreinamento {

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
	public void testeTextField() {

		// Aqui diz para o selenium qual elemento eu quero interagir
		driver.findElement(By.id("elementosForm:nome")).sendKeys("Teste de escrita");

		// Pega o que foi escrito no campo pedido
		Assert.assertEquals("Teste de escrita", driver.findElement(By.id("elementosForm:nome")).getAttribute("value"));
	}

	@Test
	public void deveInteragirComTextArea() {

		// Aqui diz para o selenium qual elemento eu quero interagir com quebra de linha
		driver.findElement(By.id("elementosForm:sugestoes")).sendKeys("Teste\n\n\ndhfghfgh\nUltima linha");

		// Pega o que foi escrito no campo pedido
		Assert.assertEquals("Teste\n\n\ndhfghfgh\nUltima linha",
				driver.findElement(By.id("elementosForm:sugestoes")).getAttribute("value"));
	}

	@Test
	public void deveInteragirComRadioButton() {

		// Aqui diz para o selenium qual elemento eu quero interagir e clicar nele
		driver.findElement(By.id("elementosForm:sexo:0")).click();

		// verifica se realmente o elemento esta clicado - vai retornar um boleano entao
		// sera feito dentro de um assertTrue
		Assert.assertTrue(driver.findElement(By.id("elementosForm:sexo:0")).isSelected());
	}

	@Test
	public void deveInteragirComCheckbox() {

		// Aqui diz para o selenium qual elemento eu quero interagir e clicar nele
		driver.findElement(By.id("elementosForm:comidaFavorita:2")).click();

		// verifica se realmente o elemento esta clicado - vai retornar um boleano entao
		// sera feito dentro de um assertTrue
		Assert.assertTrue(driver.findElement(By.id("elementosForm:comidaFavorita:2")).isSelected());
	}

	@Test
	public void deveInteragirComCombo() {

		inicializa();

		// Encontra o elemento Web
		WebElement element = driver.findElement(By.id("elementosForm:escolaridade"));

		// Seleciona o elemento web
		Select combo = new Select(element);

		// Seleciona o elemento web desejado por index - lembrando que comeca por 0
//		combo.selectByIndex(2);

		// Seleciona o elemento web pelo valor real dele
//		combo.selectByValue("superior");

		// Seleciona o elemento web pelo valor exibido para o usuario;
		combo.selectByVisibleText("2o grau completo");

		// Para verificar o primeiro valor que esta selecionado
		Assert.assertEquals("2o grau completo", combo.getFirstSelectedOption().getText());
	}

	@Test
	public void deveVerificarValoresCombo() {
		// Encontra o elemento Web
		WebElement element = driver.findElement(By.id("elementosForm:escolaridade"));

		// Seleciona o elemento web
		Select combo = new Select(element);

		// GetOptions retorna uma lista de webElements
		List<WebElement> options = combo.getOptions();

		// quantidade de opcoes que ele possui
		Assert.assertEquals(8, options.size());

		boolean encontrou = false;
		for (WebElement option : options) {
			if (option.getText().equals("Mestrado")) {
				encontrou = true;
				break;
			}
		}
		Assert.assertTrue(encontrou);
	}

	@Test
	public void deveVerificarValoresComboMultiplo() {

		// Encontra o elemento Web ( o web element eh o retorno do findElement)
		WebElement element = driver.findElement(By.id("elementosForm:esportes"));

		// Seleciona o elemento web
		Select combo = new Select(element);

		// seleciona os elementos especificos descritos
		combo.selectByVisibleText("Natacao");
		combo.selectByVisibleText("Corrida");
		combo.selectByVisibleText("O que eh esporte?");

		// confirma a quantidade especifica que foi selecionada no combo
		List<WebElement> allSelectedOptions = combo.getAllSelectedOptions();
		Assert.assertEquals(3, allSelectedOptions.size());

		// desmarca uma opção do combo
		combo.deselectByVisibleText("Corrida");
		allSelectedOptions = combo.getAllSelectedOptions();
		Assert.assertEquals(2, allSelectedOptions.size());
	}

	@Test
	public void deveInteragirComBotoes() {

		// clica no determinado botao
//		driver.findElement(By.id("buttonSimple")).click();

		// clica no botao e confirma o webelement(ou seja, que é mesmo aquele botao que
		// ele quer) dele
		WebElement botao = driver.findElement(By.id("buttonSimple"));
		botao.click();

		Assert.assertEquals("Obrigado!", botao.getAttribute("value"));
	}

	@Test
	// @Ignore //diz pro junit - ignore este teste
	public void deveInteragirComLinks() {

		// inspecionar links
		driver.findElement(By.linkText("Voltar")).click();

		// obriga o testa a falhar
		// Assert.fail();

		Assert.assertEquals("Voltou!", driver.findElement(By.id("resultado")).getText());
	}

	@Test
	public void deveBuscarTextosNaPagina() {

		// procura o elemento por sua propriedade
		// Assert.assertEquals("Campo de Treinamento",
		// driver.findElement(By.tagName("h3")).getText());

		// procura o primeiro elemento que aparecer na tela, por isso deve sempre
		// encontrar uma forma mais especifica
		Assert.assertEquals("Cuidado onde clica, muitas armadilhas...",
				driver.findElement(By.className("facilAchar")).getText());
	}

}
