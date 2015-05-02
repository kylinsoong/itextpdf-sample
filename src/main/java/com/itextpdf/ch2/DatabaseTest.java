package com.itextpdf.ch2;

import java.io.FileOutputStream;
import java.io.PrintStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.itextpdf.util.Util;

public class DatabaseTest {
	
	public static final String RESULT = "results/part1/chapter02/countries.txt";

	public static void main(String[] args) throws Exception {
		
		PrintStream out = new PrintStream(new FileOutputStream(RESULT));
		
		Connection conn = Util.getConnection("org.h2.Driver", "jdbc:h2:mem://localhost/~/test", "sa", "sa");
		
		Util.initTestData(conn);
		
		Statement stmt = conn.createStatement();
		
		ResultSet rs = stmt.executeQuery("SELECT CITY FROM CUSTOMER");
		
		while (rs.next()){
			out.println(rs.getString(1));
		}
		
		rs.close();
		
		stmt.close();
		
		conn.close();
		
		out.flush();
        out.close();
	}

}
