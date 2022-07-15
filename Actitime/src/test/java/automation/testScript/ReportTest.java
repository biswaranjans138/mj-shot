package automation.testScript;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import automation.genericLab.BaseClass;

public class ReportTest extends BaseClass{
	@Test(groups= {"smoke"})
	public void title()
	{
		driver.findElement(By.cssSelector(".content.reports")).click();
		System.out.println(driver.getTitle());
	}

}
