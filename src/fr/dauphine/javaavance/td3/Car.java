package fr.dauphine.javaavance.td3;

import java.util.Objects;

public class Car {

    /*
    1. Write a class Car present a car with two private, final champs: brand (String) and value (long)
     */

    private final String brand;
    private final long value;

    /*
    2. Write a constructor that takes two parameters and initializes the two fields
    3. Make it impossible to create a car with a negative value.
     */

    public Car(String brand, long value) {
        this.brand = brand;
        if (value < 0) {
            throw new IllegalArgumentException("Value must be positive");
        }
        this.value = value;
    }

    /*
    4. Write a getter for each field
     */

    public String getBrand() {
        return brand;
    }

    public long getValue() {
        return value;
    }

    /*
    5. Write a method getString() that returns the information of the car in the form of a string
     */

    public String getString() {
        return "Brand: " + brand + ", Value: " + value;
    }

    /*
    Exercice 2. Start here
     */

    /*
    1. Is the behavior natural? Add a method with signature boolean equals(Car c);

        Car a = new Car("Audi", 10000);
        Car b = new Car("BMW", 9000);
        Car c = new Car("BMW", 9000);
        Car d = a;
        System.out.println(a == b);
        System.out.println(b == c);
        System.out.println(a == d);
        System.out.println(a.equals(b));
        System.out.println(b.equals(c));
        System.out.println(a.equals(d));
    >>
    The behavior is natural, but we need to override the equals method to compare the two objects.requireNonNull(c);
    And we need to override the hashCode method to get the hash code of the object. The hash code is used to compare the two objects.

    2. Write a method with signature boolean equals(Car c) that returns true if the two cars have the same brand and value
     */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return value == car.value &&
                Objects.equals(brand, car.brand);
    }

}
