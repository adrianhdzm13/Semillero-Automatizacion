package MapObjet;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import SemilleroPom.ClaseBase;

public class MapObjetWidgets  extends ClaseBase {

	public MapObjetWidgets(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	protected By sectionWidgets = By.xpath("//h5[contains(text(),'Widgets')]");
	protected By optionDatePicker = By.xpath("//span[contains(text(),'Date Picker')]");
	
	
	//DATE
	protected String date =  "querySelector('#datePickerMonthYearInput";
	protected By pruebaDate = By.cssSelector("#datePickerMonthYearInput");
	
	//DATETIME
	protected By dateTime = By.xpath("//input[@id='dateAndTimePickerInput']");
	protected String dateTime2 = "querySelector('#dateAndTimePickerInput";
	
	
	//js.executeScript("document.querySelector('"+locator+"').value='" + dateExcel + "'");
	
	protected String dateXpath =  "getElementById('//input[@id='datePickerMonthYearInput']";
	
	

    
	
	//input[@id='dateAndTimePickerInput']
	//CLICK EN BLANCO
	protected By blanco = By.xpath("//div[contains(text(),'Date And Time')]");
	
	protected By blanco2 = By.xpath("//div[contains(text(),'Select Date')]");
	
	
	
	
	

	
	
	
	
	
	
	
	
	
	
	

}
