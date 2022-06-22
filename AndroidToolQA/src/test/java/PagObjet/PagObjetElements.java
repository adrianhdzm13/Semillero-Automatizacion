package PagObjet;

import java.io.File;
import java.io.IOException;

import java.util.Properties;


import org.openqa.selenium.WebDriver;

import MapObjet.MapObjetElements;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import utilidadesExcel.ReadExcelFile;

public class PagObjetElements extends MapObjetElements {

	// CONSTRUCCTOR DE LA CLASE
	@SuppressWarnings("unchecked")
	public PagObjetElements(WebDriver driver) {
		super(driver);
		this.driver = (AppiumDriver<MobileElement>) driver;
	}

	public void casoElements(ReadExcelFile leer, Properties propiedades, String nomHoja, File rutaCarpeta)
			throws InterruptedException, IOException, Exception {

		// ELEMENTS
		click(selectElements, rutaCarpeta);
		scrollVertical(rutaCarpeta, 505, 332, 1800, 2);
		click(webTables, rutaCarpeta);
		tiempoEspera(2);
		
		  
		
			

		//BTN ADD
		clickSwitchTo(btnAdd, rutaCarpeta);
		tocarPantalla2(173, 639);
		write(rutaCarpeta, leer.getCellValue(propiedades.getProperty("filePathExcel"), "elements", 1, 1));
		tabAndroid();
		write(rutaCarpeta, leer.getCellValue(propiedades.getProperty("filePathExcel"), "elements", 1, 2));
		tabAndroid();
		write(rutaCarpeta, leer.getCellValue(propiedades.getProperty("filePathExcel"), "elements", 1, 3));
		tabAndroid();
		writeInt(rutaCarpeta, leer.getCellValueInt(propiedades.getProperty("filePathExcel"), "elements", 1, 4));
		tabAndroid();
		writeInt(rutaCarpeta, leer.getCellValueInt(propiedades.getProperty("filePathExcel"), "elements", 1, 5));
		tabAndroid();
		write(rutaCarpeta, leer.getCellValue(propiedades.getProperty("filePathExcel"), "elements", 1, 6));
		enterFlechaVerdeAndroid();
		
		//BUSCAR
		scrollVertical(rutaCarpeta, 459, 268, 2000, 4);
		
		click(buscar, rutaCarpeta);
		write(rutaCarpeta, leer.getCellValue(propiedades.getProperty("filePathExcel"), "elements", 1, 7));
		//sendKey(leer.getCellValue(propiedades.getProperty("filePathExcel"), "elements", 1, 7), buscar, rutaCarpeta);
		//enterFlechaVerdeAndroid();
		tocarPantalla2(501,1172);  
		scrollHorizontal(rutaCarpeta, 896, 999, 116, 1);
		click(borrar, rutaCarpeta);
		tiempoEspera(2);
		
		
	

	}

}
