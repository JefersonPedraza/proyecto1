package pruebaa;

import java.awt.Robot;

import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Month;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.format.CellNumberFormatter;
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

public class reporteHoras {

	
	public static WebDriver driver;

	public static WebElement AñoMes() {
		return driver.findElement(By.cssSelector(
				"body > form > table > tbody > tr:nth-child(6) > td > table.adquisicionCrearTdGris > tbody > tr:nth-child(1) > td > table > tbody > tr:nth-child(1) > td:nth-child(3)"));
	}

	public static void sleep(WebDriver driver, int seconds) {
		driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);

	}

	public static void Start() {
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "/lib/seleniumDrivers/chromeDriver/chromeDriver.exe");
		// Creamos la instancia de chrome
		driver = new ChromeDriver();
		driver.manage().window().maximize();

		// iniciar la pagina requerida
		driver.get("http://172.17.100.10/bposamtel/?controlador=Index");
		// maximizar pantalla

	}

	public static void digitar(String valor) {
		valor = valor.toUpperCase();
		try {
			Robot actionObj = new Robot();
			for (int i = 0; i < valor.length(); i++) {
				if (valor.charAt(i) == 'A') {
					actionObj.keyPress(KeyEvent.VK_A);
					actionObj.keyRelease(KeyEvent.VK_A);
				} else if (valor.charAt(i) == 'B') {
					actionObj.keyPress(KeyEvent.VK_B);
					actionObj.keyRelease(KeyEvent.VK_B);
				} else if (valor.charAt(i) == 'C') {
					actionObj.keyPress(KeyEvent.VK_C);
					actionObj.keyRelease(KeyEvent.VK_C);
				} else if (valor.charAt(i) == 'D') {
					actionObj.keyPress(KeyEvent.VK_D);
					actionObj.keyRelease(KeyEvent.VK_D);
				} else if (valor.charAt(i) == 'E') {
					actionObj.keyPress(KeyEvent.VK_E);
					actionObj.keyRelease(KeyEvent.VK_E);
				} else if (valor.charAt(i) == 'F') {
					actionObj.keyPress(KeyEvent.VK_F);
					actionObj.keyRelease(KeyEvent.VK_F);
				} else if (valor.charAt(i) == 'G') {
					actionObj.keyPress(KeyEvent.VK_G);
					actionObj.keyRelease(KeyEvent.VK_G);
				} else if (valor.charAt(i) == 'H') {
					actionObj.keyPress(KeyEvent.VK_H);
					actionObj.keyRelease(KeyEvent.VK_H);
				} else if (valor.charAt(i) == 'I') {
					actionObj.keyPress(KeyEvent.VK_I);
					actionObj.keyRelease(KeyEvent.VK_I);
				} else if (valor.charAt(i) == 'J') {
					actionObj.keyPress(KeyEvent.VK_J);
					actionObj.keyRelease(KeyEvent.VK_J);
				} else if (valor.charAt(i) == 'K') {
					actionObj.keyPress(KeyEvent.VK_K);
					actionObj.keyRelease(KeyEvent.VK_K);
				} else if (valor.charAt(i) == 'L') {
					actionObj.keyPress(KeyEvent.VK_L);
					actionObj.keyRelease(KeyEvent.VK_L);
				} else if (valor.charAt(i) == 'M') {
					actionObj.keyPress(KeyEvent.VK_M);
					actionObj.keyRelease(KeyEvent.VK_M);
				} else if (valor.charAt(i) == 'N') {
					actionObj.keyPress(KeyEvent.VK_N);
					actionObj.keyRelease(KeyEvent.VK_N);
				} else if (valor.charAt(i) == 'O') {
					actionObj.keyPress(KeyEvent.VK_O);
					actionObj.keyRelease(KeyEvent.VK_O);
				} else if (valor.charAt(i) == 'P') {
					actionObj.keyPress(KeyEvent.VK_P);
					actionObj.keyRelease(KeyEvent.VK_P);
				} else if (valor.charAt(i) == 'Q') {
					actionObj.keyPress(KeyEvent.VK_Q);
					actionObj.keyRelease(KeyEvent.VK_Q);
				} else if (valor.charAt(i) == 'R') {
					actionObj.keyPress(KeyEvent.VK_R);
					actionObj.keyRelease(KeyEvent.VK_R);
				} else if (valor.charAt(i) == 'S') {
					actionObj.keyPress(KeyEvent.VK_S);
					actionObj.keyRelease(KeyEvent.VK_S);
				} else if (valor.charAt(i) == 'T') {
					actionObj.keyPress(KeyEvent.VK_T);
					actionObj.keyRelease(KeyEvent.VK_T);
				} else if (valor.charAt(i) == 'U') {
					actionObj.keyPress(KeyEvent.VK_U);
					actionObj.keyRelease(KeyEvent.VK_U);
				} else if (valor.charAt(i) == 'V') {
					actionObj.keyPress(KeyEvent.VK_V);
					actionObj.keyRelease(KeyEvent.VK_V);
				} else if (valor.charAt(i) == 'W') {
					actionObj.keyPress(KeyEvent.VK_W);
					actionObj.keyRelease(KeyEvent.VK_W);
				} else if (valor.charAt(i) == 'X') {
					actionObj.keyPress(KeyEvent.VK_X);
					actionObj.keyRelease(KeyEvent.VK_X);
				} else if (valor.charAt(i) == 'Y') {
					actionObj.keyPress(KeyEvent.VK_Y);
					actionObj.keyRelease(KeyEvent.VK_Y);
				} else if (valor.charAt(i) == 'Z') {
					actionObj.keyPress(KeyEvent.VK_Z);
					actionObj.keyRelease(KeyEvent.VK_Z);
				} else if (valor.charAt(i) == '0') {
					actionObj.keyPress(KeyEvent.VK_0);
					actionObj.keyRelease(KeyEvent.VK_0);
				} else if (valor.charAt(i) == '1') {
					actionObj.keyPress(KeyEvent.VK_1);
					actionObj.keyRelease(KeyEvent.VK_1);
				} else if (valor.charAt(i) == '2') {
					actionObj.keyPress(KeyEvent.VK_2);
					actionObj.keyRelease(KeyEvent.VK_2);
				} else if (valor.charAt(i) == '3') {
					actionObj.keyPress(KeyEvent.VK_3);
					actionObj.keyRelease(KeyEvent.VK_3);
				} else if (valor.charAt(i) == '4') {
					actionObj.keyPress(KeyEvent.VK_4);
					actionObj.keyRelease(KeyEvent.VK_4);
				} else if (valor.charAt(i) == '5') {
					actionObj.keyPress(KeyEvent.VK_5);
					actionObj.keyRelease(KeyEvent.VK_5);
				} else if (valor.charAt(i) == '6') {
					actionObj.keyPress(KeyEvent.VK_6);
					actionObj.keyRelease(KeyEvent.VK_6);
				} else if (valor.charAt(i) == '7') {
					actionObj.keyPress(KeyEvent.VK_7);
					actionObj.keyRelease(KeyEvent.VK_7);
				} else if (valor.charAt(i) == '8') {
					actionObj.keyPress(KeyEvent.VK_8);
					actionObj.keyRelease(KeyEvent.VK_8);
				} else if (valor.charAt(i) == '9') {
					actionObj.keyPress(KeyEvent.VK_9);
					actionObj.keyRelease(KeyEvent.VK_9);
				} else if (valor.charAt(i) == ' ') {
					actionObj.keyPress(KeyEvent.VK_SPACE);
					actionObj.keyRelease(KeyEvent.VK_SPACE);
				}

				else if (valor.charAt(i) == '/') {
					actionObj.keyPress(KeyEvent.VK_DIVIDE);
					actionObj.keyRelease(KeyEvent.VK_DIVIDE);
				}

			}

		} catch (Exception e) {
			System.out.println(e);
		}

	}
	
	
	

	public static void registro(String dato1, String dato2, String dato3, String dato4, String dato5) throws InterruptedException, IOException {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd--HH-mm-ss");
		DateFormat dateFormat2 = new SimpleDateFormat("yyyy-MM-dd---HH-mm-ss");
		Date date = new Date();
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		
		// codigo despues de seleccionar fecha
		WebElement element3;
		// tiempo de espera
		sleep(driver, 50);
		element3 = driver.findElement(By.xpath("//*[@id=\"cmbproyectos\"]"));
		sleep(driver, 50);
		driver.findElement(By.xpath("//*[@id=\"cmbproyectos\"]")).click();
		sleep(driver, 50);
		digitar(dato1.charAt(0) + "");
		sleep(driver, 50);
		digitar(dato1.charAt(1) + "");
		sleep(driver, 50);
		Thread.sleep(2000);
		driver.findElement(By.linkText(dato1)).click();
		
		Thread.sleep(1000);
		

		// se elige la actividad

		sleep(driver, 20);
		List<WebElement> list1 = driver.findElement(By.xpath("//*[@id=\"cmbactividades\"]")).findElements(By.tagName("option"));

		driver.findElement(By.cssSelector("#cmbactividades")).click();

		for (int i = 0; i < list1.size(); i++) {
			System.out.println(list1.get(i).getText()+" "+ dato2+";");
		sleep(driver, 10);
			if (list1.get(i).getText().equals(dato2)) {
				sleep(driver, 10);
					list1.get(i).click();
					break;
			}
	}
	sleep(driver, 30);
		
//		driver.findElement(By.linkText(dato2)).click();
		

		
		sleep(driver, 30);
		driver.findElement(By.xpath("//*[@id=\"tcantidad\"]")).click();
		WebElement element4;
		sleep(driver, 50);
		element4 = driver.findElement(By.xpath("//*[@id=\"tcantidad\"]"));
		element4.sendKeys(dato3);

		sleep(driver, 30);
		driver.findElement(By.xpath("//*[@id=\"tdescripcion\"]")).click();
		WebElement element5;
		element5 = driver.findElement(By.xpath("//*[@id=\"tdescripcion\"]"));
		element5.sendKeys(dato4);
		sleep(driver, 30);
		
		
		//creación de carpeta
		File directorio = new File("C:\\webDriver\\imagenes\\"+dato5); 
		directorio.mkdir(); 

		sleep(driver, 30);
		//asignación de imagen a la carpeta!
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(scrFile, new File("C:\\webDriver\\imagenes\\"+dato5+"\\"+dateFormat2.format(date)+".png"));
		Thread.sleep(3000);

		// se selecciona guardar
		driver.findElement(By.xpath("//*[@id=\"cambioBtn\"]/img")).click();

		Thread.sleep(2000);
		
		js.executeScript("window.scrollBy(0,2000)");
		Thread.sleep(2000);
		//asignación de imagen a la carpeta!
				File scrFile21 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				FileHandler.copy(scrFile21, new File("C:\\webDriver\\imagenes\\"+dato5+"\\"+dateFormat.format(date)+".png"));
				
		
		// boton para regresar
		driver.findElement(By.xpath("//*[@id=\"tdBotones\"]/input")).click();

	}

	public static void main(String[] args) throws ParseException, InterruptedException, IOException {
		archivoPlano archivo = new archivoPlano();
		Start();

		Date fecha1 = new Date();

		ArrayList<String> lineas = new ArrayList<String>();
		try {
			// workboot lee todas las hojas que tiene el excel
			Workbook workbook = WorkbookFactory.create(new File("C:\\webDriver\\prueba4.xlsx"));
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

				sleep(driver, 50);
				// lenado de la lista
				lineas.add(aux);
				sleep(driver, 50);

			}

		} catch (Exception e) {
			System.out.println(e);
		}

		sleep(driver, 50);
		sleep(driver, 50);
		driver.findElement(By.name("login1")).click();
		sleep(driver, 50);

		// un for para que recorra la lista de lineas

		String dato[] = lineas.get(1).split("\\t");

	

		// asignacion de usuario!
		WebElement element;

		element = driver.findElement(By.xpath("//*[@id=\"tusuario\"]"));
		sleep(driver, 50);
		// se envia datos del excel
		element.sendKeys(dato[0]);

		// tiempo de espera
		sleep(driver, 30);
		// asignacion de clave
		WebElement element2;
		element2 = driver.findElement(By.xpath("//*[@id=\"tclave\"]"));
		// se envia datos del excel
		element2.sendKeys(dato[1]);
		// tiempo de espera
		sleep(driver, 10);

		// se selecciona el boton para loguearse
		driver.findElement(By.xpath("//*[@id=\"login1\"]/table/tbody/tr[2]/td[2]/table/tbody/tr[4]/td[2]/input"))
				.click();
		sleep(driver, 10);

		// se selecciona el boton reporte
		driver.findElement(By.xpath("/html/body/table/tbody/tr[6]/td/fieldset[1]/table/tbody/tr[3]/td/div/a[2]"))
				.click();
		sleep(driver, 50);


		sleep(driver, 50);

		// se hace separacion del String por -
		for (int i = 1; i < lineas.size(); i++) {
			String datos[] = lineas.get(i).split("\\t");
			String datos3[] = datos[2].split("-");

			System.out.println(datos3[2] + " " + datos3[1]);
			// se busca el elemento donde esta el mes y año en pagina
			WebElement myInput = driver.findElement(By.cssSelector(
					"body > form > table > tbody > tr:nth-child(6) > td > table.adquisicionCrearTdGris > tbody > tr:nth-child(1) > td > table > tbody > tr:nth-child(1) > td:nth-child(3)"));
			String b = myInput.getAttribute("innerHTML");
			String datos4[] = b.split(" ");
			System.out.println(b);
			// condicional para comparar entre mes y año con el de excel
			if (b.equals(datos3[2] + " " + datos3[1])) {
				sleep(driver, 50);
				System.out.println("las fechas coinciden");
				
			
				// seleciona el dia indicado!
				driver.findElement(By.linkText(datos3[0])).click();
				
				
				registro(datos[3], datos[4], datos[5], datos[6],datos[7]);
			} else if (Integer.parseInt(datos3[2]) < Integer.parseInt(datos4[0])) {
				System.out.println("La fecha es inferior");
				// condicional mientras no se cumpla la condición
				while (!b.equals(datos3[2] + " " + datos3[1])) {
					driver.findElement(By.xpath(
							"/html/body/form/table/tbody/tr[6]/td/table[2]/tbody/tr[1]/td/table/tbody/tr[1]/td[2]/a"))
							.click();
					myInput = AñoMes();
					// realiza el comparativo
					b = myInput.getAttribute("innerHTML");
					System.out.println(b);

				}
				// seleciona el dia indicado!
				driver.findElement(By.linkText(datos3[0])).click();

	registro(datos[3], datos[4], datos[5], datos[6],datos[7]);

			} else {
				System.out.println("La fecha es superior");

				// condicional mientras no se cumpla la condición
				while (!b.equals(datos3[2] + " " + datos3[1])) {
					driver.findElement(By.xpath(
							"/html/body/form/table/tbody/tr[6]/td/table[2]/tbody/tr[1]/td/table/tbody/tr[1]/td[4]/a"))
							.click();
					myInput = AñoMes();
					// realiza el comparativo
					b = myInput.getAttribute("innerHTML");
					System.out.println(b);

					System.out.println("la fecha no se puede registrar días");

					driver.findElement(
							By.xpath("/html/body/form/table/tbody/tr[6]/td/table[2]/tbody/tr[3]/td/center/a/img"));
				}

			}

		}

	}

}
