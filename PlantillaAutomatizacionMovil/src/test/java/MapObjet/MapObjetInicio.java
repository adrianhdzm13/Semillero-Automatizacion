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
	protected By actionBuscar = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout[2]/android.webkit.WebView/android.view.View/android.view.View[2]/android.view.View[2]/android.view.View[1]/android.widget.EditText");
	//protected By btnBuscar = By.xpath("	//android.widget.Button[contains[@text='Buscar con Google']]");
	protected By btnBuscar = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout[2]/android.webkit.WebView/android.view.View/android.view.View[2]/android.view.View[2]/android.view.View[1]/android.widget.Button[1]\r\n"
			+ "");
	
	

}
