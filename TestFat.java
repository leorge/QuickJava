public class TestFat {
	public static void main(String[] args) {
        String[] a = StdIn.readAllStrings();
        int	N = a.length;
        fatObj[] src = new fatObj[N];
        for (int i = 0; i < N; i++) src[i] = new fatObj(a[i]);
        fatObj[] wrk = src.clone();
        Stopwatch timer = new Stopwatch();
        MergeX.sort(wrk);
        double elapsedTime = timer.elapsedTime();
//        fatObj.show(wrk);
        if (fatObj.isSorted(wrk)) StdOut.println("MergeX sec. = " + elapsedTime);
        wrk = src.clone();
        double startTime = timer.elapsedTime();
        QuickX.sort(wrk);
        elapsedTime = timer.elapsedTime();
//      fatObj.show(wrk);
        if (fatObj.isSorted(wrk)) 
        	StdOut.println("Arrays sec. = " + ((int)((elapsedTime - startTime) * 1000)) / 1000.);
        wrk = src.clone();
        startTime = timer.elapsedTime();
        java.util.Arrays.sort(wrk);
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
