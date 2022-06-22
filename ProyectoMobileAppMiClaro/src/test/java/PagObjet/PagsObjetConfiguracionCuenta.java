package PagObjet;

import java.io.File;
import java.util.Properties;

import MapsObjet.MapsObjetConfiguracionCuenta;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import utilidadesExcel.ReadExcelFile;

public class PagsObjetConfiguracionCuenta extends MapsObjetConfiguracionCuenta {

	// CREAR CONSTRUCTOR DE LA CLASE
	public PagsObjetConfiguracionCuenta(AppiumDriver<MobileElement> driver) {
		super(driver);
		this.driver = driver;
	}

	// METODO BUSQUEDA DEL INDEX
	public void configurarCuenta(ReadExcelFile leer, Properties propiedades, String numHoja, String nomTest,
			File rutaFile) throws Exception {
		click(btnConfiguracionDeCuentas, rutaFile);
		click(btnActualizarDatos, rutaFile);
		click(btnNumeroCelular, rutaFile);

	}
}
