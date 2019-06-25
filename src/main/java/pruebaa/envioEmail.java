package pruebaa;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class envioEmail {
	public static void slepp(WebDriver driver, int segundos) {
		driver.manage().timeouts().implicitlyWait(segundos, TimeUnit.SECONDS);
	}

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {

		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "/lib/seleniumDrivers/chromeDriver/chromeDriver.exe");
		// Creamos una instancia de chrome
		WebDriver driver = new ChromeDriver();
		// iniciar la pagina requerida
		driver.get("https://www.google.com/intl/es-419/gmail/about/");
		// maximizar pantalla
		driver.manage().window().maximize();
		// ingreso al inicio de sesión
		driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[4]/ul[1]/li[2]/a")).click();
		// cambiar de pestaña
		List<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));

		slepp(driver, 3);

		ArrayList<String> lineas = new ArrayList<String>();
		try {
			// workboot lee todas las hojas que tiene el excel
			Workbook workbook = WorkbookFactory.create(new File("C:\\webDriver\\prueba2.xlsx"));
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

			// correo
			WebElement element;
			element = driver.findElement(By.id("identifierId"));
			element.sendKeys(datos[0]);

			// creación de carpeta
			File directorio = new File("C:\\webDriver\\correo");
			directorio.mkdir();

			// asignación de imagen a la carpeta!
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileHandler.copy(scrFile, new File("C:\\webDriver\\correo\\screenshot1.png"));

			// Oprimir el boton para continuar
			driver.findElement(By.xpath("//*[@id=\"identifierNext\"]/content")).click();

			slepp(driver, 20);

			if (driver.findElements(By.id("profileIdentifier")).size() > 0) {
				// Tiempo de espera
				slepp(driver, 3);

				// clave
				WebElement element2;
				element2 = driver.findElement(By.xpath("//*[@id=\"password\"]/div[1]/div/div[1]/input"));
				element2.sendKeys(datos[1]);

				// Tiempo de espera
				slepp(driver, 55);

				// Oprimir el boton para continuar
				driver.findElement(By.xpath("//*[@id=\"passwordNext\"]/content/span")).click();

				// Tiempo de espera
				slepp(driver, 50);

				// oprimir el boton de redactar
				driver.findElement(By.className("z0")).click();

				// Tiempo de espera
				slepp(driver, 40);

				// escribir el correo
				WebElement element3;
				// buscar el elemento a selecccionar
				element3 = driver.findElement(By.className("vO"));
				// tiempo de espera
				slepp(driver, 50);
				// se escribe el correo
				element3.sendKeys("jspedraza@gmail.com");
				slepp(driver, 20);
				// escribir el asunto
				WebElement element4;
				element4 = driver.findElement(By.id(":p8"));
				slepp(driver, 40);
				element4.sendKeys("este no es un mensaje");
		

				// pantallazo
				File scrFile2 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
				FileHandler.copy(scrFile2, new File("C:\\webDriver\\correo\\screenshot2.png"));
				slepp(driver, 20);

				// se oprime el boton enviar
				driver.findElement(By.id(":nu")).click();
				// tiempo de espera
				slepp(driver, 60);
				// se oprime cerca a las opciones del boton
				driver.findElement(By.className("wT")).click();
				slepp(driver, 50);
				// se oprime el boton enviados
				driver.findElement(By.id(":ja")).click();
				// tiempo espera
				slepp(driver, 50);
				// se selecciona el correo deseado
				List<WebElement> list = driver.findElements(By.xpath("//*[@id=\":p7\"]/tbody/tr"));
				
					// tiempo espera
					slepp(driver, 50);
					WebElement element5;
					// tiempo espera
					slepp(driver, 60);
					element5 = (list.get(0));
					// tiempo espera
					slepp(driver, 40);
					element5.click();
					slepp(driver, 5);
					System.out.println("proceso exitoso");
					slepp(driver, 30);
					//System.out.println(driver.findElement(By.xpath("//*[@dir='ltr']")).);
					
					System.out.println(driver.findElement(By.className("Bk")).findElement(By.className("gs")).findElement(By.className("aHl")).getText());
			
					

				} 
			else {
				System.out.println("Usuario incorrecto");

				// asignación de imagen a la carpeta!
				File scrFile2 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
				FileHandler.copy(scrFile2, new File("C:\\webDriver\\correo\\screenshot2.png"));

			}

		}

	}
}
