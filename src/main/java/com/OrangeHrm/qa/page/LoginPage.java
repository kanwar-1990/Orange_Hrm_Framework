package com.OrangeHrm.qa.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.OrangeHrm.qa.Base.HrmBasePage;

public class LoginPage extends HrmBasePage {

	private By forgotPasswordLink = By.linkText("Forgot your password?");
	private By LoginUserName = By.id("txtUsername");
	private By password = By.xpath("//*[@id=\"txtPassword\"]");
	private By LoginBttn = By.name("Submit");
	private By HrmPageLogo = By.cssSelector("#divLogo img");
	private By SuccessLoginMesg = By.cssSelector("a#welcome");
	private By MyInfoLink = By.linkText("My Info");

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public String HrmPagetitle() {
		return driver.getTitle();
	}

	public boolean forgotPasswordLinkCheck() {
		return driver.findElement(forgotPasswordLink).isDisplayed();
	}

	public boolean checkPageLogoVisible() {
		return driver.findElement(HrmPageLogo).isDisplayed();
	}

	public boolean doLogin(String usr, String pwd) {

		driver.findElement(LoginUserName).sendKeys(usr);
		driver.findElement(password).sendKeys(pwd);
		driver.findElement(LoginBttn).click();
		String SucessText = driver.findElement(SuccessLoginMesg).getText();
		if (SucessText.contains("Welcome")) {
			return true;
		}
		return false;
	}

	public PersonalInfoPage myInfoLink() {
		driver.findElement(MyInfoLink).click();

		return new PersonalInfoPage(driver);

	}

}
