package com.example.codecontest.simulation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class HashMapSimulation {
    HashMap hashMap = new HashMap();

    private List<LinkedList> list = new ArrayList<>(16);
    public HashMapSimulation() {
        for (int i = 0; i <15 ; i++) {
            LinkedList linkedList = new LinkedList();
            list.add(linkedList);
        }
    }

    void put(Object obj){
        int hashCode = obj.hashCode();
        int index = hashCode & 15;
        list.get(index).add(obj);
    }
}
