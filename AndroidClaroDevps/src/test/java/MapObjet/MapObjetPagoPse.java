package MapObjet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import SemilleroPom.ClaseBase;

public class MapObjetPagoPse extends ClaseBase {

	public MapObjetPagoPse(WebDriver driver) {
		super(driver);
	}

	//LOCALIZADORES
	protected By btnInicioPago = By.xpath("//android.widget.FrameLayout[@content-desc=\"Pagos\"]/android.widget.ImageView");
	protected By btnPagarAqui = By.xpath("//android.widget.Button[@text='Paga tu factura aquí']");
	protected By btnPagar = By.xpath("//android.widget.Button[@text='Pagar']");
	protected By clickLista = By.xpath("//android.view.View[@resource-id='select']");
	protected By btnContinuar = By.xpath("//android.widget.Button[@resource-id='mySubmit_']");
	protected By clickListaBanco = By.xpath("//android.widget.Spinner[@resource-id='BANCO']");
    protected By txtNombreTitular = By.xpath("//android.widget.EditText[@resource-id='TITULAR']");
    protected By clickListaTipoClie = By.xpath("//android.widget.Spinner[@resource-id='TIPO_CLIENTE']");
    protected By clickTipoDocumneto = By.xpath("//android.widget.Spinner[@resource-id='TIPO_DOCUMENTO']");
    protected By txtNumDocument = By.xpath("//android.widget.EditText[@resource-id='NUMERO_DOCUMENTO']");
    protected By txtNumTel = By.xpath("//android.widget.EditText[@resource-id='TELEFONO']");
    protected By txtDireccio = By.xpath("//android.widget.EditText[@resource-id='DIRECCION']");
    protected By txtEmail = By.xpath("//android.widget.EditText[@resource-id='EMAIL']");
    protected By btnCancelar = By.xpath("//android.widget.Button[@resource-id='btnCancelar']");
  
    
    //LISTAS
    protected String lisBanco = "//android.widget.CheckedTextView[@text='";
    protected String complet = "//android.view.View[@content-desc='";
    protected String complet2 = "//android.widget.CheckedTextView[@text ='";


	

}
