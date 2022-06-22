package MapObjet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import SemilleroPom.ClaseBase;

public class MapsObjetInicio extends ClaseBase {

	// CONSTRUCTOR DE LA CLASE
	public MapsObjetInicio(WebDriver driver) {
		super(driver);
	}

	 // ELEMENTOS PAGINA INICIAL
	 protected By txtBusquedaGoogle = By.name("q");
	 protected By btnBuscar = By.name("btnk");
	 protected By resultado = By.xpath("//h3[contains(text(),'Periferia IT Group – Somos innovación en tecnologí')]");
		
	
}// fin clase
