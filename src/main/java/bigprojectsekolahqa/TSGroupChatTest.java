package bigprojectsekolahqa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.JavascriptExecutor;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class TSGroupChatTest {
  private WebDriver driver;
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
  }
  
  @AfterTest
  public void tearDown() {
    driver.quit();
  }
  
  @Test
  public void tC10sendchattogoupchat() {
    driver.get("https://staging.cicle.app/");
    driver.findElement(By.cssSelector(".DashboardPage_DashboardPage__flex__2rA7e:nth-child(4) p")).click();
    driver.findElement(By.cssSelector("#root > div.MainLayout_MainLayout__1OYFQ.container > div > div.MainLayout_mainCol__1bT_B.col-md-10 > div > div.TeamPage_rowBox__zylkg.row > div:nth-child(1) > a > div")).click();
    {
      WebElement element = driver.findElement(By.cssSelector(".fr-element"));
      js.executeScript("if(arguments[0].contentEditable === 'true') {arguments[0].innerText = 'halo'}", element);
    }
    driver.findElement(By.cssSelector(".rounded-circle")).click();
  }
  
  @Test
  public void tC11sendattachmentgroupchat() {
    driver.get("https://staging.cicle.app/");
    driver.findElement(By.cssSelector(".DashboardPage_DashboardPage__flex__2rA7e:nth-child(4) .Card_Card__2LWWW")).click();
    driver.findElement(By.cssSelector("#root > div.MainLayout_MainLayout__1OYFQ.container > div > div.MainLayout_mainCol__1bT_B.col-md-10 > div > div.TeamPage_rowBox__zylkg.row > div:nth-child(1) > a > div")).click();
    driver.findElement(By.cssSelector(".CreateGroupMessage_attachmentButton__i4UJs > .MuiSvgIcon-root")).click();
    driver.findElement(By.cssSelector("input")).sendKeys("D:\\Selenium login.png");
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
  public void tC12mentionmemberonchat() {
    driver.get("https://staging.cicle.app/");
    driver.findElement(By.cssSelector(".DashboardPage_DashboardPage__flex__2rA7e:nth-child(4) > .LinkNoDecor_Link__3DEkL:nth-child(1) .ImageMember_wrapper__ouMKB:nth-child(3)")).click();
    driver.findElement(By.cssSelector("#root > div.MainLayout_MainLayout__1OYFQ.container > div > div.MainLayout_mainCol__1bT_B.col-md-10 > div > div.TeamPage_rowBox__zylkg.row > div:nth-child(1) > a")).click();
    {
      WebElement element = driver.findElement(By.cssSelector(".fr-element"));
      js.executeScript("if(arguments[0].contentEditable === 'true') {arguments[0].innerText = '<p><span class=\"fr-deletable fr-tribute\" contenteditable=\"false\" data-mentioned-user-id=\"61112792ca29534aec31552c\" id=\"mentioned-user\" style=\"padding:1px; background-color:#e8ffff; border-radius:2px; display:inline-flex; align-items:center\"><img style=\"width:20px; height:20px; object-fit: cover; margin-right:3px; border-radius:100%;\" src=\"https://lh3.googleusercontent.com/a/AATXAJyD_Sy8NmCGjpsnPrZ-2rJ3EKg9IWC9sRkPRx_5=s96-c\"><a href=\"/profiles/61112792ca29534aec31552c\">Sandi Ramdani</a></span>&amp;nbsp;</p>'}", element);
    }
    driver.findElement(By.cssSelector(".ChatButton_container__3Ua3q path")).click();
  }
  
  @Test
  public void tC13deletesentmessage() {
    driver.get("https://staging.cicle.app/");
    driver.findElement(By.cssSelector(".DashboardPage_DashboardPage__flex__2rA7e:nth-child(4) p")).click();
    driver.findElement(By.cssSelector("#root > div.MainLayout_MainLayout__1OYFQ.container > div > div.MainLayout_mainCol__1bT_B.col-md-10 > div > div.TeamPage_rowBox__zylkg.row > div:nth-child(1) > a")).click();
    Actions act = new Actions(driver);
    act.moveToElement(driver.findElement(By.cssSelector("#group-chat-page > div > div > div:nth-child(2) > div "))).build().perform();
    driver.findElement(By.xpath("//*[@id=\"group-chat-page\"]/div/div/div[2]/div/div[1]/div[1]/div[2]")).click();
    driver.findElement(By.cssSelector(".MessageMenuPopUp_menu__1Jgjt")).click();
    driver.findElement(By.cssSelector(".btn-danger")).click();
    {
      WebDriverWait wait = new WebDriverWait(driver, 30);
      wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("notistack-snackbar")));
    }
    {
      List<WebElement> elements = driver.findElements(By.id("notistack-snackbar"));
      assert(elements.size() > 0);
    }
  }
}
