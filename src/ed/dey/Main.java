package ed.dey;

import javax.net.ssl.HttpsURLConnection;
import javax.swing.*;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) throws IOException {
        SwingUtilities.invokeLater(()->{
            try{
                new iMPKwindow("iMPK live vehicle tracker 1.0");
            }catch (Exception e){
                e.printStackTrace();
            }


        });

//        ApiConnection connection = new ApiConnection();
//        Parser.parseData(connection.getBusData(new LinkedList<>(Arrays.asList("20","248","251"))));

/*
        BufferedReader reader;
        String line;

        StringBuffer responseContent = new StringBuffer();
        try {
            URL myUrl = new URL("https://mpk.wroc.pl/bus_position");
            HttpsURLConnection con = (HttpsURLConnection) myUrl.openConnection();

            con.setRequestMethod("POST");
            con.setDoInput(true);
            con.setDoOutput(true);

            HashMap<String,String> params = new HashMap<>();
            params.put("busList[bus][]","1");


            OutputStream os = con.getOutputStream();
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));
            writer.write(URLEncoder.encode("busList[bus][]", StandardCharsets.UTF_8) + "=" + params.get("busList[bus][]"));

            writer.flush();
            writer.close();
            os.close();

            con.setConnectTimeout(5000);
            con.setReadTimeout(5000);

            int status = con.getResponseCode();
            //System.out.println(status);

            if(status > 299){
                reader = new BufferedReader(new InputStreamReader(con.getErrorStream()));
            }
            else{
                reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
            }
            while((line=reader.readLine()) != null)
                responseContent.append(line);
            reader.close();

            System.out.println(responseContent);

        }catch (MalformedURLException e){
            e.printStackTrace();
        }
*/
    }
}
