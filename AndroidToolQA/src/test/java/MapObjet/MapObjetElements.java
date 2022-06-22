package MapObjet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import SemilleroPom.ClaseBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class MapObjetElements  extends ClaseBase {

	public MapObjetElements(WebDriver driver) {
		super(driver);
		this.driver = (AppiumDriver<MobileElement>) driver;
	}
	
	//LOCALIZADORES
	protected By selectElements = By.xpath("//android.widget.TextView[contains(@text,'Elements')]");
	protected By webTables = By.xpath("//android.widget.TextView[contains(@text,'Web Tables')]");
	
	protected By btnAdd = By.xpath("//android.widget.Button[contains(@text,'Add')]");
	
	protected By firsName = By.xpath("//android.widget.EditText[@resource-id='firstName']");
	protected By  borrar  = By.xpath("//android.view.View[@resource-id='delete-record-2']");
	protected By buscar = By.xpath("//android.widget.EditText[@resource-id='searchBox']	");
	

	
	

	


}
