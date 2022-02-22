package controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.pdf.PdfWriter;

import manipulate.Constants;

public class DecryptController {
	
	private static DecryptController decryptController;
	
	public static DecryptController getInstance() {
		if(decryptController==null)
			decryptController= new DecryptController();
		return decryptController;
	}
	
	public String decrypt(String lockedPathString, String unLockedPathString) {
		String logArea= ("Starting unlock process on "+ lockedPathString+" ...\n\n");
		File folder = new File(String.valueOf(lockedPathString));
		if(folder.isDirectory()) { // Controllo se il path src corrisponde ad una directory
			for (File lockedFile : folder.listFiles()) {
				File file = new File(unLockedPathString);
				file.getParentFile().mkdirs();
				
				try {
					DecryptController.getInstance().manipulatePdf(unLockedPathString+lockedFile.getName(),lockedPathString+lockedFile.getName());
					logArea=logArea+=(lockedFile.getName()+" unlocked! \n");
				} catch (Exception e) {
					LogController.getInstance(unLockedPathString+Constants.FILE_ERROR_LOG_NAME).printError("Unlock "+lockedFile.getName()+" KO!\n"+ e.toString() );
					logArea=logArea+=("Unlock "+lockedFile.getName()+" KO! For more details read errorLog.txt on unlocked folder.\n");
				}
				
			}
			logArea=logArea+=("\n\nEnd decryting!");
		}
		return logArea;
	}
	
	
	 private void manipulatePdf(String dest,String src) throws FileNotFoundException, IOException {
	        PdfDocument pdfDoc;
		
				pdfDoc = new PdfDocument(new PdfReader(src).setUnethicalReading(true), new PdfWriter(dest));
				   pdfDoc.close();
		
	     
	    }
}
