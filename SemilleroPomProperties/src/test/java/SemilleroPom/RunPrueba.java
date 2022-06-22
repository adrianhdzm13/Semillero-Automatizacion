package SemilleroPom;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import utilidadesExcel.ReadExcelFile;
import utilidadesExcel.WriteExcelFile;

public class RunPrueba {

	private WebDriver driver;
	PagsObjetInicio paginas;
	Properties propiedades;
	ReadExcelFile leer;
	WriteExcelFile escribir;

	@Before
	public void setUP() throws IOException {

		// INSTANCIAR LA CLASE PROPIEDADES DE JAVA UTIL
		propiedades = new Properties();

		// INSTANCIAR LAS CLASE DE EXCEL
		leer = new ReadExcelFile();
		escribir = new WriteExcelFile();

		// CERRAR VARIABLE TIPO INPUTSTRING
		InputStream entrada = null;

		// VALIDAR SI GENERA ERROR AL NO ENCONTRAR EL ARCHIVO
		try {
			entrada = new FileInputStream("./src/test/resources/Properties/datos.properties");
			propiedades.load(entrada);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println(e);
		}

		// INSTANCIA LA CLASE PAGSOBJET
		paginas = new PagsObjetInicio(driver);

		// ASIGNAMOS LAS OPCIONES Y LAS CONFIGURACIONES DEL NAVEGADORDOR A LA VARIABLE
		// DRIVER
		driver = paginas.chromeDriverConnection();

		// ACCEDER AL METODO DE ABRIR PAGINA
		paginas.urlAcceso(propiedades.getProperty("url"));

	}// fin metodo setUP()

	@Test
	public void test() throws Exception {

		// ACCEDER AL METODO DE PRUEBA INICIAL
		paginas.busquedaInicial(leer, propiedades);
	}

	@After
	public void cerrar() {
		// CIERRA EL PROCESO
		driver.quit();
	}
}
