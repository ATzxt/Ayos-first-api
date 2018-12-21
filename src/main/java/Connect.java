import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.client.utils.URIBuilder;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
 * TODO
 *
 * @author Nick West
 */

public class Connect {
    private static final String URL = "https://www.planyo.com/rest/?";

    public static void main(String[] args) {
        try {
            Connect.parsedData(planyoVerify2("138202","18160eba068b230ec4d5e41c46aca691ec297e59442faedab16639b9b8bb77" ));
            Connect.getRequest2();
//            Connect.planyoVerify2("138202","ae7588e196e5ba40d82b58cb8e2054c1adb8d6d965c8661cbc2d347c4fca94");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void getRequest() throws Exception {
        String url = "https://www.planyo.com/rest/?method=api_test";
        URL aUrl = new URL(url);
        HttpsURLConnection connection = (HttpsURLConnection) aUrl.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("User-Agent", "Mozilla/5.0");
        int responseCode = connection.getResponseCode();
        System.out.println("The response it is " + responseCode);
        BufferedReader in = new BufferedReader(
                new InputStreamReader(connection.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
//        System.out.println(response);
    }


    public static String getRequest2() throws Exception {
        String url = "https://www.planyo.com/rest/?resource_id=138202&api_key=ae7588e196e5ba40d82b58cb8e2054c1adb8d6d965c8661cbc2d347c4fca94&method=get_resource_info";
        URL aUrl = new URL(url);
        HttpsURLConnection connection = (HttpsURLConnection) aUrl.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("User-Agent", "Mozilla/5.0");
        int responseCode = connection.getResponseCode();
        System.out.println("The response it is " + responseCode);
        BufferedReader in = new BufferedReader(
                new InputStreamReader(connection.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        String output = response.toString();

//        System.out.println(output);

        return output;
    }

    public static String parsedData(String jsonData) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, String> myMap = new HashMap<String, String>();


        //convert json string to object
        try {
            myMap  = objectMapper.readValue(jsonData, HashMap.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
System.out.println("THIS IS THE MAP" +myMap.keySet().toString());
        System.out.println(myMap.values());
return myMap.keySet().toString();
    }


    public static String planyoVerify(String aResourceId, String anApiKey) throws Exception {
           String resourceId = "resource_id="+aResourceId ; //passed in as part of request
           String apiKey = anApiKey ; //stored somewhere else will be hardcoded for testing
           String methodName = "get_resource_info";
           StringBuilder fullUrlReqest = new StringBuilder();
        fullUrlReqest.append(URL);
        fullUrlReqest.append("resource_id="+ resourceId);
        fullUrlReqest.append("&");
        fullUrlReqest.append("api_key="+ apiKey);
        fullUrlReqest.append("&");
        fullUrlReqest.append("method="+ methodName);


           String url = fullUrlReqest.toString();
           URL aUrl = new URL(url);
           HttpsURLConnection connection = (HttpsURLConnection) aUrl.openConnection();
           connection.setRequestMethod("GET");
           connection.setRequestProperty("User-Agent", "Mozilla/5.0");
           int responseCode = connection.getResponseCode();
//           System.out.println("The response it is " + responseCode);
           BufferedReader in = new BufferedReader(
                   new InputStreamReader(connection.getInputStream()));
           String inputLine;
           StringBuffer response = new StringBuffer();
           while ((inputLine = in.readLine()) != null) {
               response.append(inputLine);
           }
           in.close();
           String output = response.toString();

//           System.out.println(output);

           return output;
    }

    public static String planyoVerify2(String aResourceId, String anApiKey) throws Exception {
        String resourceIdParam = "resource_id"; //passed in as part of request
        String apiKey = "api_key"; //stored somewhere else will be hardcoded for testing
        String methodName = "get_resource_info";
        URIBuilder ub = null;
        try {
            ub = new URIBuilder(URL);
            ub.addParameter(resourceIdParam, aResourceId);
            ub.addParameter(apiKey, anApiKey);
            ub.addParameter("method", methodName);

        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        System.out.println(ub.toString());
        URL aUrl = new URL(ub.toString());
        HttpsURLConnection connection = (HttpsURLConnection) aUrl.openConnection();
        connection.setRequestMethod("GET");
        int responseCode = connection.getResponseCode();
        BufferedReader in = new BufferedReader(
                new InputStreamReader(connection.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        String output = response.toString();

        return output;
    }

}