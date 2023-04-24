package unit11.b;

class Vehicle {
    private int numWheels;

    public Vehicle(int numWheels) {
        this.numWheels = numWheels;
    }

    public String a() {
        return "Vehicle";
    }

    public String toString() {
        return this.getClass().getName() + " with " + numWheels + " wheels";
    }
}

// Code me! bikes have 2 wheels
public class Bike extends Vehicle {
    
    public Bike() {
        super(2);
    }

    public String a() {
        return "Bike";
    }

    public static void main(String[] args) {
        Vehicle bike = new Bike();
        System.out.println(bike);
        System.out.println(bike.a());
    }
}
