package ins.aiite.baseClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class BaseClass {

	public static WebDriver driver;
	public static WebElement element;
	public static Select s;
	public static JavascriptExecutor js;

	public static void browserLaunch(String drivername, String path) {
		System.setProperty(drivername, path);
		driver = new ChromeDriver();
	}

	public static void getUrl(String url) {
		driver.get(url);
	}

	public static void windowsMax() {
		driver.manage().window().maximize();
	}
	public static WebElement findElementbyId(String id) {
		return driver.findElement(By.id(id));	
	}

	public static WebElement findElementbyName(String name) {
		return driver.findElement(By.name(name));	
	}

	public static WebElement bytag(String tag) {
		return driver.findElement(By.tagName(tag));
	}
	public static void typedata(WebElement element, String data) {
		element.sendKeys(data);	
	}

	public static void click(WebElement element) {
		element.click();
	}

	public static void selectindex(WebElement element, int i) {
		 s =new Select(element);
		s.selectByIndex(i);
	}
	public static void selectText(WebElement element, String text) {
		 s =new Select(element);
		s.selectByVisibleText(text);
	}
	
	public static void executeTheScript() {
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", element);
	}
	public static void waitIMP(long a) {
		driver.manage().timeouts().implicitlyWait(a, TimeUnit.SECONDS);
	}
	public static String getAttribute(String id) {
		WebElement textData = driver.findElement(By.id(id));
		return textData.getAttribute("value");

	}
	public static String readProp(String key) {
		String value = null;
		try {
			FileReader read = new FileReader("C:\\Users\\VAISHNAVI\\eclipse-workspace\\HotelProjectWithoutPagebyString\\Files\\data.properties");
		Properties prop = new Properties();
		prop.load(read);
		value = prop.getProperty(key);
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return value;
	}
	public static String readExcel(String sheetName, int r, int c) {
			String value = null;
		try {
			String fpath = "C:\\Users\\VAISHNAVI\\eclipse-workspace\\HotelProjectWithoutPagebyString\\src\\test\\resources\\TestData\\Sample.xlsx";
			File f = new File(fpath);
			FileInputStream fis = new FileInputStream(f);
			Workbook wb = new XSSFWorkbook(fis);
			Sheet sh = wb.getSheet(sheetName);
			Row row = sh.getRow(r);
			Cell cell = row.getCell(c);
			int cellType = cell.getCellType();
			if(cellType==1) {
				value = cell.getStringCellValue();
			}
			else if(cellType==0) {
				if (DateUtil.isCellDateFormatted(cell)) {
					Date datecellValue =cell.getDateCellValue();
					SimpleDateFormat sc = new SimpleDateFormat("MM-dd-yyyy");
					value = sc.format(datecellValue);
				}
					else {
						double numValue = cell.getNumericCellValue();
						long a = (long)numValue;
						value = String.valueOf(a);
					}
				}
			
			} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return value;
		}
	public static void excelWrite(String sheetName, int r, int c, String value) {
		String fpath = "C:\\Users\\VAISHNAVI\\eclipse-workspace\\HotelProjectWithoutPagebyString\\src\\test\\resources\\TestData\\Sample.xlsx";
		File f = new File(fpath);
		FileInputStream fis;
		
		try {
			fis=new FileInputStream(f);
			Workbook wb = new XSSFWorkbook(fis);
			Sheet createSheet = wb.createSheet(sheetName);
			Row createRow = createSheet.createRow(r);
			Cell createCell = createRow.createCell(c);
			createCell.setCellValue(value);
			FileOutputStream fos = new FileOutputStream(f);
			wb.write(fos);
			wb.close();
			} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
