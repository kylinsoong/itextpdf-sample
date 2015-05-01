package com.itextpdf.ch1;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfWriter;

public class HelloWorldNarrow {
	
	public static final String RESULT = "results/part1/chapter01/hello_narrow.pdf";

	public static void main(String[] args) throws FileNotFoundException, DocumentException {
		
		Rectangle pagesize = new Rectangle(216f, 720f);
		Document document = new Document(pagesize, 36f, 72f, 108f, 180f);
		PdfWriter.getInstance(document, new FileOutputStream(RESULT));
		document.open();
		document.add(new Paragraph(
	            "Hello World! Hello People! " +
	            "Hello Sky! Hello Sun! Hello Moon! Hello Stars!"));
		document.close();

	}

}
