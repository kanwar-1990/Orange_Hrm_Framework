package com.OrangeHrm.qa.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.OrangeHrm.qa.Base.HrmBaseTest;
import com.OrangeHrm.qa.Constants.Constants;

public class LoginPageTest extends HrmBaseTest implements Constants {

	@Test(priority = 1)
	public void hrmPageTitletest() {
		Assert.assertEquals(loginpage.HrmPagetitle(), Constants.LoginPage_title);
	}

	@Test(priority = 2)
	public void forgotPasswordLinkTest() {
		Assert.assertTrue(loginpage.forgotPasswordLinkCheck());
	}

	@Test(priority = 3)
	public void pageLogoTest() {
		Assert.assertTrue(loginpage.checkPageLogoVisible());
	}

	@Test(priority = 4)
	public void dologinTest() {
		loginpage.doLogin(prop.getProperty("username"),prop.getProperty("password"));
	}

}
