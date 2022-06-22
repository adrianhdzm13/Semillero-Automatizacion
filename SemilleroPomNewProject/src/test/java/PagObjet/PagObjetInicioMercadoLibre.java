package PagObjet;

import java.io.File;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

import MapObjet.MapObjetMercadoLibre;
import utilidadesExcel.ReadExcelFile;


public class PagObjetInicioMercadoLibre extends MapObjetMercadoLibre {
	
	
	// CONSTRUCCTOR DE LA CLASE
	public PagObjetInicioMercadoLibre(WebDriver driver) {
		super(driver);
	}
			
		// METODO CASO2 mercado libre
		public void busquedaMercadoLibre(ReadExcelFile leer, Properties propiedades, String nomTest) throws Exception {

			// CREAR CARPETA PARA ALMACENAMIENTO DE IMAGENES
			File rutaCarpeta = crearCarpeta(propiedades, nomTest);

			// ENVIAMOS EL VALOR DE BUSQUEDA AL NAVEGADOR
			sendKey(leer.getCellValue(propiedades.getProperty("filePathExcel"), "caso2", 1, 2),crearCuenta, rutaCarpeta);
					
			click(crearCuenta, rutaCarpeta);
			tiempoEspera(2000);
			click(btnContinuar, rutaCarpeta);
			tiempoEspera(2000);
			click(btnValidar, rutaCarpeta);
			tiempoEspera(2000);
			sendKey(leer.getCellValue(propiedades.getProperty("filePathExcel"), "caso2", 1, 3),txtEmail, rutaCarpeta);
			click(btnEnviarEmail, rutaCarpeta);
			tiempoEspera(2000);
			click(btnVolver, rutaCarpeta);
			tiempoEspera(2000);
			
			driver.close();
			
		
			
			/*
			 * click(regis, rutaCarpeta);
	tiempoEspera(2000);
	click(btnContinuar, rutaCarpeta);
	tiempoEspera(2000);
	click(btnValidar, rutaCarpeta);
	tiempoEspera(2000);
	sendkey(leer.getCellValue(propiedades.getProperty("filePatchExcel"),numHoja,1,4), txtMail,rutaCarpeta);
	tiempoEspera(2000);
	click(btnEnvairMail, rutaCarpeta);
	driver.close();*/
		}
		
		
	
	
}
