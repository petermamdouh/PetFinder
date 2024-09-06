package data;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class JsonDataReader {
    public String email, fristname , lastname ;

    public void getDataFile() throws IOException, ParseException {
        String filePath = System.getProperty("user.dir")+"/src/test/java/data/UserData.json";
        File srcfile = new File(filePath);

        JSONParser parser = new JSONParser();
        JSONArray Jsonarr = (JSONArray)parser.parse(new FileReader(srcfile));

        for(Object jsonobj : Jsonarr){

            JSONObject data = (JSONObject) jsonobj;

            email = (String) data.get("Email");
            System.out.println(email);

            fristname = (String) data.get("FirstName");
            System.out.println(fristname);

            lastname = (String) data.get("LasTName");
            System.out.println(lastname);
        }
    }
}
