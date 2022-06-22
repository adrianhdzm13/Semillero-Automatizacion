package PagObjet;

import java.io.File;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import MapObjet.MapObjetInicio;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import utilidadesExcel.ReadExcelFile;


import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
public class PagObjetInicio extends MapObjetInicio {

	// CONSTRUCCTOR DE LA CLASE
	@SuppressWarnings("unchecked")
	public PagObjetInicio(WebDriver driver) {
		super(driver);
		this.driver = (AppiumDriver<MobileElement>) driver;
	}

	@SuppressWarnings("rawtypes")
	public void inicio(ReadExcelFile leer, Properties propiedades, String nomHoja, File rutaCarpeta)
			throws InterruptedException, IOException, Exception {

		// INICIO
		click(nuevo, rutaCarpeta);
		click(nuevaPestaña, rutaCarpeta);
		sendKey(leer.getCellValue(propiedades.getProperty("filePathExcel"), "inicio", 1, 0), actionBuscar, rutaCarpeta);
	
	
		///tocarPantalla();
		//((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.ENTER));
		//DAR CLIC EN TAB
		driver.getKeyboard().pressKey(Keys.ENTER);
		tiempoEspera(2);
		
		
		
	}

}
