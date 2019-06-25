package trm;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import actividad2.Complementos;

public class Controlador {
	public static void datos() {
		Complemento com = new Complemento();
		WebElement frame = com.driver.findElement(By.xpath("//*[@id=\"form1\"]/div[3]/p[1]/iframe"));
		com.driver.switchTo().frame(frame);
		
		String myInput = com.driver.findElement(By.className("filaPub4")).getText();
		
		System.out.println(myInput);
		String datos[] = myInput.split(" ");
	
		Excel.logExcel(datos[2], datos[3]);
		Mailer.sendBienvenido(datos[2], datos[3]);

	}
	
	public static void obtenerCorreo() throws Exception {
		Complemento com = new Complemento();
	Thread.sleep(2000);
		List<WebElement> list1 = com.driver.findElement(By.xpath("//*[@id=\":6l\"]"))
				.findElements(By.tagName("tr"));
		
		System.out.println(list1);
		Thread.sleep(1000);
		WebElement w = list1.get(0);
		w.click();
		Thread.sleep(1000);
		System.out.println("Fin del proceso");
	}
	

	
}