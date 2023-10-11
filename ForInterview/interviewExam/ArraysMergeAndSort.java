package interviewExam;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ArraysMergeAndSort {

    public static void main(String[] args) {
        int[] a = {3, 7, 12, 19};
        int[] b = {2, 5, 9, 20, 30};
        
        //�}�C�X�ֻP�Ȥj��p�Ƨ�
        int[] ab = mergeAndSortArrays(a, b);
        
        //�L�Xab�}�C�Ѥj��p
        for (int num : ab) {
        	System.out.print(num + " ");
        }
        
        //����ab�}�C�������ƩM�_��
        Map<String, int[]> result = classifyEvenOdd(ab);
        
        //�L�X���ư}�C
        System.out.print("\nEven Array:");
        for (int num : result.get("even")) {
            System.out.print(num + " ");
        }

        //�L�X�_�ư}�C
        System.out.print("\nOdd Array:");
        for (int num : result.get("odd")) {
            System.out.print(num + " ");
        }
    }

    private static int[] mergeAndSortArrays(int[] a, int[] b) {
        // �X�֨�Ӱ}�C
        int[] ab = Arrays.copyOf(a, a.length + b.length);
        System.arraycopy(b, 0, ab, a.length, b.length);

        // ab�q�p��j�Ƨ�
        Arrays.sort(ab);

        // abDESC�q�j��p�Ƨ�
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

        //��_�ƩM���Ƽƶq
        for (int num : ab) {
            if (num % 2 == 0) {
                evenQuantity++;
            } else {
                oddQuantity++;
            }
        }

        //�_�ƩM���ƪ��}�C
        int[] even = new int[evenQuantity];
        int[] odd = new int[oddQuantity];
        
        //�_�ƩM���ư}�C����
        int evenIndex = 0;
        int oddIndex = 0;

        //�s�J�������}�C
        for (int num : ab) {
            if (num % 2 == 0) {
                even[evenIndex++] = num;
            } else {
                odd[oddIndex++] = num;
            }
        }
        
        //�s�x��resultMap
        Map<String, int[]> resultMap = new HashMap<>();
        resultMap.put("even", even);
        resultMap.put("odd", odd);
        
		return resultMap;
    }
}

