package com.semilleroautomatizacion.periferia;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FireFo {

	// CREAR OBJETO TIPO WEBDRIVER
		private WebDriver firefoxdriver;

		// CREAR ANOTACIONES DE JUNIT
		@Before
		public void navegadorfirefox() {
			
			//SETEAR LAS PROPIEDADES DEL EJECUTABLE DE CHROME
			System.setProperty("webdriver.gecko.driver","src/test/resources/driver/geckodriver.exe");
		
			// DECLARAR EL OBJETO DRIVER TIPO CHROMEDRIVER
			 firefoxdriver = new FirefoxDriver();
			
			//MAXIMIZAR VENTANA DE NAVEGADORES
			 firefoxdriver.manage().window().maximize();
			
			//ENVIAR LA INFORMACIÓN, INGRESAR LA URL 
			 firefoxdriver.get("https://www.google.com/");
				
		}//FIN METODO 
		
		@Test
		public void iniciarPrueba() throws InterruptedException {
			
			//CREAR UN OBJETO DE LA PAGINA PRINCIPAL
			WebElement txtBusqueda =  firefoxdriver.findElement(By.name("q"));
			//LIMPIAR LA CAJA DE TEXTO
			txtBusqueda.clear();
			//ENVIAR EL VALOR A BUSCAR
			txtBusqueda.sendKeys("periferia it");
			txtBusqueda.submit();

			Thread.sleep(5000);
			
			String titulo =  firefoxdriver.getTitle();
			System.out.println(titulo);
			
		}
		
		@After
		public void cerrarNavegador() {
			 firefoxdriver.quit();
		}
		
		
}
