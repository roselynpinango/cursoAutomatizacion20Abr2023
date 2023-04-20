package pruebas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Utilidades.DatosExcel;
import paginas.PaginaInicio;
import paginas.PaginaLogin;

public class Clase8bTest {
	String url = "http://automationpractice.pl";
	String directorioDatos = "..\\EducacionIT-61770\\Datos\\";
	WebDriver driver;
	
	@BeforeSuite
	public void abrirNavegador() { // se suele llamar setUp()
		driver = new FirefoxDriver();
		driver.get(url);
		driver.manage().window().maximize();
	}
	
	@Test(dataProvider="Datos Excel")
	public void iniciarSesion(String email, String password) {
		PaginaInicio inicio = new PaginaInicio(driver);
		inicio.hacerClicEnSignIn();
		
		PaginaLogin login = new PaginaLogin(driver);
		login.escribirEmail(email);
		login.escribirPassword(password);
		login.hacerClicEnLogin();
		
		// Si inicia sesión, el botón Sign In ya no aparecerá
		// Entonces para resolverlo habría que validar si inició o no
		// En caso positivo, habría que hacer clic en Sign Out
	}
	
	@DataProvider(name="Datos Excel")
	public Object[][] obtenerDatosExcel() throws Exception {
		// Leer los datos que están en el archivo excel
		// y armar un arreglo de objetos con esos datos
		return DatosExcel.leerExcel(
				directorioDatos + "Datos_IniciarSesion.xlsx", 
				"Hoja1");
	}
	
	@DataProvider(name="Datos Login")
	public Object[][] obtenerDatos() {
		Object[][] datos = new Object[3][2];
		
		datos[0][0] = "abc@gmail.com"; // correo
		datos[0][1] = "4rt4ey5ew"; // contraseña
		
		datos[1][0] = "def@gmail.com";
		datos[1][1] = "5r4er4w";
		
		datos[2][0] = "ghi@gmail.com";
		datos[2][1] = "67ur5erwe";
		
		return datos;
	}
}
