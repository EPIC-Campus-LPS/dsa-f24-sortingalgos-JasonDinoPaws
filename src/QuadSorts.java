public class QuadSorts {

    public static int[] bubbleSort(int[] arr) {
        boolean sorted = false;
        long start = System.currentTimeMillis();

        while (!sorted)
        {
            sorted = true;
            for (int i = 0; i < arr.length-1; i++)
            {
                if (arr[i] > arr[i+1])
                {
                    sorted = false;
                    int temp = arr[i+1];
                    arr[i+1] = arr[i];
                    arr[i] = temp;
                }
            }
        }

        System.out.println("\t\tRunTime: "+(System.currentTimeMillis()-start));
        return arr;
    }

    public static int[] selectionSort(int[] arr){
        int end = arr.length;
        long start = System.currentTimeMillis();

        while (end != 0)
        {
            int big = 0;
            for (int i = 0; i < end; i++)
                if (arr[i] > arr[big])
                    big = i;

            if (big != end)
            {
                int temp = arr[end-1];
                arr[end-1] = arr[big];
                arr[big] = temp;
            }
            end -= 1;
        }

        System.out.println("\t\tRunTime: "+(System.currentTimeMillis()-start));
        return arr;
    }

    public static int[] insertionSort(int[] arr) {
        int pos = 1;
        long start = System.currentTimeMillis();

        while (pos < arr.length) {
            int num = arr[pos];
            for (int i = 0; i < pos; i++) {
                if (arr[i] > num) {
                    for (int j = pos - 1; j >= i; j--)
                        arr[j + 1] = arr[j];

                    arr[i] = num;
                    break;
                }
            }
            pos++;
        }

        System.out.println("\t\tRunTime: "+(System.currentTimeMillis()-start));
        return arr;
    }

    private static int[] clonetable(int[] arr, int start, int end){
        int[] newarr = new int[end-start];
        int pos = 0;

        for (int i = start; i < end; i++) {
            newarr[pos] = arr[i];
            pos ++;
        }

        return  newarr;
    }

    private static int[] Merge(int[] arr)
    {
        if (arr.length > 1) {
            int split = arr.length / 2;
            int[] arr1 = Merge(clonetable(arr, 0, split));
            int[] arr2 = Merge(clonetable(arr, split, arr.length));
            int[] fin = new int[arr1.length + arr2.length];

            for (int i = 0; i < arr1.length; i++) {
                fin[i] = arr1[i];
            }

            for (int i = 0; i < arr2.length; i++) {
                fin[i + arr1.length] = arr2[i];
            }

            boolean sorted = false;
            while (!sorted) {
                sorted = true;
                for (int i = 0; i < fin.length - 1; i++) {
                    if (fin[i] > fin[i + 1]) {
                        sorted = false;
                        int temp = fin[i + 1];
                        fin[i + 1] = fin[i];
                        fin[i] = temp;
                    }
                }
            }
            return fin;
        }
        return arr;
    }

    public static int[] mergeSort(int[] arr){
        long start = System.currentTimeMillis();
        int[] sorted = Merge(arr);
        for (int i = 0; i < arr.length; i++)
        {
            arr[i] = sorted[i];
        }
        System.out.println("\t\tRunTime: "+(System.currentTimeMillis()-start));
        return arr;
    }
}
