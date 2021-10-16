package com.OrangeHrm.qa.test;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.OrangeHrm.qa.Base.HrmBaseTest;

public class PimTest extends HrmBaseTest {

	@BeforeClass
	public void PimSetup() {
		loginpage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		pimpage = loginpage.PimLinkLogin();
	}

	@Test(priority = 1,enabled=false)
	public void checkPimAddEmployeeTest() {
		pimpage.AddAnEmployee("Delta", "Sim", "Hilarious12345", "8765303");
	}

	@Test(priority = 2)
	public void searchListResultTest() {
		pimpage.SeachAnEmployee("Delta Sim Hilarious12345", "0268765303");
	}
	@Test(priority=3)
	public void DeleteAddedEmployee()
	{
		pimpage.deleteTheEmployeeDetails();
		
	}

}
