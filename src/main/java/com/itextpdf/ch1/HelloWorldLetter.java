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
 * Hello World example using the paper size Letter.
 * 
 * @author kylin
 *
 */
public class HelloWorldLetter {
	
	public static final String RESULT = "results/part1/chapter01/hello_letter.pdf";

	public static void main(String[] args) throws FileNotFoundException, DocumentException {

		Document document = new Document(PageSize.LETTER);
		PdfWriter.getInstance(document, new FileOutputStream(RESULT));
		document.open();
		document.add(new Paragraph("Hello World"));
		document.close();
	}

}
