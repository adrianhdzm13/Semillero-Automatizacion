package MapObjet;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import SemilleroPom.ClaseBase;

public class MapObjetAlerts extends ClaseBase {

	public MapObjetAlerts(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	// ELEMENTOS PAGINA INICIAL

	protected By selectionAlerts = By.xpath("//h5[contains(text(),'Alerts, Frame & Windows')]");
	protected By optionAlerts = By.xpath("//span[contains(text(),'Alerts')]");
	protected By btn1 = By.cssSelector("#alertButton");
	
	// LIST protected List<WebElement>
	protected By allBtn = By.xpath("//button[text()='Click me']");
	

	
	
	
	

}
