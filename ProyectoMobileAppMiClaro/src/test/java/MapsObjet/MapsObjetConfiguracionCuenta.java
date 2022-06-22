package MapsObjet;

import org.openqa.selenium.By;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import semilleros.ClasesBase;

public class MapsObjetConfiguracionCuenta extends ClasesBase {

	// CONTRUCTOR DE LA CLASE
	public MapsObjetConfiguracionCuenta(AppiumDriver<MobileElement> driver) {
		super(driver);
	}

	// ELEMENTOS PAGINA ELEMENTS
	protected By btnConfiguracionDeCuentas = By.id("com.clarocolombia.miclaro.debug:id/btnConfiguracion");
	protected By btnActualizarDatos = By.id("com.clarocolombia.miclaro.debug:id/btnimgActualizarDatos");
	protected By btnNumeroCelular = By.id("com.clarocolombia.miclaro.debug:id/btnimgActualizarDatos");
		
		
		
		
}
