package SemilleroPom;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import utilidadesExcel.ReadExcelFile;

public class ClaseBase {

	protected WebDriver driver;
	
	

	// CONSTRUCTOR DE CLASE
	public ClaseBase(WebDriver driver) {
		super();
	}

	// METODO INICIAL
	public void urlAcceso(String url) {
		driver.get(url);
		// busquedaInicial();
	}

	 //METODO DE NAVEGADOR
    public static WebDriver chromeDriverConnetion() {

        WebDriver _driver = null;
        try {
        //SETEAR LAS OPCIONES DE NAVEGADOR
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);

        //SETEAR LAS PROPIEDADES DEL NAVEGADOR
        System.setProperty("webdriver.chrome.driver", "./src/test/resources/driver/chromedriver.exe");
        _driver = new ChromeDriver();

        //MAXIMIZAR NAVEGADOR
        _driver.manage().window().maximize();
        return _driver;
        } catch (Exception e) {
            System.out.println(e);
        }
        return _driver;
    }
    
  //SELECCIONAR LISTA
    public 	Select seleccionarLista(ReadExcelFile leer, By locator, Properties propiedades, String numHoja, int file, int colum) throws IOException{

   	Select objSelect = new Select(driver.findElement(locator));
   	objSelect.selectByValue(leer.getCellValue(propiedades.getProperty("filePathExcel"), numHoja, file,colum));
   	return objSelect;
   }


    //METODO SCROLLBAR
    public void scrollBar() {
    	JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");
    }
	// METODO CLIK
	public void click(By locator, File rutaCarpeta) throws Exception {
		this.driver.findElement(locator).click();
		tiempoEspera(100);
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
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Rectangle screenRectangle = new Rectangle(screenSize);
		Robot robot = new Robot();
		BufferedImage image = robot.createScreenCapture(screenRectangle);
		ImageIO.write(image, "png", new File(rutaCarpeta + "/" + hora + ".jpg"));

	}// fin metodo

	public File crearCarpeta(Properties propiedades, String nomTest) {

		// ALMACENAMOS LA FECHA DEL SISTEMA
		String fecha = fechaHora();
		// CREAMOS EL NOMBRE DE LA CARPETA
		String nomCarpeta = nomTest + "-" + fecha;

		// OBTENEMOS LA RUTA DEL ALOJAMIENTO DE SALIDA Y EL NOMBRE DEL TEST A EJECUTAR
		File directorio = new File("./src/test/resources/output/" + nomCarpeta);
		// CREAMOS LA CARPETA
		directorio.mkdir();

		return directorio;

	}// fin metodo

}
