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

	// VARIABLES OPERACIONALES
	protected String allBtn = "com.miui.calculator:id/btn_";
	protected String allOperador = "//android.widget.ImageView[@content-desc='";

	// LOCALIZADORES OPERACIONES
	protected By btnClear = By.id("com.miui.calculator:id/btn_c_s");
	protected By btnIgual = By.id("com.miui.calculator:id/btn_equal_s");

}
