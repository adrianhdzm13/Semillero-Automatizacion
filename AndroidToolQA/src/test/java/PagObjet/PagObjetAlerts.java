package PagObjet;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

import MapObjet.MapObjetAlerts;
import MapObjet.MapObjetElements;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import utilidadesExcel.ReadExcelFile;

public class PagObjetAlerts extends MapObjetAlerts {

	// CONSTRUCCTOR DE LA CLASE
	@SuppressWarnings("unchecked")
	public PagObjetAlerts(WebDriver driver) {
		super(driver);
		this.driver = (AppiumDriver<MobileElement>) driver;
	}

	public void casoAlerts(ReadExcelFile leer, Properties propiedades, String nomHoja, File rutaCarpeta)
			throws InterruptedException, IOException, Exception {

		scrollVertical(rutaCarpeta, 515, 1567, 500, 2);
		click(alerts, rutaCarpeta);

		scrollVertical(rutaCarpeta, 445, 416, 1800, 2);
		click(sectionAlets, rutaCarpeta);

		tiempoEspera(2);

		// PRIMER BTN ALERTT
		clickListSwitchTo(allBtn, 0, rutaCarpeta);
		click(btnAceptar, rutaCarpeta); // ACEPTAR
		// tocarPantalla2(892,1411);
		tiempoEspera(2);

		// SEGUNDO BTN
		clickListSwitchTo(allBtn, 1, rutaCarpeta);
		tiempoEspera(6);
		click(btnAceptar, rutaCarpeta);
		tiempoEspera(2);

		// TERCER BTN
		clickListSwitchTo(allBtn, 2, rutaCarpeta);
		click(btnCancelar, rutaCarpeta);
		tiempoEspera(2);

		/// CUARTO BTN
		clickListSwitchTo(allBtn, 3, rutaCarpeta);
		sendKey(leer.getCellValue(propiedades.getProperty("filePathExcel"), "casoAlerts", 1, 1), txtTexto, rutaCarpeta);
		click(btnAceptar, rutaCarpeta);
		tiempoEspera(2);
	}

}
