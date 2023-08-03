package config;

import tests.TestBase;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

public class PropertiesFile {
   static Properties prop = new Properties();
    private static String url;
   public static void ReadPropertiesFile(){

        try {
            InputStream input = new FileInputStream(System.getProperty("user.dir")+ "\\src\\test\\java\\config\\config.properties");
            prop.load(input);
            url = prop.getProperty("Url");
            TestBase.url = prop.getProperty("Url");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void WritePropertiesFile(){
        try {
            OutputStream output = new FileOutputStream(System.getProperty("user.dir")+ "\\src\\test\\java\\config\\config.properties");
            prop.setProperty("Browser","Chrome");
            prop.store(output,null);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static String getUrl(){
        ReadPropertiesFile();
       return  url;
    }
}
