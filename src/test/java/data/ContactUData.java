package data;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ContactUData {
    private final WebDriver driver;
    public ContactUData(WebDriver driver){
        this.driver = driver;
    }

    public String name , email,subject,path,message;

    public void ContactUsData() throws IOException, ParseException {
        String srcFile = System.getProperty("user.dir")+"/src/test/java/data/contactUsData.json";
        File file = new File(srcFile);

        JSONParser parser = new JSONParser();
        JSONArray JArray = (JSONArray) parser.parse(new FileReader(file));

        for (Object object : JArray){
            JSONObject jsonObject = (JSONObject) object;

            name = (String) jsonObject.get("name");
            email = (String) jsonObject.get("email");
            subject = (String) jsonObject.get("subject");
            path = (String) jsonObject.get("filePath");
            message = (String) jsonObject.get("message");
        }
    }
}
