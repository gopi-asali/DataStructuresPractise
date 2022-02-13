import java.util.Arrays;

public class SelectionSort {


    int[] sorted(int[] inut, int min, int length) {

        for (int i = min; i <= length; i++) {
//            System.out.println("times");
            int temp = inut[i];//2
            for (int j = i+1; j <= length; j++) {
//                System.out.println("times");
                if (temp > inut[j]) {

                    int newtelp = inut[j];;
                    inut[j] =temp;
                    temp = newtelp;
//                    temp = inut[j];
                }
            }

            inut[i] =temp;

        }

        return inut;
    }


    public int[] sort(int[] inut, int min, int length) {

        return sorted(inut, min, length);
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

        int[] input = new int[]{2, 3, 1, 6, 4};

        SelectionSort sort = new SelectionSort();
        System.out.println(sort.printValues(input));
        int[] out = sort.sort(input, 0, input.length - 1);

        System.out.println(sort.printValues(out));


    }
}
