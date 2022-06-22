package PagObjet;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

import MapObjet.MapObjetInicio;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import utilidadesExcel.ReadExcelFile;

public class PagObjetInicio extends MapObjetInicio {

	// CONSTRUCCTOR DE LA CLASE
	@SuppressWarnings("unchecked")
	public PagObjetInicio(WebDriver driver) {
		super(driver);
		this.driver = (AppiumDriver<MobileElement>) driver;
	}

	public void inicio(ReadExcelFile leer, Properties propiedades, String nomHoja, File rutaCarpeta)
			throws InterruptedException, IOException, Exception {
		
		//tiempoEspera(6000);
		sendKey(leer.getCellValue(propiedades.getProperty("filePathExcel"), "inicio", 1, 0), actionBuscar, rutaCarpeta);
		tiempoEspera(2000);
		click(actionBuscar, rutaCarpeta);
		tiempoEspera(2000);
		scrollVertical(rutaCarpeta);
		tiempoEspera(2000);
	}

}
