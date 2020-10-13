package com.Project1;

import org.testng.annotations.Test;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;

public class MyTrip {
  
	WebDriver driver;
	String parent = "";

  @Test
  public void Trip() throws InterruptedException {
	
	  	WebDriverWait wait = new WebDriverWait(driver, 20);
	  	WebElement login= driver.findElement(By.xpath("//*[@id=\"SW\"]/div[1]/div[1]/ul/li[6]/div/p"));
	  	wait.until(ExpectedConditions.elementToBeClickable(login));
		WebElement username = driver.findElement(By.id("username"));
		username.clear();
		username.sendKeys("lekshmipssree2015@gmail.com");
		driver.findElement(By.xpath("//*[@id=\"SW\"]/div[1]/div[2]/div[2]/section/form/div[2]/button")).click();;
		Thread.sleep(3000);
		WebElement pwd = driver.findElement(By.xpath("//*[@id=\"password\"]"));
		pwd.clear();
		wait.until(ExpectedConditions.elementToBeClickable(pwd));
		pwd.sendKeys("rose@123");
		Thread.sleep(4000);
		driver.findElement(By.xpath("//*[@id=\"SW\"]/div[1]/div[2]/div[2]/section/form/div[2]/button")).click();;

		// booking
		driver.findElement(By.xpath("//*[@id=\"SW\"]/div[1]/div[2]/div/div/nav/ul/li[2]/a/span[1]"));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@class='   menu_Hotels ']/a")));
		driver.findElement(By.xpath("//li[@class='   menu_Hotels ']/a")).click();
		driver.findElement(By.id("city")).click();
		WebElement city = driver.findElement(By.xpath("//input[@placeholder='Enter city/ Hotel/ Area/ Building']"));
		city.sendKeys("Munnar");
		Thread.sleep(2000);
		city.sendKeys(Keys.ARROW_DOWN);
		city.sendKeys(Keys.ENTER);
		driver.findElement(By.xpath("//div[@class='DayPicker-Body']/div[2]/div[6]")).click();
		driver.findElement(By.xpath("//div[@class='DayPicker-Body']/div[4]/div[6]")).click();
		driver.findElement(By.id("guest")).click();
		driver.findElement(By.xpath("//div[@class='addRooomDetails']/ul[1]/li[4]")).click();
		driver.findElement(By.xpath("//div[@class='roomsGuestsBottom']/button[2]")).click();
		driver.findElement(By.id("hsw_search_button")).click();

		// filters
		WebElement slider;
		Thread.sleep(2000);
		slider = driver.findElement(By.xpath("//*[@id=\'hlistpg_fr_price_per_night\']/div[2]/div[2]/div/span[2]/div"));
		Actions action = new Actions(driver);
		action.moveToElement(slider).click().dragAndDropBy(slider, -50, 0).build().perform();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//span[contains(text(),'Pallivasal')]")).click();
		Thread.sleep(3000);
		Actions actions = new Actions(driver);
		WebElement star = driver.findElement(By.xpath("//*[@id=\"hlistpg_fr_star_category\"]/ul/li[2]/span[1]/label"));
		actions.moveToElement(star);
		actions.click().perform();
		driver.findElement(By.xpath("//label[@class=\'makeFlex column\']")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("htl_id_seo_201605181247348146")).click();
		String parent = driver.getWindowHandle();// next window
		Set<String> ids = driver.getWindowHandles();
		Iterator<String> it = ids.iterator();
		while (it.hasNext()) {
			driver.switchTo().window(it.next());
			System.out.println(driver.getTitle());
		}
		driver.findElement(By.xpath("//*[@id=\'detpg_book_combo_btn\']")).click();

		// Traveller information
		Select sc = new Select(driver.findElement(By.id("title")));
		sc.selectByVisibleText("Ms");
		driver.findElement(By.id("fName")).sendKeys("Lekshmi");
		driver.findElement(By.id("lName")).sendKeys("P S");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[2]/div/div[2]/div[6]/span")).click();
		Thread.sleep(3000);
		WebElement payment = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[2]/div/div[1]/ul/li[2]/span/label"));
		actions.moveToElement(payment);
		actions.click().perform();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[2]/div/div[2]/div[1]/div/a")).click();
		
		//payment
		Thread.sleep(3000);
		WebElement upi = driver.findElement(By.xpath("//*[@id=\"fullPayment\"]/p/span[2]/span/span[1]"));
		actions.moveToElement(upi);
		actions.click().perform();
		Thread.sleep(3000);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("CC_tab")));
		driver.findElement(By.id("CC_tab")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("PAYMENT_cardNumber")).sendKeys("123456789012345");
		driver.findElement(By.id("PAYMENT_nameOnCard")).sendKeys("Lekshmi PS");
		Thread.sleep(2000);
		Select month = new Select(driver.findElement(By.id("PAYMENT_expiryMonth")));
		month.selectByValue("10");
		Select year = new Select(driver.findElement(By.id("PAYMENT_expiryYear")));
		year.selectByValue("2020");
		Thread.sleep(2000);
		driver.findElement(By.id("PAYMENT_cvv")).sendKeys("111");
		Thread.sleep(3000);
		Select country = new Select(driver.findElement(By.id("PAYMENT_billingCountry")));
		country.selectByVisibleText("India");
		Thread.sleep(1000);
		driver.findElement(By.id("PAYMENT_billingAddress")).sendKeys("HARISREE");
		driver.findElement(By.id("PAYMENT_billingCity")).sendKeys("KOLLAM");
		driver.findElement(By.id("PAYMENT_billingPin")).sendKeys("691502");
		driver.findElement(By.id("PAYMENT_billingState")).sendKeys("KERALA");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\'widgetPayBtn\']/span")).click();

  }
  @BeforeClass
  public void beforeClass() {
	  System.setProperty("webdriver.chrome.driver","C:\\Users\\hp\\Desktop\\SELENIUM UDEMY\\Chrome Driver//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.makemytrip.com/");
  }
  @AfterMethod
  public void afterMethod() {
  }
  
  
  
  @AfterClass
  public void afterClass() {
	  driver.close();
  }

}
