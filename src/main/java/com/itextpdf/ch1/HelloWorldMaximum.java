package com.itextpdf.ch1;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfWriter;

/**
 * 
 * Creates a PDF with the biggest possible page size.
 * 
 * @author kylin
 *
 */
public class HelloWorldMaximum {
	
	public static final String RESULT = "results/part1/chapter01/hello_maximum.pdf";

	public static void main(String[] args) throws FileNotFoundException, DocumentException {
		
		Document document = new Document(new Rectangle(14400, 14400));
		PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(RESULT));
		writer.setUserunit(75000f);
		document.open();
		document.add(new Paragraph("Hello World"));
		document.close();
		
	}

}
