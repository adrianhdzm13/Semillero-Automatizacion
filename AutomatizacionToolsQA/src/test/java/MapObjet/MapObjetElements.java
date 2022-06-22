package MapObjet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import SemilleroPom.ClaseBase;

public class MapObjetElements extends ClaseBase {

	public MapObjetElements(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	// ELEMENTOS PAGINA INICIAL

	protected By selectionElements = By.xpath("//div[@class='avatar mx-auto white']");
	protected By webTables = By.cssSelector("#item-3");
	protected By btnAdd = By.cssSelector("#addNewRecordButton");
	protected By txtFirstName = By.cssSelector("#firstName");
	protected By txtLastaname = By.cssSelector("#lastName");
	protected By txtEmail = By.cssSelector("#userEmail");
	protected By txtAge = By.cssSelector("#age");
	protected By txtSalary = By.cssSelector("#salary"); 
	protected By txtDepartment = By.cssSelector("#department"); 
	protected By btnSubmit = By.cssSelector("#submit");
	protected By txtBuscar = By.cssSelector("#searchBox"); 
	protected By btnBuscar = By.cssSelector("#basic-addon2");
	protected By delete = By.cssSelector("#delete-record-4");
	protected By btnBuscarLimpiar = By.cssSelector("#basic-addon2");
	protected By actionInicio = By.xpath("//a[@href='https://demoqa.com']");
	
	


}
