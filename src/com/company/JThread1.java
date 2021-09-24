

package com.company;
import java.io.*;
import java.util.*;

public class JThread1 extends Thread {

    private boolean isActive;

    void disable(){
       isActive=false;
        System.out.printf("%s finished... \n", Thread.currentThread().getName());
    }



    JThread1(String name){
        super(name);
        isActive = true;
    }
    public void run() {



            System.out.printf("%s started... \n", Thread.currentThread().getName());
            try {
                String words = "the first thread writes the time:  ";
                char[] letters = words.toCharArray();
                FileOutputStream fos = null;
                try {
                    fos = new FileOutputStream("currentdata.txt");
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                while (isActive) {


                    PrintWriter out = new PrintWriter(fos, false);


                    for (int i = 0; i < letters.length; i++) {
                        if (i < letters.length - 1) {

                            out.print(letters[i]);
                            out.flush();

                            Thread.sleep(400);
                        } else {
                            out.write(letters[i]);
                            Thread.sleep(400);
                            Date date = new Date();
                            out.println(date);
                            out.flush();



                        }


                    }


                }


            } catch (InterruptedException e) {
                System.out.println("Thread has been interrupted");
            }
            System.out.printf("%s finished... \n", Thread.currentThread().getName());


    }
}
