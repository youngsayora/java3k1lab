

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
                String words = "the first thread writes the time:";
                char[] letters = words.toCharArray();
                while(true) {


                    try(PrintWriter out = new PrintWriter("C:\\Users\\user\\IdeaProjects\\java3k1lab\\src\\com\\company\\currentdata.txt")) {


                        for (int i = 0; i < letters.length; i++) {
                            if (i < letters.length - 1) {

                                out.print(letters[i]);
                                Thread.sleep(500);
                            } else {
                                out.write(letters[i]);
                                Thread.sleep(500);
                                Date date = new Date();
                                out.println(date);
                                out.flush();
                                out.close();


                            }
                        }
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }finally {

                    }
                }







            } catch (InterruptedException e) {
                System.out.println("Thread has been interrupted");
            }
            System.out.printf("%s fiished... \n", Thread.currentThread().getName());

    }
}
