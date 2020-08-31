package JunitFramework;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.Assert;

public class TestcaseFile1 {
	WebDriver driver;
	String base_url = "https://amazon.in";
	int implicitwait = 20;
	
	@Before
    public void set_up()
	{
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(implicitwait, TimeUnit.SECONDS); 
    }

    @Test
    public void testcase1_Website_is_working()
    {
        driver.get(base_url);
        String expected = "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
        String actual =driver.getTitle();
        Assert.assertEquals("Page Title validation",expected,actual);
    }
    
    @Test
    public void testcase2_search_product()
    {
    	driver.get(base_url);
 
    	//seacrh for product
        WebDriverWait webDriverWait = new WebDriverWait(driver,20);
        WebElement elementSearchBox = webDriverWait.until(ExpectedConditions.elementToBeClickable(By.id("twotabsearchtextbox")));
        elementSearchBox.sendKeys("Laptop");
        
    	//driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Laptop").;
        WebDriverWait webDriverWait1 = new WebDriverWait(driver,20);
        webDriverWait1.until(ExpectedConditions.titleIs("Amazon.in : Laptop"));
        
        //Validation
        Assert.assertEquals("Page Title validation","Amazon.in : Laptop", driver.getTitle()); 
    }
    
    @After
    public void clean(){
    	
        driver.quit();
    }

}


