package ir.aut.ceit;

import ir.aut.ceit.weather.GetInfo;

public class Main {

    public static void main(String[] args) {
        boolean go=true;
        while(go) {
            GetInfo info = new GetInfo();
            go = info.GetInformation();
        }

    }
}
