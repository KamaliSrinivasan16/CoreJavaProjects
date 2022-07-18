package program;

import java.util.Scanner;
public class arithmeticCalculator {

	public static void main(String[] args) {
		
		while(true) {
		
		//variables initialization
		double num1,num2,result = 0;
		char op;
		//get the two numbers:
		System.out.println("\n ARITHMETIC CALCULATOR: \n");
		System.out.println("Enter any two numbers: ");
		@SuppressWarnings("resource")
		
		//get the numbers
		Scanner sc = new Scanner(System.in);
		num1 = sc.nextDouble();
		num2 = sc.nextDouble();
		
		//get the operator:
		System.out.println("Enter the operator(+,-,*,/) : ");
		op = sc.next().charAt(0);
		
		//calculation:
		switch(op)
		{
		case '+':
			result = num1 + num2;
			break;
			
		case '-':
			result = num1 - num2;
			break;
			
		case '*':
			result = num1 * num2;
			break;
			
		case '/':
			result = num1 / num2;
			break;
			
		default :
			System.out.println("Oops!! Enter a valid operator");
			break;
		}
		
		//output:
		System.out.println("Result: "+num1+" "+op+" "+num2+" = "+result+"\n");
		
		}
	
	}
	
}
