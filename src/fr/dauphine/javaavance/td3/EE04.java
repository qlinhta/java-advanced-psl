package fr.dauphine.javaavance.td3;

public class EE04 {

    /*
    1. For the GarageTest4, why this test is failing?
    This test is failing because Bike and Car are not comparable.
    >> Solution: make Bike and Car comparable by implementing the Comparable interface.
     */

    /*
    2. Write an equals method for Garage that simply calls the method equals of ArrayList (that of the contents of the
    garage). Is the result satisfactory?
    >> Solution: see NewGarageVehicle.java
    >> The result is not satisfactory because the order of the vehicles make a difference. So we need to ignore the order
    of the vehicles in the garage. We can do that by sorting the vehicles before comparing them.
     */

    /*
    3. Modify the code to sort the list (using the sort method of the class
        Collections) at the level of adding a vehicle to the garage (after each
        add) so that the contents of the garage are always sorted. To be able to use spell,
        it is necessary to be able to compare one vehicle to another. These comparison criteria
        are they satisfactory?
        — Alphabetical order by vehicle name.
        — Alphabetical order on the brand name.
        — A combination of the name of the vehicle and its brand?

        >> Solution: see NewGarageVehicle.java
     */

    /*
    4. What is the number of operations in the worst case (if there are n vehicles in the
        garages) in the case of n additions followed by a call to equals in the 2 solutions
        following:
        (a) Sorting the list at the time of the comparison.
        (b) Inserting the vehicle in the right place.
        Implement it

        >> Solution: see NewGarageVehicle.java
     */

}
