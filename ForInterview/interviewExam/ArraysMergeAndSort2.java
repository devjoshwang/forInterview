package interviewExam;


public class ArraysMergeAndSort2 {

    public static void main(String[] args) {
        int[] a = {3, 7, 12, 19};
        int[] b = {2, 5, 9, 20, 30};

        //合併a,b
        int[] ab = merge2array(a, b);

        //印出結果
        for (int num : ab) {
            System.out.print(num + " ");
        }
    }

    private static int[] merge2array(int[] a, int[] b) {
        int[] ab = new int[a.length + b.length];
        int i = 0, j = 0, k = 0;

        //合併a,b
        while (i < a.length && j < b.length) {
            if (a[i] > b[j]) {
                ab[k++] = a[i++];
            } else {
                ab[k++] = b[j++];
            }
        }

        //剩餘數字加入ab
        while (i < a.length) {
            ab[k++] = a[i++];
        }

        while (j < b.length) {
            ab[k++] = b[j++];
        }

        //臨時陣列，大小與ab陣列相同
        int[] temp = new int[ab.length];
     
        //合併排序
        mergeSort(ab, 0, ab.length - 1, temp);

        return ab;
    }

    //分解與合併
    public static void mergeSort(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;
            //向左遞迴分解
            mergeSort(arr, left, mid, temp);
            //向右遞迴分解
            mergeSort(arr, mid + 1, right, temp);
            //合併
            merge(arr, left, mid, right, temp);
        }
    }

   
    public static void merge(int[] arr, int left, int mid, int right, int[] temp) {
        int i = left; //初始化i, 左邊有序序列的初始索引
        int j = mid + 1; //初始化j, 右邊有序序列的初始索引
        int t = 0; //指向temp陣列的當前索引

        // (一) 左右序列比大小，將大的放到 temp裡
        while (i <= mid && j <= right) {
            if (arr[i] >= arr[j]) { 
                temp[t] = arr[i];
                t += 1;
                i += 1;
            } else {
                temp[t] = arr[j];
                t += 1;
                j += 1;
            }
        }

        // (二) 把有剩餘數據的子序列依次全部放入temp
        while (i <= mid) {
            temp[t] = arr[i];
            t += 1;
            i += 1;
        }

        while (j <= right) {
            temp[t] = arr[j];
            t += 1;
            j += 1;
        }

        // (三) 將temp陣列的元素copy到arr
        t = 0;
        int tempLeft = left;
        while (tempLeft <= right) {
            arr[tempLeft++] = temp[t++];
        }
    }
}
