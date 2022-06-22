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


import PagObjet.PagObjetInicio;

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

	@Before
	public void setUP() throws IOException {

		driver = ClaseBase.appiumDriverConnetion();

		// instancia de las clases PagObjet
		inicio = new PagObjetInicio(driver);
		

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

	}// fin metodo setUP()

	@Test

	public void casoElements() throws Exception {

		//caso 1	
			// OBTENER EL NOMBRE DEL METODO A EJECUTAR
			nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();

			// CREAR CARPETA PARA LAMCENAR IMAGENES
			rutaCarpeta = inicio.crearCarpeta(propiedades, nomTest);

			// ACCEDER AL METODO DE ABRIR PAGINA
			//inicio.urlAcceso(leer.getCellValue(propiedades.getProperty("filePathExcel"), "inicio", 1, 0));

			inicio.inicio(leer, propiedades, nomTest, rutaCarpeta);
	
	}
	

	@After
	public void cerrar() {
		// CIERRA EL PROCESO
		driver.quit();
	}

}
