package JunitFramework;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Testcasefile2 {
	WebDriver driver;
	String Base_url = "https:/amazon.in";
	int implicit_wait = 20;
	@Before
	public void set_up()
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	@After
	public void clean()
	{
		driver.quit();
		
	}

}
