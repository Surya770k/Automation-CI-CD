package UiBaseComponents;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;



	



public class PropertyFileHandler {

    private static final String CONFIG_FILE_PATH = System.getProperty("user.dir")+"/src/test/resources/PropertyFiles/Properties.properties";;

    public static void readProperties(Properties properties) {
        try (FileInputStream input = new FileInputStream(CONFIG_FILE_PATH)) {
            properties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}



