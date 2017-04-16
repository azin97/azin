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
    public static String URLConnection(String link) {
        /**
         * URLConnection
         */
        String weatherResult="";
        try {
            URL url = new URL(link);


            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();


            String result = InputFileReader.InputFile(httpURLConnection);





            //System.out.println(weatherResult);
            return result;

        } catch (MalformedURLException ex) {
            // Logger.getLogger(BaseWeather.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("p");

        } catch (IOException ex) {

            //Logger.getLogger(BaseWeather.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("p2");
        } catch (JSONException ex) {
            System.out.println("p3");
            // Logger.getLogger(BaseWeather.class.getName()).log(Level.SEVERE, null, ex);

        }
        return weatherResult;
    }
    public static String URLConnection(int cityId) {
        String weatherResult="";
        try {
            URL url = new URL("http://api.openweathermap.org/data/2.5/weather?id="+cityId+"&appid=b9eb6b2c99686fb92a55f2775350c297");


            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();


            String result = InputFileReader.InputFile(httpURLConnection);





            System.out.println(weatherResult);
            return result;

        } catch (MalformedURLException ex) {
            // Logger.getLogger(BaseWeather.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("p");

        } catch (IOException ex) {

            // Logger.getLogger(BaseWeather.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("p2");
        } catch (JSONException ex) {
            System.out.println("p3");
            // Logger.getLogger(BaseWeather.class.getName()).log(Level.SEVERE, null, ex);

        }
        return weatherResult;
    }
}
