package pruebas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import paginas.PaginaInicio;
import paginas.PaginaLogin;

public class Clase7Test {
	String url = "http://automationpractice.pl";
	WebDriver driver;
	
	@BeforeSuite
	public void abrirNavegador() { // se suele llamar setUp()
		driver = new FirefoxDriver();
		driver.get(url);
		driver.manage().window().maximize();
	}
	
	@Test
	public void iniciarSesion() {
		PaginaInicio inicio = new PaginaInicio(driver);
		inicio.hacerClicEnSignIn();
		
		PaginaLogin login = new PaginaLogin(driver);
		login.escribirEmail("correo@gmail.com");
		login.escribirPassword("1q2w3e4r5t");
		login.hacerClicEnLogin();
	}
	
	@Test
	public void buscarPalabra() {
		PaginaInicio inicio = new PaginaInicio(driver);
		inicio.escribirPalabraABuscar("dress");
		inicio.hacerClicEnBuscar();
	}
	
	@AfterSuite
	public void cerrarNavegador() { // se suele llamar tearDown()
		//driver.close();
	}
}
