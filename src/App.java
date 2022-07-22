import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.Gson;

public class App {
    public static void main(String[] args) throws Exception {
        String targetURL = "https://api.bls.gov/publicAPI/v2/timeseries/data/";
        // String urlParameters = "{\"seriesid\":[\"LAUCN040010000000005\",
        // \"LAUCN040010000000006\"]}";
        String urlParameters = "{\"seriesid\":[\"LAUCN040010000000005\"]}";
        Gson gson = new Gson();
        BLS bls = gson.fromJson(executePost(targetURL, urlParameters), BLS.class);
        int x = 1;
    }

    private static String executePost(String targetURL, String urlParameters) {
        HttpURLConnection connection = null;

        try {
            URL url = new URL(targetURL);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Content-Type",
                    "application/json");
            connection.setRequestProperty("Content-Length",
                    Integer.toString(urlParameters.getBytes().length));
            connection.setRequestProperty("Content-Language", "en-US");

            connection.setUseCaches(false);
            connection.setDoOutput(true);

            // Send request
            DataOutputStream wr = new DataOutputStream(
                    connection.getOutputStream());
            wr.writeBytes(urlParameters);
            wr.close();

            // Get Response
            InputStream is = connection.getInputStream();
            BufferedReader rd = new BufferedReader(new InputStreamReader(is));
            StringBuilder response = new StringBuilder(); // or StringBuffer if Java version 5+
            String line;
            while ((line = rd.readLine()) != null) {
                response.append(line);
                response.append('\r');
            }
            rd.close();
            return response.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
    }
}