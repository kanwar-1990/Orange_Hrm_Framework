package com.OrangeHrm.qa.Base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HrmBasePage{

	public WebDriver driver;
	public Properties prop;
	OptionalManagers op;

	public WebDriver init_driver(String BrowserName) {

		System.out.println("The Browser Value is " + BrowserName);
		op = new OptionalManagers(prop);
		if (BrowserName.equalsIgnoreCase(("chrome"))) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(op.getChromeOptions());

		} else if (BrowserName.equalsIgnoreCase(("firefox")))

		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver(op.getFirefoxOptions());
		} else {
			System.out.println("Please check the browser givem :" + BrowserName);
		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}

	public Properties init_prop()

	{
		prop = new Properties();
		try {
			FileInputStream ip = new FileInputStream("./src/main/java/com/OrangeHrm/qa/Properties/config.properties");
			prop.load(ip);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
	}

}
