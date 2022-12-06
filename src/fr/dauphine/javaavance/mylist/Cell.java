package fr.dauphine.javaavance.mylist;

public class Cell {
    private String value;
    private Cell next;

    public Cell(String value, Cell next) {
        this.value = value;
        this.next = next;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Cell getNext() {
        return next;
    }

    public void setNext(Cell next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "Cell{" + "value='" + value + '\'' + ", next=" + next + '}';
    }

}
