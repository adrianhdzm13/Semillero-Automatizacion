package PagObjet;

import java.awt.Scrollbar;
import java.io.File;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import MapObjet.MapObjetElements;

import utilidadesExcel.ReadExcelFile;

public class PagObjetElements  extends MapObjetElements {



	// CONSTRUCCTOR DE LA CLASE
	public PagObjetElements(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	public void casoElements(ReadExcelFile leer, Properties propiedades, String nomHoja, File rutaCarpeta)
			throws InterruptedException, IOException, Exception {
		
		//Elements
		tiempoEspera(2000);
		click(selectionElements, rutaCarpeta);
		tiempoEspera(2000);
		scrollBar();
		click(webTables, rutaCarpeta);
		click(btnAdd, rutaCarpeta);
		tiempoEspera(2000);
		sendKey(leer.getCellValue(propiedades.getProperty("filePathExcel"), "elements", 1, 1), txtFirstName, rutaCarpeta);
		sendKey(leer.getCellValue(propiedades.getProperty("filePathExcel"), "elements", 1, 2), txtLastaname, rutaCarpeta);
		sendKey(leer.getCellValue(propiedades.getProperty("filePathExcel"), "elements", 1, 3), txtEmail, rutaCarpeta);
		sendKey(leer.getCellValue(propiedades.getProperty("filePathExcel"), "elements", 1, 4), txtAge, rutaCarpeta);
		sendKey(leer.getCellValue(propiedades.getProperty("filePathExcel"), "elements", 1, 5), txtSalary, rutaCarpeta);
		sendKey(leer.getCellValue(propiedades.getProperty("filePathExcel"), "elements", 1, 6), txtDepartment, rutaCarpeta);
		click(btnSubmit, rutaCarpeta);
		tiempoEspera(2000);
		
		//PERSONA A ELIMINAR DE LA TABLA
		sendKey(leer.getCellValue(propiedades.getProperty("filePathExcel"), "elements", 1, 7), txtBuscar, rutaCarpeta);
		tiempoEspera(2000);
		click(btnBuscar, rutaCarpeta);
		click(delete, rutaCarpeta);
		tiempoEspera(2000);
		//LIMPIAR CAJA
		txtDelete(txtBuscar);
		click(actionInicio, rutaCarpeta);
		//scrollBar();
		
	
		
	}
	

	



}
