package fr.dauphine.javaavance.exception;

/*
1. Construct an abstract class TabTrie that corresponds to a sorted array of objects. This class must contain:
    – an array of Objects, tab, initialized with a capacity defined by default (we must also remember to store the number
    of Objects contained in the array), and different methods that can be implemented or abstracted:
    – a GreaterGreater method that compares two objects and returns true if the first is greater than the second,
    – an append method which inserts an object into the array respecting ascending order,
    – a toString method which returns a string representing the array. When the capacity of the array is reached,
    inserting a new element will throw an ArrayFullException.
2. Build the TabTriCouple class which inherits from TabTri and orders objects of type Couple lexicographically.
3. Was a solution possible only with interfaces? What is the point of abstract classes here?
 */

public class TabTri {
    private final Object[] tab;
    private int size;

    public TabTri(int capacity) {
        this.tab = new Object[capacity];
        this.size = 0;
    }

    public boolean GreaterGreater(Object o1, Object o2) {
        return o1.toString().compareTo(o2.toString()) > 0;
    }

    public void append(Object o) throws ArrayFullException {
        if (this.size == this.tab.length) {
            throw new ArrayFullException("Array is full");
        }
        int i = 0;
        while (i < this.size && this.GreaterGreater(this.tab[i], o)) {
            i++;
        }
        for (int j = this.size; j > i; j--) {
            this.tab[j] = this.tab[j - 1];
        }
        this.tab[i] = o;
        this.size++;
    }

    public String toString() {
        if (this.size == 0) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < this.size; i++) {
            sb.append(this.tab[i]);
            if (i < this.size - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
