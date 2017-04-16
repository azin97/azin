package ir.aut.ceit.fileHandling;

import java.io.*;
import java.lang.*;
import java.util.Date;

/**
 * Created by azin on 4/15/2017.
 */
public class OutputFileWriter {
    /**
     * @param table    is a string that contains weather information in the specific order we arranged in other classes
     * @param curOrFor is short for Current or forecast, it determines whether
     *                 the information in table is forecast or current weather, since we want to write current
     *                 and forecast information in separate folders.
     *                 <p>
     *                 .makedir() method has been used for making new directories
     *                 System.currentTimeMillis() method has been used for getting the exact date for naming the text file.
     */
    public void fileWriter(String table, boolean curOrFor) {
        BufferedWriter writer = null;
        try {

            String name = new Date(System.currentTimeMillis()).toString();
            name = name.replaceAll(":", "");
            name = name.replaceAll(" ", "");
            File dir;
            if (curOrFor) {

                dir = new File("current");
                dir.mkdir();
            } else {
                dir = new File("forecast");
                dir.mkdir();
            }

            File myfile = new File(dir.getAbsolutePath() + "\\" + name + ".txt");


            writer = new BufferedWriter(new FileWriter(myfile));

            writer.write(table);


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                // Close the writer
                writer.close();
            } catch (Exception e) {

            }
        }
    }
}
