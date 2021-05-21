package Utilities;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

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

}
