package Error.Console_log;

import java.io.File;

import java.net.URL;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;



public class Cellannotation_consolelog {
	
	private RemoteWebDriver driver;
	   private WebDriverWait wait;
		
	    @BeforeTest
	    public void setup() throws Exception {
	    	DesiredCapabilities dc = DesiredCapabilities.chrome();
	    	URL url = new URL("http://172.20.23.7:5555/wd/hub/");
	    	driver = new RemoteWebDriver(url, dc);

	        wait = new WebDriverWait(driver, 10); // Adjust the timeout as needed
	    }
	    //@Parameters("URL")
	    @Test(priority = 1)
	   //public void login(@Optional("defaultURL") String URL) 
	   public void login() 
	    {
	   
	    	//driver.get(URL);
	    	driver.get("https://apollo2.humanbrain.in/viewer/annotation/portal");
			driver.manage().window().maximize();
	        String currentURL = driver.getCurrentUrl();
	        System.out.println("Current URL: " + currentURL);
			WebDriverWait wait = new WebDriverWait(driver, 10);
	    	driver.switchTo().defaultContent(); // Switch back to default content
	    	WebElement viewerElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@title='Viewer']")));
	    	if (viewerElement.isEnabled() && viewerElement.isDisplayed()) {
	    	    viewerElement.click();
	    	    System.out.println("Viewer icon is clicked");
	    	} else {
	    	    System.out.println("Viewer icon is not clickable");
	    	}
	    	
	
	        String parentWindow = driver.getWindowHandle();
	        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()=' Log In ']")));
	        if (loginButton != null) {
	            loginButton.click();
	            System.out.println("Login button clicked successfully.");
	        } else {
	            System.out.println("Login button is not clicked.");
	        }
	        
		  wait.until(ExpectedConditions.numberOfWindowsToBe(2));
		  Set<String> allWindows = driver.getWindowHandles();
	        for (String window : allWindows) {
	            if (!window.equals(parentWindow)) {
	                driver.switchTo().window(window);
	                break;
	            }
	        }
	        WebElement emailInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='email']")));
	        if (emailInput != null && emailInput.isDisplayed()) {
	            emailInput.sendKeys("teamsoftware457@gmail.com");
	            System.out.println("Email was entered successfully.");
	        } else {
	           System.out.println("Email was not entered.");
	        }
	        
	
	        WebElement nextButton1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Next']")));
	        if (nextButton1 != null) {
	            nextButton1.click();
	            System.out.println("Next button 1 is clicked.");
	        } else {
	            System.out.println("Next button 1 is not clicked.");
	        }
	       
	        WebElement passwordInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@aria-label='Enter your password']")));
	        passwordInput.sendKeys("Health#123");
	        if (passwordInput.getAttribute("value").equals("Health#123")) {
	            System.out.println("Password was entered successfully.");
	        } else {
	            System.out.println("Password was not entered.");
	        }
	        
	        
	        WebElement nextButton2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Next']")));
	        if (nextButton2 != null) {
	            nextButton2.click();
	            System.out.println("Next button 2 is clicked.");
	        } else {
	            System.out.println("Next button 2 is not clicked.");
	        }
	     
	
	        driver.switchTo().window(parentWindow);
	        System.out.println("Login successfully");
	        
	        System.out.println("************************Login validation done***********************");
	    }

	    @Test(priority=2)
		public void series_set() throws InterruptedException
		{
			WebDriverWait wait = new WebDriverWait(driver, 30); 
			driver.switchTo().defaultContent();
	
			
	    	 try {
	    		    WebElement Mouse = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//table[@role='grid']//tr[6]")));
	    		    Mouse.click();
	    		    System.out.println("Human Fetus clicked successfully.");
	    		    Thread.sleep(2000);
	    		} catch (Exception e) {
	    		    System.out.println("Human Fetus not clicked: " + e.getMessage());
	    		}
	    	 
	    	 
	    	 try {
	    		    WebElement Brain = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//table[@role='grid']//tr[7]//td[2]")));
	    		    Brain.click();
	    		    System.out.println(" Brain clicked successfully.");
	    		    Thread.sleep(2000);
	    		} catch (Exception e) {
	    		    System.out.println("Brain not clicked: " + e.getMessage());
	    		}
	    	
	    	 
	    	 try {
	 		    WebElement MTB_10 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//table[@role='grid']//tr[25]//td[3]")));
	 		    MTB_10.click();
	 		    System.out.println("FTB-40 clicked successfully.");
	 		    Thread.sleep(2000);
	 		} catch (Exception e) {
	 		    System.out.println(" FTB-40 not clicked: " + e.getMessage());
	 		}
	    	 
	    	 String parentWindow = driver.getWindowHandle();
	    	 try {
		 		    WebElement viewericon = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//nb-icon[@nbtooltip='Viewer']")));
		 		   viewericon.click();
		 		    System.out.println("viewer icon is clicked successfully.");
		 		    Thread.sleep(2000);
		 		} catch (Exception e) {
		 		    System.out.println(" viewer icon is not clicked: " + e.getMessage());
		 		}
	    	 
	    	 wait.until(ExpectedConditions.numberOfWindowsToBe(2));
			  Set<String> allWindows = driver.getWindowHandles();
		        for (String window : allWindows) {
		            if (!window.equals(parentWindow)) {
		                driver.switchTo().window(window);
		                break;
		            }
		        }
	    	 
	    	 
	    	 try {
	  		    WebElement section = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[text()='712'])[1]")));
	  		    section.click();
	  		    System.out.println("section clicked successfully.");
	  		    Thread.sleep(2000);
	  		} catch (Exception e) {
	  		    System.out.println("section not clicked: " + e.getMessage());
	  		}
	    	 
	    	 
	    	 System.out.println("************************************Series set validation done********************************");
	
	    	 
		}

	    @Test(priority = 3)
	    public void cellannotation() {
	    	
	    	driver.switchTo().defaultContent();
	    	try {
	  		    WebElement contributor= wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@title='Cell Annotation']")));
	  		    contributor.click();
	  		    System.out.println("cell annotation page opened.");
	  		    Thread.sleep(2000);
	  		} catch (Exception e) {
	  		    System.out.println("Cell annotation is not open: " + e.getMessage());
	  		}
		 checkConsoleLog();
	     System.out.println("****************Cell annotation page open successfully*******************");
	    }
	      @Test(priority=4)
	      public void Tileloading()
	      {
	    	    driver.switchTo().defaultContent();
	    	    clickElementByXpath("(//nb-icon[@pack='nebular-essentials'])[6]", "Goto option");
			    
			    WebElement tileNumberInput = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='Tile Number']")));
		        tileNumberInput.sendKeys("5731");
		        
		        clickElementByXpath("//button[text()='Go to']", "Goto Button option");
		        clickElementByXpath("//a[@title='Tile Annotation']", "Tile annotation page");
		        checkConsoleLog();
		       
		        WebDriverWait wait = new WebDriverWait(driver, 100); // Wait for up to 60 seconds

		        try {
		            WebElement toaster1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Annotated Data loaded successfully']")));
		            String Toaster1 = toaster1.getText();
		            String Expected1 = "Annotated Data loaded successfully";
		            Assert.assertEquals(Expected1, Toaster1);
		        } catch (TimeoutException e) {
		            // At least one of the expected toasters did not appear within 1 minute; fail the test.
		            Assert.fail("Toaster message did not appear within the expected time.");
		        }


		        checkConsoleLog();
		        System.out.println("************Tile loaded successfully**************");
		        
		  }
	    
		@Test(priority=5)

		  public void centroidDetection() throws InterruptedException {
			
			  driver.switchTo().defaultContent();
			  clickElementByXpath("(//select[@status='primary'])[2]", "Algorithym option"); 
			  clickElementByXpath("//option[text()=' CentroidDetection ']", "Centroid Detection");
			  
			  Thread.sleep(6000);
			  WebElement toast2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//nb-toast//span[text()='Relearn']/following-sibling::div[@class='message']")));
			  String actualFileName2 = toast2.getText();
			  String expectedFileName2 = "Relearn success"; 
			  Assert.assertEquals(expectedFileName2,actualFileName2);
			  checkConsoleLog();
			  System.out.println("****************EP4 firstpass Relearn success***********************");
			  Thread.sleep(5000);

		  }

		@Test(priority=6)
		public void celldetection() throws InterruptedException
		{
			driver.switchTo().defaultContent();
			clickElementByXpath("(//select[@status='primary'])[2]", "Algorithym option"); 
			clickElementByXpath("//option[text()=' CellDetection ']", "Cell Detection");
	
			  Thread.sleep(6000);
			  WebElement toast2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//nb-toast//span[text()='Relearn']/following-sibling::div[@class='message']")));
			  String actualFileName2 = toast2.getText();
			  String expectedFileName2 = "Relearn success"; 
			  Assert.assertEquals(expectedFileName2, actualFileName2);
			  checkConsoleLog();
			  System.out.println("****************EP1 firstpass Relearn success*****************");
			  Thread.sleep(5000);
		}

		  @Test(priority=7)

		  public void Rabies() throws InterruptedException {
			  
			  driver.switchTo().defaultContent();
			  clickElementByXpath("(//select[@status='primary'])[2]", "Algorithym option"); 
			  clickElementByXpath("//option[text()=' Rabies ']", "Rabies");
			  driver.findElement(By.xpath("//option[text()=' Rabies ']")).click();
			  Thread.sleep(6000);
			  WebElement toast3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//nb-toast//span[text()='Relearn']/following-sibling::div[@class='message']")));
			  String actualFileName3 = toast3.getText();
			  String expectedFileName3 = "Relearn success"; 
			  Assert.assertEquals(expectedFileName3, actualFileName3);
			  checkConsoleLog();
			  System.out.println("************EP7 firstpass Relearn success************");
			  Thread.sleep(5000);
		  }
		  @Test(priority=8)

		  public void Annotation() throws InterruptedException {
			 
			  driver.switchTo().defaultContent();
			  clickElementByXpath("//a[@title='Annotation']", "Annotation"); 
			  clickElementByXpath("//a[@title='Clear and Add  First Pass']", "Clear And Add Firstpass"); 
			  checkConsoleLog();
			  Thread.sleep(2000);
			  System.out.println("***********Cleared and First pass added**************");
			  Thread.sleep(5000);
		  }

		  @Test(priority=9)

		  public void save() throws InterruptedException {
			  
			  driver.switchTo().defaultContent();
			  clickElementByXpath("//a[@title='Actions']", "Action"); 
			  clickElementByXpath("//a[@title='Save']", "save"); 
			  Thread.sleep(8000);
		   	 WebElement toast4 = driver.findElement(By.xpath("//div[text()='Saved Successfullly']"));
			  String actualFileName4 = toast4.getText();
			  String expectedFileName4 = "Saved Successfullly"; 
			  Assert.assertEquals(actualFileName4, expectedFileName4);
			  checkConsoleLog();
			  System.out.println("******************Annotation Saved Successfully******************");
			  Thread.sleep(3000);
		  }
		  private void clickElementByXpath(String xpath, String elementName) {
		        try {
		        	WebDriverWait wait = new WebDriverWait(driver, 30);
		            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
		            element.click();
		            System.out.println(elementName + " clicked");
		            Thread.sleep(2000);
		        } catch (Exception e) {
		            System.out.println(elementName + " not clicked: " + e.getMessage());
		        }
			}

		  private void checkConsoleLog() {
			  LogEntries entry = driver.manage().logs().get(LogType.BROWSER);
		        List<LogEntry> logs = entry.filter(Level.SEVERE); 

		        int severeLogCount = logs.size(); 
		        System.out.println("Number of SEVERE-level logs: " + severeLogCount);

		        for (LogEntry log : logs) {																			
		            System.out.println("Level is : \n" + log.getLevel());
		            System.out.println("Message is : \n" + log.getMessage());
		        }
		        
		        
		        Assert.assertEquals(severeLogCount, 0, "SEVERE logs were found in the console.");
		        }
		  
		  @AfterTest

		  public void afterTest() {

			  driver.quit();

		  }
		

}
