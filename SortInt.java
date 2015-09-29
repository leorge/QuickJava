class SortInt {
    public static void main(String[] args) {
        String[] inp = StdIn.readAllStrings();
        int	N = inp.length;
        int [] a = new int[N];
        for (int i = 0; i < N; i++) {a[i] = Integer.parseInt(inp[i]);}
        Stopwatch timer1 = new Stopwatch();
        java.util.Arrays.sort(a);
        double elapsedTime = timer1.elapsedTime();
        StdOut.println("Sort int[" + N + "] = " + elapsedTime + " .sec");
    }
}
