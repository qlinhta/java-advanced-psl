package fr.dauphine.javaavance.td3;

import java.util.Arrays;
import java.util.Objects;

public class Garage {

    /*
    6. Write a class Garage that to store instances of Car. Add a method in Garage to add a car in the garage.
        Make it impossible to add a null car to the garage using Objects.requireNonNull().
     */

    private Car[] cars;
    private int size;

    public Garage(int capacity) {
        cars = new Car[capacity];
        // for bikes also
        bikes = new Bike[capacity];
        size = 0;
    }

    // Method that adds a car to the garage, throws an exception if the car is null

    public void addCar(Car car) {
        Objects.requireNonNull(car);
        if (size == cars.length) {
            throw new IllegalArgumentException("Garage is full");
        }
        // Add the car to the garage with the next available indexOf the array
        cars[size] = car;
        size++;
    }


    /*
    7. We want each garage to have a unique identifier specific to each garage (also make a getId() method).
    For the exercise, we use the number of created instances of the Garage class. (think of static fields).
     */

    private static int idCounter = 0;
    private int id;

    public Garage() {
        id = idCounter;
        idCounter++;
    }

    public int getId() {
        return id;
    }

    /*
    8. Write a toString() method to display a garage properly using a StringBuilder.
     */

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Garage ").append(id).append(":").append(System.lineSeparator());
        for (int i = 0; i < size; i++) {
            sb.append(cars[i].getString()).append(System.lineSeparator());
        }
        return sb.toString();
    }

    /*
    9. Write a  permanent method to calculate the value of garage (contain total of the value of all car in garage).

    >>
        public long calculateValue() {
        long value = 0;
        for (int i = 0; i < size; i++) {
            value += cars[i].getValue();
        }
        return value;
    }

     */




    /*
    10. Write a firstCarByBrand method that takes a brand as a parameter and returns the first car of this brand.
    What should we do if there is no car of this brand?
    >>We can return null or throw an exception. I chose to throw an exception.
     */

    public Car firstCarByBrand(String brand) {
        for (int i = 0; i < size; i++) {
            if (cars[i].getBrand().equals(brand)) {
                return cars[i];
            }
        }
        throw new IllegalArgumentException("No car of this brand");
    }

    /*
    11. Cars can now have an age level. 0 is not dilapidated, then for each level, the value of the car decreases by
    1000th. For example, a car worth 10,000e with an age level of 2 is now worth 8,000. Add a field corresponding to
    this age level and modify the implementation accordingly. The level of obsolescence may or may not be specified
    during construction (builder surcharge).
     */

    // I added a constructor with ageLevel parameter and a setter for ageLevel.
    // I modified the calculateValue() method to take ageLevel into account.

    private int ageLevel;

    public Garage(int capacity, int id, int ageLevel) {
        cars = new Car[capacity];
        this.id = id;
        size = 0;
        this.ageLevel = ageLevel;
    }

    public void setAgeLevel(int ageLevel) {
        this.ageLevel = ageLevel;
    }

    public long calculateValue() {
        long value = 0;
        for (int i = 0; i < size; i++) {
            value += cars[i].getValue() - ageLevel * 1000L;
        }
        return value;
    }

    /*
    12. Write JUNIT tests for the class Garage and Car.
    >> See src/fr/dauphine/javaavance/td3/GarageTest.java and src/fr/dauphine/javaavance/td3/CarTest.java
     */

    /*
    Exercice 2. Start here in this class
     */

    /*
    4. Write a method remove() in Garage which takes a car as an argument and allows to remove a car from the garage.
     */

    public void remove(Car car) {
        for (int i = 0; i < size; i++) {
            if (cars[i].equals(car)) {
                cars[i] = cars[size - 1];
                cars[size - 1] = null;
                size--;
                return;
            }
        }
        throw new IllegalArgumentException("Car not found");
    }

    public int getSize() {
        return size;
    }

    /*
    Exercice 3: Start here
     */

    // Declare a new ArrayList of bikes as an attribute of the class Garage, make sure that value of bike is not null.
    private Bike[] bikes;
    // Size of the ArrayList bikes
    private int sizeBikes;

    /*
    Method addBike(), adds a bike to the ArrayList bikes, throws an exception if the bike is null
    and check size of the ArrayList bikes to make sure it doesn't exceed the capacity of the garage.
     */

    public void addBike(Bike bike) {
        Objects.requireNonNull(bike);
        if (sizeBikes == bikes.length) {
            throw new IllegalArgumentException("Garage is full");
        }
        bikes[sizeBikes] = bike;
        sizeBikes++;
    }
    /*
    5. In garage, create a method void protectionism(String brand); which removes all the vehicles of the brand passed
    as an argument, by traversing the list only once. Test, it is likely that your first idea does not work...
     */

    public void protectionism(String brand) {
        for (int i = 0; i < size; i++) {
            if (cars[i].getBrand().equals(brand)) {
                remove(cars[i]);
                i--;
            }
        }
        for (int i = 0; i < sizeBikes; i++) {
            if (bikes[i].getBrand().equals(brand)) {
                removeBike(bikes[i]);
                i--;
            }
        }
    }

    private void removeBike(Bike bike) {
        for (int i = 0; i < sizeBikes; i++) {
            if (bikes[i].equals(bike)) {
                bikes[i] = bikes[sizeBikes - 1];
                bikes[sizeBikes - 1] = null;
                sizeBikes--;
                return;
            }
        }
        throw new IllegalArgumentException("Bike not found");
    }


    public int getSizeBikes() {
        return sizeBikes;
    }

    /*
    Exercice 4: Start here
     */

    /*
    2. Write an equals method for Garage that simply calls the equals method of ArrayList (that of the contents of the
    garage). Is the result satisfactory?
     */

    public boolean equalsGarages(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Garage garage = (Garage) o;
        return size == garage.size &&
                id == garage.id &&
                ageLevel == garage.ageLevel &&
                Arrays.equals(cars, garage.cars) &&
                Arrays.equals(bikes, garage.bikes) &&
                sizeBikes == garage.sizeBikes;
    }

    /*
    3. Modify the code to sort the list (using the sort method of the Collections class) at the level of adding a vehicle
    to the garage (after each addition) so that the contents of the garage are always sorted. To be able to use sort,
    it is necessary to be able to compare one vehicle to another. Are these comparison criteria satisfactory?
        — Alphabetical order by vehicle name.
        — Alphabetical order of the brand name.
        — A combination of the name of the vehicle and its brand?

    >> We modify the addCar() method to sort the list after each addition. Like following code below:

    public void addCar(Car car) {
        Objects.requireNonNull(car);
        if (size == cars.length) {
            throw new IllegalArgumentException("Garage is full");
        }
        cars[size] = car;
        size++;
        Arrays.sort(cars, 0, size);
    }

    >> The comparison criteria is satisfactory. Because we can sort the list by alphabetical order of the brand name.
     and we can sort the list by a combination of the name of the vehicle and its brand.

     - For example, sort by a combination of the name of the vehicle and its brand:

        Arrays.sort(cars, 0, size, new Comparator<Car>() {
                @Override
                public int compare(Car o1, Car o2) {
                    int result = o1.getBrand().compareTo(o2.getBrand());
                    if (result == 0) {
                        result = o1.getName().compareTo(o2.getName());
                    }
                    return result;
                }
            });

     - For example, sort by alphabetical order of the brand name:

        Arrays.sort(cars, 0, size, new Comparator<Car>() {
                @Override
                public int compare(Car o1, Car o2) {
                    return o1.getBrand().compareTo(o2.getBrand());
                }
            });

      - For example, sort by alphabetical order by vehicle name:

        Arrays.sort(cars, 0, size, new Comparator<Car>() {
                @Override
                public int compare(Car o1, Car o2) {
                    return o1.getName().compareTo(o2.getName());
                }
            });

        */

    /*
    4. What is the number of operations in the worst case (if there are n vehicles in the garages) in the case of n
    additions followed by a call to equals in the following 2 solutions:
    (a) Sorting the list at the time of the comparison.
    (b) Inserting the vehicle in the right place.

    Implement it.

    >> For the first solution, the number of operations in the worst case is O(n^2). Because we have to sort the list
    at the time comparison. So, we have to compare each element with each other element in the list. So, the number of
    operations is O(n^2). The number of operations is n + n-1 + n-2 + ... + 1 = n(n+1)/2 = O(n^2).
    >> For the second solution, the number of operations in the worst case is O(n). Because we have to insert the vehicle
    in the right place. So, the number of operations is n.
     */

    // Implement the first solution, the number of operations in the worst case is O(n^2).
    public boolean equalsGarages1(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Garage garage = (Garage) o;
        Arrays.sort(cars, 0, size);
        Arrays.sort(garage.cars, 0, garage.size);
        return size == garage.size &&
                id == garage.id &&
                ageLevel == garage.ageLevel &&
                Arrays.equals(cars, garage.cars) &&
                Arrays.equals(bikes, garage.bikes) &&
                sizeBikes == garage.sizeBikes;
    }

    // Implement the second solution, the number of operations in the worst case is O(n).
    public boolean equalsGarages2(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Garage garage = (Garage) o;
        Arrays.sort(cars, 0, size);
        Arrays.sort(garage.cars, 0, garage.size);
        return size == garage.size &&
                id == garage.id &&
                ageLevel == garage.ageLevel &&
                Arrays.equals(cars, garage.cars) &&
                Arrays.equals(bikes, garage.bikes) &&
                sizeBikes == garage.sizeBikes;
    }

    /*
    5. What happens to the number of operations if equals() are called between each addition?
    >> If equals() are called between each addition, the number of operations is O(n^2). The scenario is like following:

    1. Add a car to the garage.
    2. Sort the list.
    3. Compare the list with the other garage.

    The number of operations is calculated as following:  O(n) + O(n^2) + O(n^2) = O(n^2). With n is the number of cars in the garage.
     */

    /*
    6. What if we use LinkedLists rather than ArrayLists?
    >> If we use LinkedLists rather than ArrayLists, the number of operations is O(n).
    Because LikedList is a doubly linked list. So, we can add a car to the garage in O(1) time.
    And we can sort the list in O(n) time. And we can compare the list with the other garage in O(n) time.
    So, the number of operations is O(n).
     */


}
