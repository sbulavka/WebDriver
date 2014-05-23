package demo.test.forms;

import org.openqa.selenium.By;
import org.openqa.selenium.Alert;
import webdriver.BaseForm;
import webdriver.elements.Button;
import webdriver.elements.Label;
import webdriver.elements.TextBox;
import webdriver.elements.Tab;

public class MPAdminHomePage extends BaseForm {
	private static String formlocator="//div[@class='container']";

	private Label lbWelcome = new Label(By.partialLinkText("Welcome,"), "Welcome label");
    private Label lbLogout = new Label(By.partialLinkText("Log out"), "LogOut label");
    private Tab tbRespSet = new Tab(By.partialLinkText("Response Settings"), "Response Settings tab");
    private Tab tbRespSetAct = new Tab(By.xpath("//li[@class='ng-scope active']/a[@href='#/ResponseSettings']"), "Response Settings active tab");
    private Tab tbMedCen = new Tab(By.partialLinkText("Medical Centers"), "Medical Centers tab");
    private Tab tbMedCenAct = new Tab(By.xpath("//li[@class='ng-scope active']/a[@href='#/MedicalCenters']"), "Medical Centers active tab");
    private Tab tbPerm = new Tab(By.partialLinkText("Permsions"), "Permissions tab");
    private Tab tbPermAct = new Tab(By.xpath("//li[@class='ng-scope active']/a[@href='#/Permissions']"), "Permissions active tab");
    private Label btnRegNewCenter = new Label(By.xpath("//a[@class= 'btn btn-primary']"),"Reg New Center button");
    private TextBox lbNewPosTemplate = new TextBox(By.xpath("//div[@class='answer-templates']/div/input"), "Add New Positive template link");
    private Button btnApply = new Button (By.xpath("//button[@ng-click='saveAnswerTemplates()']"),"Apply button");
    private Button btnAdd = new Button (By.xpath("//div[@class='answer-templates']/div/button"),"Add button");

    public void tabRespSettingsClick() {
        tbRespSet.click();
        assert( tbRespSetAct.isPresent());
    }

    public void addTemplate(String template){
        lbNewPosTemplate.type(template);
        assert( btnApply.isPresent());
        btnAdd.waitForIsElementPresent();
        btnAdd.click();
        btnApply.click();
    }

    public void addedTemplIsPresentAssert(String template){
        Label lbAddedTemplate= new Label(By.xpath("//div[text()[contains(., '"+template+"')]]"), "Enable button");
        lbAddedTemplate.waitForIsElementPresent();
        assert( lbAddedTemplate.isPresent());
    }

    public void tabClick() {

        tbRespSet.click();
        assert( tbRespSetAct.isPresent());
        tbPerm.click();
        assert( tbPermAct.isPresent());
        tbMedCen.click();
        assert( tbMedCenAct.isPresent());
    }

	public MPAdminHomePage() {
		super(By.xpath(formlocator), "MP Home form");
	}

	public void searchLogOutAssert(){

		assert(lbWelcome.isPresent());
        lbWelcome.click();
        assert(lbLogout.isPresent());
        lbLogout.click();
	}

    public void search_clickRegNewCenterAssert(){


        btnRegNewCenter.waitForIsElementPresent();
        assert(btnRegNewCenter.isPresent());
        btnRegNewCenter.click();
    }

    public void MedCenterAssert (String MedEmail){
        Label lbMedCenter = new Label(By.xpath("//td[text()[contains(., '"+MedEmail+"')]]"),"lbMedCenter logo");
        lbMedCenter.waitForIsElementPresent();
        assert(lbMedCenter.isPresent());
    }

    public void EditClickAssert (String MedEmail) {
        Label btnEdit = new Label(By.xpath("//td[text()[contains(., '"+MedEmail+"')]]/..//a[text()[contains(., 'Edit')]]"), "Edit button");
        btnEdit.waitForIsElementPresent();
        assert(btnEdit.isPresent());
        btnEdit.click();
    }

    public void DisableClickAssert(String MedEmail){
        Label lbdisable = new Label(By.xpath("//td[text()[contains(., '"+MedEmail+"')]]/..//a[text()[contains(., ' Disable')]]"), "Disable button");
        lbdisable.waitForIsElementPresent();
        assert(lbdisable.isPresent());
        lbdisable.click();
        Alert alert = browser.getAllert();
        alert.accept();
    }

    public void enableIsPresentAssert (String MedEmail){
        Label lbMedCenter = new Label(By.xpath("//td[text()[contains(., '"+MedEmail+"')]]/..//a[text()[contains(., 'Enable')]]"), "Enable button");
        lbMedCenter.waitForIsElementPresent();
        assert(lbMedCenter.isPresent());
    }

    public void disableIsPresentAssert (String MedEmail){
        Label lbdisable = new Label(By.xpath("//td[text()[contains(., '"+MedEmail+"')]]/..//a[text()[contains(., 'Disable')]]"), "Disable button");
        lbdisable.waitForIsElementPresent();
        assert(lbdisable.isPresent());
    }
    public void enableClickAssert (String MedEmail){
        Label lbMedCenter = new Label(By.xpath("//td[text()[contains(., '"+MedEmail+"')]]/..//a[text()[contains(., 'Enable')]]"), "Enable button");
        lbMedCenter.waitForIsElementPresent();
        lbMedCenter.click();
        Alert alert = browser.getAllert();
        alert.accept();
    }


}
