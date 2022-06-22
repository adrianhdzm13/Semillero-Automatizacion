package MapObjet;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import SemilleroPom.ClaseBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import utilidadesExcel.ReadExcelFile;

public class MapObjetLogin extends ClaseBase {

	public MapObjetLogin(WebDriver driver) {
		super(driver);
	}


	//LOCALIZADORES
	protected By btnIngreso = By.xpath("//android.widget.Button[contains(@text,'Ingresa con usuario y contraseña')]");
	protected By btnCorreo = By.xpath("//android.widget.LinearLayout[@resource-id='com.clarocolombia.miclaro.debug:id/lyEmail']");
	protected By txtCorreo = By.xpath("//android.widget.EditText[@text ='Usuario o correo electrónico']");
	protected By txtContraseña = By.xpath("//android.widget.EditText[@resource-id='com.clarocolombia.miclaro.debug:id/edPassword']");
	protected By btnLogin = By.xpath("//android.widget.Button[@resource-id ='com.clarocolombia.miclaro.debug:id/btnLoginUsPass']");
	protected By mostrarContraseña = By.xpath("//android.widget.ImageButton[@content-desc=\"Mostrar contraseña\"]");
	protected By cancelar = By.xpath("//android.widget.Button[@resource-id ='com.clarocolombia.miclaro.debug:id/btn31']");
	
	//lOCALIZADORES CERRAR SESION DISPOSITIVO MOVIL 
	protected By checkCerraSession = By.xpath("//android.widget.RadioButton[@resource-id ='com.clarocolombia.miclaro.debug:id/checkOtheSessionThis']");
	protected By btnContinuar = By.xpath("//android.widget.Button[@text ='Continuar']");	
	protected By btnAceptar = By.xpath("//android.widget.Button[@text ='Aceptar']");
	protected By ventanaDispositivos = By.xpath("//android.widget.TextView[contains(@text,'Mi Claro te permite tener abierta')]");
	
	//LOCALIZADORES PARA CERRAR SESION
	protected By btnInicio = By.xpath("//android.widget.Button[@resource-id='com.clarocolombia.miclaro.debug:id/btnInicio']");
	protected By btnPerfil = By.xpath("//android.widget.ImageView[@resource-id ='com.clarocolombia.miclaro.debug:id/imgPerfil']");
	protected By btnCerrarSesion = By.xpath("//android.widget.TextView[@resource-id='com.clarocolombia.miclaro.debug:id/tvCerrarSesion']");
	protected By btnCerrar = By.xpath("//android.widget.Button[@resource-id='com.clarocolombia.miclaro.debug:id/btn_aceptar']");
	//LOCALIZADOR CERRAR SESION PAGO
	protected By btnAtras = By.xpath("//android.widget.ImageButton[@content-desc=\"Desplazarse hacia arriba\"]");
	
	
	
	
	
	
	
	
	
	
	
	

	

	
}
