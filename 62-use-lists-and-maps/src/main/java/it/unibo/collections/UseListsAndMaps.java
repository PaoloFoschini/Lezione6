package it.unibo.collections;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Example class using {@link List} and {@link Map}.
 *
 */
public final class UseListsAndMaps {

    private UseListsAndMaps() {
    }

    /**
     * @param s
     *            unused
     */
    public static void main(final String... s) {
        /*
         * 1) Create a new ArrayList<Integer>, and populate it with the numbers
         * from 1000 (included) to 2000 (excluded).
         */
        ArrayList<Integer> al = new ArrayList<>();
        for(int i = 0; i <= 1000; i++){
            al.add(i, i+1000);
        }

        /*
         * 2) Create a new LinkedList<Integer> and, in a single line of code
         * without using any looping construct (for, while), populate it with
         * the same contents of the list of point 1.
         */
        LinkedList<Integer> ll = new LinkedList<>(al);

        /*
         * 3) Using "set" and "get" and "size" methods, swap the first and last
         * element of the first list. You can not use any "magic number".
         * (Suggestion: use a temporary variable)
         */
        final int FIRST;
        final int LAST;
        FIRST = al.get(0);
        LAST = al.get(al.size() - 1);
        al.set(0, LAST);
        al.set(al.size() - 1, FIRST);
        /*
         * 4) Using a single for-each, print the contents of the arraylist.
         */
        System.out.print("[");
        for(int elem : al){
            System.out.print(" " + elem);
        }
        System.out.println("]");
        /*
         * 5) Measure the performance of inserting new elements in the head of
         * the collection: measure the time required to add 100.000 elements as
         * first element of the collection for both ArrayList and LinkedList,
         * using the previous lists. In order to measure times, use as example
         * TestPerformance.java.
         */
        final int ELEMENTS = 100_000;
        
        long time = System.nanoTime();
        for (int i = 1; i <= ELEMENTS; i++) {
            al.add(0, i);
        }
        time = System.nanoTime() - time;
        final var millis = TimeUnit.NANOSECONDS.toMillis(time);
        System.out.println(
                "Adding 100000 elements as first element of the collection in an arraylist took "
                + time
                + "ns ("
                + millis
                + "ms)"
        );

        long time2 = System.nanoTime();
        for (int i = 1; i <= ELEMENTS; i++) {
            ll.add(0, i);
        }
        time2 = System.nanoTime() - time2;
        final var millis2 = TimeUnit.NANOSECONDS.toMillis(time);
        System.out.println(
                "Adding 100000 elements as first element of the collection in a linked list took "
                + time2
                + "ns ("
                + millis2
                + "ms)"
        );

        /*
         * 6) Measure the performance of reading 1000 times an element whose
         * position is in the middle of the collection for both ArrayList and
         * LinkedList, using the collections of point 5. In order to measure
         * times, use as example TestPerformance.java.
         */
        final int MILL = 1000;
        
        long time3 = System.nanoTime();
        for (int i = 1; i <= MILL; i++) {
            al.get((int)al.size() / 2);         //num,5 non è num, quindi va castato a int
        }
        time = System.nanoTime() - time;
        final var millis3 = TimeUnit.NANOSECONDS.toMillis(time);
        System.out.println(
                "Reading 1000 times an element whose position is in the middle in an arraylist took "
                + time3
                + "ns ("
                + millis3
                + "ms)"
        );

        long time4 = System.nanoTime();
        for (int i = 1; i <= MILL; i++) {
            ll.get((int)al.size() / 2);         //num,5 non è num, quindi va castato a int
        }
        time = System.nanoTime() - time;
        final var millis4 = TimeUnit.NANOSECONDS.toMillis(time);
        System.out.println(
                "Reading 1000 times an element whose position is in the middle in an arraylist took "
                + time4
                + "ns ("
                + millis4
                + "ms)"
        );
        /*
         * 7) Build a new Map that associates to each continent's name its
         * population:
         *
         * Africa -> 1,110,635,000
         *
         * Americas -> 972,005,000
         *
         * Antarctica -> 0
         *
         * Asia -> 4,298,723,000
         *
         * Europe -> 742,452,000
         *
         * Oceania -> 38,304,000
         */
        final Map <String, Long> map = new HashMap<>();
        map.put("Africa", 1_110_635_000L);
        map.put("Americas", 972_005_000L);
        map.put("Antartica", 0L);
        map.put("Asia", 4_298_723_000L);
        map.put("Europe", 742_452_000L);
        map.put("Oceania", 38_304_000L);
        /*
         * 8) Compute the population of the world
         */
        for(int elem:){

        }
    }
}
