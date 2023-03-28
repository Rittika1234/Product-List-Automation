package com.tamali.pages;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.tamali.base.Base;

import io.netty.handler.timeout.TimeoutException;

public class Pepperfry extends Base 
{
	public void openUrl()
	{
		
		driver.get("https://www.pepperfry.com/");
	}
   
	public void popUp() {
		
		    try {
		        // Check if popUp frame exists
		    	// Wait for the popUp to appear and switch to it
				WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("webengage-notification-container")));
				
				WebElement popup = driver.findElement(By.id("webengage-notification-container"));
				driver.switchTo().frame(popup.findElement(By.tagName("iframe")));

		        // Close the popUp
		        WebElement closeButton = driver.findElement(By.id("webklipper-publisher-widget-container-notification-close-div"));
		        
		        // wait for the element to be clickable
		        wait.until(ExpectedConditions.elementToBeClickable(closeButton));
		        
		        // click the element using Actions class
		        Actions actions = new Actions(driver);
		        actions.moveToElement(closeButton).click().build().perform();

		        // Switch back to the main window
		        driver.switchTo().defaultContent();
		        
		    }catch (TimeoutException e) {
		        // Handle TimeoutException
		        System.out.println("Element not found within 20 seconds");
		        e.printStackTrace(); 
		    }
		    catch (NoSuchElementException e) {
		        
		    	// Handle the case where the popUp frame does not exist
		        System.out.println("Popup iframe not found");
		        
		    } catch (ElementClickInterceptedException e) {
		        
		    	// Handle the case where the element is not clickable at point
		        System.out.println("Element not clickable at point");
		        
		    }catch (Exception e) {
		        // Handle other exceptions
		        e.printStackTrace();
		    }
		    
		}

	public void validateText()
	{
		if(driver.getTitle().contains("Online Furniture Shopping Store"))
		    //Pass
		    System.out.println("Page title contains Online Furniture Shopping Store");
		else
		    //Fail
		    System.out.println("Page title doesn't contains Online Furniture Shopping Store ");
	}
	
    public void selectFurniture() {
	  // Hover over the Furniture menu item
	   WebElement furnitureMenu = driver.findElement(By.xpath("//li[@data-category='1']"));
	   Actions actions = new Actions(driver);
	   actions.moveToElement(furnitureMenu).perform();

   }
    
   public void selectBenches() {
	// Wait for the Benches sub-menu item to appear and click on it
		  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		  WebElement benchesSubMenu = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@data-id='Benches']/a")));
		  benchesSubMenu.click();
   }
   
   public void clickMaterial() {
	   WebElement materialButton = driver.findElement(By.id("Material"));
	   materialButton.click();
   }
   
    List<WebElement> materials;
	List<WebElement> countElements;
	
	public void fetchBenchDetails() 
    {
		materials=driver.findElements(By.xpath("//label[@class='checkbox-label']"));
		countElements=driver.findElements(By.xpath("//span[@class='text-md filter-checkList-count']"));
	}
	
	public void printBenchDetails()
	{
		System.out.println();
		System.out.println("No. of benches with respect to material and count:");
		for(int i=0;i<materials.size();i++)
		{
			System.out.print(materials.get(i).getText());
			System.out.print(": ");
			System.out.println(countElements.get(i).getText());

	    }
	}
	
	public void validateMetalBenchesCount()
	{
		WebElement metalCountElement = driver.findElement(By.xpath("//span[contains(text(),'(8)')]"));
		int metalCount = Integer.parseInt(metalCountElement.getText().replaceAll("\\D+", ""));
		if (metalCount > 1) {
		    System.out.println("Metal count is greater than one: " + metalCount);
		} else {
		    System.out.println("Metal count is not greater than one: " + metalCount);
		}	

     } 
	

}

