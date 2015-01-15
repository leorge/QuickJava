public class DummySort {

    // This class should not be instantiated.
    private DummySort() { }

     // print array to standard output
     private static void show(Comparable[] a) {
         for (int i = 0; i < a.length; i++) {
             StdOut.println(a[i]);
         }
     }

     /**
     * Reads in a sequence of strings from standard input; 
     * and prints them through to standard output. 
     */
    public static void main(String[] args) {
        String[] a = StdIn.readAllStrings();
        show(a);
    }
}
