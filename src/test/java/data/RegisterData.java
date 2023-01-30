package data;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class RegisterData {
    private final WebDriver driver;
    public RegisterData(WebDriver driver){
        this.driver = driver;
    }

    public String name,email,password,month,firstName,
                 lastName,company,city,state,
                 country,address1,address2,
                 day,year,zipcode,mobNumber;


    public void UserData() throws IOException, ParseException {
        String srcFile = System.getProperty("user.dir")+"/src/test/java/data/registerData.json";
        File file = new File(srcFile);

        JSONParser parser = new JSONParser();
        JSONArray jArray = (JSONArray) parser.parse(new FileReader(file));


        for (Object object : jArray){
            JSONObject jsonObject = (JSONObject) object;

            name = (String) jsonObject.get("name");
            email = (String) jsonObject.get("email");
            password = (String) jsonObject.get("password");
            day = (String) jsonObject.get(("day"));
            month = (String) jsonObject.get("month");
            year = (String) jsonObject.get("year");
            firstName = (String) jsonObject.get("firstName");
            lastName = (String) jsonObject.get("lastName");
            company = (String) jsonObject.get("company");
            address1 = (String) jsonObject.get("address1");
            address2 = (String) jsonObject.get("address2");
            country = (String) jsonObject.get("country");
            state = (String) jsonObject.get("state");
            city = (String) jsonObject.get("city");
            zipcode = (String) jsonObject.get("zip");
            mobNumber = (String) jsonObject.get("mobNumber");

        }


    }
}
