package fr.dauphine.javaavance.exception;

public class TabTriCouple extends TabTri {
    /*
    Build the TabTriCouple class which inherits from TabTri and orders objects of type Couple lexicographically.
     */
    public TabTriCouple(int capacity) {
        super(capacity);
    }

    @Override
    public boolean GreaterGreater(Object o1, Object o2) {
        return o1.toString().compareTo(o2.toString()) > 0;
    }

    public static void main(String[] args) {
        TabTriCouple tabTriCouple = new TabTriCouple(5);
        try {
            tabTriCouple.append(new Couple(1, 2));
            tabTriCouple.append(new Couple(2, 1));
            tabTriCouple.append(new Couple(1, 1));
            tabTriCouple.append(new Couple(2, 2));
            tabTriCouple.append(new Couple(1, 3));
        } catch (ArrayFullException e) {
            e.printStackTrace();
        }
        System.out.println(tabTriCouple);
    }

}