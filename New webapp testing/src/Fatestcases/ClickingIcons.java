package Fatestcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.ie.InternetExplorerDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;

//import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ClickingIcons {

	public static void main(String[] args) throws InterruptedException {

//		System.setProperty("webdriver.gecko.driver", "C:\\Users\\surender\\drivers\\geckodriver.exe");
//		WebDriver driver = new FirefoxDriver();
		 System.setProperty("webdriver.chrome.driver",
		 "C:\\Users\\surender\\drivers\\chromedriver.exe");
		 WebDriver driver = new ChromeDriver();
//		System.setProperty("webdriver.opera.driver",
//		"C:\\Users\\surender\\drivers\\operadriver.exe");
//		WebDriver driver = new OperaDriver();
//		System.setProperty("webdriver.ie.driver", "C:\\Users\\surender\\drivers\\IEDriverServer.exe");
//		WebDriver driver = new InternetExplorerDriver();

		driver.manage().window().maximize();
		driver.get("http://ec2-13-235-95-50.ap-south-1.compute.amazonaws.com/filmartsy-staging/#/login");
		Thread.sleep(2000);
		driver.findElement(By.id("mat-input-0")).sendKeys("surender.santapuri@comspade.com");
		driver.findElement(By.id("mat-input-1")).sendKeys("Splendor2418@");
		driver.findElement(By.xpath("/html/body/app-root/app-login/div/div/form/div[2]/button")).click();
		System.out.println("login successfull");

		WebDriverWait wait = new WebDriverWait(driver, 20);
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("/html/body/app-root/app-dashboard/div/div/div[1]/app-sidebar/div/div[2]/div/mat-icon[2]")));
		driver.findElement(
				By.xpath("/html/body/app-root/app-dashboard/div/div/div[1]/app-sidebar/div/div[2]/div/mat-icon[2]"))
				.click();

		Thread.sleep(3000);
		driver.findElement(
				By.xpath("/html/body/app-root/app-dashboard/div/div/div[1]/app-sidebar/div/div[2]/div/mat-icon[3]"))
				.click();

		Thread.sleep(3000);
		driver.findElement(
				By.xpath("/html/body/app-root/app-dashboard/div/div/div[1]/app-sidebar/div/div[2]/div/mat-icon[4]"))
				.click();
		Thread.sleep(3000);
		driver.findElement(
				By.xpath("/html/body/app-root/app-dashboard/div/div/div[1]/app-sidebar/div/div[2]/div/mat-icon[5]"))
				.click();
		Thread.sleep(3000);
		driver.findElement(
				By.xpath("/html/body/app-root/app-dashboard/div/div/div[1]/app-sidebar/div/div[2]/div/mat-icon[6]"))
				.click();

		Thread.sleep(3000);
		driver.findElement(By.className("fa-sign-out")).click();
		Thread.sleep(3000);

		driver.close();

		// TODO Auto-generated method stub

	}

}
