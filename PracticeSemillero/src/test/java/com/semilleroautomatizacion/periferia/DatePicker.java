package com.semilleroautomatizacion.periferia;

import java.util.Calendar;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DatePicker {
	
    @Test
    public void testDAtePicker() throws Exception{
        //Fecha y hora que se establecerán en TextBox
        String dateTime ="12/07/2014 2:00 PM";
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("http://demos.telerik.com/kendo-ui/datetimepicker/index");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //botón para abrir el calendario
        WebElement selectDate = driver.findElement(By.xpath("//span[@aria-controls='datetimepicker_dateview']"));
       
        selectDate.click();
        //Botón para desplazarse a la siguiente en el calendario
        WebElement nextLink = driver.findElement(By.xpath("//div[@id='datetimepicker_dateview']//div[@class='k-header']//a[contains(@class,'k-nav-next')]"));
        //Botón para hacer clic en el centro del encabezado del calendario
        WebElement midLink = driver.findElement(By.xpath("//div[@id='datetimepicker_dateview']//div[@class='k-header']//a[contains(@class,'k-nav-fast')]"));
        //botón para mover el mes anterior en el calendario
        WebElement previousLink = driver.findElement(By.xpath("//div[@id='datetimepicker_dateview']//div[@class='k-header']//a[contains(@class,'k-nav-prev')]")); 
        //Particionar el datetime para obtener solo la parte de la fecha
        String date_dd_MM_yyyy[] = (dateTime.split(" ")[0]).split("/");
        //Obtener la diferencia de año entre el año actual y el año a establecer en el Calendario
        int yearDiff = Integer.parseInt(date_dd_MM_yyyy[2])- Calendar.getInstance().get(Calendar.YEAR);
        midLink.click();
        if(yearDiff!=0){
            //Si se tiene que mover a el proximo año
            if(yearDiff>0){
                for(int i=0;i< yearDiff;i++){
                    System.out.println("Year Diff->"+i);
                    nextLink.click();
                }
            }
            //Si tienes que moverte al año anterior
            else if(yearDiff<0){
                for(int i=0;i< (yearDiff*(-1));i++){
                    System.out.println("Year Diff->"+i);
                    previousLink.click();
                }
            }
        }
        Thread.sleep(1000);
        //Obtener todos los meses de calendario para seleccionar uno correcto
        List<WebElement> list_AllMonthToBook = driver.findElements(By.xpath("//div[@id='datetimepicker_dateview']//table//tbody//td[not(contains(@class,'k-other-month'))]"));    
        list_AllMonthToBook.get(Integer.parseInt(date_dd_MM_yyyy[1])-1).click();
        Thread.sleep(1000);
        //obtener todas las fechas del calendario para seleccionar una correcta
        List<WebElement> list_AllDateToBook = driver.findElements(By.xpath("//div[@id='datetimepicker_dateview']//table//tbody//td[not(contains(@class,'k-other-month'))]"));
        list_AllDateToBook.get(Integer.parseInt(date_dd_MM_yyyy[0])-1).click();
        
        ///PARA EL TIEMPO
        WebElement selectTime = driver.findElement(By.xpath("//span[@aria-controls='datetimepicker_timeview']"));
        //clic en el boton timepicker 
        selectTime.click();
        //Obtiene la lista de times
        List<WebElement> allTime = driver.findElements(By.xpath("//div[@data-role='popup'][contains(@style,'display: block')]//ul//li[@role='option']"));
        dateTime = dateTime.split(" ")[1]+" "+dateTime.split(" ")[2];
     //Seleccionar el time correcto
        for (WebElement webElement : allTime) {
            if(webElement.getText().equalsIgnoreCase(dateTime))
            {
                webElement.click();
            }
        }
    }
}
 