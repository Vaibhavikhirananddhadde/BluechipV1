package util;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.google.common.collect.ImmutableMap;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UtilClass {
	public static WebDriver driver;
	public String sheetName;
	
	public static String readProperty(String key) throws Exception {
		String projectPath = System.getProperty("user.dir");
		File file = new File(projectPath + ".\\src\\test\\resources\\Register.properties" );
		FileInputStream fileInput = new FileInputStream(file);
		Properties prop = new Properties();
		prop.load(fileInput);
		return prop.get(key).toString();
	}

	public static void launchBrowser(String browser) {
		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--headless");
			options.setCapability("pageLoadStrategy", "normal"); // or "eager" or "none"
			options.setCapability("timeouts", ImmutableMap.of("pageLoad", 60000));
		
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions options=new FirefoxOptions();
			options.addArguments("--headless");
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else {
			System.out.println("Opening Chrome browser as Default browser");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		waitImplicit();
	}
	
	public static void checkAlertpresent() {
		if (isAlertPresent()) {
            // Switch to the alert
            Alert alert = driver.switchTo().alert();

            // Perform actions with the alert if needed
            System.out.println("Alert text: " + alert.getText());

            // Accept the alert
            alert.accept();
        } else {
            System.out.println("No alert present on the webpage.");
        }
	}
		
	    public static boolean isAlertPresent() {
	        try {
	        	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	            wait.until(ExpectedConditions.alertIsPresent());
	            return true;
	        } catch (NoAlertPresentException e) {
	            return false;
	        }
	    }
	
	public static void scrolltoview(WebElement element) {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", element);

	}

	public static void waitExplicit(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(150));
		wait.until(ExpectedConditions.visibilityOf(element));
		wait.until(ExpectedConditions.elementToBeClickable(element));
		
	}
	
	public static void waitUntillVisiblity(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(150));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public static void waitExplicitUntillTitle(String titleToWait) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.titleIs(titleToWait));
	}

	public static void waitImplicit() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	public static void getApplication(String url) {
		driver.get(url);
	}

	public static void type(WebElement element, String text) {
		element.sendKeys(text);
	}

	public static void clickOn(WebElement element) {
		
	    waitExplicit(element);
	    try {
	        element.click();
	    } catch (ElementClickInterceptedException e) {
	        // Handle the exception, for example, scrolling into view and trying again
	        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
	        element.click();
	    }
		
	}

	public static String getPageTitle() {
		waitExplicitUntillTitle(driver.getTitle());
		return driver.getTitle();
	}

	public static String extractText(WebElement element) {
		waitExplicit(element);
		return element.getText();
	}

	public static int getResponseCode(String url) throws Exception, Exception {
		URL link = new URL(url);
		HttpURLConnection connect = (HttpURLConnection) link.openConnection();
		// connect.setRequestMethod("Head");
		// connect.connect();
		int responseCode = connect.getResponseCode();
		return responseCode;
	}

//	public static Object[][] dataReader(String sheetName) throws Exception {
//		String excelPath = System.getProperty("user.dir");
//		XSSFWorkbook workBook = new XSSFWorkbook(excelPath+"/Excel/BlueChipExcelData.xlsx");
//		XSSFSheet sheet = workBook.getSheet(sheetName);
//		int row = sheet.getPhysicalNumberOfRows();
//		int column = sheet.getRow(0).getPhysicalNumberOfCells();
//		Object[][] data = new Object[row][column];
//
//
//		for (int i = 0; i < row; i++) {
//			for (int j = 0; j < column; j++) {
//			//	DataFormatter dataFormatter = new DataFormatter();
//				//String cellValue = dataFormatter.formatCellValue(data[i][j]);
//				data[i][j] = sheet.getRow(i).getCell(j) + "".toString();
//				data[i][j] = sheet.getRow(i).getCell(j).getStringCellValue();
//			}
//		}
//		workBook.close();
//		return data;no 
//	}
	
	
//	public static Object[][] dataReader1(String sheetName) throws Exception {
//	    String excelPath = System.getProperty("user.dir");
//	    XSSFWorkbook workBook = new XSSFWorkbook(excelPath + ".\\src\\test\\resources\\ExcelData.xlsx");
//	    XSSFSheet sheet = workBook.getSheet(sheetName);
//	    int row = sheet.getPhysicalNumberOfRows();
//	    int column = sheet.getRow(0).getPhysicalNumberOfCells();
//	    Object[][] data = new Object[row-1][column];  // update row to row-1 ==>otherwise Null pointer exception !!!
//
//	    for (int i = 1; i < row; i++) {
//	        for (int j = 0; j < column; j++) {
//	            XSSFCell cell = sheet.getRow(i).getCell(j);
//	            if(cell !=null) {
//	            if (cell.getCellType() == CellType.NUMERIC) {
//	                // Convert numeric value to string
//	                data[i-1][j] = String.valueOf((int) cell.getNumericCellValue());   //updated here from i ==> i-1
//	            } else {
//	                // For other cell types, get the string value
//	                data[i-1][j] = cell.getStringCellValue();    //updated here from i ==> i-1
//	            }
//	            }else {
//	            	data[i][j]="";    ////updated here from i ==> i-1
//	            }
//	        }
//	    }
//
//	    workBook.close();
//	    return data;
//	}
//	
	
	public static Object[][] dataReader(String sheetName) throws Exception {
	    String excelPath = System.getProperty("user.dir");
	    XSSFWorkbook workBook = new XSSFWorkbook(excelPath + "\\src\\test\\resources\\ExcelData.xlsx");
	    XSSFSheet sheet = workBook.getSheet(sheetName);
	    int row = sheet.getPhysicalNumberOfRows();
	    int column = sheet.getRow(0).getPhysicalNumberOfCells();
	    Object[][] data = new Object[row - 1][column];

	    for (int i = 1; i < row; i++) {
	        for (int j = 0; j < column; j++) {
	            XSSFCell cell = sheet.getRow(i).getCell(j);
	            if (cell != null) {
	                if (cell.getCellType() == CellType.NUMERIC) {
	                    // Convert numeric value to string
	                    data[i - 1][j] = String.valueOf((int) cell.getNumericCellValue());
	                } else {
	                    // For other cell types, get the string value
	                    data[i - 1][j] = cell.getStringCellValue();
	                }
	            } else {
	                data[i - 1][j] = "";
	            }
	        }
	    }
	    workBook.close();
	    return data;
	}


	public static void selectFromDropDown(WebElement element, String visibleText) {
		waitExplicit(element);
		Select select = new Select(element);
		select.selectByVisibleText(visibleText);
	}

	public static void titleAssertion(String expTitle) {
		Assert.assertEquals(getPageTitle(), expTitle);
	}
	
	public static void textAssertion(WebElement element, String expectedText) {
		Assert.assertEquals(extractText(element), expectedText);
		
	}

	public static void jsScrollUntillElement(WebElement element) {
		waitExplicit(element);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
	}
     
	public static void scrollDown() throws Exception {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,8000)", "");
		Thread.sleep(3000);
	}
	public static void jsClickOn(WebElement element) {
		waitExplicit(element);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
	}

	public static void softAssert(String actResult, String expResult) {
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(actResult, expResult);
	}
	
	public static String getScreenshot(String testCaseName) throws Exception, IOException {
		String time = getTime();
		String path=System.getProperty("user.dir")+"/screenshot/"+testCaseName+time+".png";
		FileUtils.copyFile(((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE), new File(path));
		return path;
	}
	
	public static String getParentWindowId() {
		return driver.getWindowHandle();
	}
	
	public static void switchToChildWindow(String parentWindowId) {
		Set<String> allWindows = driver.getWindowHandles();
		for(String windows : allWindows) {
			if(windows!=parentWindowId) {
				driver.switchTo().window(windows);
			}
		}
	}
	
	public void windowhandle(WebElement element) {
	
	String mainWindowHandle = driver.getWindowHandle();

	// Click on an element that opens the new window
	element.click();

	// Switch to the new window
	Set<String> allWindowHandles = driver.getWindowHandles();
	for (String windowHandle : allWindowHandles) {
	    if (!windowHandle.equals(mainWindowHandle)) {
	        driver.switchTo().window(windowHandle);
	        // Perform operations in the new window
	        // ...
	        // Close or switch back to the main window when done
	        // driver.close(); // Close the current window
	        // driver.switchTo().window(mainWindowHandle); // Switch back to the main window
	    }
	}
	}
	
	
	public static String getTime() {
		DateFormat dateFormat = null;
		Date date = null;
		try {
			dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
			date = new Date();
		} catch (Exception e) {
			System.out.println("Error in Getdateandtime : " + e.getMessage());
		}

		return dateFormat.format(date);
	}
	
	public static void switchToParentWindow(String parentWindowId) {
		driver.switchTo().window(parentWindowId);
	}
	
	public static void handleAlert() {
		driver.switchTo().alert().accept();
	}
	
	public void switchToFrame(WebElement elemnt) {
		driver.switchTo().frame(elemnt);
	}
	
	public void toDefaultContent() {
		driver.switchTo().defaultContent();
	}
	
	public boolean isElementDisplayed(WebElement element) {
		return element.isDisplayed();
	}
	
	public void flWait() {
		new FluentWait<>(driver)
				.withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofMillis(200))
				.ignoring(Exception.class);
	}
	
	public void checkIfPagesReachesTop() {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("return window.pageYOffset;");
	}

	
	public static void jsScrollDownUntilElementVisible(WebElement element) {
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		    while (true) {
		        try {
		            if (wait.until(ExpectedConditions.elementToBeClickable(element)).isDisplayed()) {
		                element.click();
		                break; 
		            } else {
		            	((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
		            }
		        } catch (StaleElementReferenceException | TimeoutException e) {
		   
		        }
		    }

	}

	public void clickButtonAndWaitForDownload(String buttonxpath, int timeoutInSeconds) {
        WebElement downloadButton = driver.findElement(By.xpath(buttonxpath));
        downloadButton.click();
        waitForDownload(timeoutInSeconds);
    }

    public boolean isPdfDownloaded(String fileName, String downloadPath) {
        String filePath = downloadPath + "/" + fileName;
        return isFileDownloaded(filePath);
    }

    private void waitForDownload(int timeoutInSeconds) {
        // You can use WebDriverWait here for a more robust solution
        try {
            Thread.sleep(timeoutInSeconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private boolean isFileDownloaded(String filePath) {
        // Implement logic to check if the file exists in the specified path
        // You can use java.nio.file.Path and java.nio.file.Files to check file existence
        // Return true if the file is found, false otherwise
        // For example:
        return Files.exists(Paths.get(filePath));
      
    }
    
    public boolean isFooterSticky() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

        // Check if footer is sticky
        WebElement footer = driver.findElement(By.id("footer"));
        return (boolean) js.executeScript(
                "var rect = arguments[0].getBoundingClientRect();" +
                        "return (rect.bottom <= window.innerHeight && rect.bottom > 0);",
                footer
        );
    }
    
    
    public List<WebElement> handleDropdown(WebElement container, String path) throws Exception {
		List<WebElement> DDelements = new ArrayList<>();
		List<WebElement> containerlements = new ArrayList<>();
		containerlements = container.findElements(By.cssSelector(path));
		for(int i=0;i<containerlements.size();i++) {
			DDelements.add(containerlements.get(i));
			
		}
		return DDelements;

	}
    
    public void childBrowser(WebDriver driver)
	{
		Set<String> child = driver.getWindowHandles();
		for(String b:child)
		{
		   driver.switchTo().window(b);
		}
	}
    
    public void mouseOvering(WebDriver driver,WebElement ele)
	{
		Actions a=new Actions(driver);
		a.moveToElement(ele).perform();
	}
    
    public void uploadFileRobot(WebElement uploadElement, String filePath) throws AWTException, InterruptedException {
        // Click the upload element to open the file dialog
        uploadElement.click();
        Thread.sleep(1000);
        
        Robot robot = new Robot();

        // Use Robot class to handle the file upload dialog
        StringSelection selection = new StringSelection(filePath);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);

        

        // Press CTRL+V to paste the file path
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);

        // Press ENTER to confirm the file upload
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
    }
    

}
