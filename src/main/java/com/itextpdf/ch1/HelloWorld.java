package com.itextpdf.ch1;

import java.io.FileOutputStream;
import java.io.IOException;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class HelloWorld {
	
	public static final String RESULT = "results/part1/chapter01/hello.pdf";

	public static void main(String[] args) throws DocumentException, IOException {
		
		Document document = new Document();
		PdfWriter.getInstance(document, new FileOutputStream(RESULT));
		document.open();
		document.add(new Paragraph("Hello World!"));
		document.close();
	}


}
