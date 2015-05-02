package com.itextpdf.ch1;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class HelloZip {
	
	public static final String RESULT = "results/part1/chapter01/hello.zip";

	public static void main(String[] args) throws IOException, DocumentException {

		ZipOutputStream zip = new ZipOutputStream(new FileOutputStream(RESULT));
		for (int i = 1; i <= 3; i++) {
			ZipEntry entry = new ZipEntry("hello_" + i + ".pdf");
			zip.putNextEntry(entry);
			
			Document document = new Document();
			
			PdfWriter writer = PdfWriter.getInstance(document, zip);
            writer.setCloseStream(false);
            
            document.open();
            
            document.add(new Paragraph("Hello " + i));
            
            document.close();
            
            zip.closeEntry();
		}
		zip.close();
	}

}
