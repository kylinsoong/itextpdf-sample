package com.itextpdf.ch5;

import java.io.FileOutputStream;
import java.sql.Connection;
import java.util.Date;
import java.util.List;

import com.itextpdf.text.Document;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfPTableEvent;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.util.Util;

public class AlternatingBackground implements PdfPTableEvent {
	
	public static final String RESULT = "results/part1/chapter05/alternating.pdf";

	public void createPdf(String filename) throws Exception {
        // Create a database connection 
		Connection conn = Util.getConnection("org.h2.Driver", "jdbc:h2:mem://localhost/~/test", "sa", "sa");
        // step 1
        Document document = new Document(PageSize.A4.rotate());
        // step 2
        PdfWriter.getInstance(document, new FileOutputStream(filename));
        // step 3
        document.open();
        // step 4
//        List<Date> days = PojoFactory.getDays(connection);
//        PdfPTableEvent event = new AlternatingBackground();
//        for (Date day : days) {
//            PdfPTable table = getTable(connection, day);
//            table.setTableEvent(event);
//            document.add(table);
//            document.newPage();
//        }
        // step 5
        document.close();
        // Close the database connection
        conn.close();
    }
	
	
	public void tableLayout(PdfPTable table, float[][] widths, float[] heights, int headerRows, int rowStart, PdfContentByte[] canvases) {
		// TODO Auto-generated method stub

	}
	
	public static void main(String[] args) throws Exception {
		
	}

}
