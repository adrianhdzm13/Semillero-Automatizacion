package PagObjet;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;


import MapObjet.MapObjetHome;
import utilidadesExcel.ReadExcelFile;

public class PagObjetHome extends MapObjetHome {

	// CONSTRUCCTOR DE LA CLASE
	public PagObjetHome(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	public void casoHome(ReadExcelFile leer, Properties propiedades, String nomHoja, File rutaCarpeta)
			throws InterruptedException, IOException,Exception {

			click(btnHome, rutaCarpeta);
			tiempoEspera(2000);

			}

}
