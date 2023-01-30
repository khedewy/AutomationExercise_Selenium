package data;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class CheckOutData {
    private final WebDriver driver;
    public CheckOutData(WebDriver driver){
        this.driver = driver;
    }

    public String name, cardNumber, cvc, month, year;
    public void checkOutData() throws IOException, ParseException {
       String srcFile = System.getProperty("user.dir")+"/src/test/java/data/checkoutData.json";
       File file = new File(srcFile);

        JSONParser parser = new JSONParser();
        JSONArray JArray = (JSONArray) parser.parse(new FileReader(file));

        for (Object object : JArray){
            JSONObject jsonObject = (JSONObject) object;

            name = (String) jsonObject.get("name");
            cardNumber = (String) jsonObject.get("cardNumber");
            cvc = (String) jsonObject.get("cvcNumber");
            month = (String) jsonObject.get("month");
            year = (String) jsonObject.get("year");
        }
    }

}
