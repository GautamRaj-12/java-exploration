package numbers;
//Approach: First, check if the number is less than or equal to 1, as such numbers are not prime.
//Then, check divisibility starting from 2 up to num-1. If a divisor is found, it's not prime.
//If no divisors are found, the number is prime.
import java.util.Scanner;

public class PrimeCheck3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number for prime checking:");
        int num = sc.nextInt();
        int i;

        if(num<=1){
            System.out.println(num+" is not a prime number");
            return;
        }
        for(i=2;i<num;i++){
            if(num%i==0){
                System.out.println(num+" is not a prime number");
                //break;
                return;
            }
        }
        if(i==num){
            System.out.println(num+" is a prime number");
        }
    }
}
