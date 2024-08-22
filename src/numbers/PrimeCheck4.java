package numbers;
//Approach: Initialize a boolean variable to track if the number is prime.
//Iterate from 2 up to num-1 to check for any divisors. If a divisor is found, set the boolean to false and break the loop.
//Finally, check the boolean and the number to determine if it's prime.
import java.util.Scanner;

public class PrimeCheck4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number for prime checking:");
        int num = sc.nextInt();

        boolean isPrime = true;

        for(int i=2;i<num;i++){
            if(num%i==0){
                isPrime=false;
                break;
            }
        }
        if(isPrime && num>1){
            System.out.println(num+" is a prime number");
        }else{
            System.out.println(num+" is not a prime number");
        }
    }
}
