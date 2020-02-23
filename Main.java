import java.util.Scanner;
import java.text.DecimalFormat;


class Main {
  public static void main(String[] args) {
    System.out.println("How many people are there?");

    Scanner sc = new Scanner(System.in);
    int scanned = sc.nextInt();
    int people = scanned;
    // System.out.println(people);

    double price = 60.50;
    float array1[];
    array1 = new float[people];

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

    float array2[];
    array2 = new float[people];
    float difference;
    for (int i = 0; i<people; i++){
      float number = array1[i];
      if (array1[i] > price){
        difference = number - (float)price;
        array2[i] = difference;
      }else{
        difference = (float)price - number;
        array2[i] = difference;
      }
    }

    float biggest_difference = array2[0];
    int place = 0;
    // Finding the largest difference
    for (int i = 0; i<people; i++){
      if (biggest_difference < array2[i]){
        biggest_difference = array2[i];
        place = i;
      }
    }

    DecimalFormat f1 = new DecimalFormat("##.00");
    double final_price = (double)(price/(people-1));
    double final_diff = (double)array2[place];

    System.out.println("Person " + (place+1) + ", you must pay the difference of $" + f1.format(final_diff) + " as the tip \n");

    System.out.println("The rest of you must pay $" + f1.format(final_price) + " each, for the total of $" + f1.format(price));

}
  
}
