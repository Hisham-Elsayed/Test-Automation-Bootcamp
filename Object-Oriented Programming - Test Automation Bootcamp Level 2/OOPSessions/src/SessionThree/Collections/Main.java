package SessionThree.Collections;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        //Set >> unique - unordered
        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        for(int i : set)
        {
            System.out.println(i);
        }

        //List >> duplicated - ordered
        List<Integer> list = new ArrayList<>(5);
        list.add(0,1);
        list.add(1,2);
        list.add(2,3);
        list.add(3,10);
        list.add(4);

        System.out.println(list.get(3));

        //ArrayList >> duplicated - ordered - random access fast - modify frequently
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);
        arrayList.add(5);

        System.out.println(arrayList.contains(5));

        HashMap<String,Integer> hashMap = new HashMap<>();
        hashMap.put("NumberOfEmp",100);
        hashMap.put("NumberOfData",5000);

        System.out.println(hashMap.get("NumberOfEmp"));
    }
}
