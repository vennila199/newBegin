package Utils;

import java.util.Properties;

public class Configloader {
     private static Configloader configloader;
     private Properties properties;

     private Configloader()
     {
        properties= PropertyUtils.getPropload();
     }

     public  static Configloader getConfigloader()
     {
         if(configloader==null)
         {
             return new Configloader();
         }
         return null;
     }

     public String getURL()
     {
        return properties.getProperty("url");
     }

}
