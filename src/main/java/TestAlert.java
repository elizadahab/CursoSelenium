import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestAlert {
	@Test
	public void deveInteragirComAlertSimples() {

		WebDriver driver = new FirefoxDriver();

		// Posicao do browser:
		driver.manage().window().setSize(new Dimension(1200, 765));

		// Propriedade que vai me retornar o local exato onde o java esta rodando
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");

		// interage com o botao alert que vai clicar e abrir o modal alerta
		driver.findElement(By.id("alert")).click();

		// mudar o foco do driver atraves da alternancia de contexto
		Alert alert = driver.switchTo().alert();

		// Salva o texto na variável (get.Text) de fechar
		String texto = alert.getText();
		Assert.assertEquals("Alert Simples", texto);

		// Confirma/fecha a janela do alerta
		alert.accept();

		driver.findElement(By.id("elementosForm:nome")).sendKeys(texto);
		driver.quit();

	}

	@Test
	public void deveInteragirComAlertConfirm() {

		WebDriver driver = new FirefoxDriver();

		// Posicao do browser:
		driver.manage().window().setSize(new Dimension(1200, 765));

		// Propriedade que vai me retornar o local exato onde o java esta rodando
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");

		// interage com o botao alert que vai clicar e abrir o modal alerta
		driver.findElement(By.id("confirm")).click();

		// agora começa o controle de fluxos condicionais dentro da modal

		Alert alerta = driver.switchTo().alert();
		Assert.assertEquals("Confirm Simples", alerta.getText());
		// acept eh para aceitar uma ação
		alerta.accept();
		alerta = driver.switchTo().alert();
		Assert.assertEquals("Confirmado", alerta.getText());
		alerta.accept();

		driver.findElement(By.id("confirm")).click();
		alerta = driver.switchTo().alert();
		Assert.assertEquals("Confirm Simples", alerta.getText());
		// dismiss eh para simular o cancelamento da ação
		alerta.dismiss();
		alerta = driver.switchTo().alert();
		Assert.assertEquals("Negado", alerta.getText());
		alerta.dismiss();

		driver.quit();
	}

	@Test
	public void deveInteragirComAlertPrompt() {

		WebDriver driver = new FirefoxDriver();
		driver.manage().window().setSize(new Dimension(1200, 765));
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");

		driver.findElement(By.id("prompt")).click();
		Alert alerta = driver.switchTo().alert();
		Assert.assertEquals("Digite um numero", alerta.getText());

		alerta.sendKeys("12");
		alerta.accept();
		Assert.assertEquals("Era 12?", alerta.getText());
		alerta.accept();
		Assert.assertEquals(":D", alerta.getText());
		alerta.accept();
		driver.quit();
	}
}
