package com.itextpdf.ch1;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class HelloWorldMirroredMarginsTop {
	
	public static final String RESULT = "results/part1/chapter01/hello_mirrored_top.pdf";

	public static void main(String[] args) throws FileNotFoundException, DocumentException {
		

		Document document = new Document();
		
		PdfWriter.getInstance(document, new FileOutputStream(RESULT));
		
		document.setPageSize(PageSize.A5);
        document.setMargins(36, 72, 108, 180);
        document.setMarginMirroringTopBottom(true);
        
        document.open();
        
        document.add(new Paragraph(
                "The left margin of this odd page is 36pt (0.5 inch); " +
                "the right margin 72pt (1 inch); " +
                "the top margin 108pt (1.5 inch); " +
                "the bottom margin 180pt (2.5 inch)."));
        
        Paragraph paragraph = new Paragraph();
        paragraph.setAlignment(Element.ALIGN_JUSTIFIED);
        for (int i = 0; i < 20; i++) {
            paragraph.add("Hello World! Hello People! " +
                "Hello Sky! Hello Sun! Hello Moon! Hello Stars!");
        }
        document.add(paragraph);
        document.add(new Paragraph("The top margin 180pt (2.5 inch)."));
        
        document.close();

	}

}
