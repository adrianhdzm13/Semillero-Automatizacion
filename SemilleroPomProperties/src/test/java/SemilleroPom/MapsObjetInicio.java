package SemilleroPom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MapsObjetInicio extends ClaseBase {

	// CONSTRUCTOR DE LA CLASE
	public MapsObjetInicio(WebDriver driver) {
		super(driver);
	}

	// ELEMENTOS PAGINA INICIAL
	By txtBusquedaGoogle = By.name("q");
	By btnBuscar = By.name("btnk");
	By resultado = By.xpath("//h3[contains(text(),'Periferia IT Group – Somos innovación en tecnologí')]");
		
	
}// fin clase
