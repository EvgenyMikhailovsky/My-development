package Mypackage;
import java.io.*;
import java.net.*;
import org.json.*;

public class VkApi {

    private static String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }


    public static void main(String[] args) throws IOException, JSONException {
        URL url = new URL("https://api.vk.com/method/users.get?user_id=556444498&first_name&last_name&access_token=6a6f00e00e32891b7922d7c1ccb908a78de2c0f6b2abfe7a66ac9b634338b5b8c02848d4a1fe8f309d553&v=5.124");
        URLConnection yc = url.openConnection();
        StringBuilder builder = new StringBuilder();
        BufferedReader in = new BufferedReader(
                new InputStreamReader(
                        yc.getInputStream()));
        String inputLine =  readAll(in);
        in.close();


        JSONObject json  = new JSONObject(inputLine);

        System.out.println(json.toString());
        String firstName = json.getJSONArray("response").getJSONObject(0).get("first_name").toString();
        String lastName =  json.getJSONArray("response").getJSONObject(0).get("last_name").toString();
        System.out.println("fio: " + firstName + " " + lastName);

    }

}
