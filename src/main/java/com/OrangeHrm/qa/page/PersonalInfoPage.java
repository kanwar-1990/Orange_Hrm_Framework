package com.OrangeHrm.qa.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.OrangeHrm.qa.Base.HrmBasePage;

public class PersonalInfoPage extends HrmBasePage {

	private By EditOption = By.cssSelector("btnSave");
	private By FullName = By.name("personal[txtEmpFirstName]");
	private By LastName = By.cssSelector("#personal_txtEmpLastName");

	public PersonalInfoPage(WebDriver driver) {
		this.driver = driver;
	}

	public void personalDetailsView() {
		String firstname = driver.findElement(FullName).getAttribute("value");
		String lastname = driver.findElement(LastName).getAttribute("value");

		System.out.println(firstname);
		System.out.println(lastname);
		
	}

}
