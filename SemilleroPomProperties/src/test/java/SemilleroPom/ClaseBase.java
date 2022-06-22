package SemilleroPom;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ClaseBase {

	protected WebDriver driver;

	// CONSTRUCTOR DE CLASE
	public ClaseBase(WebDriver driver) {
		super();
	}

	// METODO DE NAVEGADOR
	public WebDriver chromeDriverConnection() {
		// SETEAR LAS OPCIONES DE NAVEGADOR
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);

		// SETEAR LAS PROPIEDADES DEL NAVEGADOR
		System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver.exe");
		this.driver = new ChromeDriver();

		// MAXIMIZAR NAVEGADOR
		this.driver.manage().window().maximize();
		return this.driver;

	}// fin

		// METODO CLIK
		public void click(By locator, File rutaCarpeta) throws Exception{
			this.driver.findElement(locator).click();
			tiempoEspera(2000);
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

		public String fechaHora()
		{
		//TOMAMOS LA FECHA DEL SISTEMA
		LocalDateTime fechaSistema = LocalDateTime.now();
		//DEFINIR FORMATO FECHA
		DateTimeFormatter fecha = DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss");
		//DAR FORMATO A LA FECHA DEL SITEMA
		String formatFecha = fecha.format(fechaSistema);
		return formatFecha;
		}


		public String HoraSistema()
		{
		//TOMAMOS LA FECHA DEL SISTEMA
		LocalTime horaSistema = LocalTime.now();
		//DEFINIR FORMATO FECHA
		DateTimeFormatter fecha = DateTimeFormatter.ofPattern("HHmmss");
		//DAR FORMATO A LA FECHA DEL SITEMA
		String hora = fecha.format(horaSistema);
		return hora;
		}
		public void captureScreen(File rutaCarpeta)  throws Exception {

		String hora = HoraSistema();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Rectangle screenRectangle = new Rectangle(screenSize);
		Robot robot = new Robot();
		BufferedImage image = robot.createScreenCapture(screenRectangle);
		ImageIO.write(image, "png", new File(rutaCarpeta+"/"+hora+".jpg"));

	}// fin metodo

	public File crearCarpeta(Properties propiedades, String nomTest) {
	
		//ALMACENAMOS LA FECHA DEL SISTEMA
		String fecha = fechaHora();
		//CREAMOS EL NOMBRE DE LA CARPETA 
		String nomCarpeta = nomTest+"-"+fecha;
		
		//OBTENEMOS LA RUTA DEL ALOJAMIENTO DE SALIDA Y EL NOMBRE DEL TEST A EJECUTAR
		File directorio = new File("./src/test/resources/output/" + nomCarpeta);
		//CREAMOS LA CARPETA
		directorio.mkdir();

		return directorio;

	}// fin metodo
	
}
