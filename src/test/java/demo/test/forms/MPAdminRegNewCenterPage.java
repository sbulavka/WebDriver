package demo.test.forms;

import org.openqa.selenium.By;
import webdriver.BaseForm;
import webdriver.elements.Label;
import webdriver.elements.Button;
import webdriver.elements.TextBox;

public class MPAdminRegNewCenterPage extends BaseForm {
	private static String formlocator="//div[@class='container']";

	private TextBox txbCenterName = new TextBox(By.name("CenterName"),"Center Name filed");
    private TextBox txbOfficeAccount = new TextBox(By.name("OfficeAccount"),"Office Account filed");
    private TextBox txbCenterEmail = new TextBox(By.name("CenterEmail"),"Center Email filed");
    private TextBox txbPhoneNumber = new TextBox(By.name("PhoneNumber"),"Phone Number filed");
    private TextBox txbFax = new TextBox(By.name("Fax"),"Fax filed");
    private TextBox txbStreet = new TextBox(By.name("Street"),"Street filed");
    private TextBox txbCity = new TextBox(By.name("City"),"City filed");
    private TextBox txbState = new TextBox(By.name("State"),"State filed");
    private TextBox txbZipCode = new TextBox(By.name("ZipCode"),"ZipCode filed");
    private TextBox txbFirstName = new TextBox(By.name("FirstName"),"First Name filed");
    private TextBox txbLastName = new TextBox(By.name("LastName"),"LastName filed");
    private TextBox txbUserEmail = new TextBox(By.name("UserEmail"),"UserEmail filed");
    private TextBox txbUserName = new TextBox(By.name("UserName"),"UserName filed");
    private TextBox txbPassword = new TextBox(By.name("Password"),"Password filed");
    private TextBox txbConfirmPassword = new TextBox(By.name("ConfirmPassword"),"ConfirmPassword filed");
	private Button btnSave = new Button (By.xpath("//button[@class='btn btn-lg btn-primary']"),"Save button");
    private Label lbRegNewCenter= new Label(By.tagName("legend"), "Registration of new center label");

    public void FillRequiredField(String CenterName,String OfficeAccount, String CenterEmail, String PhoneNumber, String Fax,
                                  String Street, String City, String State, String ZipCode, String FirstName, String LastName,
                                  String UserEmail, String UserName, String Password, String ConfirmPassword) {
        txbCenterName.type(CenterName);
        txbOfficeAccount.type(OfficeAccount);
        txbCenterEmail.type(CenterEmail);
        txbPhoneNumber.type(PhoneNumber);
        txbFax.type(Fax);
        txbStreet.type(Street);
        txbCity.type(City);
        txbState.type(State);
        txbZipCode.type(ZipCode);
        txbFirstName.type(FirstName);
        txbLastName.type(LastName);
        txbUserEmail.type(UserEmail);
        txbUserName.type(UserName);
        txbPassword.type(Password);
        txbConfirmPassword.type(ConfirmPassword);
        btnSave.click();
    }

	public MPAdminRegNewCenterPage() {
        super(By.xpath(formlocator), "MP Reg form");
	}


    public void RegNewCenterFormAssert(){
        lbRegNewCenter.waitForIsElementPresent();
        assert(lbRegNewCenter.isPresent());
    }

}
