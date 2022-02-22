package controller;

import java.io.File;
import java.io.FileOutputStream;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;

public class CopyAcrofieldController {

	private static CopyAcrofieldController copyAcrofieldController;
	
	public static CopyAcrofieldController getInstance() {
		if(copyAcrofieldController==null)
			copyAcrofieldController= new CopyAcrofieldController();
		return copyAcrofieldController;
	}
	
	private CopyAcrofieldController() {}
	
	
	public String MapSingleDoc(String toMap, String mapped, String destinazione)  {
		
		try {
			String nameFile = toMap.substring(toMap.lastIndexOf("\\"),toMap.length());
			File toMapFile = new File(toMap);
			File mappedFile = new File(mapped);
			if(toMapFile.isFile() && mappedFile.isFile()) {  // Ampliare controlli sui file !!!!
				PdfReader pieno = new PdfReader( mapped );
				PdfReader vuoto = new PdfReader( toMap ); // throws
				PdfStamper stamper = new PdfStamper( pieno ,  new FileOutputStream(destinazione+nameFile) ); //throws
				
				for( int i = 1; i <= pieno.getNumberOfPages(); ++i) {
					stamper.replacePage( vuoto, i, i );
				}
				
				stamper.close();
				
				return "DOC MAPPATO";
			}
			else  return"ERRORE TEMPLATE NON TROVATO";
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return"";
	}
}
