package lab1;

public class Arrays {
    public static void swapLargestAndSmallest(int[] a) {
        int smallNum = a[0];
        int bigNum = a[0];
        int index1 = 0;
        int index2 = 0;

        for (int i = 0; i < a.length; i++) {
            if (a[i] > bigNum) {
                bigNum = a[i];
                index1 = i;
            }
            if (a[i] < smallNum) {
                smallNum = a[i];
                index2 = i;
            }

        }
        int tempNum = a[index1];
        a[index1] = a[index2];
        a[index2] = tempNum;
    }
}
