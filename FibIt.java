//FibIt.java
//CS111 sample program 
//iterative fibonacci series

import java.util.Scanner;

public class FibIt {
  
  
    public static void main(String [] args)
    {
      long fibTerm, fibNum = 0, fibNum1,fibNum2, nextTerm;
      Scanner numIn = new Scanner(System.in);
    
      System.out.print ("enter the fibonacci term you wish to find: ");
      fibTerm = numIn.nextInt();
      nextTerm = fibTerm;
      fibNum1=1;
      fibNum2 =1;
      if (fibTerm == 2 || fibTerm ==1) 
        System.out.println("1 is the " + fibTerm + "nd term in the series");
      else if (fibTerm < 1)  System.out.println("can't find the term");
      else
      {
        while (nextTerm-2 > 0)
        {
          // System.out.println("calculating the term " + nextTerm);
          fibNum = fibNum1 + fibNum2;
          fibNum1 = fibNum2;
          fibNum2 = fibNum;
          nextTerm--;
        }
     
        System.out.println(fibNum + " is the " + fibTerm + "th term in the series");
      }
      numIn.close();
    }
}
