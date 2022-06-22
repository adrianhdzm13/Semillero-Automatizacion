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

import PagObjet.PagObjetAlerts;
import PagObjet.PagObjetElements;
import PagObjet.PagObjetInicio;
import PagObjet.PagObjetWidgets;
import utilidadesExcel.ReadExcelFile;
import utilidadesExcel.WriteExcelFile;

public class RunPrueba {

	private WebDriver driver;

	Properties propiedades;
	ReadExcelFile leer;
	WriteExcelFile escribir;
	ClaseBase claseBase;
	String nomTest = null;
	File rutaCarpeta = null;
	PagObjetInicio inicio;
	PagObjetElements elements;
	PagObjetWidgets widgets;
	PagObjetAlerts alerts;

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
			entrada = new FileInputStream("./Properties/datos.properties");
			propiedades.load(entrada);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println(e);
		}
		// INSTANCIA DE CLASES
		driver = ClaseBase.appiumDriverConnetion(propiedades);
		inicio = new PagObjetInicio(driver);
		elements = new PagObjetElements(driver);
		widgets =  new PagObjetWidgets(driver);
		claseBase = new ClaseBase(driver);
		alerts = new PagObjetAlerts(driver);

	}// fin metodo setUP()

	@Test

	public void testInicio() throws Exception {

		// CASO ELEMENTS
		if (leer.getCellValue(propiedades.getProperty("filePathExcel"), "elements", 1, 0).equals("si")) {
			// OBTENER EL NOMBRE DEL METODO A EJECUTAR
			nomTest = "casoPruebaElements";
			// CREAR CARPETA PARA LAMCENAR IMAGENES
			rutaCarpeta = inicio.crearCarpeta(propiedades, nomTest);

			// INICIO PAGINA PRINCIPAL
			inicio.inicio(leer, propiedades, nomTest, rutaCarpeta);
			//
			elements.casoElements(leer, propiedades, nomTest, rutaCarpeta);

		} else {
			System.out.println("No me va a ejecutar :(");
		}
		// CASO WIDGETS 
		if (leer.getCellValue(propiedades.getProperty("filePathExcel"), "casoWidgets", 1, 0).equals("si")) {
			// OBTENER EL NOMBRE DEL METODO A EJECUTAR
			nomTest = "casoWidgets";
			// CREAR CARPETA PARA LAMCENAR IMAGENES
			rutaCarpeta = inicio.crearCarpeta(propiedades, nomTest);

			// INICIO PAGINA PRINCIPAL
			inicio.inicio(leer, propiedades, nomTest, rutaCarpeta);
			//
			widgets.casoWidgets(leer, propiedades, nomTest, rutaCarpeta);

		} else {
			System.out.println("No me va a ejecutar :(");
		}
		
		// CASO Alerts
				if (leer.getCellValue(propiedades.getProperty("filePathExcel"), "casoAlerts", 1, 0).equals("si")) {
					// OBTENER EL NOMBRE DEL METODO A EJECUTAR
					nomTest = "casoAlerts";
					// CREAR CARPETA PARA LAMCENAR IMAGENES
					rutaCarpeta = inicio.crearCarpeta(propiedades, nomTest);

					// INICIO PAGINA PRINCIPAL
					inicio.inicio(leer, propiedades, nomTest, rutaCarpeta);
					//
					alerts.casoAlerts(leer, propiedades, nomTest, rutaCarpeta);

				} else {
					System.out.println("No me va a ejecutar :(");
				}


	}

	@After
	public void cerrar() {
		// CIERRA EL PROCESO
		driver.quit();
	}

}
