package com.company;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.MouseEvent;
import java.awt.event.KeyEvent;
import java.awt.datatransfer.StringSelection;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;

public class Main {

    private static Robot bot = null;



    public static void main(String[] args) {
	// write your code here




        String[] output0 = new String[]{"Yes","No","Only for the first month after New Years"};

        String[] output1 = new String[]{"Yes","Depends on how I feel","I have no money"};

        String[] output2 = new String[]{"Never","Occassionally but only when forced to","I'd like to","The sea is my one true passion. Dry land is death"};

        String[] output3 = new String[]{"I'd make it to the end and double dab","I wouldn't make it past the first wing","I'd make it to the end half dead"};

        String[] output4 = new String[]{"Hulk Hogan","Jacky Chan","Who?"};


        String[] questions = new String[]{"Do you consider yourself an athletic person?","Are you the type of person to spend excessive amounts of money on food?","Do you feel lkke visiting the sea side?","Picture a senario where you are invited to the Hot Ones YouTube series. How would you fair on the show?","Who would win in a fight, Jacky Chan or Hulk Hogan?"};

        String[][] output = new String[][]{output0,output1,output2,output3,output4};
        Scanner myObj = new Scanner(System.in);

        int[][][] bank = {
                {{1,3},{2},{0,4}},
                {{3},{0,1,2},{4}},
                {{1},{4,0},{2},{3}},
                {{1},{3},{0,2,4}},
                {{0,4},{2,3},{1}},
        };
        int[] tally = {0,0,0,0,0};

        String[] cusines = new String[]{"Fast food","Indian","Chinese","Sushi","Pizza"};
        System.out.print("\033[H\033[2J");

        for(int i = 0; i < questions.length; i++){
            for(int ii = 0; ii < 5; ii++){
                // System.out.print(tally[ii]+" ");

            }

            System.out.println("\n"+questions[i]+"\n");
            for(int j = 0; j < output[i].length; j++){
                System.out.println((j+1)+". "+output[i][j]+"\n");
            }
            int ans = myObj.nextInt()-1;
            for(int k = 0; k < bank[i][ans].length;k++){
                tally[bank[i][ans][k]]++;
            }


            System.out.print("\033[H\033[2J");
        }

        int max = tally[0];
        int max_i = 0;

        for (int jj = 1; jj < tally.length; jj++) {
            if (tally[jj] > max) {
                max = tally[jj];
                max_i = jj;
            }
        }

        //System.out.print(max);


        ArrayList<Integer> same_index = new ArrayList<Integer>();

        for(int y = 0; y < tally.length;y++){
            if (tally[y] == max){
                same_index.add(y);

            }
        }

        // for (Integer num : same_index) {
        //        System.out.println(num);
        // }

        Collections.shuffle(same_index);
        max_i = same_index.get(0);
        // System.out.print("max_i = "+max_i+"\n");

        String toEat = cusines[max_i];


        // for(int xx = 0; xx < 5; xx++){
        //   System.out.print(tally[xx]+" ");
        // }

        System.out.print("\nI recommend: "+toEat+"\n");


        System.out.println("How many people are there?");

        Scanner sc = new Scanner(System.in);
        int scanned = sc.nextInt();
        int people = scanned;
        // System.out.println(people);

        double price=0.0;


        // Total Price will be given from the Doordash app
        if(toEat=="Sushi")
        {
             price = 8.95;}
        else
        {
             price = 9.99;
        }

        // initialize array1 to store price guesses from people
        float array1[];
        array1 = new float[people];

        // getting the guesses of the price from each person
        for (int i = 0; i<array1.length; i++){
            System.out.println("Person " + (i+1) + ", enter your guess:");
            Scanner scan = new Scanner(System.in);
            float newscanned = sc.nextFloat();
            float guess = newscanned;
            array1[i] = guess;
        }

    /*
    // testing if guesses were stored
    for (int i = 0; i<array1.length; i++){
      System.out.println("Person: " + (i+1) + " , value: " + array1[i]);
    }
    */

        // initialize new array to store the difference values
        float array2[];
        array2 = new float[people];

        // initialize variable to calculate the difference in prices
        float difference;

        // use for loop to iterate through array of guesses
        for (int i = 0; i<people; i++){
            float number = array1[i];
            // if the guess is higher than the price we subtract the guess from the price
            // prevents giving us a negative number
            if (array1[i] > price){
                difference = number - (float)price;
                array2[i] = difference;
            }else{
                // the guess is lower than the price
                // therefore we can subtract the price from the guess
                difference = (float)price - number;
                array2[i] = difference;
            }
        }

        // arbitrarily set first value of difference as the biggest difference
        // we want the person with the biggest difference to pay the tip
        float biggest_difference = array2[0];
        int place = 0;
        // Finding the largest difference
        for (int i = 0; i<people; i++){
            if (biggest_difference < array2[i]){
                biggest_difference = array2[i];
                // records the index of where the biggest difference is found
                place = i;
            }
        }

        // format numbers to 2 decimal places
        DecimalFormat f1 = new DecimalFormat("##.00");
        // the final price is the price of the meal that all the other persons have to pay
        double final_price = (double)(price/(people-1));
        double final_diff = (double)array2[place];

        // output text
        System.out.println("Person " + (place+1) + ", you must pay the difference of $" + f1.format(final_diff) + " as the tip and the total price of "+f1.format(price));
        System.out.println("Person "+(place+1)+" please connect your phone via usb to complete order");


        //Time Delay

        try
        {
            Thread.sleep(20000);
        }
        catch(InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }

        //Run Screen Mirror

        try {
            Runtime runTime = Runtime.getRuntime();

            String executablePath = "C:\\Users\\Harsh\\Downloads\\scrcpy-win64-v1.12.1\\scrcpy.exe";

            Process process = runTime.exec(executablePath);
        } catch (IOException e) {
            e.printStackTrace();
        }


        //Time Delay
        try
        {
            Thread.sleep(10000);
        }
        catch(InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }



        try {
            bot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
        klick(550, 600);
        pastee(600, 350, toEat);
        klick(600, 350);
        scrolle();
        klick(600, 820);
        klick(600, 820);
        klick(600, 820);
        String tip=Double.toString(final_diff);
        pastee(740,720, tip);


    }

    public static void klick(int x, int y) {
        bot.mouseMove(x, y);
        bot.delay(5);
        bot.mousePress(MouseEvent.BUTTON1_MASK);
        bot.mouseRelease(MouseEvent.BUTTON1_MASK);
        bot.delay(10000);
    }

    public static void pastee(int x, int y, String cop) {
        bot.mouseMove(x, y);
        bot.delay(5);
        bot.mousePress(MouseEvent.BUTTON1_MASK);
        bot.mouseRelease(MouseEvent.BUTTON1_MASK);
        bot.delay(3000);

        //Copying

        String myString = cop;
        StringSelection stringSelection = new StringSelection(myString);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, null);

        try {
            Robot r = new Robot();
            r.keyPress(KeyEvent.VK_CONTROL);
            r.keyPress(KeyEvent.VK_V);
            r.keyRelease(KeyEvent.VK_CONTROL);
            r.keyRelease(KeyEvent.VK_V);
            bot.delay(2000);

        } catch (Exception e) {

        }
    }


    public static void scrolle() {
        bot.mouseWheel(15);
        bot.delay(3000);
        bot.mousePress(MouseEvent.BUTTON1_MASK);
        bot.mouseRelease(MouseEvent.BUTTON1_MASK);
        bot.delay(10000);

    }
}



// {"How often do you exercise?","How many times have you been to a beach?","Would you classify yourself as a 'jack of all trades', or a 'one trick pony'", "Have you watched the Oscar's best picture of 2019 movie, Parasite?", "How many assigments do you have due currently?","Do you like turtles?","What type of phone do you have?","What colour of pen ink do you prefer?"};

