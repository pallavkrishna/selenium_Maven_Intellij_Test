package practice.testng.java.hackerrank;

import java.util.Scanner;

public class IFExample {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int N = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        if(N%2==0){
            if(N>=2 && N<=5){
                System.out.println("N>=2 || N<5 ->Not Weird");
            }
            else if(N>=6 && N<=20){

                System.out.println("N>=6 || N<=20 Weird");
            }

            else if(N>20){
                System.out.println("N>20 Not Weird");

            }
        }
        else{
            System.out.println("Weird");
        }



        scanner.close();
    }

}
