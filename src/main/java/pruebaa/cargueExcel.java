package pruebaa;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class cargueExcel {
	public static void sleep(WebDriver driver, int segundos) {
		driver.manage().timeouts().implicitlyWait(segundos, TimeUnit.SECONDS);
	}

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "/lib/seleniumDrivers/chromeDriver/chromeDriver.exe");
		// Creamos una instancia de chrome
		WebDriver driver = new ChromeDriver();
		// iniciar la pagina requerida
		driver.get(
				"https://www.bhdleon.com.do/wps/portal/BHD/Inicio/!ut/p/z1/04_Sj9CPykssy0xPLMnMz0vMAfIjo8ziTSxdDDxNTAy93T3cDAwcjXxMLYOD_IO8Hc30w_Eq8DfVjyJGvwEO4GhAnH48CqLwGx-uH4XXCpAPCJlRkBsaGmGQ6QgAIyLKwQ!!/dz/d5/L2dBISEvZ0FBIS9nQSEh/");
		// maximizar pantalla
		driver.manage().window().maximize();
		// abrir formulario!
		driver.findElement(By.xpath("//*[@id=\"top\"]/section/section/article/span[1]")).click();

		// tiempo de espera
		sleep(driver, 10);
		// leer formulario
		WebElement frame = driver.findElement(By.cssSelector("#top > section > section > article > div > iframe"));
		driver.switchTo().frame(frame);
		// tiempo de espera
		sleep(driver, 3);

		// desplegar formulario
		driver.findElement(By.xpath("//*[@id=\"loginCombo_title\"]")).click();
		// tiempo de espera
		sleep(driver, 3);
		// seleccion empresarial
		driver.findElement(By.cssSelector("#loginCombo_child > ul > li:nth-child(2)")).click();
		// tiempo de espera
		sleep(driver, 2);
		// lista

		ArrayList<String> lineas = new ArrayList<String>();
		try {
			// workboot lee todas las hojas que tiene el excel
			Workbook workbook = WorkbookFactory.create(new File("C:\\webDriver\\prueba.xlsx"));
			// sheet asignación de la hoja la cual vamos a sacar los datos
			Sheet sheet = workbook.getSheetAt(0);
			// formato el cual trae el excel la escritura
			DataFormatter dataFormatter = new DataFormatter();
			// iterator es una lista de el row(fila)
			Iterator<Row> rowIterator = sheet.rowIterator();
			while (rowIterator.hasNext()) {
				Row row = rowIterator.next();
				Iterator<Cell> cellIterator = row.cellIterator();
				String aux = "";
				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();
					String cellValue = dataFormatter.formatCellValue(cell);
					// la asignacion del escrito separado por un tab
					aux = aux + cellValue + "\t";
				}
				// lenado de la lista
				lineas.add(aux);
			}
		} catch (Exception e) {
			System.out.println(e);
		}

		for (int i = 1; i < lineas.size(); i++) {
			String datos[] = lineas.get(i).split("\\t");

			// cedula
			WebElement element;
			element = driver.findElement(By.xpath("//*[@id=\"bhdlologinBody\"]/div[1]/form/ul/li[3]/div/input"));

			element.sendKeys(datos[0]);
			sleep(driver, 3);
			// clave
			WebElement element2;
			element2 = driver.findElement(By.xpath("//*[@id=\"bhdlologinBody\"]/div[1]/form/ul/li[4]/div/input"));

			element2.sendKeys(datos[1]);
			sleep(driver, 3);
			// codigo imagen
			WebElement element3;
			element3 = driver.findElement(By.xpath("//*[@id=\"bhdlologinBody\"]/div[1]/form/ul/li[5]/div/input"));

			element3.sendKeys(datos[2]);
			sleep(driver, 3);

			element.clear();
			element2.clear();
			element3.clear();
		}

	}

}
