package week4.day2;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v85.indexeddb.model.Key;

import com.aventstack.extentreports.utils.FileUtil;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowHandle {
	public static void main(String[] args) throws IOException, InterruptedException {
		
		  WebDriverManager.chromedriver().setup();
	       ChromeDriver driver=new ChromeDriver();
	       driver.get("https://www.amazon.in/");
	       driver.manage().window().maximize();
	       driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("oneplus 9 pro",Keys.ENTER);
	       String text = driver.findElement(By.xpath("(//span[@class='a-price-whole'])[1]")).getText();
	       System.out.println("price of the first product is rs."+text);
	       String text2 = driver.findElement(By.xpath("(//span[@class='a-size-base s-underline-text'])[1]")).getText();
	       System.out.println("numbers of customer reviews are  "  +text2);
	       driver.findElement(By.xpath("//span[contains(@class,'a-size-medium a-color-base')]")).click();
	       Set<String> windowHandlID = driver.getWindowHandles();
		     List<String>windList=new ArrayList<String>(windowHandlID);
		     String parent = windList.get(0);
		     //String child = windList.get(1);
		     //String grandchild=windList.get(3);
		     driver.switchTo().window(windList.get(1));
	       
	       
	       //screenshot
			
			 File sorceimg = driver.getScreenshotAs(OutputType.FILE); File desimg =new
			  File(".//snapamazon//IMG001.png"); FileUtils.copyFile(sorceimg,desimg);
			  
			  driver.findElement(By.xpath("//input[@id='add-to-cart-button']")).click();
			  
			  Thread.sleep(3000);
			  String text3 = driver.findElement(By.xpath("//span[@id='attach-accessory-cart-subtotal']")).getText();
			  
		System.out.println("cart subtotal is:" +text3);
	      
	      
	      
	      
	      

	      

	      

}
}
