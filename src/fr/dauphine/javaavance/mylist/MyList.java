package fr.dauphine.javaavance.mylist;

public class MyList {
    private Cell first; // reference to the first cell of the list

    public MyList() {
        this.first = null;
    }

    public void add(String s) {
        Cell c = new Cell(s, this.first);
        this.first = c;
    }

    public void add(int index, String s) {
        /**
         * @param index
         * @param s
         * The function to add a string at a specific index in the list
         */
        if (index < 0 || index > this.size()) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        if (index == 0) {
            this.add(s);
        } else {
            Cell c = this.first;
            for (int i = 0; i < index - 1; i++) {
                c = c.getNext();
            }
            Cell newCell = new Cell(s, c.getNext());
            c.setNext(newCell);
        }
    }

    public String get(int index) {
        if (index < 0 || index >= this.size()) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        Cell c = this.first;
        for (int i = 0; i < index; i++) {
            c = c.getNext();
        }
        return c.getValue();
    }

    public int size() {
        int size = 0;
        Cell c = this.first;
        while (c != null) {
            size++;
            c = c.getNext();
        }
        return size;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Cell c = this.first;
        while (c != null) {
            sb.append(c.getValue());
            if (c.getNext() != null) {
                sb.append(", ");
            }
            c = c.getNext();
        }
        sb.append("]");
        return sb.toString();
    }

    public void addLast(String s) {
        if (this.first == null) {
            this.add(s);
        } else {
            Cell c = this.first;
            while (c.getNext() != null) {
                c = c.getNext();
            }
            c.setNext(new Cell(s, null));
        }
    }

    public static void main(String[] args) {
        MyList ml = new MyList();
        ml.addLast("tatu");
        ml.add("toto");
        ml.add("titi");
        ml.addLast("tutu");
        System.out.println(ml);
        System.out.println(ml.size());
        System.out.println(ml.get(0));
        System.out.println(ml.get(1));
        System.out.println(ml.get(2));
        System.out.println(ml.get(3));
        System.out.println(ml.get(4)); // IndexOutOfBoundsException
    }

}
