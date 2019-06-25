package actividad2;

import java.sql.Driver;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import actividad2.Fecha;
import org.openqa.selenium.By;

public class login {
	Fecha F = new Fecha();

	public static void registro(Fecha f) throws Throwable {
		Asistente asistente = new Asistente();
		Compra comp = new Compra();
		Thread.sleep(3000);
						System.out.println(Complementos.driver.getCurrentUrl());
		try {
			Thread.sleep(3000);
			if (Complementos.driver.getCurrentUrl().equals("https://www.phptravels.net/login")) {
				System.out.println("esta en la pagina correcta");
			} else if (Complementos.driver.getCurrentUrl().equals("https://www.phptravels.net/register")) {	
				Thread.sleep(3000);
				Complementos.driver.findElement(By.xpath("/html/body/nav/div/div[2]/ul[2]/ul/li[1]/a")).click();
				Thread.sleep(3000);
				Complementos.driver.get("https://www.phptravels.net/login");
				Thread.sleep(3000);
				
			} 
			Thread.sleep(2000);
			if (Complementos.driver.getCurrentUrl().equals("https://www.phptravels.net/login")) {
				Complementos.generarLog("Ingreso a pagina, efectivo", Complementos.driver.getTitle(),
						"Ingreso a pagina login efectiva");
			} else {
				Complementos.generarLog("Ingreso a pagina, errado", Complementos.driver.getTitle(),
						"Ingreso a pagina login errado");
			}
		} catch (Exception e) {
			Complementos.generarLog("ERROR", "SE GENERO UN ERROR", "");
		}
		try {
			List<String> excel = Complementos.leerAchivo("C:\\webDriver\\prueba8.xlsx");
			for (int i = 1; i < excel.size(); i++) {
				String datos[] = excel.get(i).split("\\t");
				Date date = new Date();
				// LOGIN USUARIO
				Thread.sleep(1000);
				Complementos.driver.findElement(By.name("username")).sendKeys(datos[3]);
				// LOGIN CLAVE
				Thread.sleep(1000);
				Complementos.driver.findElement(By.name("password")).sendKeys(datos[4]);
				Thread.sleep(2000);
				asistente.captura(f, 2);
				// VALIDACION
				Thread.sleep(2000);
				Complementos.enter();
				Thread.sleep(2000);
				if (Complementos.driver.getCurrentUrl().equals("https://www.phptravels.net/account/")) {
					Complementos.generarLog("Ingreso de usuario, efectivo", Complementos.driver.getTitle(), "Login efectivo");
				} else {
					Complementos.generarLog("Ingreso de usuario, errado", Complementos.driver.getTitle(),
							"No se logra  el Login");
				}
				Thread.sleep(1000);
				Complementos.driver.findElement(By.xpath("/html/body/nav/div/div[2]/ul[1]/li[1]/a")).click();
				Thread.sleep(3000);
				if (Complementos.driver.getCurrentUrl().equals("https://www.phptravels.net/m-hotels")) {
					Complementos.generarLog("cambio de pagina, efectivo", Complementos.driver.getTitle(),
							"se retorna a la pagina del inicio");
				} else {
					Complementos.generarLog("cambio de pagina, errado", Complementos.driver.getTitle(),
							"No se logra  cambio de pagina");
				}
			}
		} catch (Exception e) {
			Complementos.generarLog("ERROR", "SE GENERO UN ERROR", "");
			Complementos.driver.close();
		}
	}
}
