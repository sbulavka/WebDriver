package demo.test;

import webdriver.BaseTest;
import demo.test.forms.*;

public class DemoTest extends BaseTest {

    public String WebSiteName = "http://mxp-qa-1.azurewebsites.net/Account/AdminLogIn";

    //credentials to login:
    public String LoginUserName = "super";
    public String LoginPassword = "admin";


    //data used to fill the fields when registering a new medical center:
    public String MedCenterName = "BulavkaCen";
    public String OfficeAccount = "Bulavka";
    public String MedCenterEmail = "bulavkasa@gamil.com";
    public String PhoneNumber = "3546576541";
    public String Fax = "3546570541";
    public String Street = "Street";
    public String City = "City";
    public String State = "State";
    public String ZipCode = "44444";
    public String FirstName = "FirstName";
    public String LastName = "LastName";
    public String DefAdminEmail = "fdgf456@sdfg.tu";
    public String DefAdminUserName = "UserBulavka";
    public String DefAdminPassword = "Passwor22";

    //data used to fill the field when editing the medical center:
    public String NewMedCenterEmail = "bulavkasa@gmail.com";

    //added answer template
    public String AnsTemplate = "Yeas";

    /**
     * Run all test
     */
	public void runTest() {
      DemoTest d = new DemoTest();
      d.runTestLogInLogOut();
      d.runTestClickingAllTab();
      d.runTestOpenFormRegNewNMedicalCenter();
      d.runTestRegistrationNewNMedicalCenter(MedCenterName, OfficeAccount, MedCenterEmail, PhoneNumber, Fax, Street, City, State, ZipCode, FirstName, LastName,
                    DefAdminEmail, DefAdminUserName, DefAdminPassword, DefAdminPassword);
      d.runTestOpenEditMedicalCenter(MedCenterEmail);
      d.runTestEditMedicalCenter(MedCenterEmail, NewMedCenterEmail);
      d.runTestDisableCenter(NewMedCenterEmail);
      d.runTestEnableCenter(NewMedCenterEmail);
      d.runTestGoToPractLogin();
      d.runTestAddNewAnswerTemplate(AnsTemplate);
	}

    /**
     * Run test Log In, Search Log out label, Log Out
     */
    public void runTestLogInLogOut() {
        logger.step(1);
        browser.navigate(WebSiteName);
        logger.step(2);
        MPAdminLogInPage logf = new MPAdminLogInPage();
        MPAdminHomePage homepagef = new MPAdminHomePage();
        logf.Login(LoginUserName, LoginPassword);
        logger.step(3);
        browser.waitForPageToLoad();
        logger.step(4);
        homepagef.searchLogOutAssert();
        logger.step(5);
        logf.LogOutAssert();
    }


    /**
     * Run test Clicking all tab on the Admin page
     */
    public void runTestClickingAllTab() {
        logger.step(1);
        browser.navigate(WebSiteName);
        logger.step(2);
        MPAdminLogInPage logf = new MPAdminLogInPage();
        MPAdminHomePage homepagef = new MPAdminHomePage();
        logf.Login(LoginUserName, LoginPassword);
        logger.step(3);
        browser.waitForPageToLoad();
        logger.step(4);
        homepagef.tabClick();
        logger.step(5);
        homepagef.searchLogOutAssert();
        browser.waitForPageToLoad();
    }


    /**
     * Run test Opening the Registration new medical center form
     * by clicking on the Registration new medical center button
     */
    public void runTestOpenFormRegNewNMedicalCenter() {
        logger.step(1);
        browser.navigate(WebSiteName);
        logger.step(2);
        MPAdminLogInPage logf = new MPAdminLogInPage();
        MPAdminHomePage homepagef = new MPAdminHomePage();
        MPAdminRegNewCenterPage regnewf = new MPAdminRegNewCenterPage();
        logger.step(3);
        logf.Login(LoginUserName, LoginPassword);
        logger.step(4);
        browser.waitForPageToLoad();
        logger.step(5);
        homepagef.search_clickRegNewCenterAssert();
        logger.step(6);
        browser.waitForPageToLoad();
        logger.step(7);
        regnewf.RegNewCenterFormAssert();
        logger.step(8);
        homepagef.searchLogOutAssert();
        browser.waitForPageToLoad();
    }


    /**
     * Run test registration new medical center(fill fields, displaying result)
     */
    public void runTestRegistrationNewNMedicalCenter(String CenterName,String OfficeAccount, String CenterEmail, String PhoneNumber, String Fax,
                                                     String Street, String City, String State, String ZipCode, String FirstName, String LastName,
                                                     String UserEmail, String UserName, String Password, String ConfirmPasswor) {
        logger.step(1);
        browser.navigate(WebSiteName);
        logger.step(2);
        MPAdminLogInPage logf = new MPAdminLogInPage();
        MPAdminHomePage homepagef = new MPAdminHomePage();
        MPAdminRegNewCenterPage regnewf = new MPAdminRegNewCenterPage();
        logger.step(3);
        logf.Login(LoginUserName, LoginPassword);
        logger.step(4);
        browser.waitForPageToLoad();
        logger.step(5);
        homepagef.search_clickRegNewCenterAssert();
        logger.step(6);
        browser.waitForPageToLoad();
        logger.step(7);
        regnewf.FillRequiredField(CenterName, OfficeAccount, CenterEmail, PhoneNumber, Fax, Street, City, State, ZipCode, FirstName, LastName,
                                  UserEmail, UserName, Password, ConfirmPasswor);
        logger.step(8);
       // browser.waitForPageToLoad();
        logger.step(9);
        homepagef.MedCenterAssert(CenterEmail);
        logger.step(10);
        homepagef.searchLogOutAssert();
        browser.waitForPageToLoad();
    }


    /**
     * Run test open the edit medical center form
     * @param CenterEmail - the medical center with this email will be selected for editing
     */
    public  void runTestOpenEditMedicalCenter(String CenterEmail) {
        logger.step(1);
        browser.navigate(WebSiteName);
        logger.step(2);
        MPAdminLogInPage logf = new MPAdminLogInPage();
        MPAdminHomePage homepagef = new MPAdminHomePage();
        MPAdminEditCenterPage editf = new MPAdminEditCenterPage();
        logger.step(3);
        logf.Login(LoginUserName, LoginPassword);
        logger.step(4);
        browser.waitForPageToLoad();
        logger.step(5);
        homepagef.EditClickAssert(CenterEmail);
        logger.step(6);
        browser.waitForPageToLoad();
        logger.step(7);
        editf.EdtCenterFormAssert();
        logger.step(8);
        homepagef.searchLogOutAssert();
        browser.waitForPageToLoad();
    }

    /**
     * Run test editing the medical center
     * @param CenterEmail - the medical center with this email will be selected for editing
     * @param NewCenterEmail - new medical center email after editing
     */
    public  void runTestEditMedicalCenter(String CenterEmail, String NewCenterEmail) {
        logger.step(1);
        browser.navigate(WebSiteName);
        logger.step(2);
        MPAdminLogInPage logf = new MPAdminLogInPage();
        MPAdminHomePage homepagef = new MPAdminHomePage();
        MPAdminEditCenterPage editf = new MPAdminEditCenterPage();
        logger.step(3);
        logf.Login(LoginUserName, LoginPassword);
        logger.step(4);
        browser.waitForPageToLoad();
        logger.step(5);
        homepagef.EditClickAssert(CenterEmail);
        logger.step(6);
        browser.waitForPageToLoad();
        logger.step(7);
        editf.EdtCenterFormAssert();
        logger.step(8);
        browser.waitForPageToLoad();
        logger.step(9);
        editf.ChangeEmailField(NewCenterEmail);
        logger.step(10);
        browser.waitForPageToLoad();
        logger.step(11);
        homepagef.MedCenterAssert(NewCenterEmail);
        logger.step(12);
        homepagef.searchLogOutAssert();
        browser.waitForPageToLoad();
    }

    /**
     * Run test disabling the medical center, check the result(the enable button should be displayed)
     * @param CenterEmail - the medical center with this email will be selected for disabling
     */
    public void runTestDisableCenter(String CenterEmail){
        logger.step(1);
        browser.navigate(WebSiteName);
        logger.step(2);
        MPAdminLogInPage logf = new MPAdminLogInPage();
        MPAdminHomePage homepagef = new MPAdminHomePage();
        logger.step(3);
        logf.Login(LoginUserName, LoginPassword);
        logger.step(4);
        browser.waitForPageToLoad();
        logger.step(5);
        homepagef.DisableClickAssert(CenterEmail);
        logger.step(6);
        homepagef.enableIsPresentAssert(CenterEmail);
        logger.step(7);
        browser.waitForPageToLoad();
        logger.step(8);
        homepagef.searchLogOutAssert();
        browser.waitForPageToLoad();
    }

    /**
     * Run test enabling the medical center, check the result(the disable button should be displayed)
     * @param CenterEmail - the medical center with this email will be selected for enabling
     */
    public void runTestEnableCenter(String CenterEmail){
        logger.step(1);
        browser.navigate(WebSiteName);
        logger.step(2);
        MPAdminLogInPage logf = new MPAdminLogInPage();
        MPAdminHomePage homepagef = new MPAdminHomePage();
        logger.step(3);
        browser.waitForPageToLoad();
        logger.step(4);
        logf.Login(LoginUserName, LoginPassword);
        logger.step(5);
        homepagef.enableClickAssert(CenterEmail);
        logger.step(6);
        browser.waitForPageToLoad();
        logger.step(7);
        homepagef.disableIsPresentAssert(CenterEmail);
        logger.step(9);
        browser.waitForPageToLoad();
        logger.step(10);
        homepagef.searchLogOutAssert();
        browser.waitForPageToLoad();
    }

    /**
     * Run test the Go to Practice log in page function.
     */
    public void runTestGoToPractLogin() {
        logger.step(1);
        browser.navigate(WebSiteName);
        logger.step(2);
        MPAdminLogInPage logf = new MPAdminLogInPage();
        MPPracticeLoginPage logPrf = new MPPracticeLoginPage();
        logger.step(3);
        logf.goToPractLoginClick();
        logger.step(4);
        logPrf.MPPracticeAssert();
    }

    /**
     * Run test adding new answer template for the Positive answer
     * * @param template - the answer template that will be added
     */
    public void runTestAddNewAnswerTemplate(String template) {
        logger.step(1);
        browser.navigate(WebSiteName);
        logger.step(2);
        MPAdminLogInPage logf = new MPAdminLogInPage();
        MPAdminHomePage homepagef = new MPAdminHomePage();
        logger.step(3);
        browser.waitForPageToLoad();
        logger.step(4);
        logf.Login(LoginUserName, LoginPassword);
        logger.step(5);
        homepagef.tabRespSettingsClick();
        logger.step(6);
        homepagef.addTemplate(template);
        logger.step(7);
        browser.waitForPageToLoad();
        logger.step(8);
        homepagef.addedTemplIsPresentAssert(template);
        logger.step(9);
        homepagef.searchLogOutAssert();
        browser.waitForPageToLoad();
    }


}
