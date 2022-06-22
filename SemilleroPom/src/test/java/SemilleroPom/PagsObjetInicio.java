package SemilleroPom;

import org.openqa.selenium.WebDriver;

public class PagsObjetInicio extends MapsObjetInicio {

	// CONSTRUCCTOR DE LA CLASE
	public PagsObjetInicio(WebDriver driver) {
		super(driver);
	}

	// METODO INICIAL
	public void urlAcceso(String url) {
		driver.get(url);
		// busquedaInicial();
	}

	// METODO PRIMERA PRUEBA
	public void busquedaInicial() throws InterruptedException {
		sendKey("periferia it", txtBusquedaGoogle);
		submit(txtBusquedaGoogle);
		tiempoEspera(2000);
		driver.close();
	}

}// fin clase
