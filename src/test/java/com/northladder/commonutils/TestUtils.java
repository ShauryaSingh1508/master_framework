package com.northladder.commonutils;



import com.northladder.mobile.base.MobileBasePage;
import com.northladder.web.base.BaseTest;
import com.northladder.web.base.WebBasePage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class TestUtils {

	public static final long WAIT = 10;
	public HashMap<String, String> parseStringXML(InputStream file) throws Exception{
		HashMap<String, String> stringMap = new HashMap<String, String>();
		//Get Document Builder
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		 
		//Build Document
		Document document = builder.parse(file);
		 
		//Normalize the XML Structure; It's just too important !!
		document.getDocumentElement().normalize();
		 
		//Here comes the root node
		Element root = document.getDocumentElement();
		 
		//Get all elements
		NodeList nList = document.getElementsByTagName("string");
		 
		for (int temp = 0; temp < nList.getLength(); temp++)
		{
		 Node node = nList.item(temp);
		 if (node.getNodeType() == Node.ELEMENT_NODE)
		 {
		    Element eElement = (Element) node;
		    // Store each element key value in map
		    stringMap.put(eElement.getAttribute("name"), eElement.getTextContent());
		 }
		}
		return stringMap;
	}
	
	public String dateTime() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
		Date date = new Date();
		return dateFormat.format(date);
	}
	
	public void log(String txt,String loggingType) {
		String strFile=null;
		String msg = null;
		if(loggingType.equalsIgnoreCase("mobile")) {
			MobileBasePage base = new MobileBasePage();
			msg = Thread.currentThread().getId() + ":" + base.getPlatform() + ":" + base.getDeviceName() + ":"
					+ Thread.currentThread().getStackTrace()[2].getClassName() + ":" + txt;

			System.out.println(msg);

			strFile = "logs" + File.separator + base.getPlatform() + "_" + base.getDeviceName()
					+ File.separator + base.getDateTime();
		}else{
			BaseTest baseTest = new BaseTest();
/*			String msg = Thread.currentThread().getId() + ":" + baseTest.getDriver() + ":" + base.getDeviceName() + ":"
					+ Thread.currentThread().getStackTrace()[2].getClassName() + ":" + txt;

			System.out.println(msg);

			strFile = "logs" + File.separator + base.getPlatform() + "_" + base.getDeviceName()
					+ File.separator + base.getDateTime();*/

		}

		assert strFile != null;
		File logFile = new File(strFile);

		if (!logFile.exists()) {
			logFile.mkdirs();
		}
		
		FileWriter fileWriter = null;
		try {
			fileWriter = new FileWriter(logFile + File.separator + "log.txt",true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assert fileWriter != null;
		PrintWriter printWriter = new PrintWriter(fileWriter);
	    printWriter.println(msg);
	    printWriter.close();
	}

	public Logger log() {
		return LogManager.getLogger(Thread.currentThread().getStackTrace()[2].getClassName());
	}
	
}
