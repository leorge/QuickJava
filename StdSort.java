public class StdSort {

    // This class should not be instantiated.
    private StdSort() { }

    /***********************************************************************
     *  Helper sorting functions
     ***********************************************************************/
     
     // is v < w ?
     private static boolean less(Comparable v, Comparable w) {
         return (v.compareTo(w) < 0);
     }

    /***********************************************************************
     *  Check if array is sorted - useful for debugging
     ***********************************************************************/
     private static boolean isSorted(Comparable[] a) {
         return isSorted(a, 0, a.length - 1);
     }

     private static boolean isSorted(Comparable[] a, int lo, int hi) {
         for (int i = lo + 1; i <= hi; i++)
             if (less(a[i], a[i-1])) return false;
         return true;
     }

     // print array to standard output
     private static void show(Comparable[] a) {
         for (int i = 0; i < a.length; i++) {
             StdOut.println(a[i]);
         }
     }

     /**
     * Reads in a sequence of strings from standard input; 
     * and sorts them; and prints them to standard output in ascending order. 
     */
    public static void main(String[] args) {
        String[] a = StdIn.readAllStrings();
        Stopwatch when = new Stopwatch();
        java.util.Arrays.sort(a);
        double elapsedTime = when.elapsedTime();
        show(a);
        if (isSorted(a)) StdOut.println("Arrays.sort sec. = " + elapsedTime);
    }
}
