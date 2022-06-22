package SemilleroPom;

import java.awt.AWTException;
import java.awt.Dimension;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.formula.functions.Value;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import utilidadesExcel.ReadExcelFile;

public class ClaseBase {

	// protected WebDriver driver;
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
	// METODO APPIUM
	// ---------------------------------------------------------------------------------
	@SuppressWarnings("rawtypes")
	public static AppiumDriver appiumDriverConnetion(Properties propiedades) {

		AppiumDriver _driver = null;
		try {
			// SETEAR LAS OPCIONES DE NAVEGADOR
			DesiredCapabilities caps = new DesiredCapabilities();

			caps.setCapability("platformName", propiedades.getProperty("platformName"));
			caps.setCapability("deviceName", propiedades.getProperty("deviceName"));
			caps.setCapability("platformVersion", propiedades.getProperty("platformVersion"));
			caps.setCapability("appPackage", propiedades.getProperty("appPackage"));
			caps.setCapability("appActivity", propiedades.getProperty("appActivity"));
			caps.setCapability("noReset", propiedades.getProperty("noReset"));
			caps.setCapability("autoGrantPermissions", propiedades.getProperty("autoGrantPermissions"));
			caps.setCapability("autoAcceptAlerts", propiedades.getProperty("autoAcceptAlerts"));
			caps.setCapability("autoDismissAlerts", propiedades.getProperty("autoDismissAlerts"));

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

	// METODO CLIK PARA LISTA CON POP PAP
	public void clickListSwitchTo(By allBtn, int pos, File rutaCarpeta) throws Exception {
		this.driver.findElements((By) allBtn).get(pos).click();
		driver.switchTo();
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

	// METODO PARA ANDROID ESCRIBIR EN U
	@SuppressWarnings({ "deprecation", "rawtypes" })
	public void write(File rutaCarpeta, String word) throws Exception {

		word = word.toUpperCase();
		char[] c = word.toCharArray();

		for (int i = 0; i < word.length(); i++) {

			String mayus = String.valueOf(c[i]);

			if (mayus.equals("@")) {
				((AndroidDriver<MobileElement>) driver).pressKey(new KeyEvent(AndroidKey.AT));
			} else if (mayus.equals(".")) {
				((AndroidDriver<MobileElement>) driver).pressKey(new KeyEvent(AndroidKey.PERIOD));
			} else if (mayus.equals(" ")) {
				((AndroidDriver<MobileElement>) driver).pressKey(new KeyEvent(AndroidKey.SPACE));
			} else {
				((AndroidDriver<MobileElement>) driver).pressKey(new KeyEvent(AndroidKey.valueOf(mayus)));
				captureScreen(rutaCarpeta);
			}
		}

		// TECLA TAB
		// ((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.TAB));
		// TECLA TAB
		// driver.getKeyboard().pressKey(Keys.TAB);

		// CERRAR TECLADO
		// driver.hideKeyboard();

	}

	public void writeInt( File rutaCarpeta, int num) throws Exception {

		  String word = String.valueOf(num); // DE INT A STRING
		  
		  char[] c = word.toCharArray(); // DIVIDE LA CADENA EN UN ARREGLO
		  
		  for (int i = 0; i < word.length(); i++) {
		  
		  String cadena = String.valueOf(c[i]); // VALOR DE CADENA A UN STRING
		 
		  int numEntero = Integer.parseInt(cadena); // DE STRING A INT
		  
		  String d = "DIGIT_"+numEntero;
		  

		  ((AndroidDriver<MobileElement>) driver).pressKey(new KeyEvent(AndroidKey.valueOf(d)));
		  captureScreen(rutaCarpeta);
		  }
		 
		// TECLA TAB

		// CERRAR TECLADO
		// driver.hideKeyboard();

	}

	public void tabAndroid() {
		driver.getKeyboard().pressKey(Keys.TAB);
	}

	// SCROLL
	public void scrollVertical(File rutaCarpeta) throws Exception {

		@SuppressWarnings("rawtypes")
		TouchAction touch = new TouchAction(driver);
		// INICIO
		touch.press(PointOption.point(505, 332)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
				.moveTo(PointOption.point(505, 2110)).release().perform(); // HASTA ODE LO VAMOS A MOVER, CON TIEMPO D
																			// E2 SEGUNDOS
		captureScreen(rutaCarpeta);

	}

	// SCROLLVERCTICAL ANDROID
	public void scrollVertical(File rutaFile, int xini, int yini, int yfinal, int iteraciones) throws Exception {
		for (int i = 1; i <= iteraciones; i++) {
			@SuppressWarnings("rawtypes")
			TouchAction touch = new TouchAction(driver);
			touch.press(PointOption.point(xini, yini)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3)))
					.moveTo(PointOption.point(xini, yfinal)).release().perform();
			captureScreen(rutaFile);
		}
	}

	// SCROLLVERCTICAL ANDROID
	public void scrollHorizontal(File rutaFile, int xini, int yini, int xfinal, int iteraciones) throws Exception {
		for (int i = 1; i <= iteraciones; i++) {
			@SuppressWarnings("rawtypes")
			TouchAction touch = new TouchAction(driver);
			touch.press(PointOption.point(xini, yini)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3)))
					.moveTo(PointOption.point(xfinal, yini)).release().perform();
			captureScreen(rutaFile);
		}
	}

	// METODO ENTER EN ANDROID
	@SuppressWarnings("deprecation")
	public void enterFlechaVerdeAndroid() {
		driver.getKeyboard().pressKey(Keys.ENTER);
	}

	// TOCAR PANTALLA
	public void tocarPantalla() {
		@SuppressWarnings("rawtypes")
		TouchAction touch = new TouchAction(driver);
		touch.press(PointOption.point(399, 335)).release().perform();
	}

	public void tocarPantalla2(int x, int y) {
		@SuppressWarnings("rawtypes")
		TouchAction touch = new TouchAction(driver);
		touch.press(PointOption.point(x, y)).release().perform();
	}

	// METODO CLIK
	public void click(By locator, File rutaCarpeta) throws Exception {
		this.driver.findElement(locator).click();
		captureScreen(rutaCarpeta);
	}

	// METODO switchTo
	public void clickSwitchTo(By locator, File rutaCarpeta) throws Exception {
		this.driver.findElement(locator).click();
		driver.switchTo();
		// driver.getWindowHandles(); /DE ESTA FORMA SIRVE
		captureScreen(rutaCarpeta);
	}

	// METODO SUMA
	public void suma(By locator, File rutaCarpeta) throws Exception {
		this.driver.findElement(locator).click();
		captureScreen(rutaCarpeta);
	}

	// METODO PARA ENVIAR FECHA
	public void campoDateCssSelector(String locator, String dateExcel) throws Exception {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document." + locator + "').value='" + dateExcel + "'");
	}

	// METODO CLIK ANDROID
	public void clickNumExcel(String num1, File rutaCarpeta) throws Exception {
		this.driver.findElementById(num1).click();
		captureScreen(rutaCarpeta);
	}

	// METODO DE OPERACION
	public void clickOperacion(String operador, File rutaCarpeta) throws Exception {
		this.driver.findElementByXPath(operador).click();
		captureScreen(rutaCarpeta);
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

	// METODO ENTER
	public void teclaEnter(By locator, File rutaCarpeta) throws Exception {
		driver.findElement(locator).sendKeys(Keys.ENTER);
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
		Thread.sleep(tiempo * 1000);
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
