package MapObjet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import SemilleroPom.ClaseBase;

public class MapObjetHome extends ClaseBase {

	// CONSTRUCTOR DE LA CLASE
	public MapObjetHome (WebDriver driver) {
		super(driver);
	}
	
	protected By btnHome = By.xpath("//a[contains(text(),'Home')]");

}
