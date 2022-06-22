package PagObjet;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import MapObjet.MapObjetAlerts;
import utilidadesExcel.ReadExcelFile;

public class PagObjetAlerts extends MapObjetAlerts {

	// CONSTRUCCTOR DE LA CLASE
	public PagObjetAlerts(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public void casoAlerts(ReadExcelFile leer, Properties propiedades, String nomHoja, File rutaCarpeta)
			throws InterruptedException, IOException, Exception {

		click(selectionAlerts, rutaCarpeta);
		tiempoEspera(2000);
		scrollBar();
		click(optionAlerts, rutaCarpeta);
		tiempoEspera(2000);
		
		// PRIMER BTN ALERTT
		clickList(allBtn, 0, rutaCarpeta);
		tiempoEspera(2000);
		acepAlert(rutaCarpeta);
		tiempoEspera(2000);

		// SEGUNDO BTN ALERT
		clickList(allBtn, 1, rutaCarpeta);
		tiempoEspera(6000);
		acepAlert(rutaCarpeta);
		tiempoEspera(2000);

		// TERCER BTN ALERT
		clickList(allBtn, 2, rutaCarpeta);
		tiempoEspera(2000);
		canceAlert(rutaCarpeta);
		tiempoEspera(2000);
		
		//CUARTO BTN ALERT
		clickList(allBtn, 3, rutaCarpeta);
		tiempoEspera(2000);
		//ENVIO DE DATOS ALERT
		textoAlert(rutaCarpeta, leer.getCellValue(propiedades.getProperty("filePathExcel"), "casoAlerts", 1, 1));
		acepAlert(rutaCarpeta);
		tiempoEspera(2000);		
		
		
		/*
		// ARRAY LIST
		List<WebElement> allBtn = driver.findElements(By.xpath("//button[text()='Click me']"));

		// PRIMER BTN
		allBtn.get(0).click();
		tiempoEspera(2000);
		driver.switchTo().alert().accept();

		// SEGUNDO BTN
		allBtn.get(1).click();
		// TIEMPO DE ESPERA DE 6 SEGUNDOS
		tiempoEspera(6000);
		driver.switchTo().alert().accept();
		tiempoEspera(2000);

		// TERCER BTN
		allBtn.get(2).click();
		tiempoEspera(2000);
		// SELECT OK
		// driver.switchTo().alert().accept();
		// SELECT CANCEL
		driver.switchTo().alert().dismiss();
		tiempoEspera(2000);

		// DATO DE EXCEL
		String datos = leer.getCellValue(propiedades.getProperty("filePathExcel"), "casoAlerts", 1, 1);
		;

		// CUARTO BTN
		allBtn.get(3).click();
		tiempoEspera(2000);
		// SELECT CANCEL
		driver.switchTo().alert().sendKeys(datos);
		tiempoEspera(2000);
		driver.switchTo().alert().accept();
		tiempoEspera(2000);
		*/
	}

}
