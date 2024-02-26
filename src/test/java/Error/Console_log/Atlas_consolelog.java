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
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;



public class Atlas_consolelog {
	
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
		
		public void atlaseditor() throws InterruptedException
		{
			WebDriverWait wait = new WebDriverWait(driver, 30); 
			driver.switchTo().defaultContent();
			 try {
		  		    WebElement atlaseditor= wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@title='Atlas Editor']")));
		  		    atlaseditor.click();
		  		    System.out.println("Atlas Editor open");
		  		    Thread.sleep(2000);
		  		} catch (Exception e) {
		  		    System.out.println("Atlas Editor is not open: " + e.getMessage());
		  		}
			 Thread.sleep(6000);
			 checkConsoleLog();
			 System.out.println("************************Atlas Editor open sucessfully***********************");
			 Thread.sleep(6000);
			 
		}
		@Test(priority=4)
		public void Editmenu() throws InterruptedException
		{
	
			WebDriverWait wait = new WebDriverWait(driver, 30); 
			driver.switchTo().defaultContent();
			 try {
		  		    WebElement Editmenu= wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@title='Edit Menu']")));
		  		    Editmenu.click();
		  		    System.out.println("Edit menu open successfully.");
		  		    Thread.sleep(2000);
		  		} catch (Exception e) {
		  		    System.out.println("Edit menu is not open: " + e.getMessage());
		  		}
			 checkConsoleLog();
		}
		@Test(priority=5)
		public void contributor() throws InterruptedException
		{
			WebDriverWait wait = new WebDriverWait(driver, 30); 
			driver.switchTo().defaultContent();
			 try {
		  		    WebElement contributor= wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//nb-icon[@pack='nebular-essentials'])[2]")));
		  		    contributor.click();
		  		    System.out.println("contributor option open successfully.");
		  		    Thread.sleep(2000);
		  		} catch (Exception e) {
		  		    System.out.println("contributor option is not open: " + e.getMessage());
		  		}
			 checkConsoleLog();
			 
			 try {
		  		    WebElement contributor= wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@type='radio'])[2]")));
		  		    contributor.click();
		  		    System.out.println("contributor selected successfully.");
		  		    Thread.sleep(2000);
		  		} catch (Exception e) {
		  		    System.out.println("contributor is not selected : " + e.getMessage());
		  		}
			 checkConsoleLog();
		}
		@Test(priority=6)
		public void draw() throws InterruptedException
		{
			WebDriverWait wait = new WebDriverWait(driver, 30); 
			driver.switchTo().defaultContent();
			try {
	  		    WebElement draw= wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@title='Draw']")));
	  		    draw.click();
	  		    System.out.println("Draw option selected successfully.");
	  		    Thread.sleep(2000);
	  		} catch (Exception e) {
	  		    System.out.println("Draw option is not open: " + e.getMessage());
	  		}
		 checkConsoleLog();
		}
		
		@Test(priority=7)
		public void annotation() throws InterruptedException
		{
			
			clickElementByXpath("(//nb-icon[@pack='nebular-essentials'])[2]", "Annotation option");
	    	clickElementByXpath("(//i[@role='presentation'])[1]", "node1");
	    	 clickElementByXpath("(//i[@role='presentation'])[4]", "node2");
	    	 clickElementByXpath("(//i[@role='presentation'])[7]", "node3");
	    	 clickElementByXpath("(//i[@role='presentation'])[11]", "node4");
			
			 WebElement canvas = driver.findElement(By.xpath("//canvas"));
		     Actions actions = new Actions(driver);
		        
		        clickElementByXpath("//a[@title='Add']", "Add");
		        
		        actions.moveToElement(canvas)
	            .click()
	            .moveByOffset(200, 0)
	            .click()
	            .moveByOffset(0, 200)
	            .click()
	            .moveByOffset(-200, 0)
	            .click()
	            .moveByOffset(0, -200)
	            .click()
	            .release()
	            .perform();
		        Thread.sleep(5000);
		        checkConsoleLog();
		        System.out.println("Annotation completed");
		}
		@Test(priority=8)
		public void save() throws InterruptedException
		{
			clickElementByXpath("//a[@title='Save']", "save");
			WebDriverWait deleteWait = new WebDriverWait(driver, 100);
			By toasterLocator = By.xpath("//div[text()='Sucessfully saved the regions']");
			WebElement toasterElement = deleteWait.until(ExpectedConditions.presenceOfElementLocated(toasterLocator));
			String toasterMessage = toasterElement.getText();
			AssertJUnit.assertEquals("Sucessfully saved the regions", toasterMessage);
			Thread.sleep(2000);
			checkConsoleLog();
			System.out.println("*******************Saved the regions successfully************************");
	
		}
		@Test(priority=9)
		public void back() throws InterruptedException
		{
			clickElementByXpath("//a[@title='Close']", "close");
			clickElementByXpath("//a[@title='Back']", "Back ");
			
		}
		@Test(priority=10)
		public void retrive() throws InterruptedException
		{
			clickElementByXpath("(//span[text()='883'])[1]", "section ");
			clickElementByXpath("//a[@title='Atlas Editor']", "Atlas Editor");
			clickElementByXpath("//a[@title='Edit Menu']", "Edit menu");
			clickElementByXpath("(//nb-icon[@pack='nebular-essentials'])[2]", "Contributor option"); 
			clickElementByXpath("(//input[@type='radio'])[2]", "Contributor"); 
			String nonenode=driver.findElement(By.xpath("(//div[@class='paragraph'])[2]")).getText();
			 System.out.println("None node="+nonenode);
			clickElementByXpath("(//nb-icon[@pack='nebular-essentials'])[3]", "Annotation option");
			clickElementByXpath("(//i[@role='presentation'])[1]", "node1");
	    	 clickElementByXpath("(//i[@role='presentation'])[4]", "node2");
	    	 clickElementByXpath("(//i[@role='presentation'])[7]", "node3");
	    	 clickElementByXpath("(//i[@role='presentation'])[11]", "node4");
			String selectednode=driver.findElement(By.xpath("(//div[@class='paragraph'])[2] ")).getText();
			 System.out.println("Selected node="+selectednode);
			Assert.assertNotEquals(nonenode, selectednode);
			System.out.println("*******************saved node retrived successfully************************");
			Thread.sleep(4000);
			 
		}
		@Test(priority=11)
		public void delete() throws InterruptedException
		{
			clickElementByXpath("//a[@title='Draw']", "Draw");
			WebElement canvas = driver.findElement(By.xpath("//canvas"));
			Actions actions = new Actions(driver);
			int centerX = 0; 
			int centerY = 0; 
	
			
			actions.moveToElement(canvas, centerX, centerY)
			        .click()
			        .perform();
//			Thread.sleep(2000);
//			 clickElementByXpath("(//i[@role='presentation'])[11]", "node4");
	
			Thread.sleep(2000);
			clickElementByXpath("//a[@title='Delete']", "Delete option");
			clickElementByXpath("//button[text()='Delete']", "Delete button");
			clickElementByXpath("//a[@title='Save']", "save");
			clickElementByXpath("//a[@title='Close']", "close");
			clickElementByXpath("//a[@title='Back']", "Back ");
			System.out.println("*******************Annotated data deleted successfully**************************");
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
		public void close() throws Exception
		{
			
			driver.quit();
	
	}

}
