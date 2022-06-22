package PagObjet;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

import MapObjet.MapObjetInicio;
import utilidadesExcel.ReadExcelFile;

public class PagObjetInicio extends MapObjetInicio {

	// CONSTRUCCTOR DE LA CLASE
	public PagObjetInicio(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public void inicio(ReadExcelFile leer, Properties propiedades, String nomHoja, File rutaCarpeta)
			throws InterruptedException, IOException, Exception {
			
		scrollBar();
		tiempoEspera(2000);
		
		
	}

}
