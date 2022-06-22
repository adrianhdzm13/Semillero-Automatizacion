package semilleros;



import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import PagObjet.PagsObjetConfiguracionCuenta;
import PagObjet.PagsObjetLogin;
import PagObjet.PagsObjetDirecciònResidencia;
import io.appium.java_client.AppiumDriver;
import utilidadesExcel.ReadExcelFile;
import utilidadesExcel.WriteExcelFile;

public class runPrueba {

	//DEFINIENDO VARIABLES
	@SuppressWarnings("rawtypes")
	private AppiumDriver driver;
	Properties propiedades;
	ReadExcelFile leer;
	WriteExcelFile escribir;
	PagsObjetLogin pagLogin;
	PagsObjetConfiguracionCuenta pagConfiguracionCuenta;
	PagsObjetDirecciònResidencia pagDirecciònResidencia;
	ClasesBase clasebase;

	//METODO BEFORE
	@SuppressWarnings("unchecked")
	@Before
	public void setUp() throws IOException {

		propiedades = new Properties();
		leer = new ReadExcelFile();
		escribir = new WriteExcelFile();
		
		// CREAR VARIABLE TIPO INPUTSTRING
		InputStream entrada = null;
		
		// VALIDAR SI GENERA ERROR AL NO ENCONTRAR EL ARCHIVO
		try {
			entrada = new FileInputStream("./Properties/datos.properties");
			propiedades.load(entrada);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println(e);
		}
		// INSTANCIAMOS LAS PROPIEDADES
		driver = ClasesBase.appiumDriverConnetion(propiedades);
		pagLogin = new PagsObjetLogin(driver);
		pagConfiguracionCuenta = new PagsObjetConfiguracionCuenta(driver);
		pagDirecciònResidencia = new PagsObjetDirecciònResidencia(driver);
		
		clasebase = new ClasesBase(driver);
	}

	//HACEMOS EL PRIMER TEST 
	@Test
	public void pruebaToolsQa() throws Exception {
		if (leer.getCellValue(propiedades.getProperty("filePatchExcel"), "Login", 1, 0).equals("SI")) {
			// OBTENER EL NOMBRE DEL METODO A EJECUTAR
			String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();
			// CREAR CARPETA PARA ALMACENAMIENTO DE IMAGENES
			File rutaFile = pagLogin.crearCarpeta(propiedades, nomTest);
			pagLogin.IniciarSesion(leer, propiedades, "Login", nomTest, rutaFile);
			pagConfiguracionCuenta.configurarCuenta(leer, propiedades, "ConfCuenta", nomTest, rutaFile);
			pagDirecciònResidencia.DireccionResidencia(leer, propiedades, "Direccion", nomTest, rutaFile);
			pagLogin.CerrarSesion(leer, propiedades, "Login", nomTest, rutaFile);
			
		}else {
			System.out.println("Prueba no disponible");
		}
	}

	@After
	public void cerrar() {
		// CERRAR PROCESO
		driver.quit();
	}
}
