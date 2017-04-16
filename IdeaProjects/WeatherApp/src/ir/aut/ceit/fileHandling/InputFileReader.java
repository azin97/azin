package ir.aut.ceit.fileHandling;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

/**
 * Created by azin on 4/15/2017.
 */
public class InputFileReader {
    /**
     *
     * @param k is the link of the internet site we need data from.
     *
     * @return A string containing the data stored in the link(k).
     */
    public static String InputFile(HttpURLConnection k){
        String result="";
        try{

            InputStreamReader inputStreamReader = new InputStreamReader(k.getInputStream());

            BufferedReader bufferedReader = new BufferedReader(inputStreamReader, 8192);

            String line = null;

            while ((line = bufferedReader.readLine()) != null) {

                result += line;

            }
            bufferedReader.close();

        }catch (IOException e){}


        return result;
    }
}
