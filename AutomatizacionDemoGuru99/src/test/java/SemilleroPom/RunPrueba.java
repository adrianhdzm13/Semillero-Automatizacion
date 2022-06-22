package SemilleroPom;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import PagObjet.PagObjetHome;
import PagObjet.PagObjetRegister;
import utilidadesExcel.ReadExcelFile;
import utilidadesExcel.WriteExcelFile;

public class RunPrueba {

	private WebDriver driver;

	PagObjetRegister register;
	PagObjetHome home;
	Properties propiedades;
	ReadExcelFile leer;
	WriteExcelFile escribir;
	String url = null;
	ClaseBase claseBase;

	@Before
	public void setUP() throws IOException {

		driver = ClaseBase.chromeDriverConnetion();
		home = new PagObjetHome(driver);
		register = new PagObjetRegister(driver);
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

	@Test
	public void casoRegister() throws Exception {

		if (leer.getCellValue(propiedades.getProperty("filePathExcel"), "caso2", 1, 0).equals("si")) {

			// OBTENER EL NOMBRE DEL METODO A EJECUTAR
			String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();

			// CREAR CARPETA PARA LAMCENAR IMAGENES
			File rutaCarpeta = home.crearCarpeta(propiedades, nomTest);

			// ACCEDER AL METODO DE ABRIR PAGINA
			home.urlAcceso(leer.getCellValue(propiedades.getProperty("filePathExcel"), "caso2", 1, 1));
			home.casoHome(leer, propiedades, nomTest, rutaCarpeta);
			register.casoRegister(leer, propiedades, nomTest, rutaCarpeta);
			
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
