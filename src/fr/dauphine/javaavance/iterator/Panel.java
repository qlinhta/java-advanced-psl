package fr.dauphine.javaavance.iterator;

/*
We want to write a class Panel which will represent an interval of numbers
whole. Panel will have to be Iterable, i.e. it will be possible
iterate over all the values in the range with a for loop.

    1. We want the following code to work:
        Iterator<Integer> it = panel1(1,5);
            for(;it.hasNext();)
            System.out.println(it.next());    //    affiche    1    2    3    4    5

    For this code to work, the static function panel1() must return a
    object from the correctly implemented Iterator<> class. Consult the document
    mentation of Iterator and implement the panel1() function to ensure that
    that the previous code works. Be careful, you must not use a list
    to store the elements !

    2. We want to simplify the previous code by making use of anonymous classes.
    See the Anonymous Classes documentation here, then modify the code in the
    panel1() function to return an iterator implemented using a class
    anonymous.

    3. We now want to facilitate the traversal of the interval by supporting the syntax
    foreach from Java as in the following example:

        for(int i:panel2(1,5))
        System.out.println(i); // displays 1 2 3 4 5

    What interface should we implement to be able to iterate in this way?
    Implement the static function panel2() to make this happen.
    possible. (We are allowed to reuse code!)

    4. We want to go further and ensure that Panel can be treated like any other
    carries which object of type List. Look at the AbstractList documentation. To
    what problem does this class solve? Which (abstract) methods should be
    implemented? Why these methods?

    5. Using AbstractList write a panel() method that returns an object
    of type List which contains all the elements of the interval. Be careful, we
    does not really want to store all the elements of the list, but only
    find them using the two bounds given in argument).

        List<Integer> l = panel(3,6);
        for(int i:l) {
        System.out.println(i);
        //displays 3 4 5 6
        }
        System.out.println(l.get(1)); //display 4

    6. Test with the PanelTest ﬁle
 */

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;

public class Panel {

    public static Iterator<Integer> panel1(int start, int end) {
        return new Iterator<Integer>() {
            private int current = start;

            @Override
            public boolean hasNext() {
                return current <= end;
            }

            @Override
            public Integer next() {
                return current++;
            }
        };
    }

    public static Iterable<Integer> panel2(int start, int end) {
        return new Iterable<Integer>() {
            @Override
            public Iterator<Integer> iterator() {
                return panel1(start, end);
            }
        };
    }

    public static List<Integer> panel(int start, int end) {
        // If start is bigger than end then throw an exception IllegalArgumentException
        if (start > end) throw new IllegalArgumentException("Start must be greater than end");
        return new AbstractList<Integer>() {
            @Override
            public Integer get(int index) {
                return start + index;
            }

            @Override
            public int size() {
                return end - start + 1;
            }
        };
    }

    public static void main(String[] args) {
        Iterator<Integer> it = panel1(1, 5);
        for (; it.hasNext(); )
            System.out.println(it.next());    //    affiche    1    2    3    4    5

        for (int i : panel2(1, 5))
            System.out.println(i); // displays 1 2 3 4 5

        List<Integer> l = panel(3, 6);
        for (int i : l) {
            System.out.println(i);
            //displays 3 4 5 6
        }
        System.out.println(l.get(1)); //display 4
    }

}

