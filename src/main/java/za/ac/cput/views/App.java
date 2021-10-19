package za.ac.cput.views;

import com.google.gson.Gson;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import za.ac.cput.entity.User;

import java.io.IOException;

/**
 * Console App - to test data from database
 * Group02 - ADP3 - Library Loan Application
 */
public class App 
{
    // OkHttpClient
    private static OkHttpClient client = new OkHttpClient();

    private static String run(String URL) throws IOException {
        Request request = new Request.Builder()
                .url(URL)
                .build();
        try (Response response = client.newCall(request).execute()){
            return response.body().string();
        }
    }

    // void getAll
    // user/getAll
    public static void getAll(){
        try{
          final String URL = "http://localhost:8080/user/getAll";
          String responseBody = run(URL);
            JSONArray users = new JSONArray(responseBody);
            for (int i = 0; i < users.length(); i++) {
                JSONObject user = users.getJSONObject(i);
                //String id = user.getString("id");
                //String name = user.getString("name");
                //System.out.println(name);
                Gson g = new Gson();
                User u = g.fromJson(user.toString(), User.class);
                System.out.println(u.toString());
            }
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public static void main( String[] args )
    {
        System.out.println( "Library Loan Application Console Tests" );
        getAll();
    }
}
