package bigprojectsekolahqa;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC02 {
	
public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\zidan\\webdriver\\chromedriver.exe");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://staging.cicle.app/");
        
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div[2]/div/div[3]/div[4]")).click();
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div/div/div/div[2]/div/div[2]/div/div/div[4]")).click();
	}
}
