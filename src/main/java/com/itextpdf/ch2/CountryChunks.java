package com.itextpdf.ch2;

import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.util.Util;

public class CountryChunks {
	
	public static final String RESULT = "results/part1/chapter02/country_chunks.pdf";

	public static void main(String[] args) throws Exception {

		Document document = new Document();
		
		PdfWriter.getInstance(document, new FileOutputStream(RESULT)).setInitialLeading(16);
		
		document.open();
		
		Connection conn = Util.getConnection("org.h2.Driver", "jdbc:h2:mem://localhost/~/test", "sa", "sa");
		Util.initTestData(conn);
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT FIRSTNAME, SSN FROM CUSTOMER");
		
		Font font = new Font(FontFamily.HELVETICA, 6, Font.BOLD, BaseColor.WHITE);
		while (rs.next()){
			document.add(new Chunk(rs.getString("FIRSTNAME")));
			document.add(new Chunk(" "));
			Chunk ssn = new Chunk(rs.getString("SSN"), font);
			ssn.setBackground(BaseColor.BLACK, 1f, 0.5f, 1f, 1.5f);
			ssn.setTextRise(6);
			document.add(ssn);
            document.add(Chunk.NEWLINE);
		}
		
		rs.close();
		stmt.close();
		conn.close();
		
		document.close();
	}

}
