package TestSuite;

import com.tamali.pages.Pepperfry;


public class pepperfrytest {

	public static void main(String[] args) {
		Pepperfry obj=new Pepperfry();
		
		// Set up the WebDriver
		obj.driverSetup();

		// Open the URL of the webSite to be tested
		obj.openUrl();   

		// Handle any popUps that appear
		obj.popUp();

		// Validate that the correct page has loaded by checking for specific text
		obj.validateText();

		// Select the furniture category
		obj.selectFurniture();

		// Select the benches from the furniture menu
		obj.selectBenches();

		// Handle any popUps that appear
 	    obj.popUp();

		// Click on the "material" filter to show only metal benches
		obj.clickMaterial();

		// Fetch details about each bench, such as bench material and Count
		obj.fetchBenchDetails();

		// Print the details of each bench to the console
		obj.printBenchDetails();

		// Validate that the number of metal benches matches the number shown in the filter
		obj.validateMetalBenchesCount();

		// Close the browser and quit the WebDriver
		obj.closeBrowser();

		

	}

}
