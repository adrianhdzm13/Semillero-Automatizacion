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

import PagObjet.PagObjetInicioMercadoLibre;
import PagObjet.PagsObjetInicio;
import utilidadesExcel.ReadExcelFile;
import utilidadesExcel.WriteExcelFile;

public class RunPrueba {

	private WebDriver driver;
	PagsObjetInicio paginas;
	PagObjetInicioMercadoLibre merLibre;
	Properties propiedades;
	ReadExcelFile leer;
	WriteExcelFile escribir;
	String url = null;
	ClaseBase claseBase;

	@Before
	public void setUP() throws IOException {

		// INSTANCIAR LA CLASE PROPIEDADES DE JAVA UTIL
		propiedades = new Properties();

		// INSTANCIAR LAS CLASE DE EXCEL
		leer = new ReadExcelFile();
		escribir = new WriteExcelFile();

		// C VARIABLE TIPO INPUTSTRING
		InputStream entrada = null;

		// VALIDAR SI GENERA ERROR AL NO ENCONTRAR EL ARCHIVO
		try {
			entrada = new FileInputStream("./src/test/resources/Properties/datos.properties");
			propiedades.load(entrada);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println(e);
		}

	}// fin metodo setUP()

	@Test // CASO # 1
	public void test() throws Exception {

		if (leer.getCellValue(propiedades.getProperty("filePathExcel"), "busqueda", 1, 0).equals("si")) {

			// INSTANCIA LA CLASE PAGSOBJET
			paginas = new PagsObjetInicio(driver);

			driver = paginas.chromeDriverConnection();

			// ACCEDER AL METODO DE ABRIR PAGINA
			paginas.urlAcceso(propiedades.getProperty("url"));
			// ACCEDER AL METODO DE PRUEBA INICIAL
			paginas.busquedaInicial(leer, propiedades);

		} else {
			System.out.println("No me quieres ejecutar :( ");
		}

	}

	@Test // CASO 2
	public void mercadoLibre() throws Exception {

		if (leer.getCellValue(propiedades.getProperty("filePathExcel"), "caso2", 1, 0).equals("si")) {

			// OBTENER EL NOMBRE DEL METODO A EJECUTAR
			String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();
			
			// INSTANCIA LA CLASE PagObjetInicioMercadoLibre
			merLibre = new PagObjetInicioMercadoLibre(driver);

			driver = merLibre.chromeDriverConnection();
			// asigna la url, este valor está en la hoja caso3 del excel
			url = leer.getCellValue(propiedades.getProperty("filePathExcel"), "caso2", 1, 1);
			// ACCEDER AL METODO DE ABRIR PAGINA
			merLibre.urlAcceso(url);
			// ACCEDER AL METODO busquedaMercadoLibre3
			merLibre.busquedaMercadoLibre(leer, propiedades,nomTest);
		} else {
			System.out.println("No");
		}
	}

	@After
	public void cerrar() {
		// CIERRA EL PROCESO
		driver.quit();
	}
}
