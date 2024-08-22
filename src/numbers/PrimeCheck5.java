package numbers;
//Approach: First, check if the number is less than or equal to 1, as such numbers are not prime.
//Then, use a boolean variable to track if the number is prime.
//Iterate from 2 up to num-1 to check for any divisors. If a divisor is found, set the boolean to False and break the loop.
//Finally, check the boolean to determine if the number is prime.
import java.util.Scanner;

public class PrimeCheck5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number for prime checking:");
        int num = sc.nextInt();

        if(num<=1){
            System.out.println(num+" is not a prime number");
            return;
        }
        boolean isPrime = true;

        for(int i=2;i<num;i++){
            if(num%i==0){
                isPrime=false;
                break;
            }
        }
        if(isPrime){
            System.out.println(num+" is a prime number");
        }else{
            System.out.println(num+" is not a prime number");
        }
    }
}
