package fr.dauphine.javaavance.td3;

import java.util.Arrays;
import java.util.Comparator;

public class NewGarageVehicle {

    private final Object idGarage;
    private Vehicule[] vehicles;
    public int nbVehicles;

    private static int id = 0;


    // Update contructor

    public NewGarageVehicle() {
        this.idGarage = id++;
        this.vehicles = new Vehicule[10];
        this.nbVehicles = 0;
    }

    // Update add method, can't add a null vehicle in the garage and can add any type of vehicle (car or bike)

    public void add(Vehicule vehicle) {
        if (vehicle == null) {
            throw new NullPointerException("Can't add a null vehicle in the garage");
        }
        if (nbVehicles == vehicles.length) {
            Vehicule[] newVehicles = new Vehicule[vehicles.length * 2];
            System.arraycopy(vehicles, 0, newVehicles, 0, vehicles.length);
            vehicles = newVehicles;
        }
        vehicles[nbVehicles++] = vehicle;
    }

    /*
    Exercice 3, question 5:
    In garage, create a method void protectionism(String brand); which removes all the vehicles of the brand
    passed as an argument, by traversing the list only once. Test, it is likely that your first idea does not work...
     */

    /**
     * Remove all the vehicles of the brand given in parameter
     *
     * @param brand throw NullPointerException if brand is null
     *              throw IllegalStateException if the brand is not in the garage
     *              throw IllegalStateException if the brand is in the garage but there is no vehicle of this brand
     */

    public void protectionism(String brand) {
        if (brand == null) {
            throw new NullPointerException("Brand can't be null");
        }
        boolean brandInGarage = false;
        for (int i = 0; i < nbVehicles; i++) {
            if (vehicles[i].getBrand().equals(brand)) {
                brandInGarage = true;
                vehicles[i] = vehicles[nbVehicles - 1];
                vehicles[nbVehicles - 1] = null;
                nbVehicles--;
                i--;
            }
        }
        if (!brandInGarage) {
            throw new IllegalStateException("The brand is not in the garage");
        }
        if (nbVehicles == 0) {
            throw new IllegalStateException("There is no vehicle of this brand in the garage");
        }
    }

    // Method remove vehicle from garage

    public boolean remove(Vehicule vehicle) {
        if (vehicle == null) {
            throw new NullPointerException("Can't remove a null vehicle from the garage");
        }
        for (int i = 0; i < nbVehicles; i++) {
            if (vehicles[i].equals(vehicle)) {
                vehicles[i] = vehicles[nbVehicles - 1];
                vehicles[nbVehicles - 1] = null;
                nbVehicles--;
                return true;
            }
        }
        throw new IllegalStateException("The vehicle is not in the garage");
    }

    // Update firstCarByBrand method

    public Vehicule firstCarByBrand(String brand) {
        if (brand == null) {
            throw new NullPointerException("Brand can't be null");
        }
        for (int i = 0; i < nbVehicles; i++) {
            if (vehicles[i].getBrand().equals(brand)) {
                return vehicles[i];
            }
        }
        return null;
    }

    public long getValue() {
        long value = 0;
        for (int i = 0; i < nbVehicles; i++) {
            value += vehicles[i].getValue();
        }
        return value;
    }

    /*
    Write an equals method for Garage that simply calls the method equals of ArrayList (that of the contents of the
    garage).
     */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NewGarageVehicle that = (NewGarageVehicle) o;

        if (nbVehicles != that.nbVehicles) return false;
        for (int i = 0; i < nbVehicles; i++) {
            if (!vehicles[i].equals(that.vehicles[i])) {
                return false;
            }
        }
        return true;
    }


    /*
    3. Modify the code to sort the list (using the sort method of the class
        Collections) at the level of adding a vehicle to the garage (after each
        add) so that the contents of the garage are always sorted. To be able to use spell,
        it is necessary to be able to compare one vehicle to another. These comparison criteria
        are they satisfactory?
        — Alphabetical order by vehicle name.
        — Alphabetical order on the brand name.
        — A combination of the name of the vehicle and its brand?

     */

    // Sort the list of vehicles by alphabetical order on the brand name

    public void addSortByBrand(Vehicule vehicle) {
        if (vehicle == null) {
            throw new NullPointerException("Can't add a null vehicle in the garage"); // Check if the vehicle is null
        }
        if (nbVehicles == vehicles.length) { // Check if the garage is full
            Vehicule[] newVehicles = new Vehicule[vehicles.length * 2]; // Create a new array with double size
            System.arraycopy(vehicles, 0, newVehicles, 0, vehicles.length); // Copy the old array in the new array
            vehicles = newVehicles; // Update the old array with the new array
        }
        vehicles[nbVehicles++] = vehicle; // Add the vehicle in the garage
        // Sort the list of vehicles by alphabetical order on the brand name
        Arrays.sort(vehicles, 0, nbVehicles, Comparator.comparing(Vehicule::getBrand)); // Sort the list of vehicles by alphabetical order on the brand name
    }

    // Sort the list of vehicles by alphabetical order on the name of the vehicle

    public void addSortByName(Vehicule vehicle) {
        if (vehicle == null) {
            throw new NullPointerException("Can't add a null vehicle in the garage");
        }
        if (nbVehicles == vehicles.length) {
            Vehicule[] newVehicles = new Vehicule[vehicles.length * 2];
            System.arraycopy(vehicles, 0, newVehicles, 0, vehicles.length);
            vehicles = newVehicles;
        }
        vehicles[nbVehicles++] = vehicle;
        Arrays.sort(vehicles, 0, nbVehicles, (o1, o2) -> o1.getName().compareTo(o2.getName())); // Sort the list of vehicles by alphabetical order on the name of the vehicle
    }

    // Sort the list of vehicles by alphabetical order on the name of the vehicle and the brand

    public void addSortByNameAndBrand(Vehicule vehicle) {
        if (vehicle == null) {
            throw new NullPointerException("Can't add a null vehicle in the garage");
        }
        if (nbVehicles == vehicles.length) {
            Vehicule[] newVehicles = new Vehicule[vehicles.length * 2];
            System.arraycopy(vehicles, 0, newVehicles, 0, vehicles.length);
            vehicles = newVehicles;
        }
        vehicles[nbVehicles++] = vehicle;
        Arrays.sort(vehicles, 0, nbVehicles, (o1, o2) -> {
            int compareName = o1.getName().compareTo(o2.getName());
            if (compareName == 0) {
                return o1.getBrand().compareTo(o2.getBrand());
            }
            return compareName;
        });
    }

    /*
    4. What is the number of operations in the worst case (if there are n vehicles in the
        garages) in the case of n additions followed by a call to equals in the 2 solutions
        following:
        (a) Sorting the list at the time of the comparison.
        (b) Inserting the vehicle in the right place.
     */

    // Implement the solution (a) Sorting the list at the time of the comparison :

    public void addSortByBrandAndCompare(Vehicule vehicle) {

        // Number of operations in this case:
        // 1. Check if the vehicle is null = O(1)
        // 2. Check if the garage is full = O(1)
        // 3. Add the vehicle in the garage = O(1)
        // 4. Sort the list of vehicles by alphabetical order on the brand name = O(n log n)
        // 5. Compare the list of vehicles with the list of vehicles of the other garage = O(n)
        // --> Complexity : O(n log n) + O(n) = O(n log n)

        if (vehicle == null) {
            throw new NullPointerException("Can't add a null vehicle in the garage");
        }
        if (nbVehicles == vehicles.length) {
            Vehicule[] newVehicles = new Vehicule[vehicles.length * 2];
            System.arraycopy(vehicles, 0, newVehicles, 0, vehicles.length);
            vehicles = newVehicles;
        }
        vehicles[nbVehicles++] = vehicle;
        Arrays.sort(vehicles, 0, nbVehicles, Comparator.comparing(Vehicule::getBrand));

    }

    // Implement the solution (b) Inserting the vehicle in the right place :

    public void addInsertInRightPlace(Vehicule vehicle) {

        // Number of operations in this case:
        // 1. Check if the vehicle is null = O(1)
        // 2. Check if the garage is full = O(1)
        // 3. Add the vehicle in the garage = O(1)
        // 4. Sort the list of vehicles by alphabetical order on the brand name = O(n)
        // 5. Compare the list of vehicles with the list of vehicles of the other garage = O(n)
        // --> Complexity : O(n) + O(n) = O(n)

        if (vehicle == null) {
            throw new NullPointerException("Can't add a null vehicle in the garage");
        }
        if (nbVehicles == vehicles.length) {
            Vehicule[] newVehicles = new Vehicule[vehicles.length * 2];
            System.arraycopy(vehicles, 0, newVehicles, 0, vehicles.length);
            vehicles = newVehicles;
        }
        int index = 0;
        while (index < nbVehicles && vehicles[index].getBrand().compareTo(vehicle.getBrand()) < 0) {
            index++;
        }
        System.arraycopy(vehicles, index, vehicles, index + 1, nbVehicles - index);
        vehicles[index] = vehicle;
        nbVehicles++;

    }

    /*
    5. What happens to the number of operations if equals are called between each addition?
    - The number of operations is the same in both cases because the list of vehicles is sorted
    at the time of the comparison or when the vehicle is added in the garage.
    Time complexity is O(n log n) + O(n) = O(n log n) in the first case and O(n) + O(n) = O(n) in the second case.
     */

    /*
    6. What if we use LinkedLists rather than ArrayLists?
    >> If we use LinkedLists rather than ArrayLists, the number of operations is O(n) + O(n) = O(n) in both cases.
        Because LikedList is a doubly linked list. So, we can add a car to the garage in O(1) time.
        And we can sort the list in O(n) time. And we can compare the list with the other garage in O(n) time.
        So, the number of operations is O(n).
     */

}
