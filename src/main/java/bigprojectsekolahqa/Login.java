package bigprojectsekolahqa;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Login {

	WebDriver driver;
	
	@BeforeTest
	public void setUp() {
		
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\zidan\\webdriver\\chromedriver.exe");
        
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--user-data-dir=C:/Users/zidan/AppData/Local/Google/Chrome/User Data");
		options.addArguments("--profile-directory=Profile 4");
		driver = new ChromeDriver(options);
		
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
	
	@Test
	public void login() {
        
        driver.get("https://staging.cicle.app/");
        
        driver.findElement(By.cssSelector("#root > div.MainLayout_MainLayout__1OYFQ.container > div > div.MainLayout_mainCol__1bT_B.col-md-10 > div > div > button:nth-child(3)")).click();
        
        driver.findElement(By.id("identifierId")).sendKeys("zidanam161@gmail.com");
        driver.findElement(By.xpath("//*[@id=\"identifierNext\"]/div/button")).click();
        
        
        driver.findElement(By.name("password")).sendKeys("Zidanlearntocode");
        driver.findElement(By.xpath("//*[@id=\"passwordNext\"]/div/button")).click();
   }
}
