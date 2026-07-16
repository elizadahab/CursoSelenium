import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DSL {

	private WebDriver driver;

	public DSL(WebDriver driver) {
		this.driver = driver;
	}

	/**************** TextField e TextArea ******************/

	// metodo que encontra pelo id e escreve no campo
	public void escrever(By by, String texto) {
		driver.findElement(by).sendKeys(texto);
	}

	public void escrever(String id_campo, String texto) {
		escrever(By.id(id_campo), texto);
	}

	// metodo que encontra pelo id e retorna o valor do id
	public String obterValorCampo(String id_campo) {
		return driver.findElement(By.id(id_campo)).getAttribute("value");
	}

	/**************** Radio e Check ******************/

	public void clicarRadio(String id) {
		driver.findElement(By.id(id)).click(); // serve para escolher uma única opção exclusiva dentro de um grupo
	}

	public boolean isRadioMarcado(String id) {
		return driver.findElement(By.id(id)).isSelected(); // verifica se realmente o elemento esta clicado
	}

	public boolean isCheckMarcado(String id) {
		return driver.findElement(By.id(id)).isSelected(); // verifica se realmente o elemento esta clicado
	}

	/**************** Combo ******************/

	public void selecionarCombo(String id, String valor) {
		WebElement element = driver.findElement(By.id(id));
		Select combo = new Select(element);
		combo.selectByVisibleText(valor);
	}

	public void deselecionarCombo(String id, String valor) {
		WebElement element = driver.findElement(By.id(id));
		Select combo = new Select(element);
		combo.deselectByVisibleText(valor);
	}

	public String obterValorCombo(String id) {
		WebElement element = driver.findElement(By.id(id));
		Select combo = new Select(element);
		return combo.getFirstSelectedOption().getText();
	}

	public List<String> obterValoresCombo(String id) {
		WebElement element = driver.findElement(By.id(id));
		Select combo = new Select(element);
		List<WebElement> allSelectedOptions = combo.getAllSelectedOptions();
		// converto tudo para uma lista de string, pegando o webelement e o getText
		List<String> valores = new ArrayList<String>();
		for (WebElement opcao : allSelectedOptions) {
			valores.add(opcao.getText());
		}
		return valores;
	}

	public int obterQuantidadeOpcoesCombo(String id) {
		WebElement element = driver.findElement(By.id(id));
		Select combo = new Select(element);
		List<WebElement> options = combo.getOptions();
		return options.size();
	}

	public boolean verificarOpcaoCombo(String id, String opcao) {
		WebElement element = driver.findElement(By.id(id));
		Select combo = new Select(element);
		List<WebElement> options = combo.getOptions();
		for (WebElement option : options) {
			if (option.getText().equals(opcao)) {
				return true;
			}
		}
		return false;
	}
	
	/**************** Botao ******************/
	
	public void clicarBotao(String id) {
		driver.findElement(By.id(id)).click();
	}
	
	public String obterValueCampo(String id_campo) {
		return driver.findElement(By.id(id_campo)).getAttribute("value");
	}
	
	/**************** Link ******************/

	public void clicarLink(String id) {
		driver.findElement(By.linkText(id)).click();
	}

	/**************** Textos ******************/
	
	public String obterTexto(By by) {
		return driver.findElement(by).getText();
	}

	public String obterTexto(String id) {
		return obterTexto(By.id(id));
	}
	
	/**************** Alerts ******************/

	
}
