import java.util.Scanner;

public class PiDay {
    public static final int loops = 2500000;

    static int factorialItr(int n) {
        int result = 1;
        for(int i = n; i >= 1; i--) {
            result *= i;
        }
        return result;
    }

    static int factorialRec(int n) {
        if(n <= 1) {
            // base case
            return n;
        } else {
            // recursive case
            return n * factorialRec(n-1);
        }
    }

    static int fibonacci(int n) {
        System.out.println("Called fib " + n); 
        if (n == 1)
            // base case
            return 1;
        if (n == 0)
            // base case
            return 0;
        return fibonacci(n-1) + fibonacci(n-2);
    }

    static String reverseString(String input) {
        if (input.length() == 1) {
            //Base case
            return input;
        }
        // recursive case
        String head = input.substring(0,1);
        String tail = input.substring(1);
        return reverseString(tail) + head;
    }

    static double piItr() {
        double pi = 3.0;
        double four = 4.0;
        for(long n = 2; n <= loops; n += 2) {
            pi += four/(n*(n+1)*(n+2));
            four *= -1;
        }
        return pi;
    }

    static double converge(int n, boolean subtract) {
        long n2 = n;
        double out = 4.0/(n2*(n2+1)*(n2+2));
        if(subtract)
            out *= -1;
        if(n >= loops) {
            // base case
            return out +3.0;
        } else {
            // recursive case
            return out + converge(n+2, !subtract);
        }
    }

    static double piRec() {
        return converge(2, false);
    }

    static int power(int a, int b) {
        if(b == 1) {
            return a;
        } else {
            int nextPower = power(a, b/2);
            if (b%2 == 1)
                return nextPower * nextPower *a;
            return nextPower * nextPower;
        }
    }

    public static void main(String[] args) {
        // Scanner scan = new Scanner(System.in);
        // System.out.print("Type int: ");
        // System.out.println(factorialRec(scan.nextInt()));
        // scan.close();

        // System.out.println("fibonacci(10) = " + fibonacci(1000));
        // System.out.println(reverseString("testing"));

        System.out.println("Pi:  3.14159265358979323846264338327950288419716939937510");
        System.out.println("Itr: " + piItr());
        // System.out.println("Rec: " + piRec());

        // System.out.println(power(2, 16));
    }
}
