package MapsObjet;

import org.openqa.selenium.By;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import semilleros.ClasesBase;

public class MapsObjetLogin extends ClasesBase {

	// CONTRUCTOR DE LA CLASE
	public MapsObjetLogin(AppiumDriver<MobileElement> driver) {
		super(driver);
	}

	// ELEMENTOS DE LA CALCULADORA
	protected By btnIngresarAUsuarioYContraseña = By.xpath("//android.widget.Button[contains(@text,'Ingresa con usuario y contraseña')]");
	protected By btnCorreoElectronico = By.xpath("//android.widget.LinearLayout[@resource-id='com.clarocolombia.miclaro.debug:id/lyEmail']");
	protected By txtCorreoElectronico = By.xpath("//android.widget.EditText[contains(@text,'Usuario o correo electrónico')]");
	protected By txtContraseña = By.xpath("//android.widget.EditText[contains(@text,'Contraseña')]");
	protected By btnIniciarSesion = By.xpath("//android.widget.Button[contains(@text,'Iniciar sesión')]");
	protected By btnCancelar = By.xpath("//android.widget.Button[contains(@text,'Cancelar')]");
	protected By Ventana3dispositivos = By.xpath("//android.widget.TextView[contains(@text,'Mi Claro te permite tener abierta')]");
	protected By btnRadioButton = By.xpath("//androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]");
	protected By btnContinuar = By.xpath("//android.widget.Button[contains(@text,'Continuar')]");
	protected By btnAceptar = By.xpath("//android.widget.Button[contains(@text,'Aceptar')]");
	protected By btnPerfil = By.id("com.clarocolombia.miclaro.debug:id/imgPerfil");
	protected By btnCerrarSesion = By.id("com.clarocolombia.miclaro.debug:id/tvCerrarSesion");
	protected By btnAceptarCerrarSesion = By.id("com.clarocolombia.miclaro.debug:id/btn_aceptar");
}
