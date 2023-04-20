package pruebas;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Clase8Test {
	String url = "https://demoqa.com/alerts";
	WebDriver driver;
	
	@BeforeSuite
	public void abrirNavegador() {
		driver = new FirefoxDriver();
		driver.get(url);
		driver.manage().window().maximize();
	}
	
	@Test
	public void alertaNotificacion() {
		driver.findElement(By.id("alertButton")).click();
		
		Alert alerta = driver.switchTo().alert();
		
		System.out.println("Texto de la Alerta: " + alerta.getText());
		alerta.accept(); // Clic en Aceptar/OK/Si		
	}
	
	@Test
	public void alertaConDemora() {
		driver.findElement(By.xpath("//button[@id='timerAlertButton']")).click();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.alertIsPresent());
		
		Alert alerta = driver.switchTo().alert();
		alerta.accept();
	}
	
	@Test
	public void alertaConfirmacion() {
		driver.findElement(By.cssSelector("#confirmButton")).click();
		
		driver.switchTo().alert().dismiss(); // Clic en Cancelar/No
	}
	
	@Test
	public void alertaPrompt() {
		driver.findElement(By.id("promtButton")).click();
		
		Alert alerta = driver.switchTo().alert();
		alerta.sendKeys("Clase de Automatizacion");
		alerta.accept();
	}
	
	@AfterSuite
	public void cerrarNavegador() {
		driver.close();
	}
}
