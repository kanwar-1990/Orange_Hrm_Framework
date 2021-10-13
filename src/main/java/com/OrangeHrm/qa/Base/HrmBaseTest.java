package com.OrangeHrm.qa.Base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.OrangeHrm.qa.page.LoginPage;
import com.OrangeHrm.qa.page.PersonalInfoPage;
import com.OrangeHrm.qa.page.PimPage;

public class HrmBaseTest {
	public HrmBasePage hrmbasepage;
	public Properties prop;
	public WebDriver driver;
	public LoginPage loginpage;
	public PersonalInfoPage personalinfopage;
	public PimPage pimpage;

	@BeforeTest
	public void setup() {
		hrmbasepage = new HrmBasePage();
		prop = hrmbasepage.init_prop();
		driver = hrmbasepage.init_driver("chrome");
		String browserurl = prop.getProperty("url");

		driver.get(browserurl);
		loginpage = new LoginPage(driver);

		personalinfopage = new PersonalInfoPage(driver);

	}

	@AfterTest
	public void teardown() {
		// driver.quit();
	}

}
