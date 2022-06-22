package MapObjet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import SemilleroPom.ClaseBase;

public class MapObjetRegister extends ClaseBase {

	// CONSTRUCTOR DE LA CLASE
	
	
	public MapObjetRegister(WebDriver driver) {
		super(driver);
	}

	// ELEMENTOS PAGINA INICIAL
	
	protected By bntRegister = By.xpath("//a[contains(text(),'REGISTER')]");
	protected By txtfFirstName = By.xpath("//input[@name='firstName']");
	protected By txtLastName = By.xpath("//input[@name='lastName']");
	protected By txtPhone = By.xpath("//input[@name='phone']");
	protected By txtEmail = By.xpath("//input[@id='userName']");
	protected By txtAddres = By.xpath("//input[@name='address1']");
	protected By txtCity = By.xpath("//input[@name='city']");
	protected By txtState = By.xpath("//input[@name='state']");
	protected By txtPostalCode = By.xpath("//input[@name='postalCode']");
	protected By listCountry = By.xpath("//select[@name='country']");
	protected By txtUser = By.xpath("//input[@id='email']");
	protected By txtPass = By.xpath("//input[@name='password']");
	protected By txtConfirmaPas = By.xpath("//input[@name='confirmPassword']");
	protected By btnSubmit = By.xpath("//input[@name='submit']");
	protected By btnHome = By.xpath("//a[contains(text(),'Home')]");
	
}
