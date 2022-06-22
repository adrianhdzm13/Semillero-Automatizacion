package SemilleroPom;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Properties;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import utilidadesExcel.ReadExcelFile;

public class ClaseBase {

	//protected WebDriver driver;
	protected AppiumDriver<MobileElement> driver;

	// CONSTRUCTOR DE CLASE
	public ClaseBase(WebDriver driver) {
		super();
	}

	// METODO INICIAL
	public void urlAcceso(String url) {
		driver.get(url);
		// busquedaInicial();
	}
	
	// ---------------------------------------------------------------------------------
	//   METODO APPIUM
	// ---------------------------------------------------------------------------------	
	@SuppressWarnings("rawtypes")
	public static AppiumDriver appiumDriverConnetion() {

		AppiumDriver _driver = null;
		try {
			// SETEAR LAS OPCIONES DE NAVEGADOR
			DesiredCapabilities caps = new DesiredCapabilities();
			caps.setCapability("platformName", "Android");
			caps.setCapability("deviceName", "4laq8puwxgsca6sc");
			caps.setCapability("platformVersion", "11");
			caps.setCapability("appPackage", "com.android.chrome");
			caps.setCapability("appActivity", "com.google.android.apps.chrome.Main");
			caps.setCapability("noReset", "true");
			caps.setCapability("autoGrantPermissions", "true");

			// INSTANCIA APPIUM DRIVER
			try {
				imprimirConsola("Cargando capability de appium. favor espere...");
				_driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);

			} catch (MalformedURLException e) {
				
				imprimirConsola(e.getMessage());
			}
			return _driver;

		} catch (Exception e) {
			System.out.println(e);
		}

		return _driver;

	}

	
	// ---------------------------------------------------------------------------------
	// METODO PAAR IMPRIMIR
	// ---------------------------------------------------------------------------------
	
	public static void imprimirConsola(String mensaje) {
		System.out.println(mensaje);
	}
	
	// ---------------------------------------------------------------------------------
	// METODOS PARA UNA LISTA List<WebElement> MANEJO DE ALERTAS
	// ---------------------------------------------------------------------------------

	// METODO CLIK PARA LISTA
	public void clickList(By allBtn, int pos, File rutaCarpeta) throws Exception {
		this.driver.findElements((By) allBtn).get(pos).click();
		captureScreen(rutaCarpeta);
	}

	// METODO CLIK PARA ACEPTAR OK ALERTA
	public void acepAlert(File rutaCarpeta) throws Exception {
		this.driver.switchTo().alert().accept();
		captureScreen(rutaCarpeta);
	}

	// METODO CLIK PARA CANCELAR ALERTA
	public void canceAlert(File rutaCarpeta) throws Exception {
		this.driver.switchTo().alert().dismiss();
		captureScreen(rutaCarpeta);
	}

	// METODO CLIK PARA TEXTO EN ALERTA
	public void textoAlert(File rutaCarpeta, String dataExcel) throws Exception {
		this.driver.switchTo().alert().sendKeys(dataExcel);
		captureScreen(rutaCarpeta);
		tiempoEspera(2000);
	}
	// FIN METODOS ALERT
	// ---------------------------------------------------------------------------------

	// SELECCIONAR LISTA
	public Select seleccionarLista(ReadExcelFile leer, By locator, Properties propiedades, String numHoja, int file,
			int colum) throws IOException {

		Select objSelect = new Select(driver.findElement(locator));
		objSelect.selectByValue(leer.getCellValue(propiedades.getProperty("filePathExcel"), numHoja, file, colum));
		return objSelect;
	}

	//SCROLL
	public void scrollVertical(File rutaCarpeta) throws Exception {
		
		@SuppressWarnings("rawtypes")
		TouchAction touch = new TouchAction(driver);
		touch.press(PointOption.point(353, 390))
		.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
		.moveTo(PointOption.point(350,430))
		.release().perform();
		captureScreen(rutaCarpeta);
		
	}

	// METODO CLIK
	public void click(By locator, File rutaCarpeta) throws Exception {
		this.driver.findElement(locator).click();
		captureScreen(rutaCarpeta);
	}

	// METODO PARA ENVIAR FECHA
	public void campoDateCssSelector(String locator, String dateExcel) throws Exception {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document." + locator + "').value='" + dateExcel + "'");
	}

	// METODO BORRAR
	public void borrar(By locator, File rutaCarpeta) throws Exception {
		this.driver.findElement(locator).clear();
		captureScreen(rutaCarpeta);
	}

	// METODO ENVIAR TEXTO
	public void sendKey(String inputText, By locator, File rutaCarpeta) throws Exception {
		this.driver.findElement(locator).sendKeys(inputText);
		captureScreen(rutaCarpeta);
	}

	// método seleccionar todo
	public void seleccionar(By locator, File rutaCarpeta) throws Exception {
		driver.findElement(locator).sendKeys(Keys.CONTROL, "a");
		captureScreen(rutaCarpeta);
	}

	// METODO ELIMINAR
	public void teclaBorrar(By locator, File rutaCarpeta) throws Exception {
		driver.findElement(locator).sendKeys(Keys.BACK_SPACE);
	}

	// metodo limpiar
	public void txtDelete(By locator) throws Exception {
		this.driver.findElement(locator).clear();

	}

	// METODO ENTER SUBMI
	public void submit(By locator, File rutaCarpeta) throws Exception {
		this.driver.findElement(locator).submit();
		captureScreen(rutaCarpeta);
	}

	// METODO TIEMPO DE ESPERA
	public void tiempoEspera(long tiempo) throws InterruptedException {
		Thread.sleep(tiempo);
	}

	public String fechaHora() {
		// TOMAMOS LA FECHA DEL SISTEMA
		LocalDateTime fechaSistema = LocalDateTime.now();
		// DEFINIR FORMATO FECHA
		DateTimeFormatter fecha = DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss");
		// DAR FORMATO A LA FECHA DEL SITEMA
		String formatFecha = fecha.format(fechaSistema);
		return formatFecha;
	}

	public String HoraSistema() {
		// TOMAMOS LA FECHA DEL SISTEMA
		LocalTime horaSistema = LocalTime.now();
		// DEFINIR FORMATO FECHA
		DateTimeFormatter fecha = DateTimeFormatter.ofPattern("HHmmss");
		// DAR FORMATO A LA FECHA DEL SITEMA
		String hora = fecha.format(horaSistema);
		return hora;
	}

	public void captureScreen(File rutaCarpeta) throws Exception {

		String hora = HoraSistema();
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File(rutaCarpeta + "\\" + hora + ".png"));
	}

	public File crearCarpeta(Properties propiedades, String nomTest) {

		// ALMACENAMOS LA FECHA DEL SISTEMA
		String fecha = fechaHora();
		// CREAMOS EL NOMBRE DE LA CARPETA
		String nomCarpeta = nomTest + "-" + fecha;

		// OBTENEMOS LA RUTA DEL ALOJAMIENTO DE SALIDA Y EL NOMBRE DEL TEST A EJECUTAR
		File directorio = new File("./output/" + nomCarpeta);
		// CREAMOS LA CARPETA
		directorio.mkdir();

		return directorio;

	}// fin metodo

}
