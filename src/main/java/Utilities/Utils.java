package Utilities;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Utils {
	// this class include pure java code
	public static HashMap<String, String> envVars = new HashMap<String, String>();
	public static void initializeEnvVars() {
		try {
			// get the path of configuration file from system variables
			BufferedReader br = new BufferedReader(new FileReader(System.getenv("SeleniumConfigFile")));
			String line = br.readLine();
			while(line != null) {
				String[] variable = line.split(",");
				envVars.put(variable[0], variable[1]);
				line = br.readLine();
			}
		} catch (FileNotFoundException e) {
			System.out.println("File is not exists at : "+System.getenv("SeleniumConfigFile"));
		} catch (IOException e) {
			
		}
	}
	
	public static Object[][] readDataFromExcel(String fileLocation) {
		Object[][] data = null;
		try {
			XSSFWorkbook workbook = new XSSFWorkbook(fileLocation);
			XSSFSheet sheet = workbook.getSheetAt(0);
			int totalRows = sheet.getLastRowNum();
			int totalCells = sheet.getRow(0).getLastCellNum();
			data = new Object[totalRows][totalCells];
			for(int i=1; i<=totalRows; i++) {
				XSSFRow row = sheet.getRow(i);
				for(int j=0; j<totalCells; j++) {
					data[i-1][j] = row.getCell(j).getStringCellValue();
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
	}

}
