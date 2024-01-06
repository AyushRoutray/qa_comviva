package exampleproject;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TableSelenium {
	public static void main(String[] args) throws InterruptedException, IOException
	{
		//Method without Downloading GeckoDriver
        //WebDriverManager.firefoxdriver().setup();
		//Method with downloading GeckoDriver
		System.setProperty("webdriver.gecko.driver", "C:\\GeckoDriver\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.cricbuzz.com/live-cricket-scorecard/77898/rsa-vs-ind-2nd-test-india-tour-of-south-africa-2023-24");
        WebElement scoreCard = driver.findElement(By.id("innings_1"));
        WebElement finalScore = scoreCard.findElement(By.xpath("//*[@id=\"innings_1\"]/div[1]/div[1]/span[2]"));
        System.out.println("Final Score of 1st Innings is "+finalScore.getText());

        List<WebElement> tableList = scoreCard.findElements(By.className("cb-scrd-itms"));
        System.out.println(tableList.size());
        for(WebElement rows:tableList){
            List<WebElement> rowsDataList = rows.findElements(By.className("cb-col"));
            System.out.println("------------------------------------------");
            for(WebElement cell : rowsDataList){
                System.out.print(cell.getText()+"  | | ");
            }

            //Player Name
            System.out.println(rows.findElement(By.tagName("a")).getText());
        }

        System.out.println(tableList.size());

        driver.close();
}
}
