package bigprojectsekolahqa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.JavascriptExecutor;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class TSScheduleTest {
  private WebDriver driver;
  private Map<String, Object> vars;
  JavascriptExecutor js;
  
  @BeforeTest
  public void setUp() {
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\zidan\\webdriver\\chromedriver.exe");
      
    ChromeOptions options = new ChromeOptions();
    options.addArguments("--user-data-dir=C:/Users/zidan/AppData/Local/Google/Chrome/User Data");
	options.addArguments("--profile-directory=Profile 4");
	driver = new ChromeDriver(options);
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
    js = (JavascriptExecutor) driver;
    vars = new HashMap<String, Object>();
  }
  
  @AfterTest
  public void tearDown() {
    driver.quit();
  }
  
  public String waitForWindow(int timeout) {
    try {
      Thread.sleep(timeout);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    Set<String> whNow = driver.getWindowHandles();
    @SuppressWarnings("unchecked")
	Set<String> whThen = (Set<String>) vars.get("window_handles");
    if (whNow.size() > whThen.size()) {
      whNow.removeAll(whThen);
    }
    return whNow.iterator().next();
  }
  @Test
  public void tC14createnewevent() {
    driver.get("https://staging.cicle.app/");
    driver.findElement(By.cssSelector(".DashboardPage_DashboardPage__flex__2rA7e:nth-child(4) > .LinkNoDecor_Link__3DEkL:nth-child(1)")).click();
    driver.findElement(By.cssSelector(".EventSnapshot_Event__QCEYl")).click();
    driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div[2]/div/div[1]/div[2]/button")).click();
   
    driver.findElement(By.cssSelector(".form-control")).sendKeys("Second Event");
    driver.findElement(By.cssSelector(".btn-success > .Button_container__1WNuB")).click();
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
  public void tC15addmemberonevent() {
    driver.get("https://staging.cicle.app/");
    driver.findElement(By.cssSelector(".DashboardPage_DashboardPage__flex__2rA7e:nth-child(4) > .LinkNoDecor_Link__3DEkL:nth-child(1)")).click();
    driver.findElement(By.cssSelector("div:nth-child(3) > .EventSnapshot_Event__QCEYl p")).click();
    driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div[2]/div/div[1]/div[2]/button")).click();
    driver.findElement(By.cssSelector(".form-control")).sendKeys("New Event");
    driver.findElement(By.cssSelector(".CreateEventPage_plusButton__3LxsU > .MuiSvgIcon-root")).click();
    driver.findElement(By.cssSelector(".ManageSubscribersContainer_ManageSubscribersContainer__teamMember__dAJ8o:nth-child(3) > .mr-auto")).click();
    driver.findElement(By.cssSelector(".ManageSubscribersContainer_ManageSubscribersContainer__teamMember__dAJ8o:nth-child(2) > .mr-auto")).click();
    driver.findElement(By.cssSelector(".MuiSvgIcon-root:nth-child(2) > path")).click();
    driver.findElement(By.cssSelector(".btn-success > .Button_container__1WNuB")).click();
  }
  @Test
  public void tC16addnotesonevent() {
    driver.get("https://staging.cicle.app/");
    driver.findElement(By.cssSelector(".DashboardPage_DashboardPage__flex__2rA7e:nth-child(4) > .LinkNoDecor_Link__3DEkL:nth-child(1)")).click();
    driver.findElement(By.cssSelector(".EventSnapshot_Event__QCEYl")).click();
    driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div[2]/div/div[1]/div[2]/button")).click();
    driver.findElement(By.cssSelector(".form-control")).sendKeys("Event");
    driver.findElement(By.cssSelector(".fr-element > p")).click();
    {
      WebElement element = driver.findElement(By.cssSelector(".fr-element"));
      js.executeScript("if(arguments[0].contentEditable === 'true') {arguments[0].innerText = 'Some Description'}", element);
    }
    driver.findElement(By.cssSelector(".btn-success")).click();
  }
  @Test
  public void tC17createnewprivateevent() {
    driver.get("https://staging.cicle.app/");
    driver.findElement(By.cssSelector(".DashboardPage_DashboardPage__flex__2rA7e:nth-child(4) > .LinkNoDecor_Link__3DEkL:nth-child(1)")).click();
    driver.findElement(By.cssSelector(".EventSnapshot_Event__QCEYl")).click();
    driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div[2]/div/div[1]/div[2]/button")).click();
    driver.findElement(By.cssSelector(".form-control")).sendKeys("Event Private");
    driver.findElement(By.cssSelector(".CreateEventPage_plusButton__3LxsU > .MuiSvgIcon-root")).click();
    driver.findElement(By.cssSelector(".ManageSubscribersContainer_ManageSubscribersContainer__teamMember__dAJ8o:nth-child(2) > .mr-auto")).click();
    driver.findElement(By.cssSelector(".ManageSubscribersContainer_ManageSubscribersContainer__teamMember__dAJ8o:nth-child(3) > .mr-auto")).click();
    driver.findElement(By.cssSelector(".MuiSvgIcon-root:nth-child(2)")).click();
    driver.findElement(By.name("switchItem")).click();
    driver.findElement(By.cssSelector(".btn-success > .Button_container__1WNuB")).click();
  }
  
  @Test
  public void tC18editcreatedevent() {
    driver.get("https://staging.cicle.app/");
    driver.findElement(By.cssSelector(".DashboardPage_DashboardPage__flex__2rA7e:nth-child(4) > .LinkNoDecor_Link__3DEkL:nth-child(1)")).click();
    driver.findElement(By.cssSelector(".EventSnapshot_Event__QCEYl")).click();
    driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div[2]/div/div[3]/div[3]/div/div/div/div[3]")).click();
    driver.findElement(By.cssSelector(".RoundActionMenu_container__2ta8s")).click();
    driver.findElement(By.xpath("//div[@id='root']/div[2]/div/div[2]/div/div/div[2]/div[2]/div[3]/div/div/div")).click();
    {
      WebElement element = driver.findElement(By.cssSelector(".fr-element"));
      js.executeScript("if(arguments[0].contentEditable === 'true') {arguments[0].innerText = 'Ini saya edit'}", element);
    }
    driver.findElement(By.cssSelector(".btn-success > .Button_container__1WNuB")).click();
  }
  
  @Test
  public void tC19addeventtogooglecalendar() {
    driver.get("https://staging.cicle.app/");
    driver.findElement(By.cssSelector(".DashboardPage_DashboardPage__flex__2rA7e:nth-child(4) > .LinkNoDecor_Link__3DEkL:nth-child(1)")).click();
    driver.findElement(By.cssSelector(".EventSnapshot_Event__QCEYl")).click();
    driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div[2]/div/div[3]/div[3]/div/div/div/div[3]")).click();
    driver.findElement(By.xpath("//p[contains(.,'Add to My Calendar')]")).click();
    vars.put("window_handles", driver.getWindowHandles());
    driver.findElement(By.cssSelector(".AddEventCalendarMenu_menu__3fXUI")).click();
    vars.put("win7293", waitForWindow(2000));
    driver.switchTo().window(vars.get("win7293").toString());
    driver.findElement(By.cssSelector("#xSaveBu .NPEfkd")).click();
  }
}
