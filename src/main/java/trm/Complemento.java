package trm;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import actividad2.Complementos;

public class Complemento {
	public static WebDriver driver;
	
	public static void Start() throws Throwable {
		try {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "/lib/seleniumDrivers/chromeDriver/chromedriver.exe");
			// Creamos la instancia de chrome
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			Thread.sleep(3000);
			driver.get("https://www.superfinanciera.gov.co/jsp/index.jsf");
			Thread.sleep(3000);
			bajar();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
	
	public static void bajar() throws Exception {
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_PAGE_DOWN);
		robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
		robot.keyPress(KeyEvent.VK_PAGE_DOWN);
		robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(1000);
		System.out.println("Bajar");

	}
	
	public static void enter() throws Exception {
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(1000);
		System.out.println("enter");

	}
	}

	
	
	

