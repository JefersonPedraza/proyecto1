package actividad2;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.sql.Driver;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.concurrent.TimeUnit;

import org.omg.CORBA.TIMEOUT;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;

import okio.Timeout;

public class Compra {
	public static DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd--HH-mm-ss");

	public static void asignacionHotel(Fecha f) throws Throwable {
		Asistente asistente = new Asistente();
		Robot robot = new Robot();
		List<String> excel = Complementos.leerAchivo("C:\\webDriver\\prueba8.xlsx");

		try {
			for (int i = 1; i < excel.size(); i++) {
				String datos[] = excel.get(i).split("\\t");
				Thread.sleep(1000);
				Complementos.driver.findElement(By.xpath("//*[@id=\"s2id_autogen3\"]/a")).click();
				Thread.sleep(1000);

				Complementos.driver.findElement(By.xpath("//*[@id=\"select2-drop\"]/div/input")).sendKeys(datos[5]);
				Thread.sleep(2000);
				Complementos.enter();

				Thread.sleep(2000);
				Complementos.driver.findElement(By.xpath("//*[@id=\"dpd1\"]/div/input")).sendKeys(datos[6]);
				Thread.sleep(2000);
				Complementos.driver.findElement(By.xpath("//*[@id=\"dpd2\"]/div/input")).sendKeys(datos[7]);
				Thread.sleep(2000);
				Complementos.driver.findElement(By.xpath("//*[@id=\"hotels\"]/form/div[5]/button")).click();
				Thread.sleep(3000);

				if (Complementos.driver.getCurrentUrl().equals("https://www.phptravels.net/m-hotels")) {

					Complementos.generarLog("cambio de pagina, errado", Complementos.driver.getTitle(),
							"No se ingresa a la pagina de hoteles");
					Thread.sleep(1000);
					Complementos.driver.close();
				} else {
					Complementos.generarLog("cambio de pagina, efectivo", Complementos.driver.getTitle(),
							"se ingresa a la pagina de hoteles");
				}
				//Complementos.driver.findElement(By.xpath("//*[@id=\"cookyGotItBtn\"]")).click();
				//Thread.sleep(3000);
				List<WebElement> list1 = Complementos.driver
						.findElement(By.xpath("//*[@id=\"body-section\"]/div[5]/div/div[3]/div[1]/div/table/tbody"))
						.findElements(By.tagName("button"));
				System.out.println(list1.size());

				int numero = (int) (Math.random() * (2 -list1.size())) + list1.size()-1;
				System.out.println(numero);
				Thread.sleep(3000);
				WebElement w = list1.get(numero);
				Thread.sleep(1000);
				while (w.isDisplayed() == false) {
					JavascriptExecutor jse = (JavascriptExecutor)Complementos.driver;
					jse.executeScript("window.scrollBy(0,250)", "");
				}
				w.click();
				Thread.sleep(1000);
				if (Complementos.driver.getCurrentUrl().equals("https://www.phptravels.net/m-hotels")) {
					Complementos.generarLog("cambio de pagina, errado", Complementos.driver.getTitle(),
							"No se ingresa a la pagina de hotel");
				} else {
					Complementos.generarLog("cambio de pagina, efectivo", Complementos.driver.getTitle(),
							"se ingresa a la pagina de hotel");
				}

				System.out.println("dio click");
				Thread.sleep(1000);
				reserva(f);

			}

		} catch (Exception e) {
			Complementos.generarLog("ERROR", "SE GENERO UN ERROR", "");
			Complementos.driver.close();
		}

	}



	public static void reserva(Fecha f) throws Throwable {
		Asistente asistente = new Asistente();
		try {

			Robot robot = new Robot();
			//Complementos.driver.findElement(By.xpath("//*[@id=\"cookyGotItBtn\"]")).click();

			//Complementos.driver.findElement(By.xpath("//*[@id=\"ROOMS\"]/div/div[1]")).click();
			List<WebElement> list1 = Complementos.driver.findElement(By.xpath("//*[@id=\"ROOMS\"]/div/table/tbody"))
					.findElements(By.className("control__indicator"));
			System.out.println(list1.size());
			// robot.mouseWheel(13);

			

			int numero = (int) (Math.random() * list1.size());
			WebElement w = list1.get(numero);
			System.out.println(numero);
			Thread.sleep(1000);
			while (!w.isDisplayed()) {
				JavascriptExecutor jse = (JavascriptExecutor)Complementos.driver;
				jse.executeScript("window.scrollBy(0,250)", "");
			
			} 
			w.click();

			System.out.println("dio click en tu reserva jajaj xD");
			robot.mouseWheel(3);
			Thread.sleep(1000);
			Complementos.driver.findElement(By.xpath("//*[@id=\"ROOMS\"]/div/button")).click();

			if (Complementos.driver.getCurrentUrl().equals("https://www.phptravels.net/m-hotels")) {
				Complementos.generarLog("cambio de pagina, errado", Complementos.driver.getTitle(),
						"No se ingresa a la reserva de habitación");
			} else {
				Complementos.generarLog("cambio de pagina, efectivo", Complementos.driver.getTitle(),
						"se ingresa a la reserva de habitación");
			}
			
			Complementos.bajar();
			Thread.sleep(3000);
			Complementos.driver.findElement(By.xpath("//*[@id=\"body-section\"]/div/div[1]/div/div[1]/div/div[4]/button"))
					.click();
			if (Complementos.driver.getCurrentUrl().equals("https://www.phptravels.net/m-hotels")) {
				Complementos.generarLog("cambio de pagina, errado", Complementos.driver.getTitle(),
						"No se genera la reserva de habitación");
			} else {
				Complementos.generarLog("cambio de pagina, efectivo", Complementos.driver.getTitle(),
						"se genera la reserva de la habitación");
			}

			Thread.sleep(5000);
			asistente.captura(f, 3);
			Thread.sleep(2000);
			Complementos.driver.findElement(By.xpath("/html/body/nav/div/div[2]/ul[1]/li[1]/a")).click();
			if (Complementos.driver.getCurrentUrl().equals("https://www.phptravels.net/m-hotelsss")) {
				Complementos.generarLog("cambio de pagina, errado", Complementos.driver.getTitle(),
						"No se genera el cambio de la pagina");
			} else {
				Complementos.generarLog("cambio de pagina, efectivo", Complementos.driver.getTitle(),
						"se genera el cambio de la pagina");
			}
			System.out.println("Usuario deslogueado");
			Complementos.driver.close();

		} catch (Exception e) {
			Complementos.generarLog("ERROR", "SE GENERO UN ERROR", "");
			Complementos.driver.close();
		} 
	}
}
