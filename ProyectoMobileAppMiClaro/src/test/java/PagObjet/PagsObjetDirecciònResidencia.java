package PagObjet;

import java.io.File;
import java.util.Properties;
import MapsObjet.MapsObjetDireccionResidencia;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import utilidadesExcel.ReadExcelFile;

public class PagsObjetDirecciònResidencia extends MapsObjetDireccionResidencia {

	// CREAR CONSTRUCTOR DE LA CLASE
	public PagsObjetDirecciònResidencia(AppiumDriver<MobileElement> driver) {
		super(driver);
		this.driver = driver;
	}

	// METODO BUSQUEDA DEL INDEX
	public void DireccionResidencia(ReadExcelFile leer, Properties propiedades, String numHoja, String nomTest,
			File rutaFile) throws Exception {

		click(btnLapizDireccion, rutaFile);
		tiempoEspera(2000);
		click(btnDepartamento, rutaFile);
		tiempoEspera(2000);
		selectClaro(leer.getCellValue(propiedades.getProperty("filePatchExcel"), numHoja, 1, 1), rutaFile);
		tiempoEspera(2000);
		click(btnCiudad, rutaFile);
		selectClaro(leer.getCellValue(propiedades.getProperty("filePatchExcel"), numHoja, 1, 2), rutaFile);
		sendKey(leer.getCellValue(propiedades.getProperty("filePatchExcel"), numHoja, 1, 3), txtBarrio, rutaFile);
		click(btnTipo, rutaFile);
		selectClaro(leer.getCellValue(propiedades.getProperty("filePatchExcel"), numHoja, 1, 4), rutaFile);
		sendKey(leer.getCellValue(propiedades.getProperty("filePatchExcel"), numHoja, 1, 5), txtNPrincipal, rutaFile);
		click(btnSufijo, rutaFile);
		selectClaro(leer.getCellValue(propiedades.getProperty("filePatchExcel"), numHoja, 1, 6), rutaFile);
		sendKey(leer.getCellValue(propiedades.getProperty("filePatchExcel"), numHoja, 1, 7), txtNSecundario, rutaFile);
		sendKey(leer.getCellValue(propiedades.getProperty("filePatchExcel"), numHoja, 1, 8), txtNComp, rutaFile);
		click(btnComplemento, rutaFile);
		selectClaro(leer.getCellValue(propiedades.getProperty("filePatchExcel"), numHoja, 1, 9), rutaFile);
		sendKey(leer.getCellValue(propiedades.getProperty("filePatchExcel"), numHoja, 1, 10), txtNumero, rutaFile);
		click(btnCancelar, rutaFile);
		click(btnDevolver, rutaFile);
		click(btnDevolver, rutaFile);
		click(btnDevolver, rutaFile);
		
		

	}
}
