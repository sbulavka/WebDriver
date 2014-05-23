package demo.test.forms;

import org.openqa.selenium.By;
import webdriver.BaseForm;
import webdriver.elements.Button;
import webdriver.elements.Label;
import webdriver.elements.TextBox;


public class MPPracticeLoginPage extends BaseForm {
	private static String formlocator="//form[@class='form-signin ng-pristine ng-invalid ng-invalid-required']";

    private Label lbMPPractice = new Label(By.xpath("//h2[text()[contains(., 'MaxPatient')]]"), "MaxPatient form");

	public MPPracticeLoginPage() {
		super(By.xpath(formlocator), "MP Practice Log in form");
	}

    public void MPPracticeAssert (){
        assert(lbMPPractice.isPresent());
    }

}
