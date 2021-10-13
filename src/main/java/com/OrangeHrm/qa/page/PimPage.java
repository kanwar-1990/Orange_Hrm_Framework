package com.OrangeHrm.qa.page;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.OrangeHrm.qa.Base.HrmBasePage;

public class PimPage extends HrmBasePage {

	private By FirstName = By.id("firstName");
	private By MiddleName = By.id("middleName");
	private By LastName = By.id("lastName");
	private By EmployeeID = By.id("employeeId");
	private By CreateLoginDetails = By.id("chkLogin");
	private By SaveBttn = By.cssSelector("input[value='Save']");
	private By ConfirmNameAFsavingDetails = By.cssSelector("#profile-pic h1");
	private By EmployeeList = By.linkText("Employee List");
	private By SearchByEmployeeName = By.name("empsearch[employee_name][empName]");
	private By SearchById = By.name("empsearch[id]");
	private By Searchbttn = By.cssSelector("input#searchBtn");
	private By SearchResult = By.cssSelector("#resultTable td a");

	public PimPage(WebDriver driver) {

		this.driver = driver;
	}

	public String AddAnEmployee(String firstname, String middlename, String lastname, String EmployeeId) {

		// driver.findElement(AddEmployee).click();
		driver.findElement(FirstName).sendKeys(firstname);
		driver.findElement(MiddleName).sendKeys(middlename);
		driver.findElement(LastName).sendKeys(lastname);
		driver.findElement(EmployeeID).sendKeys(EmployeeId);
		driver.findElement(SaveBttn).click();
		String TextforTest = driver.findElement(ConfirmNameAFsavingDetails).getText();

		return TextforTest;

	}

	public void SeachAnEmployee(String EmployeeName, String EmployeeID) {

		driver.findElement(EmployeeList).click();
		driver.findElement(SearchByEmployeeName).sendKeys(EmployeeName);
		driver.findElement(SearchById).sendKeys(EmployeeID);
		driver.findElement(Searchbttn).click();
		List<String> detailsList=new ArrayList<String>();
		List<WebElement> ResultList = driver.findElements(SearchResult);
		for (WebElement e : ResultList) {
			String list = e.getText();
			System.out.println(detailsList);
		}
	}
}
