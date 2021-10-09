package com.OrangeHrm.qa.test;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.OrangeHrm.qa.Base.HrmBaseTest;

public class PersonalInfoPageTest extends HrmBaseTest{

	
	@BeforeClass
public void personalInfoSetup()
{
		loginpage.doLogin(prop.getProperty("username"),prop.getProperty("password"));
		personalinfopage=loginpage.myInfoLink();
}
	
	@Test
	public void CheckpersonalinfoVisibleTest()
	{
		personalinfopage.personalDetailsView();
	}
}
