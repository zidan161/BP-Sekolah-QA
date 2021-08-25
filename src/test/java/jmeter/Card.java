package jmeter;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Card {
	
	private WebDriver driver;
    JavascriptExecutor js;
	
	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\zidan\\webdriver\\chromedriver.exe");
		 
	    ChromeOptions options = new ChromeOptions();
	    options.addArguments("--user-data-dir=C:/Users/zidan/AppData/Local/Google/Chrome/User Data");
	    options.addArguments("--profile-directory=Profile 4");
	    driver = new ChromeDriver(options);
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@After
	  public void tearDown() {
	    driver.quit();
	}
	
	@Test
	public void editComment() {
	    driver.get("https://staging.cicle.app/");
	    driver.findElement(By.cssSelector(".DashboardPage_DashboardPage__flex__2rA7e:nth-child(4) p")).click();
	    driver.findElement(By.cssSelector(".TeamPage_colBox__1rz7F:nth-child(4) .card-body")).click();
	    driver.findElement(By.xpath("//div[@id='listcard_content-0']/div/div/div/a")).click();
	    driver.findElement(By.cssSelector(".CreateCommentForm_formInitial__3AVVg")).click();
	    {
	      WebElement element = driver.findElement(By.cssSelector(".fr-element"));
	      element.sendKeys("Test Comment!");
	    }
	}
	
	@Test
	public void addMember() {
		driver.get("https://staging.cicle.app/");
	    driver.findElement(By.cssSelector(".DashboardPage_DashboardPage__flex__2rA7e:nth-child(4) > .LinkNoDecor_Link__3DEkL:nth-child(1) p")).click();
	    driver.findElement(By.cssSelector(".TeamPage_colBox__1rz7F:nth-child(4) .card-body")).click();
	    driver.findElement(By.cssSelector("#listcard_content-1 > .OverlayButton_container__3kxDV:nth-child(1) .ModalLinkNoDecor_ModalLink__1zSCj")).click();
	    driver.findElement(By.cssSelector(".CardDetailContainer_CardDetailContainer__smallSectionContainer__3qfM5:nth-child(1) > .CardDetailContainer_buttonAction__2Sfwo:nth-child(2) .MuiSvgIcon-root")).click();
	    driver.findElement(By.cssSelector(".OverlayButton_container__3kxDV:nth-child(2) .mr-auto")).click();
	    driver.findElement(By.cssSelector(".OverlayButton_container__3kxDV:nth-child(4) .mr-auto")).click();
	    driver.findElement(By.cssSelector(".OverlayButton_container__3kxDV:nth-child(5) .mr-auto")).click();
	    {
	      WebDriverWait wait = new WebDriverWait(driver, 30);
	      wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("notistack-snackbar")));
	    }
	    {
	      List<WebElement> elements = driver.findElements(By.id("notistack-snackbar"));
	      assert(elements.size() > 0);
	    }
	}
	
	@Test
	public void moveCard() {
	    driver.get("https://staging.cicle.app/");
	    driver.findElement(By.cssSelector(".DashboardPage_DashboardPage__flex__2rA7e:nth-child(4) p")).click();
	    driver.findElement(By.cssSelector(".TeamPage_colBox__1rz7F:nth-child(4) .card-body")).click();
	    WebElement list = driver.findElement(By.id("listcard_container-4"));
	    Actions act = new Actions(driver);
	    
	    for(int i = 1; i < 6; i++) {
	        act.dragAndDrop(driver.findElement(By.xpath("//*[@id=\"listcard_content-1\"]/div["+i+"]")), list).build().perform();
	        {
		        WebDriverWait wait = new WebDriverWait(driver, 30);
		        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("notistack-snackbar")));
		    }
		    {
		        WebElement elements = driver.findElement(By.id("notistack-snackbar"));
		        assertEquals("Moving card is success", elements.getText());
		    }
	    }
	}
}
