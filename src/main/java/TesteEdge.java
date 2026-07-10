import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;


public class TesteEdge {

	@Test
	public void teste() {
		// Aponta para onde esta o driver do edge - precisei fazer localmente 
		System.setProperty("webdriver.edge.driver", "C:\\Users\\elizabeth.dahab\\Downloads\\edgedriver_win64\\msedgedriver.exe");
	
		WebDriver driver = new EdgeDriver();

		driver.get("http://www.google.com");
		
		driver.manage().window().setSize(new Dimension(1200, 765));

		Assert.assertEquals("Google", driver.getTitle());

		driver.quit();
	}
}