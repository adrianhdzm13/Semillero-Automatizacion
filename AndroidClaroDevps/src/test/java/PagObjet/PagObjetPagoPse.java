package PagObjet;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

import MapObjet.MapObjetLogin;
import MapObjet.MapObjetPagoPse;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import utilidadesExcel.ReadExcelFile;

public class PagObjetPagoPse extends MapObjetPagoPse {

	// CONSTRUCCTOR DE LA CLASE
	@SuppressWarnings("unchecked")
	public PagObjetPagoPse(WebDriver driver) {
		super(driver);
		this.driver = (AppiumDriver<MobileElement>) driver;
	}
	
	public void pagoPSE(ReadExcelFile leer, Properties propiedades, String nomHoja, File rutaCarpeta)
			throws InterruptedException, IOException, Exception {

		//PAGO	
		click(btnInicioPago, rutaCarpeta);
		tiempoEspera(4);
		click(btnPagarAqui, rutaCarpeta);
		openWindow();
		click(btnPagar, rutaCarpeta);
		tiempoEspera(4);
		
		//SELECCIONAR MEDIO DE PAGO
		scrollVertical(rutaCarpeta, 496, 1101, 390, 1);
		click(clickLista, rutaCarpeta);
		openWindow();
		selectionListAndroid2(complet, leer.getCellValue(propiedades.getProperty("filePathExcel"), "PagoPSE", 1, 1), rutaCarpeta);
		tiempoEspera(1);
		click(btnContinuar, rutaCarpeta);
		tiempoEspera(5);
		
		//BANCO
		scrollVertical(rutaCarpeta, 484, 1436, 635, 1);
		click(clickListaBanco, rutaCarpeta);
		openWindow();
		selectionListAndroid2(lisBanco,leer.getCellValue(propiedades.getProperty("filePathExcel"), "PagoPSE", 1, 2), rutaCarpeta);
		sendKey(leer.getCellValue(propiedades.getProperty("filePathExcel"), "PagoPSE", 1, 3), txtNombreTitular, rutaCarpeta);
		tiempoEspera(1);
		scrollVertical(rutaCarpeta, 484, 1436, 635, 1);
		click(clickListaTipoClie, rutaCarpeta);
		openWindow();
		selectionListAndroid2(complet2, leer.getCellValue(propiedades.getProperty("filePathExcel"), "PagoPSE", 1, 4), rutaCarpeta);
		click(clickTipoDocumneto, rutaCarpeta);
		openWindow();
		selectionListAndroid2(complet2, leer.getCellValue(propiedades.getProperty("filePathExcel"), "PagoPSE", 1, 5), rutaCarpeta);
		scrollVertical(rutaCarpeta, 484, 1436, 635, 1);
		sendKey(leer.getCellValue(propiedades.getProperty("filePathExcel"), "PagoPSE", 1, 6), txtNumDocument, rutaCarpeta);
		sendKey(leer.getCellValue(propiedades.getProperty("filePathExcel"), "PagoPSE", 1, 7), txtNumTel, rutaCarpeta);
		tiempoEspera(2);
		sendKey(leer.getCellValue(propiedades.getProperty("filePathExcel"), "PagoPSE", 1, 8), txtDireccio, rutaCarpeta);
		sendKey(leer.getCellValue(propiedades.getProperty("filePathExcel"), "PagoPSE", 1, 9), txtEmail, rutaCarpeta);
		tiempoEspera(2);
		
		//CANCELAR
		click(btnCancelar, rutaCarpeta);
		tiempoEspera(2);
		
	}

	

}
