package controller;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LogController {

	private static File log;
	private static LogController logController;
	
	
	public static LogController getInstance(String pathLogFile) {
		if(logController==null)
			logController= new LogController(pathLogFile);
		return logController;
	}
	
	
	
	private LogController(String logFile) {
		log= new File(logFile);
	}
	
	public void printError(String error){
		
		 try {
			log.createNewFile();
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
			   LocalDateTime now = LocalDateTime.now();  
			FileWriter myWriter = new FileWriter(log.getAbsolutePath(),true);
			 myWriter.append(dtf.format(now)+" : "+error+"\n");
		     myWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		 
	}
}
