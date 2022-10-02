package fr.dauphine.javaavance.td3;

import java.util.ArrayList;
import java.util.HashSet;
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
    The behavior is natural, but we need to override the equals method to compare the two objects.
    And we need to override the hashCode method to get the hash code of the object. The hash code is used to compare the two objects.

    Write a method with signature boolean equals(Car c) that returns true if the two cars have the same brand and value
     */

    @Override
    // This method is my solution for all question 1, 2, 3 of the exercice 2
    public boolean equals(Object o) { // I changed the parameter type from Car to Object, because we need to override the equals method of the Object class
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return value == car.value &&
                Objects.equals(brand, car.brand);
    }

    /*
    2. Is this a logical behavior? Read indexOf of List doc and modify your code accordingly.

        ArrayList<Car> list = new ArrayList<>();
        list.add(a);
        list.add(b);
        System.out.println(list.indexOf(a));
        System.out.println(list.indexOf(b));
        System.out.println(list.indexOf(c));
        System.out.println(b.equals(c));

     >> The result is:
        0 // index of a
        1 // The index of b is 1
        1 // The indexOf method returns -1 if the object is not found in the list but Car b and Car c are the same object.
        true // The equals method returns true because the two objects have the same brand and value

        The indexOf method returns the index of the first occurrence of the specified element in this list,
        or -1 if this list does not contain the element. So the result is not logical.
     */

    @Override
    public int hashCode() {
        return Objects.hash(brand, value); // The hash code is used to compare the two objects.
    }

    /*
    3. Is this a logical behavior? Read Set's contains doc and modify your code accordingly.

        HashSet<Car> set = new HashSet<Car>();
        set.add(b);
        System.out.println(set.contains(c));

        >> The result is:
        true // The contains method returns true because the two objects have the same brand and value

        The behavior is logical while the contains method returns true if this set contains the specified element.
        but the two objects are not the same object. So the result is not logical.

        >> Solution: Override the equals method to compare the two objects.
        Like the following:

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Car car = (Car) o;
            return value == car.value &&
                    Objects.equals(brand, car.brand);
        }

     */

    public static void main(String[] args) {

        Car a = new Car("Audi", 10000);
        Car b = new Car("BMW", 9000);
        Car c = new Car("BMW", 9000);
        Car d = a;

        /*
        System.out.println(a == b);
        System.out.println(b == c);
        System.out.println(a == d);
        System.out.println(a.equals(b));
        System.out.println(b.equals(c));
        System.out.println(a.equals(d));


        ArrayList<Car> list = new ArrayList<>();
        list.add(a);
        list.add(b);
        System.out.println(list.indexOf(a));
        System.out.println(list.indexOf(b));
        System.out.println(list.indexOf(c));
        System.out.println(b.equals(c));
         */

        HashSet<Car> set = new HashSet<Car>();
        set.add(b);
        System.out.println(set.contains(c));

    }

}
