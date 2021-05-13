package handling_Dropdown_Test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import handling_Dropdown.BaseClass;

public class Handling_Dropdown_Test1 extends BaseClass{

	@Test(enabled=false)
	public void dropdown() throws Exception{

		WebElement day = driver.findElement(By.id("Birthday_Day"));
		WebElement month = driver.findElement(By.id("Birthday_Month"));
		WebElement year = driver.findElement(By.id("Birthday_Year"));

		Select sel1 = new Select(day);
		sel1.selectByIndex(27);

		Select sel2 = new Select(month);
		sel2.selectByValue("September");

		Select sel3 = new Select(year);
		sel3.selectByVisibleText("1986");

		Thread.sleep(4000);

		BaseClass.Screenshot(driver, "Dropdown");
	}

	@Test
	public void dynamicMonthSelection() throws Exception{

		WebElement day = driver.findElement(By.id("Birthday_Day"));
		WebElement birthmonth = driver.findElement(By.id("Birthday_Month"));
		WebElement year = driver.findElement(By.id("Birthday_Year"));

		Select sel1 = new Select(day);
		sel1.selectByIndex(27);

		List<WebElement> month = driver.findElements(By.xpath("//select[@id = 'Birthday_Month']/option"));

		Select sel2 = new Select(birthmonth);

		int monthsize = month.size();
		System.out.println(monthsize);

		for (int i=0;i<monthsize;i++){

			WebElement availablemonth = month.get(i);
			String monthoftheyear= availablemonth.getAttribute("value");

			if (monthoftheyear.equalsIgnoreCase("september")){

				sel2.selectByValue(monthoftheyear);

			}

		}

		Select sel3 = new Select(year);
		sel3.selectByVisibleText("1986");
		
		BaseClass.Screenshot(driver, "dynamicDropdown");
	}

}
