package Arrays;

class CheckMaxMin {

    public static int[] maxMin(int[] arr) {

        int size = arr.length;
        int arr2[] = new int[size];
        int j = 0, k = size - 1;
        for (int i = 0; i + 2 < size; i += 2) {
            arr2[i] = arr[k--];
            arr2[i + 1] = arr[j++];
        }

        if (size % 2 != 0) arr2[size - 1] = arr[size / 2];

        arr = arr2;
        return arr;
    }

    public static void main(String[] args) {
        System.out.println(maxMin(new int[]{1, 2, 3, 4, 5}));
    }
}
