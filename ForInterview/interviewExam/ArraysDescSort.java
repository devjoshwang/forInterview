package interviewExam;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class ArraysDescSort {

    public static void main(String[] args) {
        int[] a = {3, 7, 12, 19};
        int[] b = {2, 5, 9, 20, 30};

        //合併a,b
        Set<Integer> descSet = mergeAndSort(a, b);
        
        //印出結果
        System.out.println(descSet);
     
    }

    private static Set<Integer> mergeAndSort(int[] a, int[] b) {
    	
    	 Set<Integer> mergedSet = new HashSet<>();
         for (int num : a) {
             mergedSet.add(num);
         }
         for (int num : b) {
             mergedSet.add(num);
         }
        
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
            	Integer i1 = (Integer) o1;
				Integer i2 = (Integer) o2;
				
				if(i1>i2) {
					return -1;
				}else if(i2>i1){
					return 1;
				}else {
					return 0;
				}
            }
        };
        Set<Integer> descSet = new TreeSet<Integer>(comparator);
        
        descSet.addAll(mergedSet);
        
        return descSet;
    }


}
