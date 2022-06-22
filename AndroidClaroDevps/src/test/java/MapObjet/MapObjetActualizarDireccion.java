package MapObjet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import SemilleroPom.ClaseBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class MapObjetActualizarDireccion extends ClaseBase {

	public MapObjetActualizarDireccion(WebDriver driver) {
		super(driver);
		this.driver = (AppiumDriver<MobileElement>) driver;
	}
	
	protected By btnPerfil = By.xpath("//android.widget.ImageView[@resource-id ='com.clarocolombia.miclaro.debug:id/imgPerfil']");
	protected By confiCuenta = By.xpath("//android.widget.TextView[@resource-id ='com.clarocolombia.miclaro.debug:id/tvConfiguracion']");
	protected By actualizarDatos = By.xpath("//android.view.ViewGroup[@resource-id='com.clarocolombia.miclaro.debug:id/botonDatos']");
	protected By clickNumCelular = By.xpath("//android.widget.Button[@resource-id='com.clarocolombia.miclaro.debug:id/btnimgActualizarDatos']");
	protected By clickDireccion = By.xpath("//android.widget.ImageView[@resource-id='com.clarocolombia.miclaro.debug:id/imgEditarDir']");
	
	//CLIC EN LISTAS
	protected By clicList = By.xpath("//android.widget.CheckedTextView[@text ='Seleccionar']");
	protected By clicListCiudad = By.xpath("//android.widget.Spinner[@resource-id ='com.clarocolombia.miclaro.debug:id/spCiudad']");
	protected By clicTipoCalle = By.xpath("//android.widget.Spinner[@resource-id='com.clarocolombia.miclaro.debug:id/spTipo']");
	protected By clicSufijo = By.xpath("//android.widget.Spinner[@resource-id='com.clarocolombia.miclaro.debug:id/spSufijo1']");
	protected By clicSufijo2 = By.xpath("//android.widget.Spinner[@resource-id='com.clarocolombia.miclaro.debug:id/spSufijo2']");
	protected By clicComplemento = By.xpath("//android.widget.Spinner[@resource-id='com.clarocolombia.miclaro.debug:id/spComplemento1']");
	protected By clicComplemento2 = By.xpath("//android.widget.Spinner[@resource-id='com.clarocolombia.miclaro.debug:id/spComplemento2']");
	
	//BARRIO
	protected By txtBarrio = By.xpath("//android.widget.EditText[@resource-id='com.clarocolombia.miclaro.debug:id/edtBarrio']");
	//NUMERO PRINCIPAL
	protected By txtNumero = By.xpath("//android.widget.EditText[@resource-id='com.clarocolombia.miclaro.debug:id/txtNPricipal']");
	//NUMERO SECUNDARIO
	protected By txtNumeroSecundario = By.xpath("//android.widget.EditText[@resource-id='com.clarocolombia.miclaro.debug:id/txtNSecuendario']");
	//NUMERO COMPONENTE
	protected By txtNumeroComponente = By.xpath("//android.widget.EditText[@resource-id='com.clarocolombia.miclaro.debug:id/txtNComponente']");
	//NUMERO COMPLEMENTO 
	protected By txtNumeroComplemento = By.xpath("//android.widget.EditText[@resource-id='com.clarocolombia.miclaro.debug:id/txtNumero1']");
	//NUMERO COMPLEMNTO2
	protected By txtNumeroComplemento2 = By.xpath("//android.widget.EditText[@resource-id='com.clarocolombia.miclaro.debug:id/txtNumero2']");
	//VALIDAR
	protected By btnAgregar = By.xpath("//android.widget.Button[@resource-id='com.clarocolombia.miclaro.debug:id/btnAgregar']");
	//GUARDAR
	protected By btnCancelar = By.xpath("//android.widget.Button[@resource-id='com.clarocolombia.miclaro.debug:id/btn_cancelar']");
	
	//LOCALIZADOR PARA LISTAS
	protected String complet = "//android.widget.CheckedTextView[@text ='";


}
