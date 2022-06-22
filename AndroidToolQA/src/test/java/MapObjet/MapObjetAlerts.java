package MapObjet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import SemilleroPom.ClaseBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class MapObjetAlerts extends ClaseBase {

	public MapObjetAlerts(WebDriver driver) {
		super(driver);
		this.driver = (AppiumDriver<MobileElement>) driver;
	}
	
	protected By alerts = By.xpath("//android.widget.TextView[contains(@text,'Alerts, Frame & Windows')]");
	protected By sectionAlets = By.xpath("//android.view.View[@resource-id='item-1']");
	protected By allBtn = By.xpath("//android.widget.Button[contains(@text,'Click me')]");
	protected By btnAceptar = By.xpath("//android.widget.Button[contains(@text,'Aceptar')]");
	protected By btnCancelar = By.xpath("//android.widget.Button[contains(@text,'Cancelar')]");
	protected By txtTexto = By.xpath("//android.widget.EditText[@resource-id='com.android.chrome:id/js_modal_dialog_prompt']");
	
	
	
	
	


}
