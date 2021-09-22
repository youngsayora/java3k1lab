package com.company;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;

public class JThread2 extends Thread{
    JThread2(String name){
        super(name);
    }
    public void run(){

        System.out.printf("%s started... \n", Thread.currentThread().getName());
        try{
            while(true) {
                Thread.sleep(15000);
                File file = new File("currentdata.txt");
                if(file.length()>200){

                    Date date = new Date();
                    String newDate = date.toString().replaceAll("\\s", "__").replaceAll(":", "-");


                    String path = "NewFile" + newDate +".txt";

                    File newFile = new File(path);


                    try (FileReader fr = new FileReader("currentdata.txt");
                         FileWriter fw = new FileWriter(newFile)) {
                        int c = fr.read();
                        while(c!=-1) {

                               fw.write(c);

                            c = fr.read();
                        }

                        Files.newBufferedWriter(Paths.get("currentdata.txt"), StandardOpenOption.TRUNCATE_EXISTING);
                        //PrintWriter pw = new PrintWriter("currentdata.txt");
                        //pw.close();

                        file = new java.io.File("currentdata.txt");
                    } catch(IOException e) {
                        e.printStackTrace();
                    }

                }

            }
        }
        catch(InterruptedException e){
            System.out.println("Thread has been interrupted");
        }
        System.out.printf("%s fiished... \n", Thread.currentThread().getName());
    }


}
