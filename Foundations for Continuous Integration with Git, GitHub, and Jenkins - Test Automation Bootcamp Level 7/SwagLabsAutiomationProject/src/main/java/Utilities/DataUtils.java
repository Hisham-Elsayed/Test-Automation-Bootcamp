package Utilities;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class DataUtils {
    private static final String TEST_DATA_PATH = "src/test/resources/TestData/";
    //TODO: Reading data from JSON file

    /**
     *
     * @param fileName: name of file I want to read from
     * @param field: field of file I want to read
     * @return data retrieved from json as String
     */
    public static String getJsonData(String fileName, String field) throws FileNotFoundException {
        // -> src/test/resources/TestData/validLoginData.json
        FileReader reader = new FileReader(TEST_DATA_PATH+ fileName + ".json");

        // Parse json file
        JsonElement jsonElement = JsonParser.parseReader(reader);
        return jsonElement.getAsJsonObject().get(field).getAsString();
    }

    //TODO: Reading data from properties file
    /**
     *
     * @param fileName: name of file I want to read from
     * @param key: key I want to read
     * @return value retrieved from property as String
     */
    public static String getPropertyValue(String fileName, String key) throws IOException {
        Properties properties = new Properties();
        properties.load(new FileInputStream(TEST_DATA_PATH + fileName + ".properties"));
        return properties.getProperty(key);
    }





}
