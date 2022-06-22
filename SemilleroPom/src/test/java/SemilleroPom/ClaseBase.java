package SemilleroPom;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ClaseBase {

	protected WebDriver driver;

	// CONSTRUCTOR DE CLASE
	public ClaseBase(WebDriver driver) 
	{
		super();
	}

	// METODO DE NAVEGADOR
	public WebDriver chromeDriverConnection() 
	{
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
	public void click(By locator) throws InterruptedException {
		this.driver.findElement(locator).click();
		tiempoEspera(2000);
	}

	// METODO BORRAR
	public void borrar(By locator) 
	{
		this.driver.findElement(locator).clear();
	}

	// METODO ENVIAR TEXTO
	public void sendKey(String inputText, By locator) 
	{
		this.driver.findElement(locator).sendKeys(inputText);
	}

	// METODO ENTER SUBMI
	public void submit(By locator)
	{
		this.driver.findElement(locator).submit();
	}

	// METODO TIEMPO DE ESPERA
	public void tiempoEspera(long tiempo) throws InterruptedException 
	{
		Thread.sleep(tiempo);
	}
	

}
