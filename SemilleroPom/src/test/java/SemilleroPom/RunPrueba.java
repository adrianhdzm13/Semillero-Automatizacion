package SemilleroPom;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class RunPrueba {
	private WebDriver driver;
	PagsObjetInicio paginas;

	@Before
	public void setUP() {
		// INSTANCIA LA CLASE PAGSOBJET
		paginas = new PagsObjetInicio(driver);

		// ASIGNAMOS LAS OPCIONES Y LAS CONFIGURACIONES DEL NAVEGADORDOR A LA VARIABLE
		// DRIVER
		driver = paginas.chromeDriverConnection();

		// ACCEDER AL METODO DE ABRIR PAGINA
		paginas.urlAcceso("https://google.com");
	}

	@Test
	public void test() throws Exception {
		// ACCEDER AL METODO DE PRUEBA INICIAL
		paginas.busquedaInicial();
	}

	@After
	public void cerrar() {
		// CIERRA EL PROCESO
		driver.quit();
	}
}
