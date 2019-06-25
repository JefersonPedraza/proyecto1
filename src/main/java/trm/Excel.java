package trm;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel {
	public static void logExcel(String dato1, String dato2) {
		File carpeta = new File("C:\\webDriver\\pruebaAutomatizacion\\log");
		carpeta.mkdir();

		File file = new File(("C:\\webDriver\\pruebaAutomatizacion\\log\\") + File.separator + "log.xlsx");
			Workbook libro = new XSSFWorkbook();
			// Se crea una hoja dentro del libro
			Sheet hoja = libro.createSheet("log");
			// Se crea una fila dentro de la hoja

			String[] titulos = { "TRM", "Vigencia"};
			String[] datos = { dato1,dato2 };

			Row fila = hoja.createRow(0);
			for (int i = 0; i < titulos.length; i++) {

				Cell celda = fila.createCell(i);
				celda.setCellValue(titulos[i]);
			}

			fila = hoja.createRow(1);

			// Y colocamos los datos en esa fila
			for (int i = 0; i < datos.length; i++) {

				Cell celda = fila.createCell(i);

				celda.setCellValue(datos[i]);
			}

			try {
				FileOutputStream winium = new FileOutputStream(file);
				libro.write(winium);
				System.out.println("se creo el archivo excel");
				libro.close();

			} catch (Exception e) {
				e.printStackTrace();
			}

		 
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

	
}

