package MapObjet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import SemilleroPom.ClaseBase;

public class MapObjetInicio  extends ClaseBase {

	public MapObjetInicio(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	//LOCALIZADORES
	protected By actionInicio = By.xpath("//a[@href='https://demoqa.com']");
	
	
	

}
