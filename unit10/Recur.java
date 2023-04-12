

public class Recur {

    /**
     * returns 3 to the power of n.
     */
    public static int fun3(int n) {
        System.out.println("called fun3(" + n + ")");
        if (n == 0) {
            System.out.println("returned 1");
            return 1;
        }
        else {
            System.out.println("returned 3 * fun3(" + (n-1) + ")");
            return 3 * fun3(n - 1);
        }
    }

    // f(3) = f(2) + f(1) = f(1) + f(0) + f(1) = 2
    // returns a count of branches created
    public static int f(int n) {
        if (n == 0)
            return 0; //base case 1
        else if (n == 1)
            return 1; //base case 2
        else
            return f(n - 1) + f(n - 2); //splits into two branches, one with a value of two less, one with one less.
    }

    // returns true if input has two repeated letters in a row.
    public static boolean has(String input) {
        if (input.length() < 2)
            return false;
        return (input.charAt(0) == input.charAt(1) || has(input.substring(1)));
    }

    // returns true if a string is a palindrome.
    public static boolean pot(String input) {
        if (input.length() < 2)
            return true;
        return (input.charAt(0) == input.charAt(input.length() - 1)
                && pot(input.substring(1, input.length() - 1)));
    }

    // not sure to describe this. see below.
    public static double two(int n) {
        if (n < 1)
            return 1.0 / 2; // base case of 1/2
        return 1.0 / (2 + two(n - 1)); // takes the inverse of (2 + (the inverse of 2 + ...)) n times.
    }

    // returns value of n in binary.
    public static String mop(int n) {
        if (n / 2 == 0)
            return "" + n % 2;
        return mop(n / 2) + n % 2;
    }

    // returns the sum of all digits in a number
    public static int cat(int x) {
        if (x == 0)
            return x;
        return ((x % 10) + cat(x / 10));
    }

    // returns the value of 4x-3
    public static int mystery(int x) {
        if (x <= 1)
            return 1;
        // return mystery(x - 1) + mystery(x - 2);
        // return 2 * mystery(x - 2);
        // return 2 * mystery(x - 1);
        // return 4 * mystery(x - 4);
        return 4 + mystery(x - 1);
    }

    public static void main(String[] args) {

        // Consider function fun3
        // System.out.println(fun3(5));

        // Consider function f
        // System.out.println(f(6));

        // Consider function has
        // System.out.println(has("hello"));
        // System.out.println(has("howdy"));

        // Consider function pot
        // System.out.println(pot("deified"));
        // System.out.println(pot("deepfried"));

        // Consider function two
        // System.out.println(two(6));

        // Consider function mop
        // System.out.println(mop(11));

        // Consider function cat
        // System.out.println(cat(4096));

        // Fix function mystery so that mystery(10) == 32
        // System.out.println(mystery(10));

    }

}
