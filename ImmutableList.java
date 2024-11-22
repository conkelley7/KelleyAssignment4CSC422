package com.ckelley.ckelley422week4;

/**
 * Created by: Connor Kelley
 * CSC 422- Week 4 Assignment Part 2
 * 
 * Output of my program matches the updated output listed on MyCourses. 
 * The output in the assignment PDF is different and I assume incorrect.
 */
import java.util.ArrayList;

public class ImmutableList implements IImmutableList {
    private final ArrayList<Integer> immutableList;

    /*
    * Constructor to create an ImmutableList from an array of integers
    */
    public ImmutableList(int[] elements) {
        immutableList = new ArrayList<>();
        for (int element : elements) {
            immutableList.add(element);
        }
    }

    /*
    * Constructor to create an ImmutableList from another IImmutableList
    */
    public ImmutableList(IImmutableList list) {
        immutableList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            immutableList.add(list.get(i));
        }
    }

    @Override
    public int get(int index) {
        return immutableList.get(index);
    }

    @Override
    public IImmutableList concat(IImmutableList list) {
        // Create new list and copy elements from the list used to call concat
        ArrayList<Integer> concatList = new ArrayList<>(immutableList);
        
        // Add elements from list passed as argument to concatList
        for (int i = 0; i < list.size(); i++) {
            concatList.add(list.get(i));
        }

        // Convert to ImmutableList using helper method below and return
        return new ImmutableList(concatList);
    }
    
    public ImmutableList(ArrayList<Integer> concatList){
        this.immutableList = concatList;
    }
    

    @Override
    public int size() {
        return immutableList.size();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < immutableList.size(); i++) {
            sb.append(immutableList.get(i));
            if (i < immutableList.size() - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
