package SemilleroPom;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

import utilidadesExcel.ReadExcelFile;

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
	public void busquedaInicial(ReadExcelFile leer, Properties propiedades) throws Exception {

		// OBTENER EL NOMBRE DEL METODO A EJECUTAR
		
		String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();

		// CREAR CARPETA PARA ALMACENAMIENTO DE IMAGENES
		File rutaCarpeta = crearCarpeta(propiedades, nomTest);

		// ENVIAMOS EL VALOR DE BUSQUEDA AL NAVEGADOR
		sendKey(leer.getCellValue(propiedades.getProperty("filePathExcel"), "busqueda", 1, 0),txtBusquedaGoogle,rutaCarpeta);
				
		submit(txtBusquedaGoogle,rutaCarpeta);
		tiempoEspera(2000);
		click(resultado, rutaCarpeta);
		tiempoEspera(2000);
		driver.close();
	
	}
	
	

}
// fin clase
