package PagObjet;

import java.io.File;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xddf.usermodel.chart.XDDFChartExtensionList;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import MapObjet.MapObjetLogin;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import utilidadesExcel.ReadExcelFile;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class PagObjetLogin extends MapObjetLogin {

	// CONSTRUCCTOR DE LA CLASE
	@SuppressWarnings("unchecked")
	public PagObjetLogin(WebDriver driver) {
		super(driver);
		this.driver = (AppiumDriver<MobileElement>) driver;
	}

	@SuppressWarnings("rawtypes")
	public void login(ReadExcelFile leer, Properties propiedades, String nomHoja, File rutaCarpeta)
			throws InterruptedException, IOException, Exception {

		// SI LA SESION ESTA INICIADA LA SESION SE CIERRA
		tiempoEspera(7);
		boolean bandera2 = elementExits(btnPerfil);

		if (bandera2 == true) {
			cerrarSesionInicial(leer, propiedades, nomHoja, rutaCarpeta);
		} 
	
		//SI LA SESION NO HA SIDO INICIADA
		tiempoEspera(5);

		boolean bandera4 = elementExits(btnIngreso);

		if (bandera4 == true) {
			click(btnIngreso, rutaCarpeta);
			tiempoEspera(1);
			click(btnCorreo, rutaCarpeta);
			tiempoEspera(1);
			sendKey(leer.getCellValue(propiedades.getProperty("filePathExcel"), "login", 1, 0), txtCorreo, rutaCarpeta);
			sendKey(leer.getCellValue(propiedades.getProperty("filePathExcel"), "login", 1, 1), txtContraseña,
					rutaCarpeta);
			click(mostrarContraseña, rutaCarpeta);
			tiempoEspera(1);
			click(btnLogin, rutaCarpeta);
			tiempoEspera(2);
			click(cancelar, rutaCarpeta);

			tiempoEspera(7);

			// CERRAR SESION OTRO DISPOSITIVO MOVIL
			boolean bandera = elementExits(ventanaDispositivos);

			if (bandera == true) {
				click(checkCerraSession, rutaCarpeta);
				click(btnContinuar, rutaCarpeta);
				tiempoEspera(1);
				click(btnAceptar, rutaCarpeta);
				tiempoEspera(7);
			}

		}
		
		

	}

	public void cerrarSesion(ReadExcelFile leer, Properties propiedades, String nomHoja, File rutaCarpeta)
			throws InterruptedException, IOException, Exception {
		click(btnInicio, rutaCarpeta);
		tiempoEspera(4);
		click(btnPerfil, rutaCarpeta);
		openWindow();
		click(btnCerrarSesion, rutaCarpeta);
		openWindow();
		tiempoEspera(1);
		click(btnCerrar, rutaCarpeta);

	}

	public void cerrarSesionPago(ReadExcelFile leer, Properties propiedades, String nomHoja, File rutaCarpeta)
			throws InterruptedException, IOException, Exception {
		// ATRAS
		click(btnAtras, rutaCarpeta);
		click(btnPerfil, rutaCarpeta);
		openWindow();
		click(btnCerrarSesion, rutaCarpeta);
		openWindow();
		tiempoEspera(1);
		click(btnCerrar, rutaCarpeta);
	}

	// METODO PARA CERRAR LA SESION SI SE ENCUENTA INICIADA
	public void cerrarSesionInicial(ReadExcelFile leer, Properties propiedades, String nomHoja, File rutaCarpeta)
			throws InterruptedException, IOException, Exception {
		// PERFIL
		click(btnPerfil, rutaCarpeta);
		openWindow();
		tiempoEspera(2);
		click(btnCerrarSesion, rutaCarpeta);
		openWindow();
		tiempoEspera(2);
		click(btnCerrar, rutaCarpeta);
	}

}
