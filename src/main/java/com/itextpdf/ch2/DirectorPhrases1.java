package com.itextpdf.ch2;

import java.io.FileOutputStream;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.util.Util;

public class DirectorPhrases1 {
	
	public static final String RESULT = "results/part1/chapter02/director_phrases_1.pdf";
	
	public static final Font BOLD_UNDERLINED = new Font(FontFamily.TIMES_ROMAN, 12, Font.BOLD | Font.UNDERLINE);
	
	public static final Font NORMAL = new Font(FontFamily.TIMES_ROMAN, 12);
	
	public Phrase createDirectorPhrase(ResultSet rs)throws UnsupportedEncodingException, SQLException {
		Phrase director = new Phrase();
		director.add(new Chunk(rs.getString("FIRSTNAME"), BOLD_UNDERLINED));
		director.add(new Chunk(",", BOLD_UNDERLINED));
		director.add(new Chunk(" ", NORMAL));
		director.add(new Chunk(rs.getString("LASTNAME"), NORMAL));
		return director;
	}
	
	public void createPdf(String filename) throws Exception {
		Document document = new Document();
		PdfWriter.getInstance(document, new FileOutputStream(filename));
		document.open();
		
		Connection conn = Util.getConnection("org.h2.Driver", "jdbc:h2:mem://localhost/~/test", "sa", "sa");
		Util.initTestData(conn);
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT FIRSTNAME, LASTNAME FROM CUSTOMER");
		while (rs.next()){
			document.add(createDirectorPhrase(rs));
			document.add(Chunk.NEWLINE);
		}
		
		rs.close();
		stmt.close();
		conn.close();
		
		document.close();
	}

	public static void main(String[] args) throws Exception {
		new DirectorPhrases1().createPdf(RESULT);
	}

}
