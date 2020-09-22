package Sorting_Techniques;
import java.util.*;

public class RadixSort {
	public int largest(int a[]) {
		int larger = a[0], i;
		for (i = 1; i < 10; i++) {
			if (a[i] > larger)
				larger = a[i];
		}
		return larger;
	}

	public void radixsort(int a[]) {
		int bucket[][] = new int[10][10];
		int bucket_count[] = new int[10];
		int i, j, k, remainder, NOP = 0, divisor = 1, larger, pass;
		larger = largest(a);
		while (larger > 0) {
			NOP++;
			larger /= 10;
		}
		for (pass = 0; pass < NOP; pass++) // Initialize the buckets
		{
			for (i = 0; i < 10; i++)
				bucket_count[i] = 0;
			for (i = 0; i < 10; i++) {
				// sort the numbers according to the digit at passth place
				remainder = (a[i] / divisor) % 10;
				bucket[remainder][bucket_count[remainder]] = a[i];
				bucket_count[remainder] += 1;
			}
			// collect the numbers after PASS pass
			i = 0;
			for (k = 0; k < 10; k++) {
				for (j = 0; j < bucket_count[k]; j++) {
					a[i] = bucket[k][j];
					i++;
				}
			}
			divisor *= 10;
		}
	}
	
	public static void main(String[] args) {
		int i;
		Scanner sc = new Scanner(System.in);
		int[] a = { 90, 23, 101, 45, 65, 23, 67, 89, 34, 23 };
		RadixSort ob = new RadixSort();
		ob.radixsort(a);
		System.out.println("\nThe sorted array is: \n");
		for (i = 0; i < 10; i++)
			System.out.println(a[i]);
	}
}