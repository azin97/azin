package ir.aut.ceit.api;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import ir.aut.ceit.fileHandling.InputFileReader;
import org.json.JSONException;




/**
 * Created by azin on 4/11/2017.
 *
 * UrlClass is a class for getting data from the internet.
 */
public class UrlClass {
    /**
     *
     * @param link is a string containning the url we need data from
     *
     *            we get the data  using URL and HttpURLconnection.
     *
     * @return weatherresult is a string containing the data that was stored in link
     */
    public static String URLConnection(String link) {

        String weatherResult="";
        try {
            URL url = new URL(link);


            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();


            weatherResult = InputFileReader.InputFile(httpURLConnection);






            return weatherResult;

        } catch (MalformedURLException ex) {

        } catch (IOException ex) {

        } catch (JSONException ex) {
        }
        return weatherResult;
    }

}
