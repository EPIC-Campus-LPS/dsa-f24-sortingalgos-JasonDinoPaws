import java.awt.geom.QuadCurve2D;
import java.util.stream.StreamSupport;

public class QuadSorts {

    /**
     * <pre>
     * Internal Variables:
     *  Sorted - a boolean that is always going to be true unless if it finds if a element is not in order
     *  Start - a long that gets the current milla seconds before sorting is started
     *
     *  While Loop > Sorted = true:
     *  Sets Sorted to true
     *  for 0 -> arr len
     *  if pos > pos+1
     *      sorted = false
     *      switch pos and pos+1
     *
     *  print currentmilla - start milla
     *  returns sorted arr
     * </pre>
     */
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

    /**
     * <pre>
     * Internal Variables:
     *  end - a number of where the for loop should stop
     *  Start - a long that gets the current milla seconds before sorting is started
     *
     *  While Loop > end == 0:
     *      Gets the bigest number from 0 - end
     *      compaired if big != end
     *      switched Big and end
     *      minus 1 from end
     *
     *  print currentmilla - start milla
     *  returns sorted arr
     * </pre>
     */
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

    /**
     * <pre>
     * Internal Variables:
     *  pos - the number it checks at the start
     *  Start - a long that gets the current milla seconds before sorting is started
     *
     *  While Loop > pos > arr.len:
     *      gets the number at the pos
     *      for 0 - pos
     *          checks if i is > num
     *              for pos-1 - i
     *                  moves number up one
     *          places num in i
     *          breaks
     *      pos ++
     *
     *  print currentmilla - start milla
     *  returns sorted arr
     * </pre>
     */
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

            for (int i = 0; i < arr1.length; i++)
                fin[i] = arr1[i];

            for (int i = 0; i < arr2.length; i++)
                fin[i + arr1.length] = arr2[i];

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

    /**
     * <pre>
     *     private static int[] clonetable(int[] arr, int start, int end)
     *     clones arr from start to end
     *
     *     private static int[] Merge(int[] arr)
     *     checks if given array is more than 1
     *      generates the Point
     *      Merage(0 - Point)
     *      Merage(Point - end)
     *      combines both merages
     *
     *      Sorts the final array
     *      returns the Final array
     *     else
     *      returns arr
     *
     *  print currentmilla - start milla
     *  returns sorted arr
     * </pre>
     */
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

    private static int[] Quick(int[] arr,int start, int end)
    {
        int piv = end-1;
        if (piv > start && piv > -1 && piv < end)
        {
            int num = arr[piv];
            int[] fin = new int[end-start];
            int less = 0;
            int more = fin.length-1;

            for (int i = start; i < piv; i++) {
                if (arr[i] <= num) {
                    fin[less] = arr[i];
                    less++;
                } else if (arr[i] > num) {
                    fin[more] = arr[i];
                    more--;
                }
            }

            fin[less] = num;
            num = 0;
            for (int i = start;i < end; i++)
            {
                arr[i] = fin[num];
                num ++;
            }

            Quick(arr,start,start+less);
            Quick(arr,start+less,end);
            return fin;
        }
        return arr;
    }

    /**
     * <pre>
     *     private static int[] Quick(int[] arr,int start, int end)
     *      creates the pivit form end-1
     *      checks if the pivit is within bounds of the start and end
     *      gets the number at pivit
     *      creates new array with the length between start and end
     *      creates the pos of less and more
     *
     *      for start - piv
     *          if less than piv
     *              adds where last pos was
     *              last add
     *          else if more than piv
     *              adds where more pos was
     *              more substract
     *
     *       puts num in the middle
     *
     *       creates num at 0
     *       for start - end
     *          returned arr pos = fin of num pos
     *          num adds
     *
     *       Quick arr start - start+last
     *       Quick arr start+last - end
     *       return fin
     *
     *  print currentmilla - start milla
     *  returns sorted arr
     * </pre>
     */
    public static int[] quickSort(int[] arr)
    {
        long start = System.currentTimeMillis();
        Quick(arr,0,arr.length);

        System.out.println("\t\tRunTime: "+(System.currentTimeMillis()-start));
        return arr;
    }
}
