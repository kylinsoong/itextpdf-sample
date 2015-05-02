package com.itextpdf.ch4;

import java.io.FileOutputStream;
import java.io.IOException;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class MyFirstTable {
	
	public static final String RESULT = "results/part1/chapter04/first_table.pdf";
	
	public void createPdf(String filename) throws IOException, DocumentException {
	    	// step 1
		Document document = new Document();
	        // step 2
		PdfWriter.getInstance(document, new FileOutputStream(filename));
	        // step 3
		document.open();
	        // step 4
		document.add(createFirstTable());
	        // step 5
		document.close();
	    }

	private Element createFirstTable() {
		PdfPTable table = new PdfPTable(3);
		PdfPCell cell;
		cell = new PdfPCell(new Phrase("Cell with colspan 3"));
		cell.setColspan(3);
		table.addCell(cell);
		
		table.addCell("row 1; cell 1");
        table.addCell("row 1; cell 2");
        table.addCell("row 1; cell 3");
        table.addCell("row 2; cell 1");
        table.addCell("row 2; cell 2");
        table.addCell("row 2; cell 3");
		
		return table;
	}

	public static void main(String[] args) throws IOException, DocumentException {
		new MyFirstTable().createPdf(RESULT);
	}

}
