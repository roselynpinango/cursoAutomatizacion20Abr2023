package Edit.EducacionIT_61770;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Clase6Test {
	String url = "http://automationpractice.pl/index.php";
	WebDriver driver;
	
	@Parameters("navegador")
	@BeforeTest
	public void abrirNavegador(String navegador) {
		if (navegador.equalsIgnoreCase("CHROME")) {
			driver = new ChromeDriver();
		} else if (navegador.equalsIgnoreCase("EDGE")) { 
			driver = new EdgeDriver();
		} else if (navegador.equalsIgnoreCase("FIREFOX")) {
			driver = new FirefoxDriver();
		}
				
		driver.get(url);
		driver.manage().window().maximize();
	}
	
	@Test
	public void buscarPalabra() {
		WebElement txtBuscador = driver.findElement(By.id("search_query_top"));
		txtBuscador.sendKeys("dress");
		
		txtBuscador.sendKeys(Keys.ENTER);
	}
}
