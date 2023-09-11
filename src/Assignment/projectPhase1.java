package Assignment;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class projectPhase1 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.crome.driver","C://Driver//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5000,TimeUnit.MILLISECONDS);
		
		//find the search box and search Samsung and click
		WebElement Search_bar = driver.findElement(By.id("twotabsearchtextbox"));
		Search_bar.sendKeys("Samsung");
		Thread.sleep(3000);
		
		//click on search button
		driver.findElement(By.id("nav-search-submit-button")).click();
		
		//find the Samsung product name list and Total products and Price
		
		List<WebElement> ProductList = driver.findElements(By.xpath("//div[@class='a-section']//span[starts-with(text(),'Samsung ')]"));
		List<WebElement> PriceList = driver.findElements(By.xpath("//div[@data-component-type='s-search-result']//span[@class='a-price']"));
		System.out.println("Total Samsung Products are  " +ProductList.size());
		
		for (int i= 0;i<ProductList.size();i++) {
			System.out.println("Total Price list and prices are "  +ProductList.get(i).getText()+ "" +PriceList.get(i).getText());
			
		}
		
		//window handling
		
	    String ParentWindow = driver.getWindowHandle();
	    String Expected_value = ProductList.get(0).getText();
	    ProductList.get(0).click();	    
	    Set <String> allWindows =driver.getWindowHandles();
		for(String win : allWindows) {
			System.out.println(win);
			if(!win.equals(ParentWindow)) {
				driver.switchTo().window(win);
				}
			}	    	
	    //Product title verification-
		
	    WebElement String = driver.findElement(By.id("productTitle"));
	    String ActualValue = String.getText();
	    if(ActualValue.equals(Expected_value)) {
	    	System.out.println("Title is matching");
	    }else {
	    	System.out.println("Failed in title verification");
	    }
	    Thread.sleep(4000);
	    driver.quit();
	    
	    
	    
	   
	}
}
