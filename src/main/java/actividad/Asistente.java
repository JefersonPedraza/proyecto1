package actividad;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

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

public class Asistente {

	public static WebDriver driver;
	public static WebElement w;
	
	public static ArrayList<String> leerAchivo(String ruta) {
		ArrayList<String> lineas = new ArrayList<String>();
		try {

			Workbook workbook = WorkbookFactory.create(new File(ruta));
			Sheet sheet = workbook.getSheetAt(0);
			DataFormatter dataFormatter = new DataFormatter();

			Iterator<Row> rowIterator = sheet.rowIterator();
			while (rowIterator.hasNext()) {
				Row row = rowIterator.next();
				Iterator<Cell> cellIterator = row.cellIterator();
				String aux = "";
				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();
					String cellValue = dataFormatter.formatCellValue(cell);

					aux = aux + cellValue + "\t";
				}

				lineas.add(aux);
			}
		} catch (Exception e) {

		}
		return lineas;

	}

	
	public static void Start() throws Throwable {
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "/lib/seleniumDrivers/chromeDriver/chromedriver.exe");
		// Creamos la instancia de chrome
		driver = new ChromeDriver();
		driver.manage().window().maximize();

		// iniciar la pagina requerida
		 driver.get("http://automationpractice.com/index.php");
		 if (driver.getTitle().equals("My Store")) {
				generarLog("inicio de pagina, efectivo", "accede a la pagina inicial");
			}else {
				generarLog("inicio de pagina, errado", "No se logra el inicio de la pagina");
			}
	}
	
		
		public static void generarLog(String validacion, String descripcion) throws Throwable {
		java.util.Date fecha = new Date();
		System.out.println("generando log ");

		File carpeta = new File(System.getProperty("user.home")+"\\Documents\\logs");
		carpeta.mkdir();
		File file = new File((System.getProperty("user.home")+"\\Documents\\logs\\") + File.separator + "LOG.txt");
//			BufferedWriter escribir;

		Thread.sleep(1000);
		// FileOutputStream output = new FileOutputStream("output", false);
		try (BufferedWriter escribir = new BufferedWriter(new FileWriter(file, true));) {
		escribir.write(" fecha: " + fecha + " // ");
		escribir.write(" validación: " + validacion + " // ");
		escribir.write(" Descripción: " + descripcion +  " // " + "\n");
		escribir.write("\n");
		escribir.newLine();
		System.out.println("log generado");
		escribir.close();
		} catch (IOException e) {
		System.out.println("Error E/S: " + e);

		}
		}
		
		
		public static void enter() throws Exception {
			Robot robot = new Robot();	
			Thread.sleep(1000);
			Robot r = new Robot();
			r.keyPress(KeyEvent.VK_ENTER);
			r.keyRelease(KeyEvent.VK_ENTER);
			System.out.println("Se hizo enter");
		}
		
		
		public static void registro() throws Throwable {
		Start();
		
		driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a")).click();
		Thread.sleep(1000);
		if (driver.getTitle().equals("Login - My Store")) {
				generarLog("Cambio de pagina, efectivo", "accede a la pagina de registro");
				System.out.println("accede a la pagina de registro");
			}else {
				generarLog("Cambio de pagina, errado", "No se logra el cambio de pagina");
				System.out.println("No se logra el cambio de pagina");
			}
		Thread.sleep(1000);
		List<String> excel = leerAchivo("C:\\webDriver\\prueba8.xlsx");
		for (int i = 1; i < excel.size(); i++) {
			String datos[] = excel.get(i).split("\\t");
			System.out.println(datos[5]);
			String datos2[] = datos[5].split("-");
			Thread.sleep(1000);
			// registrar correro
			driver.findElement(By.xpath("//*[@id=\"email_create\"]")).sendKeys(datos[0]);
			Thread.sleep(1000);
			driver.findElement(By.xpath("//*[@id=\"SubmitCreate\"]")).click();
			Thread.sleep(1000);
			if (driver.getCurrentUrl().equals("http://automationpractice.com/index.php?controller=authentication&back=my-account#account-creation")) {
				generarLog("registro correo, Efectivo", "El correo fue registrado exitosamente!");
			}else {
				generarLog("registro correo, errado", "No se logra el registro de correo");
			}
			Thread.sleep(4000);
			// asignación de sexo
			if (datos[1].equals("hombre")) {
				Thread.sleep(2000);
				driver.findElement(By.id("id_gender1")).click();
			}else {
				Thread.sleep(2000);
				driver.findElement(By.id("id_gender2")).click();
			}
			Thread.sleep(1000);
			//primer nombre
			driver.findElement(By.id("customer_firstname")).sendKeys(datos[2]);
			Thread.sleep(1000);
			//segundo nombre
			driver.findElement(By.id("customer_lastname")).sendKeys(datos[3]);
			Thread.sleep(1000);
			//Clave
			driver.findElement(By.id("passwd")).sendKeys(datos[4]);
			Thread.sleep(1000);
			//Fecha nacimiento
			//dia
			Thread.sleep(1000);
			driver.findElement(By.id("days")).click();
			Thread.sleep(1000);
			driver.findElement(By.id("days")).sendKeys(datos2[0]);
			Thread.sleep(1000);
			//mes
			driver.findElement(By.xpath("//*[@id=\"months\"]")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//*[@id=\"months\"]")).sendKeys(datos2[1]);
			//año
			Thread.sleep(1000);
			driver.findElement(By.id("years")).click();
			Thread.sleep(1000);
			driver.findElement(By.id("years")).sendKeys(datos2[2]);
			Thread.sleep(1000);
			driver.findElement(By.xpath("//*[@id=\"newsletter\"]")).click();
			//empresa
			Thread.sleep(1000);
			driver.findElement(By.id("company")).sendKeys(datos[6]);
			//Direccion 1
			Thread.sleep(1000);
			driver.findElement(By.id("address1")).sendKeys(datos[7]);
			//Direccion 2
			Thread.sleep(1000);
			driver.findElement(By.id("address2")).sendKeys(datos[8]);
			//Ciudad
			Thread.sleep(1000);	
			driver.findElement(By.id("city")).sendKeys(datos[9]);
			//Estado
			Thread.sleep(1000);	
			driver.findElement(By.id("id_state")).click();
			Thread.sleep(1000);	
			driver.findElement(By.id("id_state")).sendKeys(datos[10]);
			//codigo postal
			Thread.sleep(1000);	
			driver.findElement(By.id("postcode")).click();
			Thread.sleep(1000);	
			driver.findElement(By.id("postcode")).sendKeys(datos[11]);
			//pais
			Thread.sleep(1000);	
			driver.findElement(By.id("id_country")).sendKeys(datos[12]);
			//adicional
			Thread.sleep(1000);	
			driver.findElement(By.id("other")).sendKeys(datos[13]);
			//telefono 
			Thread.sleep(1000);	
			driver.findElement(By.id("phone")).sendKeys(datos[14]);
			//telefono celular
			Thread.sleep(1000);	
			driver.findElement(By.id("phone_mobile")).sendKeys(datos[15]);
			//registro
			Thread.sleep(1000);	
			driver.findElement(By.xpath("//*[@id=\"submitAccount\"]")).click();
			
		}
			
			
			
		}
	
		}
		
	
	
	

