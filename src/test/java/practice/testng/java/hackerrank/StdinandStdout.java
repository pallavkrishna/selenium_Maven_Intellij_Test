package practice.testng.java.hackerrank;

import java.util.Scanner;

public class StdinandStdout {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int i = scan.nextInt();

        double d = scan.nextDouble();

        String s = scan.nextLine();
        scan.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        // Write your code here.

        System.out.println("String: " + s);
        System.out.println("Double: " + d);
        System.out.println("Int: " + i);
    }

}
