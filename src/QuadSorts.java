public class QuadSorts {

    public static int[] bubbleSort(int[] arr){
        boolean sorted = false;
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i]+" | ");
        System.out.println();

        //while (!sorted)
       // {
            int p = 0;
            int num = arr[p];
            sorted = true;

            for (int i = 0; i < arr.length; i++)
            {
                if (!(arr[p] < arr[i]))
                {
                    arr[p] = arr[i];
                    arr[i+1] = num;
                    p = i+1;
                }
                else
                    break;
                for (int j = 0; j < arr.length; j++)
                    System.out.print(arr[j]+" | ");
                System.out.println();
            }

        //}
        return arr;
    }

    public static int[] selectionSort(int[] arr){
        int[] arrfin = new int[arr.length];

        return arrfin;
    }

    public static int[] insertionSort(int[] arr){
        int[] arrfin = new int[arr.length];

        return arrfin;
    }

    public static int[] mergeSort(int[] arr){
        int[] arrfin = new int[arr.length];

        return arrfin;
    }
}
