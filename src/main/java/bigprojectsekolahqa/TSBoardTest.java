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

public class TSBoardTest {

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
    new HashMap<String, Object>();
  }
  
  @AfterTest
  public void tearDown() {
    driver.quit();
  }
  
  @Test
  public void tC01createlist() {
    driver.get("https://staging.cicle.app/");
    driver.findElement(By.cssSelector(".DashboardPage_DashboardPage__flex__2rA7e:nth-child(4) .ImageMember_wrapper__ouMKB:nth-child(3)")).click();
    driver.findElement(By.cssSelector(".TeamPage_colBox__1rz7F:nth-child(4) .BoxMenu_BoxMenu__1FX08")).click();
    driver.findElement(By.linkText("Add List")).click();
    driver.findElement(By.name("name")).sendKeys("First List");
    driver.findElement(By.cssSelector(".Button_container__1WNuB")).click();
  }
  
  @Test
  public void tC02setlistascomplete() {
    driver.get("https://staging.cicle.app/");
    driver.findElement(By.cssSelector(".DashboardPage_DashboardPage__flex__2rA7e:nth-child(4) p")).click();
    driver.findElement(By.cssSelector(".TeamPage_colBox__1rz7F:nth-child(4) .card-body")).click();
    driver.findElement(By.cssSelector(".List_List__30q9z:nth-child(1) .RoundActionMenu_container__2ta8s > .MuiSvgIcon-root")).click();
    driver.findElement(By.cssSelector(".ListMenu_menu__2FIPr:nth-child(3) > p")).click();
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
  public void tC03unsetlistascomplete() {
    driver.get("https://staging.cicle.app/");
    driver.findElement(By.cssSelector(".DashboardPage_DashboardPage__flex__2rA7e:nth-child(4) p")).click();
    driver.findElement(By.cssSelector(".TeamPage_colBox__1rz7F:nth-child(4) .card-body")).click();
    driver.findElement(By.cssSelector(".List_List__30q9z:nth-child(1) .ListContainer_headerSection__more__3On04 .MuiSvgIcon-root")).click();
    driver.findElement(By.cssSelector(".ListMenu_menu__2FIPr:nth-child(3) > p")).click();
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
  public void tC04reatecardonthelist() {
    driver.get("https://staging.cicle.app/check-login?previousPath=/");
    driver.findElement(By.cssSelector(".DashboardPage_DashboardPage__flex__2rA7e:nth-child(4) p")).click();
    driver.findElement(By.cssSelector(".CardSnapshot_SmallCard__1TW01:nth-child(4)")).click();
    driver.findElement(By.xpath("(//a[contains(text(),\'Add Card\')])[2]")).click();
    driver.findElement(By.cssSelector(".form-control")).sendKeys("Card One");
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
  public void tC05addcardnote() {
    driver.get("https://staging.cicle.app/");
    driver.findElement(By.cssSelector(".DashboardPage_DashboardPage__flex__2rA7e:nth-child(4) p")).click();
    driver.findElement(By.cssSelector(".TeamPage_colBox__1rz7F:nth-child(4) .card-body")).click();
    driver.findElement(By.cssSelector(".OverlayButton_container__3kxDV:nth-child(4) .ModalLinkNoDecor_ModalLink__1zSCj")).click();
    driver.findElement(By.cssSelector(".ManageDesc_sectionEmptyDesc__md0ll")).click();
    {
      WebElement element = driver.findElement(By.cssSelector(".fr-element"));
      js.executeScript("if(arguments[0].contentEditable === 'true') {arguments[0].innerText = '<p>hasajgs</p>'}", element);
    }
    driver.findElement(By.cssSelector(".btn-success")).click();
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
  public void tC06addattachmenttocard() {
    driver.get("https://staging.cicle.app/");
    driver.findElement(By.cssSelector(".DashboardPage_DashboardPage__flex__2rA7e:nth-child(4) > .LinkNoDecor_Link__3DEkL:nth-child(1) .ShowLimitMembers_container__1aumA")).click();
    driver.findElement(By.cssSelector(".TeamPage_colBox__1rz7F:nth-child(4) .card-title")).click();
    driver.findElement(By.cssSelector("#listcard_content-0 > .OverlayButton_container__3kxDV:nth-child(1) .ModalLinkNoDecor_ModalLink__1zSCj")).click();
    driver.findElement(By.cssSelector(".btn:nth-child(2) > .Button_container__1WNuB")).click();
    driver.findElement(By.cssSelector("div:nth-child(1) > input")).sendKeys("D:\\Kode login.png");
  }
  
  @Test
  public void tC07movingcard() {
    driver.get("https://staging.cicle.app/");
    driver.findElement(By.cssSelector(".DashboardPage_DashboardPage__flex__2rA7e:nth-child(4) p")).click();
    driver.findElement(By.cssSelector(".TeamPage_colBox__1rz7F:nth-child(4) .card-title")).click();
    
    WebElement card = driver.findElement(By.xpath("//*[@id=\"listcard_content-1\"]/div[4]/div/div"));
    WebElement list = driver.findElement(By.id("listcard_container-4"));
    
    Actions act = new Actions(driver);
    act.dragAndDrop(card, list).build().perform();
  }
  
  @Test
  public void tC08addmemberoncard() {
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
  public void tC09createnewprivatecard() {
    driver.get("https://staging.cicle.app/");
    driver.findElement(By.cssSelector(".DashboardPage_DashboardPage__flex__2rA7e:nth-child(4) > .LinkNoDecor_Link__3DEkL:nth-child(1) .ShowLimitMembers_container__1aumA")).click();
    driver.findElement(By.cssSelector(".TeamPage_colBox__1rz7F:nth-child(4) .card-title")).click();
    driver.findElement(By.xpath("(//a[contains(text(),\'Add Card\')])[3]")).click();
    driver.findElement(By.cssSelector(".form-control")).sendKeys("New Card");
    driver.findElement(By.cssSelector(".jss4")).click();
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
}
