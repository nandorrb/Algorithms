/* *****************************************************************************
 *  Name:              Fernando Rubio
 *  Coursera User ID:  99f10e17bd6b7e7f61d187b45df23273
 *  Last modified:     29/01/2025
 **************************************************************************** */

package test.multithreading;

import edu.princeton.cs.algs4.Point2D;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class DataStructuresSummary {


    public static void main(String[] args) {


        System.out.println("\nDemonstrating Data Structures:");
        // TreeMap example
        TreeMap<String, Integer> treeMap = new TreeMap<>();
        treeMap.put("A", 1);
        treeMap.put("B", 2);
        treeMap.put("D", 1); // Unordered data, ordered by key
        treeMap.put("C", 3);
        System.out.println("TreeMap: " + treeMap);

        // HashMap example
        HashMap<String, Integer> hashMap = new HashMap<>();
        hashMap.put("X", 10);
        hashMap.put("Y", 20);
        hashMap.put("Z", 30);
        System.out.println("HashMap: " + hashMap);

        // HashSet example
        HashSet<Point2D> hashSet = new HashSet<>();
        hashSet.add(new Point2D(0.1, 0.2));
        hashSet.add(new Point2D(0.3, 0.4));
        hashSet.add(new Point2D(0.1, 0.2)); // Duplicate point
        System.out.println("HashSet: " + hashSet);

        // Set example
        Set<String> set = new HashSet<>();
        set.add("Alpha");
        set.add("Beta");
        set.add("Alpha"); // Duplicate element
        System.out.println("Set: " + set);

        // Map example
        Map<String, String> map = new HashMap<>();
        map.put("Key1", "Value1");
        map.put("Key2", "Value2");
        System.out.println("Map: " + map);

        // TreeSet example
        TreeSet<Integer> treeSet = new TreeSet<>();
        treeSet.add(5);
        treeSet.add(1);
        treeSet.add(3);
        System.out.println("TreeSet (sorted): " + treeSet);
    }
}
