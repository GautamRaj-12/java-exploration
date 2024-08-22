package numbers;
//Approach: Start checking divisibility from 2 up to the number itself (excluding the number).
//If any number divides the input number, it's not prime. If no number divides it by the end,
//then it's a prime number. Additionally, handle the case where the input number is 1 or less.
import java.util.Scanner;

public class PrimeCheck2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number for prime checking:");
        int num = sc.nextInt();
        int i;

        for(i=2;i<num;i++){
            if(num%i==0){
                System.out.println(num+" is not a prime number");
                //break;
                return;
            }
        }
        if(i==num && num>1){
            System.out.println(num+" is a prime number");
        }else{
            System.out.println(num+" is not a prime number");
        }
    }
}
