public class Stack {
    public static void hello() {
        System.out.println("Hello World! Thy dawn is anou.");
    }

    public static void a() {
        System.out.println("a was entered");
        b();
        System.out.println("a was exited");
    }

    public static void b() {
        System.out.println("b was entered");
        b();
        // a();
        System.out.println("b was exited");
    }

    public static void c() {
        System.out.println("c was entered");
        hello();
        System.out.println("c was exited");
    }

    public static void count(int n) {
        System.out.println(""+n);
        if(n>=2023) {
            // Base Case
            // STOP!!!
        } else {
            // Recursive Case
            count(n+1);
        }
    }

    public static void main(String[] args) {
        System.out.println("Welcome.");
        // a();
        // count(1);
        try {
            count(1);
        } catch(StackOverflowError e) {
            System.out.println("Overflowed.");
        }
    }
}