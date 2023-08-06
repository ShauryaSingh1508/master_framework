package com.northladder.commonutils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

/**
 * This class is to write the value in gmailtoken.properties
 */
public class ConfigWriter {

    static File file = new File(System.getProperty("user.dir") + "/src/test/resources/gmailtoken.properties");

    /**
     * This method writes value of the access token and the time of the token generation into the gmailtoken.properties file.
     * @param p
     * @throws IOException
     */
    static void saveProperties(Properties p) throws IOException {
        try (OutputStream outputStream = new FileOutputStream(file)) {
            p.store(outputStream, "Properties");
            outputStream.close();
            System.out.println("After saving properties: " + p);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
