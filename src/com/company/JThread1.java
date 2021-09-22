

package com.company;
import java.io.*;
import java.util.*;

public class JThread1 extends Thread {
    JThread1(String name){
        super(name);
    }
    public void run(){



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
                while(true) {


                    PrintWriter out = new PrintWriter(fos, false);


                    for (int i = 0; i < letters.length; i++) {
                        if (i < letters.length - 1) {

                            out.print(letters[i]);
                            out.flush();
                            System.out.print(letters[i]);
                            Thread.sleep(100);
                        } else {
                            out.write(letters[i]);
                            Thread.sleep(100);
                            Date date = new Date();
                            out.println(date);
                            out.flush();
                            System.out.println(date);




                        }


                    }


                }







            } catch (InterruptedException e) {
                System.out.println("Thread has been interrupted");
            }
            System.out.printf("%s fiished... \n", Thread.currentThread().getName());

    }
}
