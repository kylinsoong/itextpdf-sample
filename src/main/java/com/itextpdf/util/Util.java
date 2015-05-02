package com.itextpdf.util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.h2.tools.RunScript;

public class Util {
	
	public static Connection getConnection(String driver, String url, String user, String pass) throws Exception {
        Class<?> c = Class.forName(driver);
        Driver d = (Driver) c.newInstance();
        DriverManager.registerDriver(d);
        return DriverManager.getConnection(url, user, pass);
	}
	
	public static void initTestData(Connection conn) throws FileNotFoundException, SQLException {
        RunScript.execute(conn, new FileReader("customer-schema-h2.sql"));
	}


}
