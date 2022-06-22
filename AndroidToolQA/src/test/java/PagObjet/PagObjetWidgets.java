package PagObjet;


import io.appium.java_client.android.AndroidDriver;
import java.io.File;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import MapObjet.MapObjetInicio;
import MapObjet.MapObjetWidgets;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import utilidadesExcel.ReadExcelFile;

public class PagObjetWidgets extends MapObjetWidgets {

	// CONSTRUCCTOR DE LA CLASE
	@SuppressWarnings("unchecked")
	public PagObjetWidgets(WebDriver driver) {
		super(driver);
		this.driver = (AppiumDriver<MobileElement>) driver;
	}

	@SuppressWarnings("rawtypes")
	public void casoWidgets(ReadExcelFile leer, Properties propiedades, String nomHoja, File rutaCarpeta)
			throws InterruptedException, IOException, Exception {

		

		scrollVertical(rutaCarpeta, 529, 2008, 448, 2);
		click(widgets, rutaCarpeta);
		scrollVertical(rutaCarpeta, 494, 1098, 2040, 3);
		click(datePicker, rutaCarpeta);
		
		
		sendKey(leer.getCellValue(propiedades.getProperty("filePathExcel"), "casoWidgets", 1, 1), fecha, rutaCarpeta);
		sendKey(leer.getCellValue(propiedades.getProperty("filePathExcel"), "casoWidgets", 1, 2), dateTime, rutaCarpeta);
		click(blanco, rutaCarpeta);
		tiempoEspera(2);

	}

}
