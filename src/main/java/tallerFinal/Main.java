package tallerFinal;

import java.io.IOException;

public class Main {

	
	public static void main(String[] args) throws IOException, Exception {
		Asistente asistente = new Asistente();
		asistente.Login();
		Thread.sleep(2000);
		asistente.logout();
	}
}
