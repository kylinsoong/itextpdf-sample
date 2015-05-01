package com.itextpdf.ch1;

import java.io.FileOutputStream;
import java.io.IOException;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfWriter;

public class HelloWorldDirect {
	
	public static final String RESULT = "results/part1/chapter01/hello_direct.pdf";

	public static void main(String[] args) throws DocumentException, IOException {
		
		Document document = new Document();
		
		PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(RESULT));
		
		document.open();
		
		PdfContentByte canvas = writer.getDirectContentUnder();
		writer.setCompressionLevel(0);
        canvas.saveState();                               // q
        canvas.beginText();                               // BT
        canvas.moveText(36, 788);                         // 36 788 Td
        canvas.setFontAndSize(BaseFont.createFont(), 12); // /F1 12 Tf
        canvas.showText("Hello World");                   // (Hello World)Tj
        canvas.endText();                                 // ET
        canvas.restoreState();                            // Q
        
        document.close();
	}

}
