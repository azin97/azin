package ir.aut.ceit.weather;

import ir.aut.ceit.fileHandling.OutputFileWriter;
import org.json.JSONObject;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONArray;

/**
 * Created by azin on 4/15/2017.
 * Forecast weather class is for forecasting the weather of an area for at most 16 days or 5 days with every 3 hours update.
 *
 */
public class ForecastWeather {


    /**
     *
     * @param json is a string that's been created in another class by getting data from
     *             a url. it is used to make JSONObjects and JSONArrays, for getting information.
     *
     *   this method creates an output String  using  JSON objects an d JSON arrays,
     *             sends the output string to another class for being written in a file.
     *
     */
    public void Forecast(String json) {
        int i = 0;


        JSONObject jsonObject = new JSONObject(json);
        int count = jsonObject.getInt("cnt");

        //"coord"

        JSONObject jsonObjectCity = jsonObject.getJSONObject("city");
        String resultName = jsonObjectCity.getString("name");

        JSONObject jsonObjectCoord = jsonObjectCity.getJSONObject("coord");


        Double resultLon = jsonObjectCoord.getDouble("lon");

        Double resultLat = jsonObjectCoord.getDouble("lat");
        String output = "";
        while (i < count) {
            Double resultHumidity = 0.0;
            String resultDescription = "";
            Double resultSpeed = 0.0;
            Double resultDeg = 0.0;
            Double resultTemp = 0.0;
            JSONArray jsonArrayList = jsonObject.getJSONArray("list");

            if (jsonArrayList.length() > 0) {
                JSONObject jsonObjectList = jsonArrayList.getJSONObject(i);
                JSONArray jsonArrayWeather = jsonObjectList.getJSONArray("weather");
                if (jsonArrayWeather.length() > 0) {
                    JSONObject jsonObjectWeather = jsonArrayWeather.getJSONObject(0);
                    resultDescription = jsonObjectWeather.getString("description");
                }


                JSONObject jsonObjectMain = jsonObjectList.getJSONObject("main");
                resultHumidity = jsonObjectMain.getDouble("humidity");
                resultTemp = jsonObjectMain.getDouble("temp");

                JSONObject jsonObjectWind = jsonObjectList.getJSONObject("wind");
                resultSpeed = jsonObjectWind.getDouble("speed");
                resultDeg = jsonObjectWind.getDouble("deg");
            }

            for (int p = 0; p < 150; p++) {
                output += "=";

            }

            output += "\r\nCity            Humidity                Description             Wind-info               Coordination                  \ttemp\r\n"
                    + resultName + "            " + resultHumidity + "            " + resultDescription + "             speed: " + resultSpeed + "  degree:" + resultDeg +
                    "       lat:" + resultLat + "  lon:" + resultLon +"           "+resultTemp+ "\r\n";


            for (int p = 0; p < 150; p++) {
                output += "=";

            }


            i++;
        }
        System.out.println(output);
        OutputFileWriter write = new OutputFileWriter();
        write.fileWriter(output,false);

    }

}
