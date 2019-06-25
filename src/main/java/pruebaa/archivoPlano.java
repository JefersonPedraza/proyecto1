package pruebaa;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

public class archivoPlano {

	
	public static void archivo(String var) throws IOException {
		
	     
		File 	f;
		FileWriter	fw;
		BufferedWriter bw;
		PrintWriter pw = null;
		try {
			f =new File("C:\\webDriver\\imagenes\\texto.txt");
			fw = new FileWriter(f);
			bw = new BufferedWriter(fw);
			pw = new PrintWriter(bw);
			
			pw.write(var);
			pw.append("looooool\\n");
			pw.append("looooool2\\n");
			pw.append("looooool3\\n");

			
		 pw.close();
		 bw.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
		
}
}