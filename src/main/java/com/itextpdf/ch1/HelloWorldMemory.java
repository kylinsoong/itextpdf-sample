package com.itextpdf.ch1;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

/**
 * Creates a PDF file in memory.
 * 
 * @author kylin
 *
 */
public class HelloWorldMemory {
	
	public static final String RESULT = "results/part1/chapter01/hello_memory.pdf";

	public static void main(String[] args) throws DocumentException, IOException {

		Document document = new Document();
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PdfWriter.getInstance(document, baos);
        
        document.open();
        
        document.add(new Paragraph("Hello World!"));
        
        document.close();
        
        FileOutputStream fos = new FileOutputStream(RESULT);
        fos.write(baos.toByteArray());
        fos.close();
	}

}
