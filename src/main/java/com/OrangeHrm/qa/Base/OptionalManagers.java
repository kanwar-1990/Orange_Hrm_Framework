package com.OrangeHrm.qa.Base;

import java.util.Properties;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

public class OptionalManagers {

	Properties prop;
	private ChromeOptions co;

	public OptionalManagers(Properties prop) {
		this.prop = prop;
	}

	public ChromeOptions getChromeOptions() {
		co = new ChromeOptions();

		if (prop.getProperty("headless").equals("true")) {
			co.addArguments("--headless");
		}
		if (prop.get("incognito").equals("true")) {
			co.addArguments("--incognito");
		}
		return co;

	}

	public FirefoxOptions getFirefoxOptions() {
		FirefoxOptions fo = new FirefoxOptions();

		if (prop.getProperty("headless").equals("true")) {
			fo.addArguments("--headless");

		}
		if (prop.getProperty("incognito").equals("true")) {
			fo.addArguments("--incognito");
		}
		return fo;

	}
}
