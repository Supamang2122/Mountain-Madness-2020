import java.util.Scanner;
import java.text.DecimalFormat;


class Main {
  public static void main(String[] args) {
    // Takes number of people that are ordering
    System.out.println("How many people are there?");

    Scanner sc = new Scanner(System.in);
    int scanned = sc.nextInt();
    int people = scanned;
    // System.out.println(people);
    
    
    // Total Price will be given from the Doordash app
    double price = 60.50;
    
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
    System.out.println("Person " + (place+1) + ", you must pay the difference of $" + f1.format(final_diff) + " as the tip \n");

    System.out.println("The rest of you must pay $" + f1.format(final_price) + " each, for the total of $" + f1.format(price));

}
  
}
