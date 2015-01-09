36a37
>     private static final int CUTOFF = 8;  // cutoff to insertion sort, must be >= 1
60,63c61,67
<         int mid = lo + (hi - lo) / 2;
<         sort(aux, a, lo, mid);
<         sort(aux, a, mid + 1, hi);
<         merge(aux, a, lo, mid, hi);
---
>         else if (hi - lo <= CUTOFF) insertionSort(aux, lo, hi);
>         else {
>             int mid = lo + (hi - lo) / 2;
>             sort(aux, a, lo, mid);
>             sort(aux, a, mid + 1, hi);
>             merge(aux, a, lo, mid, hi);
>         }
73a78,87
>     }
> 
>     // sort from a[lo] to a[hi] using insertion sort using a hole.
>     public static void insertionSort(Comparable[] a, int lo, int hi) {
>         for (int i = lo; i <= hi; i++) {
>         	Comparable v = a[i];
>         	int	j;
>             for (j = i; j > lo && less(v, a[j-1]); j--) a[j-1] = a[j];	// slide
>             a[j] = v;
>         }
