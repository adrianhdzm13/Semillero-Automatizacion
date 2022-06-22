package PagObjet;

import java.io.File;
import java.util.Properties;
import MapsObjet.MapsObjetLogin;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import utilidadesExcel.ReadExcelFile;

public class PagsObjetLogin extends MapsObjetLogin {

	// CREAR CONSTRUCTOR DE LA CLASE
	public PagsObjetLogin(AppiumDriver<MobileElement> driver) {
		super(driver);
		this.driver = driver;
	}

	// METODO INICIAL
	public void urlAcceso(String url) {
		driver.get(url);
	}

	// METODO BUSQUEDA DEL INDEX
	public void IniciarSesion(ReadExcelFile leer, Properties propiedades, String numHoja, String nomTest, File rutaFile)
			throws Exception {

		tiempoEspera(2000);
		click(btnIngresarAUsuarioYContraseña, rutaFile);
		click(btnCorreoElectronico, rutaFile);
		sendKey(leer.getCellValue(propiedades.getProperty("filePatchExcel"), numHoja, 1, 1), txtCorreoElectronico,
				rutaFile);
		sendKey(leer.getCellValue(propiedades.getProperty("filePatchExcel"), numHoja, 1, 2), txtContraseña, rutaFile);
		click(btnIniciarSesion, rutaFile);
		click(btnCancelar, rutaFile);
		
		//if (elementoPresente(Ventana3dispositivos) == true) {
		click(btnRadioButton, rutaFile);
		click(btnContinuar, rutaFile);
		click(btnAceptar, rutaFile);
	//	}
	
		click(btnPerfil, rutaFile);
	}
	
	public void CerrarSesion(ReadExcelFile leer, Properties propiedades, String numHoja, String nomTest, File rutaFile)
			throws Exception {

		tiempoEspera(2000);
		click(btnPerfil, rutaFile);
		click(btnCerrarSesion, rutaFile);
		click(btnAceptarCerrarSesion, rutaFile);
	}
}
