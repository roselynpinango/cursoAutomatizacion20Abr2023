package Edit.EducacionIT_61770;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Utilidades.CapturaEvidencia;

public class Clase5Test {
	String url = "http://automationpractice.pl/index.php";
	WebDriver driver;
	String rutaEvidencias = "..\\EducacionIT61770\\Evidencias\\";
	String nombreDocumento = "Evidencias-AutomationPractice.docx";
	File screen;
	
	@BeforeSuite
	public void abrirNavegador() {
		driver = new EdgeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		
		System.out.println("Before Suite");
	}
	
	@BeforeTest
	public void beforeTest() {
		System.out.println("	Before Test");
	}
	
	@Test(priority=200, description="CP02 Ir a Contactanos en AutomationPractice")
	public void irAContactanos() throws InvalidFormatException, IOException, InterruptedException {
		// Captura de Evidencia 
		CapturaEvidencia.escribirTituloEnDocumento(rutaEvidencias + nombreDocumento, "Documento de Evidencias - AutomationPractice", 18);
		CapturaEvidencia.capturarPantallaEnDocumento(driver, rutaEvidencias + "img.jpg", rutaEvidencias + nombreDocumento, "1 - Pantalla Principal");
		
		// Hacer clic en Contact us
		WebElement lnkContact = driver.findElement(By.linkText("Contact us"));
		lnkContact.click();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(0));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
		
		// Captura de Evidencia 
		CapturaEvidencia.capturarPantallaEnDocumento(driver, rutaEvidencias + "img.jpg", rutaEvidencias + nombreDocumento, "2 - Después de hacer clic en Contact us");
		
		// Completar el formulario
		Select lista = new Select(driver.findElement(By.cssSelector("#id_contact")));
		lista.selectByVisibleText("Webmaster");
		
		WebElement txtEmail = driver.findElement(By.id("email"));
		txtEmail.sendKeys("correo@gmail.com");
		
		WebElement txtOrder = driver.findElement(By.name("id_order"));
		txtOrder.sendKeys("ABC123");
		
		WebElement filAttached = driver.findElement(By.xpath("//input[@id='fileUpload']"));
		filAttached.sendKeys("C:\\addIntegerData.txt");
		
		WebElement txtMessage = driver.findElement(By.tagName("textarea"));
		txtMessage.sendKeys("Comentario del Formulario");
		
		// Captura de Evidencia 
		CapturaEvidencia.capturarPantallaEnDocumento(driver, rutaEvidencias + "img.jpg", rutaEvidencias + nombreDocumento, "3 - Luego de completar el formulario");
		
		// Hacer clic en Send
		WebElement btnSend = driver.findElement(By.id("submitMessage"));
		btnSend.click();
		
		// Captura de Evidencia 
		CapturaEvidencia.capturarPantallaEnDocumento(driver, rutaEvidencias + "img.jpg", rutaEvidencias + nombreDocumento, "4 - Al enviar el formulario");
	}
	
	@Test(priority=100, description="CP01 Hacer Busqueda en AutomationPractice")
	public void hacerBusqueda() throws IOException {
		// Captura de Evidencia
		screen = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screen, new File(rutaEvidencias + "01_pantallaInicial.jpg"));
		
		WebElement txtBusqueda = driver.findElement(By.id("search_query_top"));
		txtBusqueda.sendKeys("dress");
		
		// Captura de Evidencia
		screen = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screen, new File(rutaEvidencias + "02_palabraABuscar.jpg"));
		
		WebElement btnBuscar = driver.findElement(By.name("submit_search"));
		btnBuscar.click();
		
		// Captura de Evidencia
		screen = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screen, new File(rutaEvidencias + "03_resultadoBusqueda.jpg"));
		
		String tituloEsperado = "Search - My Store";
		String tituloActual = driver.getTitle();
		
		String urlEsperada = "http://automationpractice.pl/index.php?controller=search&orderby=position&orderway=desc&search_query=dress&submit_search=";
		String urlActual = driver.getCurrentUrl();
		
		Assert.assertEquals(tituloActual, tituloEsperado);
		Assert.assertEquals(urlActual, urlEsperada);
		
		// Otras Comprobaciones
		Assert.assertNotEquals("A", "B"); // Comprueba que no sean iguales
		Assert.assertTrue(true); // Comprueba que la condicion sea verdadera
		Assert.assertFalse(false); // Comprueba que la condidion sea falsa
		Assert.assertNull(null); // Comprueba que el valor sea nulo
		Assert.assertNotNull(urlActual); // Comprueba que el valor no sea nulo
	}
	
	@AfterTest
	public void afterTest() {
		System.out.println("	After Test");
	}
	
	@AfterSuite
	public void cerrarNavegador() {
		driver.close();
		
		System.out.println("After Suite");
	}
}
