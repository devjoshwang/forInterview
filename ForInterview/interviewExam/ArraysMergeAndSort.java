package interviewExam;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ArraysMergeAndSort {

    public static void main(String[] args) {
        int[] a = {3, 7, 12, 19};
        int[] b = {2, 5, 9, 20, 30};
        
        //皚ㄖ籔逼
        int[] ab = mergeAndSortArrays(a, b);
        
        //ab皚パ
        for (int num : ab) {
        	System.out.print(num + " ");
        }
        
        //だ瞒ab皚い案计㎝计
        Map<String, int[]> result = classifyEvenOdd(ab);
        
        //案计皚
        System.out.print("\nEven Array:");
        for (int num : result.get("even")) {
            System.out.print(num + " ");
        }

        //计皚
        System.out.print("\nOdd Array:");
        for (int num : result.get("odd")) {
            System.out.print(num + " ");
        }
    }

    private static int[] mergeAndSortArrays(int[] a, int[] b) {
        // ㄖㄢ皚
        int[] ab = Arrays.copyOf(a, a.length + b.length);
        System.arraycopy(b, 0, ab, a.length, b.length);

        // ab眖逼
        Arrays.sort(ab);

        // abDESC眖逼
        int[] abDESC = new int[ab.length];
        int j = ab.length - 1;
        for (int i = 0; i < ab.length; i++, j--) {
            abDESC[i] = ab[j];
        }

        return abDESC;
    }
    private static Map<String, int[]> classifyEvenOdd(int[] ab) {
        int evenQuantity = 0;
        int oddQuantity = 0;

        //衡计㎝案计计秖
        for (int num : ab) {
            if (num % 2 == 0) {
                evenQuantity++;
            } else {
                oddQuantity++;
            }
        }

        //计㎝案计皚
        int[] even = new int[evenQuantity];
        int[] odd = new int[oddQuantity];
        
        //计㎝案计皚ま
        int evenIndex = 0;
        int oddIndex = 0;

        //癸莱皚
        for (int num : ab) {
            if (num % 2 == 0) {
                even[evenIndex++] = num;
            } else {
                odd[oddIndex++] = num;
            }
        }
        
        //纗resultMap
        Map<String, int[]> resultMap = new HashMap<>();
        resultMap.put("even", even);
        resultMap.put("odd", odd);
        
		return resultMap;
    }
}

