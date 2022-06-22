package PagObjet;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import MapObjet.MapObjetElements;
import MapObjet.MapObjetWidgets;
import SemilleroPom.ClaseBase;
import utilidadesExcel.ReadExcelFile;

public class PagObjetWidgets extends MapObjetWidgets {

	// CONSTRUCCTOR DE LA CLASE
	public PagObjetWidgets(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public void casoWidgets(ReadExcelFile leer, Properties propiedades, String nomHoja, File rutaCarpeta)
			throws InterruptedException, IOException, Exception {

		click(sectionWidgets, rutaCarpeta);
		tiempoEspera(2000);
		scrollBar();
		click(optionDatePicker, rutaCarpeta);
		tiempoEspera(2000);

		// ESTABLECER DATE

		 campoDateCssSelector(date,leer.getCellValue(propiedades.getProperty("filePathExcel"), "casoWidgets", 1,1));
		 tiempoEspera(2000);
		 campoDateCssSelector(dateTime2,leer.getCellValue(propiedades.getProperty("filePathExcel"), "casoWidgets", 1,2));
		 tiempoEspera(4000);	 
		 
		
		//OTRA FORMA
		//DATE
		//String dataExcel2 = leer.getCellValue(propiedades.getProperty("filePathExcel"), "casoWidgets", 1, 2);
		//JavascriptExecutor js2 = (JavascriptExecutor) driver;
		//js2.executeScript("document.querySelector('#dateAndTimePickerInput').value='" + dataExcel2 + "'");
		//tiempoEspera(2000);
		
		//OTRA FORMA
		// DATETIME
		// seleccionar(dateTime, rutaCarpeta);
		// sendKey(leer.getCellValue(propiedades.getProperty("filePathExcel"),
		// "casoWidgets", 1, 2), dateTime,
		// rutaCarpeta);
		// click(blanco, rutaCarpeta);
		// tiempoEspera(2000);

	}

}
