package trm;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import actividad2.Complementos;

public class Vista {
	

	public static void abstra() throws Throwable {
		Complemento com = new Complemento();
		List<String> excel = Complementos.leerAchivo("C:\\webDriver\\prueba7.xlsx");
		for (int i = 1; i < excel.size(); i++) {
		String datos[] = excel.get(i).split("\\t");
		
		com.Start();
		com.driver.findElement(By.xpath("//*[@id=\"menuIndicadores\"]/div/div[2]/div[1]/div[2]/div/table/tbody/tr[2]/td[1]/a")).click();
		Robot rot = new Robot();
		rot.keyPress(KeyEvent.VK_PAGE_DOWN);
		rot.keyRelease(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(1000);
		Controlador.datos();
		com.driver.get("https://accounts.google.com/signin/v2/identifier?continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&service=mail&sacu=1&rip=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin");
		Thread.sleep(1000);
		com.driver.findElement(By.xpath("//*[@id=\"identifierId\"]")).click();
		com.driver.findElement(By.xpath("//*[@id=\"identifierId\"]")).sendKeys(datos[0]);
		Thread.sleep(1000);
		com.enter();
		Thread.sleep(1000);
		com.driver.findElement(By.xpath("//*[@id=\"password\"]/div[1]/div/div[1]/input")).click();
		com.driver.findElement(By.xpath("//*[@id=\"password\"]/div[1]/div/div[1]/input")).sendKeys(datos[1]);
		Thread.sleep(1000);
		com.enter();
		Thread.sleep(3000);
		com.driver.findElement(By.xpath("//*[@id=\":42\"]/div")).click();
		Thread.sleep(1000);
		//Controlador.obtenerCorreo();
		}
	}
	
}
