package MapsObjet;

import org.openqa.selenium.By;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import semilleros.ClasesBase;

public class MapsObjetDireccionResidencia extends ClasesBase {

	// CONTRUCTOR DE LA CLASE
	public MapsObjetDireccionResidencia(AppiumDriver<MobileElement> driver) {
		super(driver);
	}

	// ELEMENTOS PAGINA ELEMENTS
	protected By btnLapizDireccion = By.id("com.clarocolombia.miclaro.debug:id/imgEditarDir");
	protected By btnDepartamento = By.xpath("//android.widget.CheckedTextView[contains(@text,'Seleccionar')]");
	protected By btnCiudad = By.id("com.clarocolombia.miclaro.debug:id/spCiudad");
	protected By txtBarrio = By.id("com.clarocolombia.miclaro.debug:id/edtBarrio");
	protected By btnTipo = By.id("com.clarocolombia.miclaro.debug:id/spTipo");
	protected By txtNPrincipal = By.id("com.clarocolombia.miclaro.debug:id/txtNPricipal");
	protected By btnSufijo= By.id("com.clarocolombia.miclaro.debug:id/spSufijo1");
	protected By txtNSecundario= By.id("com.clarocolombia.miclaro.debug:id/txtNSecuendario");
	//protected By btnSufijo2= By.id("com.clarocolombia.miclaro.debug:id/spSufijo2");
	protected By txtNComp= By.id("com.clarocolombia.miclaro.debug:id/txtNComponente");
	protected By btnComplemento= By.id("com.clarocolombia.miclaro.debug:id/spComplemento1");
	protected By txtNumero = By.id("com.clarocolombia.miclaro.debug:id/txtNumero1");
	protected By btnValidar = By.id("com.clarocolombia.miclaro.debug:id/btnAgregar");
	protected By btnGuardar = By.id("com.clarocolombia.miclaro.debug:id/btn_aceptar");
	protected By btnCancelar = By.id("com.clarocolombia.miclaro.debug:id/btnCancelar");
	protected By btnDevolver = By.xpath("//android.widget.ImageButton[@content-desc=\"Desplazarse hacia arriba\"]");
	

	
	
	
	
	
	
	
}
