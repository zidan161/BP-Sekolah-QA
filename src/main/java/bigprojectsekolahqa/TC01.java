package bigprojectsekolahqa;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TC01 {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\zidan\\webdriver\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--user-data-dir=C:/Users/zidan/AppData/Local/Google/Chrome/User Data");
		options.addArguments("--profile-directory=Profile 4");
		WebDriver driver = new ChromeDriver(options);
		
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://staging.cicle.app/");
        
        driver.findElement(By.cssSelector("#root > div.container > div > div.DashboardPage_DashboardPage__mainCol__35fq5.col-md-10 > div:nth-child(4) > a:nth-child(1) > div")).click();
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div[2]/div/div[3]/div[4]")).click();
        driver.findElement(By.cssSelector("#root > div.BoardLayout_BoardLayout__1vgtV.container > div > div > div > div > div:nth-child(2) > div > div.ListContainer_createListSection__2AIXs > button")).click();
        driver.findElement(By.name("name")).sendKeys("first list");
        driver.findElement(By.cssSelector("#root > div.BoardLayout_BoardLayout__1vgtV.container > div > div > div > div > div:nth-child(2) > div > div.ListContainer_createListSection__2AIXs > div > div > form > div.CreateListButton_actionSection__1BBgC > div > button")).click();
        
	}
}
