package actividad2;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Complementos {
	public static WebDriver driver;
	
	public static void creacion(String fech) throws IOException, Exception {

		// creación de carpeta
		File directorio4 = new File("C:\\webDriver");
		directorio4.mkdir();
		File directorio = new File("C:\\webDriver\\pruebaAutomatizacion");
		directorio.mkdir();
		File directorio1 = new File("C:\\webDriver\\pruebaAutomatizacion\\capturas");
		directorio1.mkdir();
		File directorio2 = new File("C:\\webDriver\\pruebaAutomatizacion\\capturas\\" + fech + "\\");
		directorio2.mkdir();
	}
	
	public static void bajar() throws Exception {
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_PAGE_DOWN);
		robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(1000);
		System.out.println("Bajar");

	}
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
		try {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "/lib/seleniumDrivers/chromeDriver/chromedriver.exe");
			// Creamos la instancia de chrome
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			generarLog("-------", "inicio Script", "-------");
		} catch (Exception e) {
			generarLog("ERROR", "SE GENERO UN ERROR", "");
			driver.close();
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
	
	public static void generarLog(String validacion, String pag, String descripcion) throws Throwable {
		java.util.Date fecha = new Date();
		System.out.println("generando log ");
		File carpeta = new File(System.getProperty("user.home") + "\\Documents\\logs");
		carpeta.mkdir();
		File file = new File((System.getProperty("user.home") + "\\Documents\\logs\\") + File.separator + "LOG.txt");
//			BufferedWriter escribir;
		Thread.sleep(1000);
		// FileOutputStream output = new FileOutputStream("output", false);
		try (BufferedWriter escribir = new BufferedWriter(new FileWriter(file, true));) {
			escribir.write(fecha + " // ");
			escribir.write(validacion + " // ");
			escribir.write(pag + " // ");
			escribir.write(descripcion + " // " + "\n");
			escribir.newLine();
			System.out.println("log generado");
			escribir.close();
		} catch (IOException e) {
			System.out.println("Error E/S: " + e);
		}
	}


}
