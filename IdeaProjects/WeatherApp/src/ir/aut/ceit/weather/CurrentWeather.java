package ir.aut.ceit.weather;

import ir.aut.ceit.fileHandling.*;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONArray;


/**
 * Created by azin on 4/11/2017.
 *
 */
public class CurrentWeather {
    /**
     * Current meethod is for getting daily update on a city.
     * @param json is a string that's been created in another class by getting data from
     *             a url. it is used to make JSONObjects and JSONArrays, for getting information.
     *
     *   this method creates an output String  using  JSON objects an d JSON arrays,
     *             sends the output string to another class for being written in a file.
     * @throws JSONException
     */
    static void Current(String json) throws JSONException {


        JSONObject jsonObject = new JSONObject(json);


        //"coord"

        JSONObject jsonObjectCoord = jsonObject.getJSONObject("coord");

        Double resultLon = jsonObjectCoord.getDouble("lon");

        Double resultLat = jsonObjectCoord.getDouble("lat");


        //"weather"


        JSONArray jsonArrayWeather = jsonObject.getJSONArray("weather");
        String resultDescription = "";
        if (jsonArrayWeather.length() > 0) {

            JSONObject jsonObjectWeather = jsonArrayWeather.getJSONObject(0);

            resultDescription = jsonObjectWeather.getString("description");



        } else {}

        //"main"

        JSONObject jsonObjectMain = jsonObject.getJSONObject("main");

        Double resultTemp = jsonObjectMain.getDouble("temp");




        Double resultHumidity = jsonObjectMain.getDouble("humidity");


        Double resultTempMin = jsonObjectMain.getDouble("temp_min");


        //"wind"

        JSONObject jsonObjectWind = jsonObject.getJSONObject("wind");

        Double resultSpeed = jsonObjectWind.getDouble("speed");




        Double resultDeg = jsonObjectWind.getDouble("deg");





        //"name"

        String resultName = jsonObject.getString("name");


        String output = "";
        for (int i = 0; i < 150; i++) {
            output += "=";

        }

        output += "\r\nCity            Humidity                Description             Wind-info                 Coordination              \ttemp\r\n"
                + resultName + "            " + resultHumidity + "            " + resultDescription + "             speed: " + resultSpeed + "  degree:" + resultDeg +
                "      lat:" + resultLat + "  lon:" + resultLon + "        " + resultTemp + "\r\n";


        for (int i = 0; i < 150; i++) {
            output += "=";

        }
        System.out.println(output);
        OutputFileWriter write = new OutputFileWriter();
        write.fileWriter(output,true);


    }


}
