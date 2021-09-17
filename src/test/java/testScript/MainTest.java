package testScript;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MainTest {
	public static String browser = "chrome";
    public static WebDriver driver;

    public static String url = "";

	@BeforeClass
	public void setup() {
		if(browser.equals("Firefox"))
	       {
	           WebDriverManager.firefoxdriver().setup();
	           driver = new FirefoxDriver();
	       }
	       else if(browser.equals("chrome"))
	       {
	           WebDriverManager.chromedriver().setup();
	           driver = new ChromeDriver();
	       }
	       
	       else if(browser.equals("edge"))
	       {
	           WebDriverManager.edgedriver().setup();
	           driver = new EdgeDriver();
	       }
	       driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	       url = "http://automationpractice.com/index.php";
	       driver.get(url);
	       
	       driver.manage().window().maximize();
	}
  @Test(priority = 1)
  public void createUser() {
	  WebDriverWait wait = new WebDriverWait(driver,5);
	  
	  //details
	  String email="testmail@cobaaja.com";
	  String firstName="Aruma";
	  String lastName="Putora";
	  String password= "112233";
	  String street="Jalan Kenangan";
	  String city= "Surabaya";
	  String postal="60235";
	  String phone="081122334455";
	  String alias="rumah";
	  
	  //navigate to sign up
	  driver.findElement(By.xpath("/html/body/div/div[1]/header/div[2]/div/div/nav/div[1]/a")).click();
	  
	  //input email
	  driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div/div[1]/form/div/div[2]/input")).sendKeys(email);
	  driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div/div[1]/form/div/div[3]/button")).click();
	  
	  //sign up page
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div[2]/div/div[3]/div/div/h1")));
	  
	  driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div/form/div[1]/div[1]/div[1]/label/div/span/input")).click();
	  driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div/form/div[1]/div[2]/input")).sendKeys(firstName);
	  driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div/form/div[1]/div[3]/input")).sendKeys(lastName);
	  driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div/form/div[1]/div[5]/input")).sendKeys(password);
	  driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div/form/div[2]/p[4]/input")).sendKeys(street);
	  driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div/form/div[2]/p[6]/input")).sendKeys(city);
	  
	  Select state=new Select(driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div/form/div[2]/p[7]/div/select")));
	  
	  state.selectByVisibleText("Alabama");
	  driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div/form/div[2]/p[8]/input")).sendKeys(postal);
	  
	  Select country = new Select(driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div/form/div[2]/p[9]/div/select")));
	  
	  country.selectByVisibleText("United States");
	  
	  driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div/form/div[2]/p[13]/input")).sendKeys(phone);
	  driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div/form/div[2]/p[14]/input")).sendKeys(alias);
	  
	  driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div/form/div[4]/button")).click();
	  
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div[1]/header/div[2]/div/div/nav/div[1]/a/span")));
	  
	  String textName=driver.findElement(By.xpath("/html/body/div/div[1]/header/div[2]/div/div/nav/div[1]/a/span")).getText();
	  
	  if(textName.contains(firstName)) {
		  System.out.println("Account Created");
	  }else {
		  System.out.println("Account not Created");
	  }
	  
  }
}
