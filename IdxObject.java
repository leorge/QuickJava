
public class IdxObject implements Comparable<IdxObject> {
    public final int    index;
    public final String data;
    
    public IdxObject(int index, String data) {
        this.index = index;
        this.data = data;
    }
    
    public int compareTo(IdxObject v) {
        return  data.compareTo(v.data);
    }
    
    /***********************************************************************
     *  Helper sorting functions
     ***********************************************************************/
     
     // is v < w ?
     private static boolean less(IdxObject v, IdxObject w) {
         return (v.compareTo(w) < 0);
     }

    /***********************************************************************
     *  Check if array is sorted - useful for debugging
     ***********************************************************************/
     public static boolean isSorted(IdxObject[] a) {
         return isSorted(a, 0, a.length - 1);
     }

     private static boolean isSorted(IdxObject[] a, int lo, int hi) {
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
        int N = a.length;
        IdxObject[] b = new IdxObject[N];
        for (int i = 0; i < N; i++) b[i] = new IdxObject(i, a[i]);
        Stopwatch timer = new Stopwatch();
        java.util.Arrays.sort(b);
        for (int i = 0; i < N; i++) a[i] = b[i].data;
        double elapsedTime = timer.elapsedTime();
        show(a);
        if (isSorted(b)) StdOut.println("IdxObject sec. = " + elapsedTime);
    }
}
