package MapObjet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import SemilleroPom.ClaseBase;

public class MapObjetMercadoLibre extends ClaseBase {

	// CONSTRUCTOR DE LA CLASE
	public MapObjetMercadoLibre(WebDriver driver) {
		super(driver);
	}

	// ELEMENTOS PAGINA INICIAL
	
	
	protected By txtBusquedaMercadoLibre = By.cssSelector("#cb1-edit");
	protected By crearCuenta = By.xpath("//a[@data-link-id='registration']");
	protected By btnContinuar = By.xpath("//span[@class='andes-button__content']");
	protected By btnValidar = By.xpath("//span[@class='andes-button__text']");
	protected By txtEmail = By.xpath("//input[@type='email']");
	protected By btnEnviarEmail = By.xpath("//span[@class='andes-button__content']");
	protected By btnVolver = By.xpath("//span[contains(text(),'Ir a la página principal')]");
	
	//span[contains(text(),'Ir a la página principal')]

	//span[@class='andes-button__content']
	
	//input[@type='email']
	//span[@class='andes-button__text']
		
	//	#cb1-edit

	// // h3[contains(text(),'Mercado Libre Colombia - Envíos Gratis en el día')]
	 
	 

}
