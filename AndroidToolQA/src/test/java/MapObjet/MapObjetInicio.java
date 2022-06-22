package MapObjet;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import SemilleroPom.ClaseBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import utilidadesExcel.ReadExcelFile;

public class MapObjetInicio extends ClaseBase {

	public MapObjetInicio(WebDriver driver) {
		super(driver);
		this.driver = (AppiumDriver<MobileElement>) driver;
	}


	//LOCALIZADORES
	protected By nuevo = By.id("com.android.chrome:id/menu_button");
	protected By nuevaPestaña = By.xpath("//android.widget.TextView[@content-desc=\"Nueva pestaña\"]");
	
	//NUEVA BUSQUEDAD

	protected By actionBuscar = By.id("com.android.chrome:id/search_box_text");

	protected By buscar = By.xpath("//android.widget.TextView[contains(@text,'https://demoqa.com/')]");

	

	
}
