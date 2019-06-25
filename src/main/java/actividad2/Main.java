package actividad2;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

public class Main {
public static DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd--HH-mm-ss");
public static void clearConsole() {

    File fichero = new File((System.getProperty("user.home") + "\\Documents\\logs\\") + File.separator + "LOG.txt");

    if (fichero.delete())
        System.out.println("El fichero ha sido borrado satisfactoriamente");
    else
        System.out.println("El fichero no pudó ser borrado");
}	 


	public static void main(String[] args) throws Throwable {
		Fecha f = new Fecha();		
		Asistente asis = new Asistente();
		Compra comp = new Compra();
		Complementos complemento = new Complementos();
		clearConsole();
		// asignación de imagen a la carpeta!
		Date data = new Date();
		 String fecha1= dateFormat.format(data);
		f.setFech(fecha1);
		
		complemento.creacion(fecha1);

		
		 login login = new login();
	
	
		 asis.Registro(f);
		 login.registro(f);
		 comp.asignacionHotel(f);
	}
}
