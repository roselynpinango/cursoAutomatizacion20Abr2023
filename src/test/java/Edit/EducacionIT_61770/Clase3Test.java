package Edit.EducacionIT_61770;

import org.testng.annotations.Test;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Clase3Test {
	// Variables
	String url = "http://automationpractice.pl/index.php";
	
	// Métodos de prueba @Test
	@Test
	public void registrarUsuario() {
		// Acciones de la prueba
		// 1) Indicar qué navegador vamos a utilizar
		WebDriver driver = new EdgeDriver();
		
		// 2) Abrir el navegador en la url a probar
		driver.navigate().to(url); // Es igual a driver.get(url);
		
		// 3) Maximizar el navegador
		driver.manage().window().maximize();
		
		// 4) Borrar las cookies
		driver.manage().deleteAllCookies();
		
		// 5) Hacer clic en 'Sign in'
		WebElement lnkSignIn = driver.findElement(By.partialLinkText("Sign"));
		lnkSignIn.click();
		
		// Espera
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("email_create")));
		
		// 6) Escribir el correo y hacer clic en el botón
		String email = "correo" + Math.random() + "@gmail.com"; 
		
		WebElement txtEmail = driver.findElement(By.name("email_create"));
		txtEmail.sendKeys(email);
		
		WebElement btnCreate = driver.findElement(By.cssSelector("#SubmitCreate"));
		btnCreate.click();
		
		// Espera
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(By.id("id_gender1")));
		
		// 7) Completar el formulario
		WebElement radTitle = driver.findElement(By.id("id_gender1"));
		radTitle.click();
		
		WebElement txtFirstname = driver.findElement(By.xpath("//input[@id='customer_firstname']"));
		txtFirstname.sendKeys("Arturo");
		
		WebElement txtLastname = driver.findElement(By.cssSelector("#customer_lastname"));
		txtLastname.sendKeys("Jimenez");
		
		WebElement txtEmailInterno = driver.findElement(By.id("email"));
		txtEmailInterno.clear(); // Blanqueamos el valor del campo
		txtEmailInterno.sendKeys("correo29032023@gmail.com");
		
		WebElement txtPassword = driver.findElement(By.name("passwd"));
		txtPassword.sendKeys("1q2w3e4r5t");
		
		Select days = new Select(driver.findElement(By.id("days")));
		days.selectByValue("18");
		
		Select months = new Select(driver.findElement(By.name("months")));
		months.selectByVisibleText("June ");
		
		Select years = new Select(driver.findElement(By.xpath("//select[@id='years']")));
		years.selectByIndex(30);
		
		WebElement chkNewsletter = driver.findElement(By.id("newsletter"));
		chkNewsletter.click();
		
		WebElement chkOffers = driver.findElement(By.xpath("//input[@id='optin']"));
		chkOffers.click();
		
		// 8) Hacer clic en el botón 'Register'
		WebElement btnRegister = driver.findElement(By.cssSelector("#submitAccount"));
		btnRegister.click();
	}
}
