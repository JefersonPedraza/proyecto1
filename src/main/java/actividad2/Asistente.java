package actividad2;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.formula.functions.T;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import actividad2.Fecha;

public class Asistente {
	Fecha F = new Fecha();
	Complementos comp = new Complementos();
	public static void captura(Fecha f, int num) throws Exception {
		// asignación de imagen a la carpeta!
		System.out.println(f);
		File scrFile = ((TakesScreenshot) Complementos.driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(scrFile,
				new File("C:\\webDriver\\pruebaAutomatizacion\\capturas\\" + f.getFech() + "\\captura" + num + ".png"));
		Thread.sleep(3000);
	}
	public static void Registro(Fecha f) throws Throwable {
		Complementos.Start();
		try {
			Complementos.driver.get("https://www.phptravels.net");
			Thread.sleep(3000);
			if (Complementos.driver.getCurrentUrl().equals("https://www.phptravels.net/")) {
				Complementos.generarLog("inicio de pagina, efectivo", Complementos.driver.getTitle(), "accede a la pagina inicial");
			} else {
				Complementos.generarLog("inicio de pagina, errado", Complementos.driver.getTitle(),
						"No se logra el inicio de la pagina");}

		} catch (Exception e) {
			Complementos.generarLog("ERROR", "SE GENERO UN ERROR", "");
			Complementos.driver.close();}	
		try {
			Thread.sleep(3000);
			Complementos.driver.findElement(By.xpath("/html/body/nav/div/div[2]/ul[2]/ul/li[1]/a")).click();
			Thread.sleep(3000);
			Complementos.driver.get("https://www.phptravels.net/register");
			Thread.sleep(1000);
			if (Complementos.driver.getCurrentUrl().equals("https://www.phptravels.net/register")) {
				Complementos.generarLog("cambio de pagina, efectivo", Complementos.driver.getTitle(),
						"accede a la pagina de registro");
			} else {
				Complementos.generarLog("cambio de pagina, errado", Complementos.driver.getTitle(),
						"No se logra  el ingreso al registro");}
		} catch (Exception e) {
			Complementos.generarLog("ERROR", "SE GENERO UN ERROR", "");
			Complementos.driver.close();}
		try {
			List<String> excel = Complementos.leerAchivo("C:\\webDriver\\prueba8.xlsx");
			for (int i = 1; i < excel.size(); i++) {
				String datos[] = excel.get(i).split("\\t");
				Date date = new Date();
				Thread.sleep(1000);
				Complementos.driver.findElement(By.name("firstname")).sendKeys(datos[0]);
				Thread.sleep(1000);
				Complementos.driver.findElement(By.name("lastname")).sendKeys(datos[1]);
				Thread.sleep(1000);
				Complementos.driver.findElement(By.name("phone")).sendKeys(datos[2]);
				Thread.sleep(1000);
				Complementos.driver.findElement(By.name("email")).sendKeys(datos[3]);
				Thread.sleep(1000);
				JavascriptExecutor jse = (JavascriptExecutor)Complementos.driver;
				jse.executeScript("window.scrollBy(0,100)", "");
				Thread.sleep(1000);
				Complementos.driver.findElement(By.name("password")).sendKeys(datos[4]);
				Thread.sleep(1000);
				Complementos.driver.findElement(By.name("confirmpassword")).sendKeys(datos[4]);
				Thread.sleep(3000);
				captura(f, 1);
				Thread.sleep(2000);
				Complementos.driver.findElement(By.xpath("//*[@id=\"cookyGotItBtn\"]")).click();
				jse.executeScript("window.scrollBy(0,20)", "");
				Thread.sleep(2000);
				Complementos.driver.findElement(By.xpath("//*[@id=\"headersignupform\"]/div[9]/button")).click();
				Thread.sleep(3000);
				if (Complementos.driver.findElements(By.xpath("//*[@id=\"headersignupform\"]/div[2]/div"))
						.size() == 0) {
					System.out.println("Se puede registrar");
					Thread.sleep(3000);
					if (Complementos.driver.getCurrentUrl().equals("https://www.phptravels.net/account/")) {
						Complementos.generarLog("Registro, efectivo", Complementos.driver.getTitle(), "registro efectivo");
					} else {
						Complementos.generarLog("Registro, errado", Complementos.driver.getTitle(), "no fue efectivo el registro");}
					Thread.sleep(3000);
					if (Complementos.driver.getCurrentUrl().equals("https://www.phptravels.net/account/")) {
						Complementos.generarLog("Cambio pagina, efectivo", Complementos.driver.getTitle(), "Cambio pagina efectivo");
					} else {
						Complementos.generarLog("Cambio pagina, errado", Complementos.driver.getTitle(),
								"no fue efectivo el Cambio pagina");}
					Thread.sleep(2000);
					Complementos.driver.findElement(By.xpath("/html/body/nav/div/div[2]/ul[2]/ul/li[1]/a")).click();
					Thread.sleep(2000);
					Complementos.driver.findElement(By.xpath("/html/body/nav/div/div[2]/ul[2]/ul/li[1]/ul/li[2]/a")).click();
					Thread.sleep(2000);
					if (Complementos.driver.getCurrentUrl().equals("https://www.phptravels.net/login")) {
						Complementos.generarLog("Cierre de sesión, efectivo", Complementos.driver.getTitle(), "Logout efectivo");
					} else {
						Complementos.generarLog("Cierre de sesión, errado", Complementos.driver.getTitle(),
								"No se logra  el Logout");}
					if (Complementos.driver.getCurrentUrl().equals("https://www.phptravels.net/login/")) {
						Complementos.generarLog("Cambio pagina, efectivo", Complementos.driver.getTitle(), "Cambio pagina efectivo");
					} else {
						Complementos.generarLog("Cambio pagina, errado", Complementos.driver.getTitle(),
								"no fue efectivo el Cambio pagina");}
				} else {
					System.out.println("Ya existe");
					Thread.sleep(2000);
					Complementos.generarLog("Registro, errado", Complementos.driver.getTitle(), "ya existe un correo registro");
					Thread.sleep(2000);}
			}
		} catch (Exception e) {
			Complementos.generarLog("ERROR", "SE GENERO UN ERROR", "");
		}
	}
}
