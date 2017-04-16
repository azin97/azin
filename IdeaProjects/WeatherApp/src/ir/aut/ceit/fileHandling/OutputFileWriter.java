package ir.aut.ceit.fileHandling;



        import java.io.*;
        import  java.lang.*;
        import java.util.Date;

/**
 * Created by azin on 4/15/2017.
 */
public class OutputFileWriter {
    public void fileWriter(String table,boolean curOrFor){
        BufferedWriter writer = null;
        try {

            String name = new Date(System.currentTimeMillis()).toString();
            name = name.replaceAll(":","");
            name =name.replaceAll(" ","");
            File dir;
            if (curOrFor){

                dir = new File("current");
                dir.mkdir();
            }

            else{
                dir = new File("forecast");
                dir.mkdir();
            }
            System.out.println(dir.getAbsoluteFile());
            System.out.println(dir.getAbsolutePath());
            File myfile = new File(dir.getAbsolutePath()+"\\"+name+".txt");




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
