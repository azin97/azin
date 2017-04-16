package ir.aut.ceit.weather;

import ir.aut.ceit.fileHandling.*;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONArray;


/**
 * Created by azin on 4/11/2017.
 */
public class CurrentWeather {
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
