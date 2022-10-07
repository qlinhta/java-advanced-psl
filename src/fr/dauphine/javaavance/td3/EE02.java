package fr.dauphine.javaavance.td3;

import java.util.ArrayList;
import java.util.HashSet;

public class EE02 {

    /*
    1. Is the behavior natural? Add a method with signature boolean equals(Car c);

        Car a = new Car("Audi",10000);
        Car b = new Car("BMW",9000);
        Car c = new Car("BMW",9000);
        Car d = a;
        System.out.println(a==b);
        System.out.println(b==c);
        System.out.println(a==d);
        System.out.println(a.equals(b));
        System.out.println(b.equals(c));
        System.out.println(a.equals(d));

        >> Output:
                        false // a==b
                        false // b==c
                        true // a==d
                        false // a.equals(b)
                        false // b.equals(c)
                        true // a.equals(d)

         The behavior is not natural because the equals is comparing the references of the objects and not the values of the objects.
         So, we need to override the equals method to compare the values of the objects.

         See method equals(Car c) in the Car class (Car.java)

         Result after overriding the equals method:
                        false // a==b
                        false // b==c
                        true // a==d
                        false // a.equals(b)
                        true // b.equals(c)
                        true // a.equals(d)

    */

    /*
    2. Is this a logical behavior? Read indexOf List doc and edit your code accordingly.

    ArrayList<Car> list = new ArrayList<>();
    list.add(a);
    list.add(b);
    System.out.println(list.indexOf(a));
    System.out.println(list.indexOf(b));
    System.out.println(list.indexOf(c));
    System.out.println(b.equals(c));

    >> Output:
                0 // list.indexOf(a)
                1 // list.indexOf(b)
                -1 // list.indexOf(c) because the equals method is not overridden
                true // b.equals(c)

    The behavior is not logical because the indexOf method is returning the index of the first occurrence of the object
    in the list.indexOf(c) should return 1 because the object c is the second occurrence of the object b in the list.indexOf(b).

    So, we need to override the equals method to compare the values of the objects.

    See method equals(Car c) in the Car class (Car.java)

    Result after overriding the equals() method:
                0 // list.indexOf(a)
                1 // list.indexOf(b)
                1 // list.indexOf(c)
                true // b.equals(c)

     */

    /*
    3. Is this a logical behavior? Read List's indexOf doc and edit your code accordingly.
        HashSet<Car> set = new HashSet<Car>();
        set.add(b);
        System.out.println(set.contains(c));

        >> Output:
                    false // set.contains(c) because the equals method is not overridden

        The behavior is not logical because the contains method is returning false, but the object c is in the set because
        object b and object c are equals.

        See method equals(Car c) in the Car class (Car.java)

        Result after overriding the equals() method:
                    true // set.contains(c) because the equals method is overridden
     */

    // FOR ALL QUESTION 1, 2 AND 3 SEE THE Car.java, THE MEDTHOD equals(Object c) IS SATISFYING THE REQUIREMENTS OF THE QUESTIONS.

    /*
    4. Write a remove method in Garage that takes a car as an argument and which allows to remove a car from the garage
        See method remove(Car c) in the Garage class (Garage.java)
     */


    public static void main(String[] args) {
        Car a = new Car("Audi",10000);
        Car b = new Car("BMW",9000);
        Car c = new Car("BMW",9000);
        Car d = a;

        HashSet<Car> set = new HashSet<Car>();
        set.add(b);
        System.out.println(set.contains(c));
    }


}
