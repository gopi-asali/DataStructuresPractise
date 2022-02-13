import java.util.Arrays;

public class MergeSort {


    public void mergeTwoSplit(int[] inut, int min, int mid, int length) {


        int arrSize = mid - min + 1;
        int sarrSize = length - mid;

        int[] firstarry = new int[arrSize];
        int[] secondarry = new int[sarrSize];

        for (int i = 0; i < arrSize; i++) {
            firstarry[i] = inut[i+min];
        }
        for (int i = 0; i < sarrSize; i++) {
            secondarry[i] = inut[i+mid+1];
        }

        int i = 0, j = 0;
        int k = min;

        while (i < arrSize && j < sarrSize) {
            if (firstarry[i] < secondarry[j]) {
                inut[k] = firstarry[i];
                i++;
            } else {
                inut[k] = secondarry[j];
                j++;
            }
            k++;
        }


        while (i < arrSize) {
            inut[k] = firstarry[i];
            i++;
            k++;
        }

        while (j < sarrSize) {
            inut[k] = secondarry[j];
            j++;
            k++;
        }

        /*
        }*/


    }

    public int[] merge(int[] inut, int min, int length) {

//        if (inut.length == 0)
//            return inut;

        if (min < length) {

            int mid = min + (length - min) / 2;
            merge(inut, min, mid);
            merge(inut, mid + 1, length);
            mergeTwoSplit(inut, min, mid, length);

        }/* else {

            if(min == length)
                return inut;
            int temp = inut[min];
            int newEle = inut[min+1];
            if (temp > newEle) {
                inut[min] = newEle;
                inut[min+1] = temp;
            }
        }*/


        return inut;

    }


    public String printValues(int[] input) {

        StringBuilder stringValue = new StringBuilder();
        Arrays.stream(input).sequential().forEach(values -> {
            stringValue.append(values);
            stringValue.append(",");
        });

        return stringValue.toString();

    }


    public static void main(String[] args) {
        int[] inut = new int[]{1, 3, 4, 2, 0};

        MergeSort inti = new MergeSort();

        System.out.println(inti.printValues(inut));

        int[] sorde = inti.merge(inut, 0, inut.length - 1);

        System.out.println(inti.printValues(sorde));

    }
}
