package ed.dey;

import javax.net.ssl.HttpsURLConnection;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.LinkedList;

public class ApiConnection {

    public ApiConnection(){
    }

    private static HttpsURLConnection con;

    public String getBusData(LinkedList<String> busLines) throws IOException {
        /*
        * This piece of code is basically responsible for asking
        * and receiving requests from the server regarding the
        * passed-in bus/tram lines. The response is being cast from
        * JSON byte format into a String which is then further
        * passed into a parser who creates the appropriate object.
        * */

        BufferedReader reader;                                                  //A reader necessary to receive the connection's output stream.
        String uri = "https://mpk.wroc.pl/bus_position";
        StringBuilder requestParams = new StringBuilder();
        StringBuilder responseContent = new StringBuilder();
        String responseLog = "";

        for(String l : busLines){
            requestParams.append("busList[bus][]=").append(l).append("&");
        }

        byte[] postBody = requestParams.toString().getBytes(StandardCharsets.UTF_8);

        try {
//=======================================================
            /*
            * Down here the connection with the server is established
            * via the uri provided earlier and then opened right away.
            *
            * According to the API provided within the site's dev tools, the bus
            * position data is received via the POST request.
            *
            * For cohesiveness' sake I decided to add connect and read timeout
            * values.
            * */
//=======================================================
            URL myUrl = new URL(uri);
            con = (HttpsURLConnection) myUrl.openConnection();

            con.setRequestMethod("POST");
            con.setDoInput(true);
            con.setDoOutput(true);
            con.setConnectTimeout(5000);
            con.setReadTimeout(5000);
//=======================================================

            OutputStream os = con.getOutputStream();
            os.write(postBody);


            int status = con.getResponseCode();
            System.out.println("Connection status: " + status + "\n");

            if(status > 200){                                                               //According to the connection status, log the correct response.
                reader = new BufferedReader(new InputStreamReader(con.getErrorStream()));
            }
            else{
                reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
            }


            String line;
            while((line=reader.readLine()) != null)
                responseContent.append(line);

            responseLog = responseContent.toString();
            responseLog = responseLog.replace("},{", "},\n{");              //adding newlines after each new object, for ease of logging.

            System.out.println("Got response:\n" + responseLog);

            reader.close();
        }catch (MalformedURLException e){
            e.printStackTrace();
        }finally{
            con.disconnect();
            return responseContent.toString();
        }
    }

}
