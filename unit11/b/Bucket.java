package unit11.b;

// https://www.youtube.com/watch?v=xVAvMIhvqfk
public class Bucket {
    private int value;

    public Bucket(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    // to explore...

    static void updateValue(Bucket b) {
        b.setValue(5);
    }

    void updateValue() {
        setValue(5);
    }

    static void updateValueDirect(Bucket b) {
        b.value = 5;
    }

    // what does static mean?
    // static means the method is non-specific to an instance of a class.
    // what is by value vs. by reference?
    // by value updates a value specific to a method and by reference updates a variable based on its storage location.

    static void updateValue(int value) {
        value = 5;
    }

    public static void main(String[] args) {
        // explore: predict before uncommenting
        int value = 3;
        // value = 5;
        System.out.println(value);

        // System.out.println("Within method:");
        // updateValue(value);
        // System.out.println(value);
        // should be 3

        // System.out.println("Within bucket:");
        // Bucket b = new Bucket(value);
        // b.value = 5;
        // updateValue(valueBucket);
        // updateValueDirect(b);
        // System.out.println(b.getValue());
        // should be 5
    }
}
