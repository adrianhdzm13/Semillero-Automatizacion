package MapObjet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import SemilleroPom.ClaseBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class MapObjetWidgets extends ClaseBase {

	public MapObjetWidgets(WebDriver driver) {
		super(driver);
		
	}
	
	protected By widgets = By.xpath("//android.widget.TextView[contains(@text,'Widgets')]");
	protected By datePicker = By.xpath("//android.widget.TextView[contains(@text,'Date Picker')]");
	protected By fecha = By.xpath("//android.widget.EditText[@resource-id ='datePickerMonthYearInput']");
	protected By  blanco = By.xpath("//android.widget.TextView[contains(@text,'Select Date')]");
	
	
	protected By  dateTime = By.xpath("//android.widget.EditText[@resource-id='dateAndTimePickerInput']");
	
	
	

}
