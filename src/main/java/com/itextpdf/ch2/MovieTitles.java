package com.itextpdf.ch2;

import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.util.Util;

public class MovieTitles {
	
	public static final String RESULT = "results/part1/chapter02/movie_titles.pdf";

	public static void main(String[] args) throws Exception {

		Document document = new Document();
		
		PdfWriter.getInstance(document, new FileOutputStream(RESULT)).setInitialLeading(16);
		
		document.open();
		
		Connection conn = Util.getConnection("org.h2.Driver", "jdbc:h2:mem://localhost/~/test", "sa", "sa");
		Util.initTestData(conn);
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT FIRSTNAME FROM CUSTOMER");
		
		while(rs.next()){
			document.add(new Paragraph(rs.getString(1)));
		}
		
		document.close();
		
		conn.close();
	}

}
