package ir.aut.ceit.weather;

import ir.aut.ceit.api.UrlClass;
import ir.aut.ceit.view.MenuView;

import java.util.*;

/**
 * Created by azin on 4/15/2017.
 */
public class GetInfo {
    /**
     *  * getinfo is a class for getting the user's request, processing it, and then leading the program to
     * other classes based on user's request.
     *
     * @return boolean keepgoing
     * keep going shows whether the user wants to continue or wants to exit the program.
     *  this class has 6 booleans, used for determining the kind of update each user wants, processing
     *  each in a switch case loop, then creating a link based on the booleans, and finally sending them to the classes
     *  the user requested.
     */
    public boolean GetInformation() {
        Scanner in = new Scanner(System.in);
        MenuView.MenuViewer();


        boolean forecast = false, Daily = false, current = false, Id = false, name = false, loc = false;

        for (int i = 0; i < 2; i++) {
            int p = in.nextInt();
            System.out.println(p);
            switch (p) {
                case 1:
                    current = true;
                    break;
                case 2:
                    forecast = true;
                    break;
                case 3:
                    Daily = true;
                    break;
                case 4:
                    loc = true;
                    break;
                case 5:
                    Id = true;
                    break;
                case 6:
                    name = true;
                    break;
                default:
                    System.out.println("wrong input.");
                    break;

            }
        }
        String link = "";


        if (current) {
            if (Id) {
                System.out.println("please enter id:");
                String id = in.next();
                link = "http://api.openweathermap.org/data/2.5/weather?id=" + id + "&appid=b9eb6b2c99686fb92a55f2775350c297";
            }
            if (loc) {
                System.out.println("please enter location(lat and lon):");

                String lot = in.next();
                String lon = in.next();
                link = "http://api.openweathermap.org/data/2.5/weather?lat=" + lot + "&lon=" + lon + "&appid=b9eb6b2c99686fb92a55f2775350c297";
            }
            if (name) {
                System.out.println("please enter city's name:");

                String city = in.next();
                link = "http://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=b9eb6b2c99686fb92a55f2775350c297";
            }

            String something = UrlClass.URLConnection(link);
            CurrentWeather w = new CurrentWeather();
            CurrentWeather.Current(something);


        } else if (forecast || Daily) {

            if (forecast) {
                System.out.println("please enter the number of days you want weather forecast for:");
                int days = in.nextInt();
                if (Id) {
                    System.out.println("please enter city's id:");
                    String id = in.next();
                    link = "http://api.openweathermap.org/data/2.5/forecast?q=" + id + "&appid=b9eb6b2c99686fb92a55f2775350c297&cnt=" + days;
                }
                if (loc) {
                    System.out.println("please enter city's location:");
                    String lot = in.next();
                    String lon = in.next();
                    link = "http://api.openweathermap.org/data/2.5/forecast?lat=" + lot + "&lon=" + lon + "&appid=b9eb6b2c99686fb92a55f2775350c297&cnt=" + days;
                }
                if (name) {
                    System.out.println("please enter city's name:");
                    String city = in.next();
                    link = "http://api.openweathermap.org/data/2.5/forecast?q=" + city + "&appid=b9eb6b2c99686fb92a55f2775350c297&cnt=" + days;
                }
            } else {
                if (loc) {
                    System.out.println("please enter city's location:");
                    String lot = in.next();
                    String lon = in.next();
                    link = "http://api.openweathermap.org/data/2.5/forecast?lat=" + lot + "&lon=" + lon + "appid=b9eb6b2c99686fb92a55f2775350c297";
                }
                if (name) {
                    System.out.println("please enter city's name:");
                    String city = in.next();
                    link = "http://api.openweathermap.org/data/2.5/forecast?q=" + city + "&appid=b9eb6b2c99686fb92a55f2775350c297";
                }
                if (Id) {
                    System.out.println("please enter city's id:");
                    String id = in.next();
                    link = "http://api.openweathermap.org/data/2.5/forecast?q=" + id + "&appid=b9eb6b2c99686fb92a55f2775350c297";
                }
            }

            String something = UrlClass.URLConnection(link);
            ForecastWeather w = new ForecastWeather();
            w.Forecast(something);

        }


        boolean keepGoing = false;
        System.out.println("do you wanna continue?");
        if (in.next().equalsIgnoreCase("yes"))
            keepGoing = true;
        return keepGoing;
    }
}
