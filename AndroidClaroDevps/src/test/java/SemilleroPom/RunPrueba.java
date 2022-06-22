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

import PagObjet.PagObjetActualizarDireccion;
import PagObjet.PagObjetLogin;
import PagObjet.PagObjetPagoPse;
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
	PagObjetLogin inicio;
	PagObjetActualizarDireccion direccion;
	PagObjetPagoPse pago;


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
		inicio = new PagObjetLogin(driver);
		direccion = new PagObjetActualizarDireccion(driver);
		pago = new PagObjetPagoPse(driver);

	}// fin metodo setUP()

	@Test
	public void actualizarDireccion() throws Exception {	
		if (leer.getCellValue(propiedades.getProperty("filePathExcel"), "ActualizarDireccion", 1, 0).equals("si")) {
			// OBTENER EL NOMBRE DEL METODO A EJECUTAR
			String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();
			// CREAR CARPETA PARA LAMCENAR IMAGENES
			rutaCarpeta = inicio.crearCarpeta(propiedades, nomTest);
	        // INICIO PAGINA PRINCIPAL
			inicio.login(leer, propiedades, nomTest, rutaCarpeta);
		    direccion.actualizarDatos(leer, propiedades, nomTest, rutaCarpeta);
		    inicio.cerrarSesion(leer, propiedades, nomTest, rutaCarpeta);    
		} else {
			System.out.println("No ejecutar");
		}
		//CASO PAGOPSE
		if (leer.getCellValue(propiedades.getProperty("filePathExcel"), "PagoPSE", 1, 0).equals("si")) {
			// OBTENER EL NOMBRE DEL METODO A EJECUTAR
			String nomTest = "pagoPSE";
			// CREAR CARPETA PARA LAMCENAR IMAGENES
			rutaCarpeta = inicio.crearCarpeta(propiedades, nomTest);
	        // INICIO PAGINA PRINCIPAL
			inicio.login(leer, propiedades, nomTest, rutaCarpeta);
		    pago.pagoPSE(leer, propiedades, nomTest, rutaCarpeta);
		    inicio.cerrarSesionPago(leer, propiedades, nomTest, rutaCarpeta);    
		} else {
			System.out.println("No ejecutar");
		}
		
	}
	

	@After
	public void cerrar() {
		// CIERRA EL PROCESO
		driver.quit();
	}

}
