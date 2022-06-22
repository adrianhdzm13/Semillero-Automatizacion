package PagObjet;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import MapObjet.MapObjetRegister;
import utilidadesExcel.ReadExcelFile;

public class PagObjetRegister extends MapObjetRegister {

	PagObjetHome home;

	// CONSTRUCCTOR DE LA CLASE
	public PagObjetRegister(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public void casoRegister(ReadExcelFile leer, Properties propiedades, String nomHoja, File rutaCarpeta)
			throws InterruptedException, IOException, Exception {

		// REGISTRO
		tiempoEspera(2000);
		click(bntRegister, rutaCarpeta);
		tiempoEspera(2000);
		// LLAMADO AL METODO SCROLLBAR
		scrollBar();

		// ENVIO DE TADOS TEXTFIED INFORMATION
		// Thread.sleep(2000);
		//tiempoEspera(2000);
		sendKey(leer.getCellValue(propiedades.getProperty("filePathExcel"), "caso2", 1, 2), txtfFirstName, rutaCarpeta);
		
		sendKey(leer.getCellValue(propiedades.getProperty("filePathExcel"), "caso2", 1, 3), txtLastName, rutaCarpeta);
		
		sendKey(leer.getCellValue(propiedades.getProperty("filePathExcel"), "caso2", 1, 4), txtPhone, rutaCarpeta);
	
		sendKey(leer.getCellValue(propiedades.getProperty("filePathExcel"), "caso2", 1, 5), txtEmail, rutaCarpeta);
	
		sendKey(leer.getCellValue(propiedades.getProperty("filePathExcel"), "caso2", 1, 6), txtAddres, rutaCarpeta);
		
		sendKey(leer.getCellValue(propiedades.getProperty("filePathExcel"), "caso2", 1, 7), txtCity, rutaCarpeta);
		
		sendKey(leer.getCellValue(propiedades.getProperty("filePathExcel"), "caso2", 1, 8), txtState, rutaCarpeta);
		//tiempoEspera(2000);
		sendKey(leer.getCellValue(propiedades.getProperty("filePathExcel"), "caso2", 1, 9), txtPostalCode, rutaCarpeta);
		//tiempoEspera(2000);
		
		//Lista
		/*
		Select lista = new Select(driver.findElement(listCountry));
		lista.selectByValue(leer.getCellValue(propiedades.getProperty("filePathExcel"), "caso2", 1, 10));
		tiempoEspera(2000);
		*/
		//Lista
		seleccionarLista(leer, listCountry, propiedades, "caso2", 1, 10);
		sendKey(leer.getCellValue(propiedades.getProperty("filePathExcel"), "caso2", 1, 11), txtUser, rutaCarpeta);
		//tiempoEspera(2000);
		sendKey(leer.getCellValue(propiedades.getProperty("filePathExcel"), "caso2", 1, 12), txtPass, rutaCarpeta);
		//tiempoEspera(2000);
		sendKey(leer.getCellValue(propiedades.getProperty("filePathExcel"), "caso2", 1, 13), txtConfirmaPas, rutaCarpeta);
		//tiempoEspera(2000);

		click(btnSubmit, rutaCarpeta);
		tiempoEspera(2000);
		
		click(btnHome, rutaCarpeta);
		tiempoEspera(2000);

		driver.close();

	}

}
