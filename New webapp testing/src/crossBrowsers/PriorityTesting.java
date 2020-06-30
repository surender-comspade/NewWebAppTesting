package crossBrowsers;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class PriorityTesting {

	@Test(priority=2)
	public void Firsttest() throws InterruptedException {

		System.out.println("Mozilla Browser");
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\surender\\drivers\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://ec2-13-235-95-50.ap-south-1.compute.amazonaws.com/filmartsy-staging/#/login");
		driver.findElement(By.id("mat-input-0")).sendKeys("surender.santapuri@comspade.com");
		driver.findElement(By.id("mat-input-1")).sendKeys("Splendor2418@");
		driver.findElement(By.xpath("/html/body/app-root/app-login/div/div/form/div[2]/button")).click();
		System.out.println("login successfull");
		Thread.sleep(3000);

//	Pattern fileNameInput = new Pattern("C:\\Users\\surender\\Pictures\\FileOpenInput.PNG");
//	Pattern OpenButton = new Pattern("C:\\Users\\surender\\Pictures\\OpenButton.PNG");
//
//	for (int b = 0; b < 4; b++) {
//		Thread.sleep(5000);
//		driver.findElement(
//				By.xpath("/html/body/app-root/app-dashboard/div/div/div[1]/app-sidebar/div/div[2]/mat-icon[1]"))
//				.click();
//
//		Thread.sleep(2000);
//
//		driver.findElement(By.xpath("//*[contains(text(),'Choose file')]")).click();
//
//		Screen screen = new Screen();
//		screen.type(fileNameInput, "C:\\Users\\surender\\Downloads\\fapic" + b + ".jpg");
//		screen.click(OpenButton);
//		Thread.sleep(2000);
//		driver.findElement(By.xpath(
//				"/html/body/div[3]/div[2]/div/mat-dialog-container/app-add-pop-up/div/mat-tab-group/div/mat-tab-body[1]/div/app-add-post/div/div/div[2]/div/div[1]/mat-form-field[1]/div/div[1]/div/textarea"))
//				.sendKeys("TEST IMAGE" + String.valueOf(b));
//
//		// driver.findElement(By.xpath("//*[@id=\"mat-select-0\"]/div/div[1]/span")).click();
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//*[@id=\"mat-select-0\"]/div/div[1]/span")).click();
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//*[@id=\"mat-option-" + b + "\"]/span")).click();
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//*[contains(text(),'Showcase')]")).click();
//	
		WebDriverWait wait = new WebDriverWait(driver, 20);
		for (int a = 1; a < 50; a++) {

			Thread.sleep(2000);
			Actions action = new Actions(driver);
//When the remainder a = 0 the scroll bar will be moved downward			
			if (a % 10 == 0) {
				Thread.sleep(2000);
				driver.findElement(By.xpath("//mat-card[*]/div[4]/div")).click();
				// actions.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();
				action.sendKeys(Keys.END).perform();
			}

			try {

				System.out.println(a);
				Thread.sleep(1000);
//The path of the image will be checked
				wait.until(ExpectedConditions
						.visibilityOfElementLocated(By.xpath("//mat-card[" + a + "]/div[2]/app-feed-img/div")));
//The click action will be performed on the image and popup will be opened 			
				driver.findElement(By.xpath("//mat-card[" + a + "]/div[2]/app-feed-img/div")).click();

				Thread.sleep(2000);

			}
//if the path of the image will be checked whtehr it is present or not 
			catch (NoSuchElementException | TimeoutException | ElementClickInterceptedException e) {
				System.out.println(e);
				continue;
//if the path is not present it will be waited for sometime and the process will be continued				
			}
			for (int i = 0; i < 3; i++) {
				Thread.sleep(1000);
//The comments will be sent in the text format in comment section				
				driver.findElement(By.xpath("//input [@placeholder='Type a comment...']"))
						.sendKeys("Comment" + String.valueOf(i));
//The send button will be clicked				
				driver.findElement(By.xpath("//*[contains(text(),'send')]")).click();
				WebDriverWait wait1 = new WebDriverWait(driver, 20);
				wait1.until(ExpectedConditions
						.visibilityOfElementLocated(By.xpath("//input [@placeholder='Type a comment...']")));
			}
			Thread.sleep(2000);
//The Popup will be closed			
			action.sendKeys(Keys.ESCAPE).perform();
		}
//profile page path will be checked	
		WebDriverWait wait2 = new WebDriverWait(driver, 30);
		wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"/html/body/app-root/app-dashboard/div/div/div[2]/div[2]/div[1]/div[1]/app-profile-basic-details/mat-card/div/div[2]/div/img")));
//profile page will be opened
		driver.findElement(By.xpath(
				"/html/body/app-root/app-dashboard/div/div/div[2]/div[2]/div[1]/div[1]/app-profile-basic-details/mat-card/div/div[2]/div/img"))
				.click();
//The page will  be loaded back		
		driver.navigate().back();
		Thread.sleep(1000);
//notification popup will be opened		
		driver.findElement(
				By.xpath("/html/body/app-root/app-dashboard/div/div/div[1]/app-sidebar/div/div[2]/div/mat-icon[2]"))
				.click();
		Thread.sleep(3000);
//Messages popup will be opened			
		driver.findElement(
				By.xpath("/html/body/app-root/app-dashboard/div/div/div[1]/app-sidebar/div/div[2]/div/mat-icon[3]"))
				.click();
		Thread.sleep(3000);
//Gropus popup will be opened			
		driver.findElement(
				By.xpath("/html/body/app-root/app-dashboard/div/div/div[1]/app-sidebar/div/div[2]/div/mat-icon[4]"))
				.click();
		Thread.sleep(3000);
//events popup will be opened		
		driver.findElement(
				By.xpath("/html/body/app-root/app-dashboard/div/div/div[1]/app-sidebar/div/div[2]/div/mat-icon[5]"))
				.click();
		Thread.sleep(3000);
//interests popup will be opened		
		driver.findElement(
				By.xpath("/html/body/app-root/app-dashboard/div/div/div[1]/app-sidebar/div/div[2]/div/mat-icon[6]"))
				.click();
		Thread.sleep(3000);
//The account will be sign out 
		driver.findElement(By.className("fa-sign-out")).click();
		Thread.sleep(1000);

		driver.close();

	}

	@Test(priority=0)
	public void secondtest() throws InterruptedException {
		System.out.println("Chrome Browser");
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\surender\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://ec2-13-235-95-50.ap-south-1.compute.amazonaws.com/filmartsy-staging/#/login");
		driver.findElement(By.id("mat-input-0")).sendKeys("surender.santapuri@comspade.com");
		driver.findElement(By.id("mat-input-1")).sendKeys("Splendor2418@");
		driver.findElement(By.xpath("/html/body/app-root/app-login/div/div/form/div[2]/button")).click();
		System.out.println("login successfull");
		Thread.sleep(3000);

//	Pattern fileNameInput = new Pattern("C:\\Users\\surender\\Pictures\\FileOpenInput.PNG");
//	Pattern OpenButton = new Pattern("C:\\Users\\surender\\Pictures\\OpenButton.PNG");
//
//	for (int b = 0; b < 4; b++) {
//		Thread.sleep(5000);
//		driver.findElement(
//				By.xpath("/html/body/app-root/app-dashboard/div/div/div[1]/app-sidebar/div/div[2]/mat-icon[1]"))
//				.click();
//
//		Thread.sleep(2000);
//
//		driver.findElement(By.xpath("//*[contains(text(),'Choose file')]")).click();
//
//		Screen screen = new Screen();
//		screen.type(fileNameInput, "C:\\Users\\surender\\Downloads\\fapic" + b + ".jpg");
//		screen.click(OpenButton);
//		Thread.sleep(2000);
//		driver.findElement(By.xpath(
//				"/html/body/div[3]/div[2]/div/mat-dialog-container/app-add-pop-up/div/mat-tab-group/div/mat-tab-body[1]/div/app-add-post/div/div/div[2]/div/div[1]/mat-form-field[1]/div/div[1]/div/textarea"))
//				.sendKeys("TEST IMAGE" + String.valueOf(b));
//
//		// driver.findElement(By.xpath("//*[@id=\"mat-select-0\"]/div/div[1]/span")).click();
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//*[@id=\"mat-select-0\"]/div/div[1]/span")).click();
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//*[@id=\"mat-option-" + b + "\"]/span")).click();
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//*[contains(text(),'Showcase')]")).click();
//	
		WebDriverWait wait = new WebDriverWait(driver, 20);
		for (int a = 1; a < 50; a++) {

			Thread.sleep(2000);
			Actions action = new Actions(driver);
//When the remainder a = 0 the scroll bar will be moved downward			
			if (a % 10 == 0) {
				Thread.sleep(2000);
				driver.findElement(By.xpath("//mat-card[*]/div[4]/div")).click();
				// actions.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();
				action.sendKeys(Keys.END).perform();
			}

			try {

				System.out.println(a);
				Thread.sleep(1000);
//The path of the image will be checked
				wait.until(ExpectedConditions
						.visibilityOfElementLocated(By.xpath("//mat-card[" + a + "]/div[2]/app-feed-img/div")));
//The click action will be performed on the image and popup will be opened 			
				driver.findElement(By.xpath("//mat-card[" + a + "]/div[2]/app-feed-img/div")).click();

				Thread.sleep(2000);

			}
//if the path of the image will be checked whtehr it is present or not 
			catch (NoSuchElementException | TimeoutException | ElementClickInterceptedException e) {
				System.out.println(e);
				continue;
//if the path is not present it will be waited for sometime and the process will be continued				
			}
			for (int i = 0; i < 3; i++) {
				Thread.sleep(1000);
//The comments will be sent in the text format in comment section				
				driver.findElement(By.xpath("//input [@placeholder='Type a comment...']"))
						.sendKeys("Comment" + String.valueOf(i));
//The send button will be clicked				
				driver.findElement(By.xpath("//*[contains(text(),'send')]")).click();
				WebDriverWait wait1 = new WebDriverWait(driver, 20);
				wait1.until(ExpectedConditions
						.visibilityOfElementLocated(By.xpath("//input [@placeholder='Type a comment...']")));
			}
			Thread.sleep(2000);
//The Popup will be closed			
			action.sendKeys(Keys.ESCAPE).perform();
		}
//profile page path will be checked	
		WebDriverWait wait2 = new WebDriverWait(driver, 30);
		wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"/html/body/app-root/app-dashboard/div/div/div[2]/div[2]/div[1]/div[1]/app-profile-basic-details/mat-card/div/div[2]/div/img")));
//profile page will be opened
		driver.findElement(By.xpath(
				"/html/body/app-root/app-dashboard/div/div/div[2]/div[2]/div[1]/div[1]/app-profile-basic-details/mat-card/div/div[2]/div/img"))
				.click();
//The page will  be loaded back		
		driver.navigate().back();
		Thread.sleep(1000);
//notification popup will be opened		
		driver.findElement(
				By.xpath("/html/body/app-root/app-dashboard/div/div/div[1]/app-sidebar/div/div[2]/div/mat-icon[2]"))
				.click();
		Thread.sleep(3000);
//Messages popup will be opened			
		driver.findElement(
				By.xpath("/html/body/app-root/app-dashboard/div/div/div[1]/app-sidebar/div/div[2]/div/mat-icon[3]"))
				.click();
		Thread.sleep(3000);
//Gropus popup will be opened			
		driver.findElement(
				By.xpath("/html/body/app-root/app-dashboard/div/div/div[1]/app-sidebar/div/div[2]/div/mat-icon[4]"))
				.click();
		Thread.sleep(3000);
//events popup will be opened		
		driver.findElement(
				By.xpath("/html/body/app-root/app-dashboard/div/div/div[1]/app-sidebar/div/div[2]/div/mat-icon[5]"))
				.click();
		Thread.sleep(3000);
//interests popup will be opened		
		driver.findElement(
				By.xpath("/html/body/app-root/app-dashboard/div/div/div[1]/app-sidebar/div/div[2]/div/mat-icon[6]"))
				.click();
		Thread.sleep(3000);
//The account will be sign out 
		driver.findElement(By.className("fa-sign-out")).click();
		Thread.sleep(1000);

		driver.close();

	}

	@Test(priority=1)
	public void Thirdtest() throws InterruptedException

	{

		System.out.println("Opera Browser");
		System.setProperty("webdriver.opera.driver", "C:\\Users\\surender\\drivers\\operadriver.exe");
		WebDriver driver = new OperaDriver();
		driver.manage().window().maximize();
		driver.get("http://ec2-13-235-95-50.ap-south-1.compute.amazonaws.com/filmartsy-staging/#/login");
		driver.findElement(By.id("mat-input-0")).sendKeys("surender.santapuri@comspade.com");
		driver.findElement(By.id("mat-input-1")).sendKeys("Splendor2418@");
		driver.findElement(By.xpath("/html/body/app-root/app-login/div/div/form/div[2]/button")).click();
		System.out.println("login successfull");
		Thread.sleep(3000);

//	Pattern fileNameInput = new Pattern("C:\\Users\\surender\\Pictures\\FileOpenInput.PNG");
//	Pattern OpenButton = new Pattern("C:\\Users\\surender\\Pictures\\OpenButton.PNG");
//
//	for (int b = 0; b < 4; b++) {
//		Thread.sleep(5000);
//		driver.findElement(
//				By.xpath("/html/body/app-root/app-dashboard/div/div/div[1]/app-sidebar/div/div[2]/mat-icon[1]"))
//				.click();
//
//		Thread.sleep(2000);
//
//		driver.findElement(By.xpath("//*[contains(text(),'Choose file')]")).click();
//
//		Screen screen = new Screen();
//		screen.type(fileNameInput, "C:\\Users\\surender\\Downloads\\fapic" + b + ".jpg");
//		screen.click(OpenButton);
//		Thread.sleep(2000);
//		driver.findElement(By.xpath(
//				"/html/body/div[3]/div[2]/div/mat-dialog-container/app-add-pop-up/div/mat-tab-group/div/mat-tab-body[1]/div/app-add-post/div/div/div[2]/div/div[1]/mat-form-field[1]/div/div[1]/div/textarea"))
//				.sendKeys("TEST IMAGE" + String.valueOf(b));
//
//		// driver.findElement(By.xpath("//*[@id=\"mat-select-0\"]/div/div[1]/span")).click();
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//*[@id=\"mat-select-0\"]/div/div[1]/span")).click();
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//*[@id=\"mat-option-" + b + "\"]/span")).click();
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//*[contains(text(),'Showcase')]")).click();
//	
		WebDriverWait wait = new WebDriverWait(driver, 20);
		for (int a = 1; a < 50; a++) {

			Thread.sleep(2000);
			Actions action = new Actions(driver);
//When the remainder a = 0 the scroll bar will be moved downward			
			if (a % 10 == 0) {
				Thread.sleep(2000);
				driver.findElement(By.xpath("//mat-card[*]/div[4]/div")).click();
				// actions.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();
				action.sendKeys(Keys.END).perform();
			}

			try {

				System.out.println(a);
				Thread.sleep(1000);
//The path of the image will be checked
				wait.until(ExpectedConditions
						.visibilityOfElementLocated(By.xpath("//mat-card[" + a + "]/div[2]/app-feed-img/div")));
//The click action will be performed on the image and popup will be opened 			
				driver.findElement(By.xpath("//mat-card[" + a + "]/div[2]/app-feed-img/div")).click();

				Thread.sleep(2000);

			}
//if the path of the image will be checked whtehr it is present or not 
			catch (NoSuchElementException | TimeoutException | ElementClickInterceptedException e) {
				System.out.println(e);
				continue;
//if the path is not present it will be waited for sometime and the process will be continued				
			}
			for (int i = 0; i < 3; i++) {
				Thread.sleep(1000);
//The comments will be sent in the text format in comment section				
				driver.findElement(By.xpath("//input [@placeholder='Type a comment...']"))
						.sendKeys("Comment" + String.valueOf(i));
//The send button will be clicked				
				driver.findElement(By.xpath("//*[contains(text(),'send')]")).click();
				WebDriverWait wait1 = new WebDriverWait(driver, 20);
				wait1.until(ExpectedConditions
						.visibilityOfElementLocated(By.xpath("//input [@placeholder='Type a comment...']")));
			}
			Thread.sleep(2000);
//The Popup will be closed			
			action.sendKeys(Keys.ESCAPE).perform();
		}
//profile page path will be checked	
		WebDriverWait wait2 = new WebDriverWait(driver, 30);
		wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"/html/body/app-root/app-dashboard/div/div/div[2]/div[2]/div[1]/div[1]/app-profile-basic-details/mat-card/div/div[2]/div/img")));
//profile page will be opened
		driver.findElement(By.xpath(
				"/html/body/app-root/app-dashboard/div/div/div[2]/div[2]/div[1]/div[1]/app-profile-basic-details/mat-card/div/div[2]/div/img"))
				.click();
//The page will  be loaded back		
		driver.navigate().back();
		Thread.sleep(1000);
//notification popup will be opened		
		driver.findElement(
				By.xpath("/html/body/app-root/app-dashboard/div/div/div[1]/app-sidebar/div/div[2]/div/mat-icon[2]"))
				.click();
		Thread.sleep(3000);
//Messages popup will be opened			
		driver.findElement(
				By.xpath("/html/body/app-root/app-dashboard/div/div/div[1]/app-sidebar/div/div[2]/div/mat-icon[3]"))
				.click();
		Thread.sleep(3000);
//Gropus popup will be opened			
		driver.findElement(
				By.xpath("/html/body/app-root/app-dashboard/div/div/div[1]/app-sidebar/div/div[2]/div/mat-icon[4]"))
				.click();
		Thread.sleep(3000);
//events popup will be opened		
		driver.findElement(
				By.xpath("/html/body/app-root/app-dashboard/div/div/div[1]/app-sidebar/div/div[2]/div/mat-icon[5]"))
				.click();
		Thread.sleep(3000);
//interests popup will be opened		
		driver.findElement(
				By.xpath("/html/body/app-root/app-dashboard/div/div/div[1]/app-sidebar/div/div[2]/div/mat-icon[6]"))
				.click();
		Thread.sleep(3000);
//The account will be sign out 
		driver.findElement(By.className("fa-sign-out")).click();
		Thread.sleep(1000);

		driver.close();

	}

}
