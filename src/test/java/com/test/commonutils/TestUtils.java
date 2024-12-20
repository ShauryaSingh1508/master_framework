package com.test.commonutils;



import com.test.mobile.base.MobileBasePage;
import com.test.web.base.WebBasePage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.ThreadContext;

import org.openqa.selenium.remote.RemoteWebDriver;
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

public class TestUtils extends WebBasePage {

	public static final long WAIT = 10;
	public static  Logger logger = null;

	public TestUtils(RemoteWebDriver driver) {
        super(driver);

	}

	public static HashMap<String, String> parseStringXML(InputStream file) throws Exception{
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
	
	public static String dateTime() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
		Date date = new Date();
		return dateFormat.format(date);
	}
	
	public static String getLogFilePath(String loggingType){
		String strFile=null;
		String msg = null;
		String logFilePath =null;
		if(loggingType.equalsIgnoreCase("mobile")) {
			MobileBasePage base = new MobileBasePage();
			/*msg = Thread.currentThread().getId() + ":" + base.getPlatform() + ":" + base.getDeviceName() + ":"
					+ Thread.currentThread().getStackTrace()[2].getClassName() + ":" + txt;*/

			//System.out.println(msg);

			strFile = "logs" + File.separator + base.getPlatform() + "_" + driver
					+ File.separator + base.getDateTime();
		}else if(loggingType.equalsIgnoreCase("web")){
			/*msg = Thread.currentThread().getId() + ":" + baseTest.getDriver() + ":"
					+ Thread.currentThread().getStackTrace()[2].getClassName() + ":" + txt;*/

			//System.out.println(msg);

			/*strFile = "logs" + File.separator + driver
					+ File.separator + dateTime();*/
			strFile = File.separator + driver.toString();

		}else{
			strFile = File.separator + "restAssured";
		}

        File logFile = new File(strFile);

		if (!logFile.exists()) {
			logFile.mkdirs();
		}

		// return log file path
		logFilePath = strFile;
		return logFilePath;

		
/*		FileWriter fileWriter;
		try {
			fileWriter = new FileWriter(logFile + File.separator + "log.log",true);
			PrintWriter printWriter = new PrintWriter(fileWriter);
			printWriter.println(msg);
			printWriter.close();
		} catch (IOException e) {
			throw new CustomCheckedException("Unable to write the logs in the log file. " + logFile,e.getCause());
		}*/

	}

	public static Logger log(String loggingType) {

		try {
			logger = LogManager.getLogger(Thread.currentThread().getStackTrace()[2].getClassName());


			// Update Log4j configuration dynamically
			/*LoggerContext context = (LoggerContext) LogManager.getContext(false);
			context.getConfiguration().getProperties().put("LOG_PATH", getLogFilePath(loggingType,driver));
			context.updateLoggers(); // Apply new configuration*/
			ThreadContext.put("DYNAMIC_LOG", getLogFilePath(loggingType));


		}
	catch (Exception e) {
		logger.error("Failed to configure logger: " + e.getMessage());
	}
		return logger;
	}
	
}
