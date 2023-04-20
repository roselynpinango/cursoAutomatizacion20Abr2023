package Edit.EducacionIT_61770;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Clase2Test {
	// Variables de uso común
	String url = "http://automationpractice.pl/index.php";
	
	// Métodos de Prueba @Test
	@Test
	public void buscarPalabraEnFirefox() {
		// Acciones propias del método de prueba
		// 1) Configurando el navegador Chrome
		WebDriver navegador = new FirefoxDriver();  
		
		// 2) Abrir el navegador en la página donde haremos la prueba
		navegador.get(url);
		
		// 3) Escribir la palabra a buscar en el campo de búsqueda
		WebElement txtBusqueda = navegador.findElement(By.id("search_query_top"));
		txtBusqueda.sendKeys("dress");
		
		// 4) Hacer la búsqueda (presionando Enter o clic en el botón)
		txtBusqueda.sendKeys(Keys.ENTER);
		
		// 5) Cerrar el navegador
		
	}
	
	@Test
	public void buscarPalabraEnEdge() {
		// Acciones propias del método de prueba
		// 1) Configurando el navegador Chrome
		WebDriver navegador = new EdgeDriver();  
		
		// 2) Abrir el navegador en la página donde haremos la prueba
		navegador.get(url);
		
		// 3) Escribir la palabra a buscar en el campo de búsqueda
		WebElement txtBusqueda = navegador.findElement(By.id("search_query_top"));
		txtBusqueda.sendKeys("dress");
		
		// 4) Hacer la búsqueda (presionando Enter o clic en el botón)
		txtBusqueda.sendKeys(Keys.ENTER);
		
		// 5) Cerrar el navegador
		navegador.close();
	}
	
	@Test
	public void buscarPalabraEnChrome() {
		// Acciones propias del método de prueba
		// 1) Configurando el navegador Chrome
		WebDriver navegador = new ChromeDriver();  
		
		// 2) Abrir el navegador en la página donde haremos la prueba
		navegador.get(url);
		
		// 3) Escribir la palabra a buscar en el campo de búsqueda
		WebElement txtBusqueda = navegador.findElement(By.id("search_query_top"));
		txtBusqueda.sendKeys("dress");
		
		// 4) Hacer la búsqueda (presionando Enter o clic en el botón)
		txtBusqueda.sendKeys(Keys.ENTER);
		
		// 5) Cerrar el navegador
		
	}
}
