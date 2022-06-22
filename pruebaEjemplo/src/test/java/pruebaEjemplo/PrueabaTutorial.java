package pruebaEjemplo;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PrueabaTutorial {

		private WebDriver driver;
		
		
		public void setUp() {
			
			System.setProperty("webdriver.chrome.driver", "/src/test/resources/chromeDriver/chromedriver.exe");
			driver =  new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("https://www.google.com/");
			
			
		}
		
		
	public void testGoogle() {
		
		WebElement buscar = driver.findElement(By.name("q"));
		
		buscar.clear();
		
		buscar.sendKeys("Gears of war");
		
		buscar.submit();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		assertEquals("Gears of war - Google Search ", driver.getTitle());
	}
	
	public void tearDown() {
		driver.quit();
	}
	

}
