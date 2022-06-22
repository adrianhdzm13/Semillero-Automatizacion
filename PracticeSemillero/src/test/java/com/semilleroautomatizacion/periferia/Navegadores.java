package com.semilleroautomatizacion.periferia;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Navegadores {

	// CREAR OBJETO TIPO WEBDRIVER
	private WebDriver driver;

	// CREAR ANOTACIONES DE JUNIT
	@Before
	public void navegadorChrome() {
		
		//SETEAR LAS PROPIEDADES DEL EJECUTABLE DE CHROME
		System.setProperty("webdriver.chrome.driver","src/test/resources/driver/chromedriver.exe");
		// DECLARAR EL OBJETO DRIVER TIPO CHROMEDRIVER
		driver = new ChromeDriver();
		
		//MAXIMIZAR VENTANA DE NAVEGADORES
		driver.manage().window().maximize();
		
		//ENVIAR LA INFORMACIÓN, INGRESAR LA URL 
		driver.get("https://www.google.com/");
			
	}//FIN METODO 
	
	@Test
	public void iniciarPrueba() {
		
		//CREAR UN OBJETO DE LA PAGINA PRINCIPAL
		WebElement txtBusqueda = driver.findElement(By.name("q"));
		//LIMPIAR LA CAJA DE TEXTO
		txtBusqueda.clear();
		//ENVIAR EL VALOR A BUSCAR
		txtBusqueda.sendKeys("periferia it");
		txtBusqueda.submit();
		
		String titulo = driver.getTitle();
		System.out.println(titulo);
		
	}
	
	@After
	public void cerrarNavegador() {
		driver.quit();
	}
	
	
}
