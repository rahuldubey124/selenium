package clubkitchenAutomation;

import java.awt.Robot;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.sun.glass.events.KeyEvent;

public class ClubKitchenE2EFlow {

	WebDriver driver;

	@BeforeClass
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver/chromedriver.exe");
	}

	@Test

	public void addbasket() throws Exception {

		// Change the language
		ChromeOptions options = new ChromeOptions();

		options.addArguments("-lang= en");

		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();

		driver.get("https://clubkitchen.at");

		String pagetitlea = driver.getTitle();
		System.out.println("Print the title of the page:" + pagetitlea);

		Thread.sleep(5000);
		// Click Ok to Privacy policy
		driver.findElement(By.xpath("//*[@id=\"cookie-policy\"]/div/div[2]/button")).click();

		Thread.sleep(7000);

		// Selecting the mamacita Product

		driver.findElement(By.xpath("/html/body/div/section/div/div/div/div/div[10]/section/div[1]/div/div/a")).click();

		driver.findElement(By.id("address-input")).sendKeys("Semperstraﬂe 44, 1180 Wien, Austria");
		Thread.sleep(6000);

		String pagetitleb = driver.getTitle();
		System.out.println("Print the title of the page:" + pagetitleb);

		driver.findElement(By.xpath("/html/body/div[2]/div/div/div[1]/div[2]/form/input[2]")).click();
		// add to the basket
		Thread.sleep(8000);

		// Used Robot class for Page down to select the product
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_PAGE_DOWN);
		robot.keyPress(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(4000);
		robot.keyPress(KeyEvent.VK_PAGE_DOWN);
		robot.keyPress(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(4000);
		robot.keyPress(KeyEvent.VK_PAGE_DOWN);
		robot.keyPress(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(4000);
		robot.keyPress(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(4000);
		robot.keyPress(KeyEvent.VK_PAGE_DOWN);

		Thread.sleep(6000);

		driver.findElement(By.xpath(
				"/html/body/div[2]/section/div/div/div[2]/div/div[2]/div[2]/div[4]/div[8]/div/div[2]/div[4]/form/button"))
				.click();

		Thread.sleep(6000);

		driver.findElement(By.id("topup-modal--close")).click();

		Thread.sleep(6000);

		driver.findElement(By.partialLinkText("Zur Kasse")).click();

		// Filling Customer Information page Details

		driver.findElement(By.id("register_personal_customer_type")).sendKeys("private");

		String pagetitlec = driver.getTitle();
		System.out.println("Print the title of the page:" + pagetitlec);

		driver.findElement(By.name("register[personal][salutation]")).sendKeys("Herr");

		driver.findElement(By.id("firstname")).sendKeys("Rahul");

		driver.findElement(By.id("lastname")).sendKeys("Dubey");

		driver.findElement(By.id("register_personal_email")).sendKeys("rahul@gmail.com");

		driver.findElement(By.id("register_personal_skipLogin")).click();

		driver.findElement(By.id("phone")).sendKeys("08087689105");

		driver.findElement(By.id("stiege")).sendKeys("2");
		driver.findElement(By.id("door")).sendKeys("1");

		driver.findElement(By.id("dpacheckbox")).click();

		driver.findElement(By.xpath("//*[@id=\"opc-register\"]/div[8]/div/button")).submit();

	}

	@AfterTest
	public void closebrowser() {
		driver.close();

	}
}
