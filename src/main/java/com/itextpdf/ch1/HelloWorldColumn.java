package com.itextpdf.ch1;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfWriter;

public class HelloWorldColumn {
	
	public static final String RESULT = "results/part1/chapter01/hello_column.pdf";

	public static void main(String[] args) throws FileNotFoundException, DocumentException {

		Document document = new Document();
		
		PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(RESULT));
		
		document.open();
		
		writer.setCompressionLevel(0);
		Phrase hello = new Phrase("Hello World");
        PdfContentByte canvas = writer.getDirectContentUnder();
        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, hello, 36, 788, 0);
        
        document.close();
	}

}
