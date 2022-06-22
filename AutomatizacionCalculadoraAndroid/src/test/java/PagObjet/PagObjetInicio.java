package PagObjet;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

import MapObjet.MapObjetInicio;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import utilidadesExcel.ReadExcelFile;

public class PagObjetInicio extends MapObjetInicio {

	int[] cifras2;

	// CONSTRUCCTOR DE LA CLASE
	@SuppressWarnings("unchecked")
	public PagObjetInicio(WebDriver driver) {
		super(driver);
		this.driver = (AppiumDriver<MobileElement>) driver;
	}

	public void inicio(ReadExcelFile leer, Properties propiedades, String nomHoja, File rutaCarpeta)
			throws InterruptedException, IOException, Exception {

		click(btnClear, rutaCarpeta);

		// ESTABLECE EL PRIMER VALOR DEL EXCEL
		@SuppressWarnings("unused")
		int num1 = leer.getCellValueInt(propiedades.getProperty("filePathExcel"), "inicio", 1, 0);

		// LLAMADO AL METODO
		unidad(num1);
 
		for (int i = 0; i < cifras2.length; i++) {
			 String valor1 = allBtn + cifras2[i] + "_s";
			clickNumExcel(valor1, rutaCarpeta);
		} 

		// ESTABLECE LA OPERACION
		String operador = leer.getCellValue(propiedades.getProperty("filePathExcel"), "inicio", 1, 2);
		String operacion = allOperador + operador + "']";

		clickOperacion(operacion, rutaCarpeta);

		// ESTABLECE EL SEGUNDO VALOR VALOR DEL EXCEL
		int num2 = leer.getCellValueInt(propiedades.getProperty("filePathExcel"), "inicio", 1, 1);

		// LLAMADO AL METODO
		unidad(num2);

		for (int i = 0; i < cifras2.length; i++) {
			 String valor2 = allBtn + cifras2[i] + "_s";
			clickNumExcel(valor2, rutaCarpeta);
		}

		// LIMPIAR
		click(btnIgual, rutaCarpeta);
		tiempoEspera(2);


	}

	/*
	 * METODO PARA CONVERTIR UN NUMERO EN UNIDADES
	 */
	private void unidad(int num1) {

		int i = 0;
		int tamanio = 0;
		// ARRAY PARA NUMEROS DE 10 CIFRAS
		int[] cifras = new int[10];

		while (num1 > 0) {
			
			cifras[i] = num1 % 10;
			num1 = num1 / 10;
			i++;
			tamanio = i;
			
		}
		// ASIGNA EL TAMAÑO AL VECTOR
		cifras2 = new int[tamanio];

		int k = 0;
		for (int j = i - 1; j >= 0; j--) {

			// PASAMOS EL VALOR
			cifras2[k] = cifras[j];
			k++;
		}
	}

}
