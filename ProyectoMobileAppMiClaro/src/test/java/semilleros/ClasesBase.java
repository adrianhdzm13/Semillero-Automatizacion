package semilleros;

import java.awt.AWTException;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.NoSuchElementException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import utilidadesExcel.ReadExcelFile;

public class ClasesBase {

	protected AppiumDriver<MobileElement> driver;

	// CONSTRUCTOR DE CLASE
	public ClasesBase(AppiumDriver<MobileElement> driver ) {
		super();
	}

	// METODO DE NAVEGADOR
	@SuppressWarnings("rawtypes")
	public static AppiumDriver appiumDriverConnetion(Properties propiedades) {

		AppiumDriver _driver = null;
		try {

			// CREARLAS CAPABILITYS DEL MOVIL
			DesiredCapabilities caps = new DesiredCapabilities();
			caps.setCapability("platformName", propiedades.getProperty("platformName"));
			caps.setCapability("deviceName", propiedades.getProperty("deviceName"));
			caps.setCapability("platformVersion", propiedades.getProperty("platformVersion"));
			caps.setCapability("appPackage", propiedades.getProperty("appPackage"));
			caps.setCapability("appActivity", propiedades.getProperty("appActivity"));
			caps.setCapability("noReset", propiedades.getProperty("noReset"));
			caps.setCapability("autoGrantPermissions", propiedades.getProperty("autoGrantPermissions"));
			
			try {
				printConsole("Cargando capability de apium, favor esperar...");
				_driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
			} catch (MalformedURLException e) {
				printConsole(e.getMessage());
			}
			return _driver;
		} catch (Exception e) {
			printConsole(e.getMessage());
		}
		return _driver;
	}
	//METODO PARA REEMPLAZAR SYSTEM.OUT.PRINT
	public static void printConsole(String texto) {
		System.out.println(texto);
	}

	// METODO CLICK
	public void click(By locator, File rutaCarpeta) throws Exception {
		driver.findElement(locator).click();
		tiempoEspera(2000);
		captureScreen(rutaCarpeta);

	}

	//METODO PARA CONVERTIR EL ID DE LA CALCULADORA 
	public void numCal(char c, File rutaCarpeta) throws Exception{
		String v = "com.miui.calculator:id/btn_" + c + "_s";
		By nc = By.id(v);
		click(nc, rutaCarpeta);
	}
	
	//Scroll Arriba
	public void scrollArriba(File rutaFile, int x, int y, int z, int a) throws Exception {
		@SuppressWarnings("rawtypes")
		TouchAction touch = new TouchAction(driver);
		touch.press(PointOption.point(x, y)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2))).moveTo(PointOption.point(z,a)).release().perform();
		captureScreen(rutaFile);
	}
	
	//Scroll Arriba
	public void scrollAbajo(File rutaFile, int x, int y, int z, int a) throws Exception {
		@SuppressWarnings("rawtypes")
		TouchAction touch = new TouchAction(driver);
		touch.press(PointOption.point(x, y)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2))).moveTo(PointOption.point(z,a)).release().perform();
		captureScreen(rutaFile);
	}
	
	//Scroll a la Derecha
	public void scrollDerecha(File rutaFile) throws Exception {
		@SuppressWarnings("rawtypes")
		TouchAction touch = new TouchAction(driver);
		touch.press(PointOption.point(764,1300)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2))).moveTo(PointOption.point(143,1300)).release().perform();
		captureScreen(rutaFile);
	}
	

	// METODO BORRAR
	public void borrar(By locator, File rutaFile) throws AWTException, IOException {
		driver.findElement(locator).clear();
		captureScreen(rutaFile);
	}

	// METODO ENVIAR TEXTO
	public void sendKey(String inputText, By locator, File rutaFile)
			throws AWTException, IOException, InterruptedException {
		driver.findElement(locator).sendKeys(inputText);
		tiempoEspera(2000);
		captureScreen(rutaFile);
	}

	// METODO ENTER SUBMIN
	public void submit(By locator, File rutaFile) throws AWTException, IOException {
		driver.findElement(locator).submit();
		captureScreen(rutaFile);
	}

	// METODO PARA SELECCIONAR TODOS EL TEXTO
	public void controlA(By locator, File rutaCarpeta) {
		driver.findElement(locator).sendKeys(Keys.CONTROL, "a");
	}

	// METODO PARA LA TECLA DE BORRAR
	public void teclaborrar(By locator, File rutaCarpeta) throws InterruptedException {
		driver.findElement(locator).sendKeys(Keys.BACK_SPACE);
	}

	// METODO ENTER POR TECLADO
	public void intro(By locator, File rutaCarpeta) throws AWTException, IOException, InterruptedException {
		driver.findElement(locator).sendKeys(Keys.ENTER);
		tiempoEspera(2000);
		captureScreen(rutaCarpeta);
	}

	// METODO TIEMPO DE ESPERA
	public void tiempoEspera(long tiempo) throws InterruptedException {
		Thread.sleep(tiempo);
	}

	// METODO SELECCIONAR LISTA
	public Select seleccionarLista(ReadExcelFile leer, By locator, Properties propiedades, String numHoja, int file,
			int colum) throws IOException {
		Select objSelect = new Select(driver.findElement(locator));
		objSelect.selectByValue(leer.getCellValue(propiedades.getProperty("filePathExcel"), numHoja, file, colum));
		return objSelect;
	}

	// SCROLL
	public void scroll(int scr) throws InterruptedException {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0," + scr + ")");
		tiempoEspera(1000);
	}
	
	public void escribir(String palabra) throws Exception {
		char[] c = palabra.toCharArray();
		for(int i=0; i<palabra.length(); i++) {
			String C = String.valueOf(c[i]);
			C = C.toUpperCase();
			if(C.equals("0") || C.equals("1") || C.equals("2") || C.equals("3") || C.equals("4") || C.equals("5") || C.equals("6") || C.equals("7") || C.equals("8") || C.equals("9")) {
				String D="DIGIT_"+C;
				((AndroidDriver<MobileElement>) driver).pressKey(new KeyEvent(AndroidKey.valueOf(D)));
			}
			else if (C.equals("@")) {
				((AndroidDriver<MobileElement>) driver).pressKey(new KeyEvent(AndroidKey.AT));
			}
			else if (C.equals(".")) {
				((AndroidDriver<MobileElement>) driver).pressKey(new KeyEvent(AndroidKey.PERIOD));
			}
			else if (C.equals(" ")) {
				((AndroidDriver<MobileElement>) driver).pressKey(new KeyEvent(AndroidKey.SPACE));
			}
			else {
				((AndroidDriver<MobileElement>) driver).pressKey(new KeyEvent(AndroidKey.valueOf(C)));
			}
			
		}
		driver.hideKeyboard();
	}

	//TOCAR PANTALLA
	public void tocarPantalla(int x, int y) {
		@SuppressWarnings("rawtypes")
		TouchAction touch = new TouchAction(driver);
		touch.press(PointOption.point(x,y)).release().perform();
	}
	//METODO FECHA HORA
	public String fechaHora() {
		// TOMAMOS LA FECHA DEL SISTEMA
		LocalDateTime fechaSistema = LocalDateTime.now();
		// DEFINIR FORMATO FECHA
		DateTimeFormatter fecha = DateTimeFormatter.ofPattern("dd-MMM-yyyy h-mm-ss a");
		// DAR FORMATO A LA FECHA DEL SISTEMA
		String formatFecha = fecha.format(fechaSistema);
		return formatFecha;
	}

	//METODO HORA SISTEMA
	public String HoraSistema() {
		// TOMAMOS LA FECHA DEL SISTEMA
		LocalTime horaSistema = LocalTime.now();
		// DEFINIR FORMATO FECHA
		DateTimeFormatter fecha = DateTimeFormatter.ofPattern("h-mm-ss a");
		// DAR FORMATO A LA FECHA DEL SISTEMA
		String hora = fecha.format(horaSistema);
		return hora;
	}

	//METODO CAPTURA IMAGEN
	public void captureScreen(File rutaCarpeta) throws AWTException, IOException {
		String hora = HoraSistema();
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File(rutaCarpeta + "\\" + hora + ".png"));
	}

	//METODO CREAR CARPETA DE IMAGEN
	public File crearCarpeta(Properties propiedades, String nomTest) {
		// ALMACENAMOS LA FECHA DEL SISTEMA
		String fecha = fechaHora();
		// CREAMOS EL NOMBRE DE LA CARPETA
		String nomCarpeta = nomTest + "_" + fecha;
		// OBTENEMOS LA RUTA DE ALOJAMIENTO DE SALIDA Y EL NOMBRE DEL TEST A EJECUTAR
		File directorio = new File("./output/" + nomCarpeta);
		// CREAMOS LA CARPETA
		directorio.mkdir();
		return directorio;
	}
	
	//METODO OBTENER LOS DATOS DEL EXCEL PARA CALCULADORA
	public String obtenerExcel(ReadExcelFile leer, Properties propiedades, String numHoja, int fila, int colum) throws Exception {
		String valor = leer.getCellValue(propiedades.getProperty("filePatchExcel"), numHoja, fila, colum);
		return valor;
	}
	
	//METODO SCROLL VERTICAL
	public void scrollVertical(File rutaFile) throws AWTException, IOException {
		@SuppressWarnings("rawtypes")
		TouchAction touch = new TouchAction(driver);
		touch.press(PointOption.point(350,930))
		.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
		.moveTo(PointOption.point(350,430))
		.release().perform();
		captureScreen(rutaFile);
	}
	
	public boolean elementoPresente(By locator) {
		boolean present;
		try {
			driver.findElements(locator);
			present = true;
		} catch (NoSuchElementException e) {
			present = false;
			// TODO: handle exception
		}
		return present;
	}
	
	//METODO PARA CONVERTIR EL ID DE LA CALCULADORA 
		public void selectClaro(String c, File rutaCarpeta) throws Exception{
			String v = "//android.widget.CheckedTextView[@text='"+ c + "']";
			By nc = By.xpath(v);
			click(nc, rutaCarpeta);
		}
	
	


}

