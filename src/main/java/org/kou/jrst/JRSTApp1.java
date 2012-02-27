package org.kou.jrst;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

import java.net.URL;

import org.dom4j.Document;
import org.nuiton.jrst.JRSTGenerator;
import org.nuiton.jrst.JRSTReader;
import org.nuiton.jrst.JRST;

public class JRSTApp1 extends JRST{

	private static final String xsl = "rst2xhtml.xsl" ;
	
	public static void main(String[] args)throws Exception{
				
		BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(args[0])));
		JRSTReader jrstreader = new JRSTReader();
		Document doc = jrstreader.read(reader);
		
		
		PrintWriter writer = new PrintWriter(new OutputStreamWriter(new FileOutputStream(args[1]) , "UTF-8"));
		JRSTGenerator generator = new JRSTGenerator(writer);
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		URL url = loader.getResource(xsl);
		generator.generate(doc, url);
		
		reader.close();
		writer.close();
		
	}
}
