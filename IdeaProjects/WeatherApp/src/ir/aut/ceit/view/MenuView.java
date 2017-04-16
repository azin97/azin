package ir.aut.ceit.view;

/**
 * Created by azin on 4/15/2017.
 * MenuView is a class for making a table of contents for the services this program can give.
 */
public class MenuView {

    public static void MenuViewer(){
        /**
         * MenuViewr method creates a table using an array of characters.
         * @param  table is a two dimensional array of characters
         *               fisrt containing '=' and '.'
         *               then the dots are replaced by characters of the words we want to have in our table.
         */
        System.out.println("please enter your choices.");
        char[][] table = new char[8][20];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j <20 ; j++) {

                if(i==0 || j==0 || i==7 || j==19)
                    table[i][j]='=';
                else table[i][j]=' ';

            }
        }

        String row = "current";
        for (int j = 0; j <row.length() ; j++) {
            table[1][j+1]=row.charAt(j);
        }table[1][18]='1';

        String row2 = "forecast";
        for (int j = 0; j <row2.length() ; j++) {
            table[2][j+1]=row2.charAt(j);
        } table[2][18]='2';

        String row3 = "Daily Forecast";
        for (int j = 0; j <row3.length() ; j++) {
            table[3][j+1]=row3.charAt(j);
        } table[3][18]='3';


        String row4 = "Location";
        for (int j = 0; j <row4.length() ; j++) {
            table[4][j+1]=row4.charAt(j);
        } table[4][18]='4';

        String row5 = "ID";
        for (int j = 0; j <row5.length() ; j++) {
            table[5][j+1]=row5.charAt(j);
        } table[5][18]='5';

        String row6 = "Name";
        for (int j = 0; j <row6.length() ; j++) {
            table[6][j+1]=row6.charAt(j);
        } table[6][18]='6';




        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 20; j++) {

                System.out.print(table[i][j]);
                if (j == 19) System.out.println();
            }
        }
    }

}
