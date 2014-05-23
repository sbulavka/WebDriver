package demo.test.forms;

import org.openqa.selenium.By;
import webdriver.BaseForm;
import webdriver.elements.Button;
import webdriver.elements.Label;
import webdriver.elements.TextBox;

//import java.lang.*;

public class MPAdminEditCenterPage extends BaseForm {
	private static String formlocator="//div[@class='container']";


    private TextBox txbCenterEmail = new TextBox(By.name("CenterEmail"),"Center Email filed");
	private Button btnSave = new Button (By.xpath("//button[@class='btn btn-lg btn-primary']"),"Save button");
    private Label lbEditCenter= new Label(By.xpath("//legend[text()[contains(., 'Edit Form')]]"), "Edit Form label");

    public void ChangeEmailField(String CenterEmail) {
        txbCenterEmail.setText("");
        txbCenterEmail.type(CenterEmail);
        btnSave.click();
    }

	public MPAdminEditCenterPage() {
		super(By.xpath(formlocator), "MP Reg form");
	}



    public void EdtCenterFormAssert(){
        lbEditCenter.waitForIsElementPresent();
        assert(lbEditCenter.isPresent());
    }
}
