package Fatestcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.FindFailed;
//import org.sikuli.script.Pattern;
//import org.sikuli.script.Screen;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

public class samplefileuploading {

	public static void main(String[] args) throws InterruptedException, FindFailed {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\surender\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
//		System.setProperty("webdriver.gecko.driver", "C:\\Users\\surender\\drivers\\geckodriver.exe");
//		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://ec2-13-235-95-50.ap-south-1.compute.amazonaws.com/login");
		driver.findElement(By.id("mat-input-0")).sendKeys("surender.santapuri@comspade.com");
		driver.findElement(By.id("mat-input-1")).sendKeys("Splendor2418@");
		driver.findElement(By.xpath("/html/body/app-root/app-login/div/div/form/div[2]/button")).click();
		System.out.println("login successfull");
		WebDriverWait wait = new WebDriverWait(driver, 20);

		Pattern fileNameInput = new Pattern("C:\\Users\\surender\\Pictures\\FileOpenInput.PNG");
		Pattern OpenButton = new Pattern("C:\\Users\\surender\\Pictures\\OpenButton.PNG");

		for (int b = 0; b < 3; b++) {
			Thread.sleep(5000);
			driver.findElement(
					By.xpath("/html/body/app-root/app-dashboard/div/div/div[1]/app-sidebar/div/div[2]/mat-icon[1]"))
					.click();

			Thread.sleep(2000);

			driver.findElement(By.xpath("//*[contains(text(),'Choose file')]")).click();

			Screen screen = new Screen();
			screen.type(fileNameInput, "C:\\Users\\surender\\Downloads\\fapic" + b + ".jpeg");
			screen.click(OpenButton);
			Thread.sleep(2000);
			driver.findElement(By.xpath(
					"/html/body/div[3]/div[2]/div/mat-dialog-container/app-add-pop-up/div/mat-tab-group/div/mat-tab-body[1]/div/app-add-post/div/div/div[2]/div/div[1]/mat-form-field[1]/div/div[1]/div/textarea"))
					.sendKeys("TEST IMAGE" + String.valueOf(b));

			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//*[@id=\"mat-select-0\"]/div/div[1]/span")));
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id=\\\"mat-select-0\\\"]/div/div[1]/span")).click();

			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id=\"mat-option-" + b + "\"]/span")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[contains(text(),'Showcase')]")).click();

			// TODO Auto-generated method stub

		}
	}
}
