package tallerFinal;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.collections4.Get;
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
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class Asistente {
	public static WebDriver driver;
	public static DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd--HH-mm-ss");

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

	public static void Start() {
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "/lib/seleniumDrivers/chromeDriver/chromedriver.exe");
		// Creamos la instancia de chrome
		driver = new ChromeDriver();
		driver.manage().window().maximize();

		// iniciar la pagina requerida
		driver.get("http://172.17.100.10/bposamtel/?controlador=Index");

	}

	public static void screenshot(Date fechaAct) throws IOException, Exception {
		
		//creación de carpeta
				File directorio = new File("C:\\webDriver\\pruebaAutomatización"); 
				if (!directorio.exists()) {
					directorio.mkdir();
					File directorio1 = new File("C:\\webDriver\\pruebaAutomatización\\capturas"); 
					if (!directorio.exists()) {
						directorio1.mkdir();
						File directorio2 = new File("C:\\webDriver\\pruebaAutomatización\\"+fechaAct);
						if (!directorio.exists()) {
							directorio2.mkdir();
								
						}else {
							System.out.println("ya existe carpeta");
						}	
					}else {
						System.out.println("ya existe carpeta");
					}
				}else {
					System.out.println("ya existe carpeta");
				}
				

	//asignación de imagen a la carpeta!
				File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				FileHandler.copy(scrFile, new File("C:\\webDriver\\imagenes\\"+fechaAct+"\\"+dateFormat.format(fechaAct)+".png"));
				Thread.sleep(3000);
	}
	

	public static void Login() throws IOException, Exception {
		Start();
		Date date = new Date();
		Datos datos = new Datos();

		List<String> excel = leerAchivo("C:\\webDriver\\prueba7.xlsx");

		String ingreso[] = excel.get(1).split("\\t");
		datos.setUsuario(ingreso[0]);
		datos.setClave(ingreso[1]);
		screenshot(date);

		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"tusuario\"]")).sendKeys(datos.getUsuario());
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"tclave\"]")).sendKeys(datos.getClave());
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"login1\"]/table/tbody/tr[2]/td[2]/table/tbody/tr[4]/td[2]/input"))
				.click();

	}

	public static void logout() {
		driver.findElement(By.xpath("//*[@id=\"tabsJ\"]/ul/li[6]/a")).click();

		driver.findElement(By.xpath("/html/body/table/tbody/tr[9]/td/div/a/img")).click();
	}

}
