
public class fatObj implements Comparable<fatObj> {
	private double	dummy0, dummy1, dummy2, dummy3, dummy4, dummy5, dummy6, dummy7, dummy8, dummy9;
	public final String Key;
	
	public fatObj(String Id) {
		Key = Id;
	}
	
	public int compareTo(fatObj v) {
		return	Key.compareTo(v.Key);
	}
	
    /***********************************************************************
     *  Helper sorting functions
     ***********************************************************************/
     
     // is v < w ?
     private static boolean less(fatObj v, fatObj w) {
         return (v.compareTo(w) < 0);
     }

    /***********************************************************************
     *  Check if array is sorted - useful for debugging
     ***********************************************************************/
     public static boolean isSorted(fatObj[] a) {
         return isSorted(a, 0, a.length - 1);
     }

     private static boolean isSorted(fatObj[] a, int lo, int hi) {
         for (int i = lo + 1; i <= hi; i++)
             if (less(a[i], a[i-1])) return false;
         return true;
     }

     // print array to standard output
     private static void show(fatObj[] a) {
         for (int i = 0; i < a.length; i++) {
             StdOut.println(a[i].Key);
         }
     }

     /**
     * Reads in a sequence of strings from standard input; 
     * and sorts them; and prints them to standard output in ascending order. 
     */
    public static void main(String[] args) {
        String[] a = StdIn.readAllStrings();
        int	N = a.length;
        fatObj[] b = new fatObj[N];
        for (int i = 0; i < N; i++) {b[i] = new fatObj(a[i]);}
        Stopwatch timer = new Stopwatch();
        java.util.Arrays.sort(b);
        double elapsedTime = timer.elapsedTime();
        show(b);
        if (isSorted(b)) StdOut.println("fatObj sec. = " + elapsedTime);
    }

}
