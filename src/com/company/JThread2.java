package com.company;
import java.io.*;
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
                java.io.File file = new java.io.File("C:\\Users\\user\\IdeaProjects\\java3k1lab\\src\\com\\company\\currentdata.txt");
                if(file.length()>200){

                    Date date = new Date();

                    String path = "C:\\Users\\user\\IdeaProjects\\java3k1lab\\src\\com\\company\\" + date.toString() +".txt";

                    File newFile = new File(path);


                    InputStream is = null;
                    OutputStream os = null;
                    try {
                        is = new FileInputStream(file);
                        os = new FileOutputStream(newFile);
                        byte[] buffer = new byte[1024];
                        int length;
                        while ((length = is.read(buffer)) > 0) {
                            os.write(buffer, 0, length);
                        }
                        FileWriter fwOb = new FileWriter(file, false);
                        PrintWriter pwOb = new PrintWriter(fwOb, false);
                        pwOb.flush();
                        pwOb.close();
                        fwOb.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    } finally {
                        is.close();
                        os.close();
                    }

                }

            }
        }
        catch(InterruptedException | IOException e){
            System.out.println("Thread has been interrupted");
        }
        System.out.printf("%s fiished... \n", Thread.currentThread().getName());
    }


}
