package automation.testScript;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import automation.genericLab.BaseClass;

public class AlertHandlingTest extends BaseClass{

	@Test(groups= {"smoke","system"})
	public void handleAlert()
	{
		driver.findElement(By.className("popup_menu_button_settings")).click();
		driver.findElement(By.linkText("Types of Work")).click();
		driver.findElement(By.xpath("//span[text()='Create Type of Work']")).click();
		driver.findElement(By.id("name")).sendKeys("Tubulu");
		driver.findElement(By.xpath("//td[@id='ButtonPane']/input[2]")).click();
		Alert alt=driver.switchTo().alert();
		System.out.println(alt.getText());
		alt.dismiss();
	}
}
