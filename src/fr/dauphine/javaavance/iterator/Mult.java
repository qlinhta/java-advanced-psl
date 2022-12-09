package fr.dauphine.javaavance.iterator;

/*
    We seek here to write in a class Mult some static methods making
    operations.

    1. Write a method mult taking as parameters an integer and a list of integers
    and returning a new list of integers where all values are multiplied
    by the first argument (coeﬃcient).

    2. Modify your implementation so that you don't have to allocate a new list,
    but using the principle of a view (see the AbstractList doc). Do it
    as an anonymous class.

    3. What is wrong with the following code?

        ArrayList<Integer> al = new ArrayList<>();
        for (int i = 0; i < 1000000; i++) {
            al.add(i);
        }
        long t0 = System.nanoTime();
        List<Integer> ret = Mult.mult(2, al);
        long sum = 0;
        for (int val : ret) {
            sum += val / 2;
        }
        System.out.println((System.nanoTime() - t0));
        LinkedList<Integer> ll = new LinkedList<>();
        for (int i = 0; i < 1000000; i++) {
            ll.add(i);
        }
        t0 = System.nanoTime();
        sum = 0;
        ret = Mult.mult(2, ll);
        for (int val : ret) {
            sum += val / 2;
        }
        System.out.println((System.nanoTime() - t0));

    4. Correct the problem. (Look at RandomAccess, AbstractList, AbstractSequentialList)

 */

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Mult {

    public static List<Integer> mult(int coeff, List<Integer> list) {
        List<Integer> ret = new ArrayList<>();
        for (int val : list) {
            ret.add(val * coeff);
        }
        return ret;
    }

    public static List<Integer> mult2(int coeff, List<Integer> list) {
        return new AbstractList<Integer>() {
            @Override
            public Integer get(int index) {
                return list.get(index) * coeff;
            }

            @Override
            public int size() {
                return list.size();
            }
        };
    }

    public static List<Integer> mult3(int coeff, List<Integer> list) {
        return new AbstractList<Integer>() {
            @Override
            public Integer get(int index) {
                return list.get(index) * coeff;
            }

            @Override
            public int size() {
                return list.size();
            }

            @Override
            public Integer set(int index, Integer element) {
                return list.set(index, element / coeff);
            }
        };
    }

    public static List<Integer> mult4(int coeff, List<Integer> list) {
        return new AbstractList<Integer>() {
            @Override
            public Integer get(int index) {
                return list.get(index) * coeff;
            }

            @Override
            public int size() {
                return list.size();
            }

            @Override
            public Integer set(int index, Integer element) {
                return list.set(index, element / coeff);
            }

            @Override
            public boolean add(Integer e) {
                return list.add(e / coeff);
            }
        };
    }

    public static List<Integer> mult5(int coeff, List<Integer> list) {
        return new AbstractList<Integer>() {
            @Override
            public Integer get(int index) {
                return list.get(index) * coeff;
            }

            @Override
            public int size() {
                return list.size();
            }

            @Override
            public Integer set(int index, Integer element) {
                return list.set(index, element / coeff);
            }

            @Override
            public boolean add(Integer e) {
                return list.add(e / coeff);
            }

            @Override
            public void add(int index, Integer element) {
                list.add(index, element / coeff);
            }
        };
    }

    public static void main(String[] args) {
        ArrayList<Integer> al = new ArrayList<>();
        for (int i = 0; i < 1000000; i++) {
            al.add(i);
        }
        long t0 = System.nanoTime();
        List<Integer> ret = Mult.mult(2, al);
        long sum = 0;
        for (int val : ret) {
            sum += val / 2;
        }
        System.out.println((System.nanoTime() - t0));
        LinkedList<Integer> ll = new LinkedList<>();
        for (int i = 0; i < 1000000; i++) {
            ll.add(i);
        }
        t0 = System.nanoTime();
        sum = 0;
        ret = Mult.mult(2, ll);
        for (int val : ret) {
            sum += val / 2;
        }
        System.out.println((System.nanoTime() - t0));

    }


}
