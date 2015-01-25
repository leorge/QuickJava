public class TestFat {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        String[] a = StdIn.readAllStrings();
        int	N = a.length;
        fatObj[] src = new fatObj[N];
        for (int i = 0; i < N; i++) src[i] = new fatObj(a[i]);
        fatObj[] wrk = src.clone();
        Stopwatch timer = new Stopwatch();
        java.util.Arrays.sort(wrk);
        double elapsedTime = timer.elapsedTime();
//        fatObj.show(wrk);
        if (fatObj.isSorted(wrk)) StdOut.println("Arrays sec. = " + elapsedTime);
        wrk = src.clone();
        double startTime = timer.elapsedTime();
        QuickX.sort(wrk);
        elapsedTime = timer.elapsedTime();
//      fatObj.show(wrk);
        if (fatObj.isSorted(wrk)) 
        	StdOut.println("QuickX sec. = " + ((int)((elapsedTime - startTime) * 1000)) / 1000.);
        wrk = src.clone();
        startTime = timer.elapsedTime();
        QuickLog2.sort(wrk);
        elapsedTime = timer.elapsedTime();
//      fatObj.show(wrk);
        if (fatObj.isSorted(wrk)) 
        	StdOut.println("QuickLog2 sec. = " + ((int)((elapsedTime - startTime) * 1000)) / 1000.);
	}
}
