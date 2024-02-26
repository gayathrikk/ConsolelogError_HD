package Error.Console_log;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HD_consolelog {
	
	 private RemoteWebDriver driver;
		
		@BeforeTest
		
		public void setup() throws MalformedURLException 
		{
			
			  DesiredCapabilities dc = DesiredCapabilities.chrome();
		        URL url = new URL("http://172.20.23.7:5555/wd/hub");
		        driver = new RemoteWebDriver(url, dc);
		
		       
		}
		//@Parameters("URL")
		@Test(priority=1)
		//public void login(@Optional("defaultURL") String URL) throws InterruptedException
		public void login()throws InterruptedException
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
	  		    WebElement section = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[text()='883'])[1]")));
	  		    section.click();
	  		    System.out.println("section clicked successfully.");
	  		    Thread.sleep(2000);
	  		} catch (Exception e) {
	  		    System.out.println("section not clicked: " + e.getMessage());
	  		}
	    	 
	    	 
	    	
	    	 System.out.println("************************************Series set validation done********************************");
	
	 	}
		

		@Test(priority=3)
		public void gridandzoom() throws InterruptedException {
	    	WebDriverWait wait = new WebDriverWait(driver, 10);
	    	WebElement hd = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@title='View High Resolution Image']")));
	    	if (hd.isEnabled() && hd.isDisplayed()) {
	    	    hd.click();
	    	    System.out.println("High resolution page is opened");
	    	} else {
	    	    System.out.println("High resolutin page is not opened");
	    	}
	    	
		     driver.findElement(By.xpath("//a[@title='Show Grid']")).click(); 
		     Thread.sleep(5000);
		     WebElement zoomin=driver.findElement(By.xpath("(//button[@type='button'])[1]"));
		     int repeatCount = 8;

		       for (int i = 0; i < repeatCount; i++) 
		       {
		          zoomin.click();
		          Thread.sleep(3000);
		        }
		        driver.findElement(By.xpath("//a[@title='Digital Zoom']")).click();
		        int repeatCount1 = 8;

		        for (int i = 0; i < repeatCount1; i++) 
		        	{
		            zoomin.click();
		            Thread.sleep(3000);
		        	}
		        driver.findElement(By.xpath("//a[@title='Digital Zoom']")).click();
		        WebElement zoomout =driver.findElement(By.xpath("//button[@title='Zoom out']"));
		        int repeatCount3 = 7;
		        
		        for (int i = 0; i < repeatCount3; i++) 
		        {
		        zoomout.click();
		     
		        }
//		     Thread.sleep(3000);
//		     WebElement canvas = driver.findElement(By.xpath("//canvas"));
//		     Actions actions = new Actions(driver);
//		     actions.moveToElement(canvas).build().perform();
//		     actions.keyDown(Keys.CONTROL).sendKeys(Keys.chord(Keys.CONTROL, Keys.ADD)).keyUp(Keys.CONTROL).build().perform(); //zoom in
//		     Thread.sleep(5000);
//		     actions.keyDown(Keys.CONTROL).sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT)).keyUp(Keys.CONTROL).build().perform(); //zoomout
		     
		     driver.findElement(By.xpath("//a[@title='Hide Grid']")).click();
		     checkConsoleLog();
		     System.out.println("**********************************Grid and zoom validation done***********************************");
		     Thread.sleep(1000);
		        
	    }
		@Test(priority=4)
	    public void measure() throws InterruptedException {
	    	 WebElement canvas = driver.findElement(By.xpath("//canvas"));
		        Actions actions = new Actions(driver);

		        driver.findElement(By.xpath("//a[@title='Measure']")).click();
		        actions.moveToElement(canvas)
		                .click()
		                .moveByOffset(300, 0)
		                .click()
		                .moveByOffset(0, 300)
		                .click()
		                .moveByOffset(-200, 0)
		                .click()
		                .moveByOffset(0, -200)
		                .click()
		                .moveByOffset(-500, 0)
		                .click()
		                .release()
		                .perform();
		        Thread.sleep(5000);
		        driver.findElement(By.xpath("//a[@title='Stop Measure']")).click();
		        driver.findElement(By.xpath("//a[@title='Delete Measure']")).click();
		        checkConsoleLog();
		        Thread.sleep(1000);
		        System.out.println("**********************************Measure validation done******************************************");
		        
	    }
		@Test(priority=5)
	    public void download() throws InterruptedException {
	    	 driver.findElement(By.xpath("//a[@title='Dimension Download']")).click();
		        driver.findElement(By.xpath("//button[text()=' Download ']")).click();
		        Thread.sleep(5000);
		        WebElement dropdown=driver.findElement(By.id("mySelect"));
		        Select select = new Select(dropdown);
		        select.selectByValue("1024");
		        driver.findElement(By.xpath("//button[text()=' Download ']")).click();
		        Thread.sleep(5000);
		        select.selectByValue("2048");
		        driver.findElement(By.xpath("//button[text()=' Download ']")).click();
		        Thread.sleep(5000);
		        select.selectByValue("4096");
		        driver.findElement(By.xpath("//button[text()=' Download ']")).click();
		        Thread.sleep(2000);
		        driver.findElement(By.xpath("//div[text()='Download Full Image']//following::button[3]")).click();
		        checkConsoleLog();
		        Thread.sleep(5000);
		        System.out.println("**********************************Download validation done******************************************");
	    }
		@Test(priority=6)
	    public void RGB() throws InterruptedException {
	    	Thread.sleep(5000);
	    	  driver.findElement(By.xpath("(//nb-icon[@pack='nebular-essentials'])[5]")).click();

	    	    WebElement slider1 = driver.findElement(By.xpath("(//span[@role='slider'])[1]"));
	    	    Actions actions1 = new Actions(driver);
	    	    actions1.clickAndHold(slider1);
	    	    actions1.moveByOffset(50, 0).release().build().perform();
	    	    Thread.sleep(5000);
	    	    driver.findElement(By.xpath("(//button[text()=' Default '])[1]")).click();
	    	    Thread.sleep(4000);

	    	    WebElement slider2 = driver.findElement(By.xpath("(//span[@role='slider'])[3]"));
	    	    Actions actions2 = new Actions(driver);
	    	    actions2.clickAndHold(slider2);
	    	    actions2.moveByOffset(50, 0).release().build().perform();
	    	    Thread.sleep(5000);
	    	    driver.findElement(By.xpath("(//button[text()=' Default '])[1]")).click();
	    	    Thread.sleep(4000);

	    	    WebElement slider3 = driver.findElement(By.xpath("(//span[@role='slider'])[5]"));
	    	    Actions actions3 = new Actions(driver);
	    	    actions3.clickAndHold(slider3);
	    	    actions3.moveByOffset(50, 0).release().build().perform();
	    	    Thread.sleep(5000);
	    	    driver.findElement(By.xpath("(//button[text()=' Default '])[1]")).click();
	    	    Thread.sleep(4000);

	    	    WebElement slider4 = driver.findElement(By.xpath("(//span[@role='slider'])[7]"));
	    	    Actions actions4 = new Actions(driver);
	    	    actions4.clickAndHold(slider4);
	    	    actions4.moveByOffset(50, 0).release().build().perform();
	    	    Thread.sleep(4000);
	    	    driver.findElement(By.xpath("(//button[text()=' Default '])[1]")).click();
	    	    checkConsoleLog();
	    	    Thread.sleep(3000);
	    	    System.out.println("******************************RGB validation done*******************************");
	    }
		@Test(priority=7)
	    public void opacitywindow() throws InterruptedException {
	    	 driver.findElement(By.xpath("(//nb-icon[@pack='nebular-essentials'])[7]")).click();
	    	 WebElement nisslslider = driver.findElement(By.xpath("(//span[@role='slider'])[8]"));
	    	 Thread.sleep(2000);
	    	 int width = nisslslider .getSize().getWidth();
	         Actions actions = new Actions(driver);
	         actions.dragAndDropBy(nisslslider , -(width+width+width+width), 0).perform();
	         Thread.sleep(2000);
	         driver.findElement(By.xpath("//a[@title='Show Grid']")).click(); 
	         Thread.sleep(2000);
	         WebElement gridslider=driver.findElement(By.xpath("(//span[@role='slider'])[9]"));
	         Thread.sleep(2000);
	         int width2=gridslider.getSize().getWidth();
	         actions.dragAndDropBy(gridslider, -(width+width+width+width), width2).perform();
	         Thread.sleep(4000);
	    	 driver.findElement(By.xpath("(//button[text()=' Default '])[2]")).click();
	    	 driver.findElement(By.xpath("//a[@title='Hide Grid']")).click();
	    	 Thread.sleep(2000);
	    	 driver.findElement(By.xpath("//a[@title='back']")).click();
	    	 checkConsoleLog();
	    	 System.out.println("*******************************Opacity window validation done*********************************");
	    }
		
		  
		    private void checkConsoleLog() {
		        // Clear console log

		        // Retrieve console log entries
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
		    
		@AfterClass
	    public void tearDown() {
	        driver.quit();
	    }

}
