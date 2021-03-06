package lab3.test;// Generated by Selenium IDE
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import java.util.*;
import java.net.MalformedURLException;
import java.net.URL;
public class LookupdomaininfobyIpTest {
  private WebDriver driver;
  private Map<String, Object> vars;
  JavascriptExecutor js;
  @Before
  public void setUp() {
    System.setProperty("webdriver.chrome.driver", "C:\\Users\\antonAdmin\\IdeaProjects\\ST\\St\\src\\lab3\\chromedriver.exe");
    System.setProperty("webdriver.chrome.whitelistedIps", "199.30.228.112");
    System.setProperty("webdriver.gecko.driver", "C:\\Users\\antonAdmin\\IdeaProjects\\ST\\St\\src\\lab3\\geckodriver.exe");
    System.setProperty("webdriver.gecko.whitelistedIps", "199.30.228.112");
    String driverType = System.getenv("DRIVER");
    if(driverType.equals("CHROME")) {
      driver = new ChromeDriver();
    }else if(driverType.equals("FIREFOX")){
      driver = new FirefoxDriver();
    }
    js = (JavascriptExecutor) driver;
    vars = new HashMap<String, Object>();
  }
  @After
  public void tearDown() {
    driver.quit();
  }
  @Test
  public void lookupdomaininfobyIp() {
    driver.get("https://www.domaintools.com/");
    driver.manage().window().setSize(new Dimension(1920, 1040));
    {
      WebElement element = driver.findElement(By.xpath("//a[contains(text(),\'Products\')]"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).perform();
    }
    {
      WebElement element = driver.findElement(By.tagName("body"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element, 0, 0).perform();
    }
    driver.findElement(By.xpath("//a[contains(text(),\'Research\')]")).click();
    driver.findElement(By.xpath("//div[@id='navbar-collapse-1']/ul/li/a")).click();
    driver.findElement(By.xpath("//a[contains(text(),\'IP Whois Lookup\')]")).click();
    driver.findElement(By.xpath("//input[@id=\'landing-whois\']")).click();
    driver.findElement(By.xpath("//input[@id=\'landing-whois\']")).sendKeys("152.136.58.24");
    driver.findElement(By.xpath("//button[@id=\'whois-search\']")).click();
  }
}
