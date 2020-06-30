package Fatestcases;

import java.awt.AWTException;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.opera.OperaDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.ie.InternetExplorerDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

public class commenting {

	public static void main(String[] args) throws InterruptedException, AWTException, FindFailed {

//		System.setProperty("webdriver.chrome.driver", "C:\\Users\\surender\\drivers\\chromedriver.exe");
//		WebDriver driver = new ChromeDriver();
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\surender\\drivers\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
//		System.setProperty("webdriver.opera.driver",
//		"C:\\Users\\surender\\drivers\\operadriver.exe");
//		WebDriver driver = new OperaDriver();
//	    System.setProperty("webdriver.ie.driver",
//		"C:\\Users\\surender\\drivers\\IEDriverServer.exe");
//		WebDriver driver = new InternetExplorerDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//  Url will be Opened		
		driver.get("http://ec2-13-235-95-50.ap-south-1.compute.amazonaws.com/login");

//  User name Will be Passed
		driver.findElement(By.id("mat-input-0")).sendKeys("surender.santapuri@comspade.com");

//  Password will be Passed		
		driver.findElement(By.id("mat-input-1")).sendKeys("Splendor2418@");

// Sign in button will be clicked 
		driver.findElement(By.xpath("/html/body/app-root/app-login/div/div/form/div[2]/button")).click();
		Thread.sleep(5000);

// sign in success		
		System.out.println("login successfull");

// Will be waited for some time		
		Thread.sleep(3000);
		Pattern fileNameInput = new Pattern("C:\\Users\\surender\\Pictures\\FileOpenInput.PNG");
		Pattern OpenButton = new Pattern("C:\\Users\\surender\\Pictures\\OpenButton.PNG");

		for (int b = 0; b < 3; b++) {
// 	Repeating 
			Thread.sleep(5000);
// Add post Button will be clicked 
			driver.findElement(
					By.xpath("/html/body/app-root/app-dashboard/div/div/div[1]/app-sidebar/div/div[2]/mat-icon[1]"))
					.click();

			Thread.sleep(2000);

// Choose file Button will be clicked
			driver.findElement(By.xpath("//*[contains(text(),'Choose file')]")).click();
// File path will be Taken and Open Button will be clicked	
			Screen screen = new Screen();
			screen.type(fileNameInput, "C:\\Users\\surender\\Downloads\\fapic" + b + ".jpeg");
			screen.click(OpenButton);
			Thread.sleep(2000);

//	In the Description place the text will be entered
			driver.findElement(By.xpath(
					"/html/body/div[3]/div[2]/div/mat-dialog-container/app-add-pop-up/div/mat-tab-group/div/mat-tab-body[1]/div/app-add-post/div/div/div[2]/div/div[1]/mat-form-field[1]/div/div[1]/div/textarea"))
					.sendKeys("TEST IMAGE" + String.valueOf(b));

// The select category will be clicked  
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id=\"mat-select-0\"]/div/div[1]/span")).click();
			Thread.sleep(2000);
// category id will be selected		
			driver.findElement(By.xpath("//*[@id=\"mat-option-" + b + "\"]/span")).click();
			Thread.sleep(2000);
// The post will be uploaded		
			driver.findElement(By.xpath("//*[contains(text(),'Showcase')]")).click();

		}
		Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(driver, 20);

		for (int a = 30; a < 50; a++) {

			Thread.sleep(2000);
			Actions action = new Actions(driver);
// When the remainder a = 0 the scroll bar will be moved downward			
			if (a % 10 == 0) {
				Thread.sleep(2000);
				driver.findElement(By.xpath("//mat-card[*]/div[4]/div")).click();
				// actions.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();
				action.sendKeys(Keys.END).perform();
			}

			try {

				System.out.println(a);
				Thread.sleep(1000);
// The path of the image will be checked
				wait.until(ExpectedConditions
						.visibilityOfElementLocated(By.xpath("//mat-card[" + a + "]/div[2]/app-feed-img/div")));
// The click action will be performed on the image and popup will be opened 			
				driver.findElement(By.xpath("//mat-card[" + a + "]/div[2]/app-feed-img/div")).click();

				Thread.sleep(2000);

			}
//	if the path of the image will be checked whtehr it is present or not 
			catch (NoSuchElementException | TimeoutException | ElementClickInterceptedException e) {
				System.out.println(e);
				continue;
// if the path is not present it will be waited for sometime and the process will be continued				
			}
			for (int i = 0; i < 3; i++) {
				Thread.sleep(1000);
// The comments will be sent in the text format in comment section				
				driver.findElement(By.xpath("//input [@placeholder='Type a comment...']"))
						.sendKeys("Comment" + String.valueOf(i));
// The send button will be clicked				
				driver.findElement(By.xpath("//*[contains(text(),'send')]")).click();
				WebDriverWait wait1 = new WebDriverWait(driver, 20);
				wait1.until(ExpectedConditions
						.visibilityOfElementLocated(By.xpath("//input [@placeholder='Type a comment...']")));
			}
			Thread.sleep(2000);
// The Popup will be closed			
			action.sendKeys(Keys.ESCAPE).perform();
		}
// profile page path will be checked	
		WebDriverWait wait2 = new WebDriverWait(driver, 30);
		wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"/html/body/app-root/app-dashboard/div/div/div[2]/div[2]/div[1]/div[1]/app-profile-basic-details/mat-card/div/div[2]/div/img")));
// profile page will be opened
		driver.findElement(By.xpath(
				"/html/body/app-root/app-dashboard/div/div/div[2]/div[2]/div[1]/div[1]/app-profile-basic-details/mat-card/div/div[2]/div/img"))
				.click();
// The page will  be loaded back		
		driver.navigate().back();
		Thread.sleep(1000);
// notification popup will be opened		
		driver.findElement(
				By.xpath("/html/body/app-root/app-dashboard/div/div/div[1]/app-sidebar/div/div[2]/div/mat-icon[2]"))
				.click();
		Thread.sleep(3000);
// Messages popup will be opened			
		driver.findElement(
				By.xpath("/html/body/app-root/app-dashboard/div/div/div[1]/app-sidebar/div/div[2]/div/mat-icon[3]"))
				.click();
		Thread.sleep(3000);
// Gropus popup will be opened			
		driver.findElement(
				By.xpath("/html/body/app-root/app-dashboard/div/div/div[1]/app-sidebar/div/div[2]/div/mat-icon[4]"))
				.click();
		Thread.sleep(3000);
// events popup will be opened		
		driver.findElement(
				By.xpath("/html/body/app-root/app-dashboard/div/div/div[1]/app-sidebar/div/div[2]/div/mat-icon[5]"))
				.click();
		Thread.sleep(3000);
// interests popup will be opened		
		driver.findElement(
				By.xpath("/html/body/app-root/app-dashboard/div/div/div[1]/app-sidebar/div/div[2]/div/mat-icon[6]"))
				.click();
		Thread.sleep(3000);
// The account will be sign out 
		driver.findElement(By.className("fa-sign-out")).click();
		Thread.sleep(1000);
		driver.close();
// The browser will be closed 
	}
}

// private static boolean isDisplayed(WebElement element) {
// TODO Auto-generated method stub
// return false;
// }

//}
