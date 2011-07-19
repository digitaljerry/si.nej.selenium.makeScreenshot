package si.nej.selenium.makeScreenshot;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.thoughtworks.selenium.Wait;

public class SeleniumMakeScreenshot {
    public static void main(String[] args) {
        // Create a new instance of the Firefox driver
        // Notice that the remainder of the code relies on the interface, 
        // not the implementation.
        WebDriver driver = new FirefoxDriver();
        
        
        String url = "http://www.google.com";
        if ( args[0].isEmpty() == false) {
        	url = args[0];
        }

        // And now use this to visit Google
        driver.get(url);
        // Alternatively the same thing can be done like this
        // driver.navigate().to("http://www.google.com");

        // Find the text input element by its name
        //WebElement element = driver.findElement(By.name("q"));

        // Enter something to search for
        //element.sendKeys("Cheese!");

        // Now submit the form. WebDriver will find the form for us from the element
        //element.submit();

        // Check the title of the page
        System.out.println("Page title is: " + driver.getTitle());
        
        // Google's search is rendered dynamically with JavaScript.
        // Wait for the page to load, timeout after 10 seconds
        /*(new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getTitle().startsWith("cheese!");
            }
        });*/
        
        //new WebDriverWait(driver, 10);

        // Should see: "cheese! - Google Search"
        //System.out.println("Page title is: " + driver.getTitle());
        
        // Make screenshot
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        // Now you can do whatever you need to do with it, for example copy somewhere
        try {
			FileUtils.copyFile(scrFile, new File("/Users/jernejz/Temp/screenshot.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        //Close the browser
        driver.quit();
    }
}