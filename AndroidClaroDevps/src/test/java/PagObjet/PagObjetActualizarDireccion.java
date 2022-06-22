package PagObjet;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

import MapObjet.MapObjetActualizarDireccion;
import MapObjet.MapObjetLogin;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import utilidadesExcel.ReadExcelFile;

public class PagObjetActualizarDireccion extends MapObjetActualizarDireccion {

	// CONSTRUCCTOR DE LA CLASE
	@SuppressWarnings("unchecked")
	public PagObjetActualizarDireccion(WebDriver driver) {
		super(driver);
		this.driver = (AppiumDriver<MobileElement>) driver;
	}
	
	public void actualizarDatos(ReadExcelFile leer, Properties propiedades, String nomHoja, File rutaCarpeta)
			throws InterruptedException, IOException, Exception {

		click(btnPerfil, rutaCarpeta);
		openWindow();
		click(confiCuenta, rutaCarpeta);
		click(actualizarDatos, rutaCarpeta);
		click(clickNumCelular, rutaCarpeta);
		tiempoEspera(4);

		click(clickDireccion, rutaCarpeta);
		tiempoEspera(5);
		//DATOS LISTAS
		click(clicList, rutaCarpeta);
		openWindow();
		selectionListAndroid2(complet, leer.getCellValue(propiedades.getProperty("filePathExcel"), "ActualizarDireccion", 1, 1), rutaCarpeta);
		click(clicListCiudad, rutaCarpeta);
		openWindow();
		selectionListAndroid2(complet,leer.getCellValue(propiedades.getProperty("filePathExcel"), "ActualizarDireccion", 1, 2), rutaCarpeta);
		sendKey(leer.getCellValue(propiedades.getProperty("filePathExcel"), "ActualizarDireccion", 1, 3), txtBarrio, rutaCarpeta);
		tiempoEspera(2);
		click(clicTipoCalle, rutaCarpeta);
		openWindow();
		selectionListAndroid2(complet,leer.getCellValue(propiedades.getProperty("filePathExcel"), "ActualizarDireccion", 1, 4), rutaCarpeta);
		sendKey(leer.getCellValue(propiedades.getProperty("filePathExcel"), "ActualizarDireccion", 1, 5), txtNumero, rutaCarpeta);
		click(clicSufijo, rutaCarpeta);
		openWindow();
		selectionListAndroid2(complet,leer.getCellValue(propiedades.getProperty("filePathExcel"), "ActualizarDireccion", 1, 6), rutaCarpeta);
		scrollVertical(rutaCarpeta, 455, 1076, 476, 1);
		tiempoEspera(2);
		sendKey(leer.getCellValue(propiedades.getProperty("filePathExcel"), "ActualizarDireccion", 1, 7), txtNumeroSecundario, rutaCarpeta);
		click(clicSufijo2, rutaCarpeta);
		openWindow();
		selectionListAndroid2(complet,leer.getCellValue(propiedades.getProperty("filePathExcel"), "ActualizarDireccion", 1, 8), rutaCarpeta);
		sendKey(leer.getCellValue(propiedades.getProperty("filePathExcel"), "ActualizarDireccion", 1, 9), txtNumeroComponente, rutaCarpeta);
		scrollVertical(rutaCarpeta, 455, 1076, 476, 1);
		click(clicComplemento, rutaCarpeta);
		openWindow();
		selectionListAndroid2(complet,leer.getCellValue(propiedades.getProperty("filePathExcel"), "ActualizarDireccion", 1, 10), rutaCarpeta);
		sendKey(leer.getCellValue(propiedades.getProperty("filePathExcel"), "ActualizarDireccion", 1, 11), txtNumeroComplemento, rutaCarpeta);
		tabAndroid();
		click(clicComplemento2, rutaCarpeta);
		openWindow();
		selectionListAndroid2(complet,leer.getCellValue(propiedades.getProperty("filePathExcel"), "ActualizarDireccion", 1, 12), rutaCarpeta);
		sendKey(leer.getCellValue(propiedades.getProperty("filePathExcel"), "ActualizarDireccion", 1, 13), txtNumeroComplemento2, rutaCarpeta);
	
		//VALIDAR
		click(btnAgregar, rutaCarpeta);
		openWindow();
		click(btnCancelar, rutaCarpeta);
		tiempoEspera(1);
	}


}
