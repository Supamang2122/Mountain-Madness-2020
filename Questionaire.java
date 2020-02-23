import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main {
  
  
  public static void main(String[] args) {

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
    
  }

  
}


// {"How often do you exercise?","How many times have you been to a beach?","Would you classify yourself as a 'jack of all trades', or a 'one trick pony'", "Have you watched the Oscar's best picture of 2019 movie, Parasite?", "How many assigments do you have due currently?","Do you like turtles?","What type of phone do you have?","What colour of pen ink do you prefer?"};