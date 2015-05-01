package com.itextpdf.ch1;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

/**
 * Creates a Hello World in PDF version 1.7
 * 
 * @author kylin
 *
 */
public class HelloWorldVersion_1_7 {
	
	public static final String RESULT = "results/part1/chapter01/hello_1_7.pdf";

	public static void main(String[] args) throws FileNotFoundException, DocumentException {
		
		Document document = new Document();
		
		PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(RESULT));
        writer.setPdfVersion(PdfWriter.VERSION_1_7);

        document.open();
        
        document.add(new Paragraph("Hello World!"));
        
        document.close();
	}

}
