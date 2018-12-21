import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

/**
 * TODO
 *
 * @author Nick West
 */
public class Jettison {


    public static String jsonData = "{\n" +
            "  \"id\": 123,\n" +
            "  \"name\": \"Pankaj\",\n" +
            "  \"permanent\": true,\n" +
            "  \"address\": {\n" +
            "    \"street\": \"Albany Dr\",\n" +
            "    \"city\": \"San Jose\",\n" +
            "    \"zipcode\": 95129\n" +
            "  }";



    public static void main(String[]args) {

        try {
            JSONObject jsonTest = new JSONObject(jsonData);
        } catch (JSONException e) {
            e.printStackTrace();
        }


    }

}