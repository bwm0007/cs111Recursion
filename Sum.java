//Sum.java


import java.util.Scanner;

public class Sum{
    public static int sum (int n)
    {
	System.out.println("On this call n = " + n);
	if (n==1)
	    return 1;
	else return (n + sum(n-1));
	System.out.println("on the way back n is: "+n);
    }

    public static void main(String[] args){
	int value;
	Scanner valueIn = new Scanner(System.in);

	System.out.print("enter the value to sum to: ");
	value = valueIn.nextInt();

	System.out.println("the sum of the number 1-" + value + " is: " + sum(value));
    }
}