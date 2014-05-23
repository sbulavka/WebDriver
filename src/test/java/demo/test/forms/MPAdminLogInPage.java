package demo.test.forms;

import org.openqa.selenium.By;
import webdriver.BaseForm;
import webdriver.elements.Button;
import webdriver.elements.Label;
import webdriver.elements.Tab;
import webdriver.elements.TextBox;



public class MPAdminLogInPage extends BaseForm {
	private static String formlocator="//form[@class='form-signin ng-pristine ng-invalid ng-invalid-required']";

	private TextBox txbUserName = new TextBox(By.id("UserName"),"User Name filed");
    private TextBox txbPassword = new TextBox(By.id("Password"),"Password filed");
	private Button btnLogin = new Button (By.xpath("//button[@type='submit']"),"Login button");
    private Label lbMpAdminRoom = new Label(By.xpath(formlocator), "MaxPatAdminRoom label");
    private Label lbGoToPracLogin = new Label(By.partialLinkText("Go to practice login"), "Go to practice login link");


    public void Login(String username,String password) {
        txbUserName.type(username);
        txbPassword.type(password);
        btnLogin.click();
    }

	public MPAdminLogInPage() {
		super(By.xpath(formlocator), "MP Admin form");
	}

    public void LogOutAssert (){
        assert(lbMpAdminRoom.isPresent());
    }

    public void goToPractLoginClick () {
        lbGoToPracLogin.waitForIsElementPresent();
        lbGoToPracLogin.click();
    }
}
