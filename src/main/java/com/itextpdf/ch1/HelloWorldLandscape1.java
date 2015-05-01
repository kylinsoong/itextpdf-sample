package com.itextpdf.ch1;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

/**
 * 
 * A possible way to create a document in the landscape format.
 * 
 * @author kylin
 *
 */
public class HelloWorldLandscape1 {
	
	public static final String RESULT = "results/part1/chapter01/hello_landscape1.pdf";

	public static void main(String[] args) throws FileNotFoundException, DocumentException {

		Document document = new Document(PageSize.LETTER.rotate());
		PdfWriter.getInstance(document, new FileOutputStream(RESULT));
		document.open();
		document.add(new Paragraph("Hello World"));
		document.close();
	}

}
